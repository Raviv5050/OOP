// ID: 208387951


package buildgame;

import all.interfaces.LevelInformation;
import biuoop.GUI;

import java.util.List;

/**
 * @author Raviv
 * The GameFlow class  support for moving from one level to the next.
 * This class will be in charge of creating the different levels, and moving from one level to the next.
 */
public class GameFlow {
    private static final int ZERO = 0;
    private static final String SPACE = "space";


    //the gui of the game
    private GUI gui;
    //the animation runner of this game
    private AnimationRunner runner;
    //the keyboard for the game
    private biuoop.KeyboardSensor keyboardSensor;
    //the score counter of this game
    private Counter score;
    //value that tells us if the player loose.
    private boolean isLose = false;

    // private LevelInformation levelInformation;


    /**
     * constructor that receive the gui window and create a score value.
     *
     * @param gui the gui window.
     */
    public GameFlow(GUI gui) {
        this.gui = gui;
        this.score = new Counter(0);
        this.runner = new AnimationRunner(gui);
        this.keyboardSensor = gui.getKeyboardSensor();
        //  this.levelInformation = levelInformation;
    }

    /**
     * run -- Run the game, start the animation loop by the current level from the levels list.
     * @param levels kist of all the levels.
     */
    public void runLevels(List<LevelInformation> levels) {

        // by this loop we are running over all the levels
        for (LevelInformation levelInfo : levels) {
            GameLevel gameLevel = new GameLevel(this.gui, levelInfo, this.score, this.runner, this.keyboardSensor);
            gameLevel.initialize();
            while ((gameLevel.getCounter() > ZERO) && (gameLevel.getBallsCounter() > ZERO)) {
                gameLevel.run();
            }

            //if the ballsCounter is zero it means no more balls are available so we want to clear the GUI
            // resources and close the window.
            if (gameLevel.getBallsCounter() == ZERO) {
                this.isLose = true;
                break;
            }

            //updating the score to the current score
            // this.score = gameLevel.getScore();
        }
        EndScreen endScreen = new EndScreen(this.score, this.isLose, this.gui);
        KeyPressStoppableAnimation endStoppableAnimation = new
                KeyPressStoppableAnimation(keyboardSensor, SPACE, endScreen);
        runner.run(endStoppableAnimation);


        // EndScreen endScreen = new EndScreen(this.keyboardSensor, this.score, this.isLose, this.gui);
        // this.runner.run(endScreen);
        if (endStoppableAnimation.shouldStop()) {
            gui.close();
        }
    }
}
