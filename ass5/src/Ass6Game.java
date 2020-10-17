// ID: 208387951

import all.interfaces.LevelInformation;
import biuoop.GUI;
import buildgame.GameFlow;
import buildgame.GameLevel;
import levels.LevelFour;
import levels.LevelOne;
import levels.LevelThree;
import levels.LevelTwo;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Raviv
 * The class create a game and runs it by using the functions in the game class
 */

public class Ass6Game {
    private static final String LEVEL_ONE = "1";
    private static final String LEVEL_TWO = "2";
    private static final String LEVEL_THREE = "3";
    private static final String LEVEL_FOUR = "4";


    /**
     * main -- calling the game class, so by that creates a ball and blocks, and the ball is bouncing around
     * the screen hitting blocks and changing directions).
     *
     * @param args an empty args array
     */
    public static void main(String[] args) {
        //creating a gui for this game
        GUI gui = new GUI("game title", (int) GameLevel.GUI_WIDTH, (int) GameLevel.GUI_HEIGHT);
        GameFlow gameFlow = new GameFlow(gui);
        boolean check = false;
        //creating a level
        LevelOne levelOne = new LevelOne();
        LevelTwo levelTwo = new LevelTwo();
        LevelThree levelThree = new LevelThree();
        LevelFour levelFour = new LevelFour();
        List<LevelInformation> levels = new ArrayList<LevelInformation>();
        List<LevelInformation> argsLevels = new ArrayList<LevelInformation>();

        for (String arg : args) {
            switch (arg) {
                case LEVEL_ONE:
                    argsLevels.add(levelOne);
                    check = true;
                    break;
                case LEVEL_TWO:
                    argsLevels.add(levelTwo);
                    check = true;
                    break;
                case LEVEL_THREE:
                    argsLevels.add(levelThree);
                    check = true;
                    break;
                case LEVEL_FOUR:
                    argsLevels.add(levelFour);
                    check = true;
                    break;
                default:
                    break;
            }
        }
        if (!check) {
            levels.add(levelOne);
            levels.add(levelTwo);
            levels.add(levelThree);
            levels.add(levelFour);
            gameFlow.runLevels(levels);
        }
        else {
            gameFlow.runLevels(argsLevels);
        }
    }
}
