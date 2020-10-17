// ID: 208387951

package buildgame;

import all.interfaces.Animation;
import all.interfaces.Collidable;
import all.interfaces.LevelInformation;
import all.interfaces.Sprite;
import allsprites.Ball;
import allsprites.Block;
import allsprites.Paddle;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import levels.NameLevelIndicator;
import shapes.Point;
import shapes.Rectangle;
import shapes.Velocity;
import java.awt.Color;

/**
 * @author Raviv
 * The buildgame.Game class will hold the sprites and the collidables, and will be in charge of the animation .
 * the class creats the GUI, adding the blocks in a nice pattern, adding the ball ,associating the ball with the
 * buildgame.GameEnvironment and adding any other game objects (such as the paddle)
 */
public class GameLevel implements Animation {
    //the width of the gui window
    public static final double GUI_WIDTH = 800;
    //the height of the gui window
    public static final double GUI_HEIGHT = 600;
    //the width of the paddle in this game
    public static final double PADDLE_WIDTH = 110;
    //the height of the paddle in this game
    public static final double PADDLE_HEIGHT = 7;
    //Tthe x value we want the blocks to start from
    public static final double BLOCKS_X_START = GUI_WIDTH - 63;
    //Tthe y value we want the blocks to start from
    public static final double BLOCKS_Y_START = 100;
    //the radius of the balls
    public static final double BALL_RADIUS = 5;
    public static final double BLOCKS_WIDTH = 43;
    public static final double BLOCKS_HEIGHT = 21;
    //the width of the frame vertical blocks in this game
    public static final double VERTICAL_FRAME_BLOCK_WIDTH = 20;
    //the height of the frame vertical blocks in this game
    public static final double VERTICAL_FRAME_BLOCK_HEIGHT = 580;
    //the width the frame horizontal blocks in this game
    public static final double HORIZONTAL_FRAME_BLOCK_WIDTH = 800;
    //the height the frame horizontal blocks in this game
    public static final double HORIZONTAL_FRAME_BLOCK_HEIGHT = 20;
    //the start width of the block in the bottom of the window
    public static final double BOTTOM_BLOCK_START_WIDTH = VERTICAL_FRAME_BLOCK_WIDTH;
    //the width of the block in the bottom of the window
    public static final double BOTTOM_BLOCK_WIDTH = HORIZONTAL_FRAME_BLOCK_WIDTH - 20;
    //the angle of the first ball in this game
    public static final double ANGLE_BALL1 = 65;
    //the angle of the second ball in this game
    public static final double ANGLE_BALL2 = 40;
    //the angle of the third ball in this game
    public static final double ANGLE_BALL3 = 70;
    //the speed of the first ball in this game
    public static final double SPEED_BALL1 = 4;
    //the speed of the second ball in this game
    public static final double SPEED_BALL2 = 4;
    //the speed of the third ball in this game
    public static final double SPEED_BALL3 = 4;
    //the width of the blue rectangle
    public static final double BLUE_RECTANGLE_WIDTH = (int) HORIZONTAL_FRAME_BLOCK_WIDTH - 40;
    //the amount of the number of the blocks
    private static final int NUM_OF_BLOCKS = 57;
    //the amount of the number of the balls
    private static final int NUM_OF_BALLS = 3;
    private static final int ZERO = 0;
    //num of seconds that we want the countdown to show up.
    private static final double NUM_OF_SECONDS = 2;
    //the countFrom number that we want the countdown to start from.
    private static final int COUNT_FROM = 3;
    private static final String SPACE = "space";


    //the buildgame.SpriteCollection of this game
    private SpriteCollection sprites;
    //the buildgame.GameEnvironment of this game
    private GameEnvironment environment;
    //the gui of the game
    private GUI gui;
    //the counter that keeping track of the number of remained (or removed) blocks
    private Counter counter;
    //the counter that keeping track of the number of remained (or removed) balls
    private Counter ballsCounter;
    //the score of the game
    private Counter score;

    private AnimationRunner runner;
    private boolean running;
    private biuoop.KeyboardSensor keyboardSensor;
    private LevelInformation levelInformation;

    /**
     * constructor that create ArrayList whose elements type is also all.interfaces.Collidable and ArrayList whose
     * elements type is also all.interfaces.Sprite.
     *
     * @param gui              the gui window.
     * @param levelInformation the chosen levelInformation.
     * @param score            the current score of the game.
     * @param runner           the animation runner of the game.
     * @param keyboardSensor   the keyboard for the game
     */
    public GameLevel(GUI gui, LevelInformation levelInformation, Counter score,
                     AnimationRunner runner, KeyboardSensor keyboardSensor) {
        this.levelInformation = levelInformation;
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.ballsCounter = new Counter(levelInformation.numberOfBalls());
        this.counter = new Counter(levelInformation.numberOfBlocksToRemove());
        this.score = score;
        this.runner = runner;
        this.running = false;
        this.gui = gui;
        this.keyboardSensor = keyboardSensor;
    }

    /**
     * addCollidable -- add the given collidable to the environment in the current game.
     *
     * @param collidable the new collidable.
     */
    public void addCollidable(Collidable collidable) {
        this.environment.addCollidable(collidable);
    }

    /**
     * addSprite -- add the given sprite s to the sprites in the current game.
     *
     * @param sprite the new sprite.
     */
    public void addSprite(Sprite sprite) {
        this.sprites.addSprite(sprite);
    }

    /**
     * initialize -- Initialize a new game: create the Blocks and allsprites.Ball (and allsprites.Paddle) and
     * add them to the game.
     */
    public void initialize() {
        // creating a PrintingHitListener variable
        //PrintingHitListener printingHitListener = new PrintingHitListener();
        // creating a blockRemover variable
        BlockRemover blockRemover = new BlockRemover(this, counter);
        // creating a ballRemover variable
        BallRemover ballRemover = new BallRemover(this, ballsCounter);
        // creating a scoreTrackingListener variable
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(score);
        //creating colors for the blocks for the game
        Color color1 = new Color(35, 62, 8);
        Color color2 = new Color(63, 115, 96);
        //the upper left point of the first vertical block
        Point upperLeftBlock2 = new Point(0, 20);
        //the upper left point of the second vertical block
        Point upperLeftBlock3 = new Point(780, 20);
        //the upper left point of the first horizontal block
        Point upperLeftBlock1 = new Point(0, 0);
        //the upper left point of the second horizontal block
        Point upperLeftDeathBlock = new Point(0, 600);
        //adding the background as a sprite to the game
        this.addSprite(levelInformation.getBackground());

        //creating black frame blocks in the limits of the game
        Block block1 = new Block(new Rectangle(upperLeftBlock1, HORIZONTAL_FRAME_BLOCK_WIDTH,
                HORIZONTAL_FRAME_BLOCK_HEIGHT), color1);
        Block block2 = new Block(new Rectangle(upperLeftBlock2, VERTICAL_FRAME_BLOCK_WIDTH,
                VERTICAL_FRAME_BLOCK_HEIGHT), color2);
        Block block3 = new Block(new Rectangle(upperLeftBlock3, VERTICAL_FRAME_BLOCK_WIDTH,
                VERTICAL_FRAME_BLOCK_HEIGHT), color2);
        Block deathBlock = new Block(new Rectangle(upperLeftDeathBlock, HORIZONTAL_FRAME_BLOCK_WIDTH,
                HORIZONTAL_FRAME_BLOCK_HEIGHT), new Color(154, 198, 255));
        //creating an array of blocks with all the block we just created
        Block[] blocks = new Block[]{block1, block2, block3, deathBlock};
        //for loop that run over all the blocks in the array of blocks
        for (Block block : blocks) {
            //adding each block to the game by calling for both addSprite and add all.interfaces.Collidable functions
            block.addToGame(this);
        }
        //adding the "ballRemover" listener to the current block
        deathBlock.addHitListener(ballRemover);
        for (int i = 0; i < levelInformation.blocks().size(); i++) {
            //adding the current block to the game
            Block block = levelInformation.blocks().get(i);
            block.addToGame(this);
            //adding the "blockRemover" listener to the current block
            block.addHitListener(blockRemover);
            //adding the "scoreTrackingListener" listener to the current block
            block.addHitListener(scoreTrackingListener);
        }


        //the upper left point of the paddle block
        Point paddleUpperLeft = new Point((GUI_WIDTH / 2) - levelInformation.paddleWidth() / 2, 580);
        //setting the color of the paddle
        Color paddleColor = new Color(255, 255, 160);
        // creating the paddle block
        Block paddleBlock = new Block(new Rectangle(paddleUpperLeft,
                levelInformation.paddleWidth(), PADDLE_HEIGHT), paddleColor);
        Paddle paddle = new Paddle(keyboardSensor, paddleBlock);
        paddle.addToGame(this);


        //creating all the balls
        for (int i = 0; i < levelInformation.numberOfBalls(); i++) {
            //the center of the the current ball
            Point ballCenter = new Point(paddleUpperLeft.getX() + (levelInformation.paddleWidth() / 2),
                    paddleUpperLeft.getY() - 10);
            //creating the balls
            Ball ball = new Ball(ballCenter, (int) BALL_RADIUS, Color.white);
            //creating the velocity of the balls
            Velocity ballVelocity = new Velocity(levelInformation.initialBallVelocities().get(i).getXVelocity(),
                    levelInformation.initialBallVelocities().get(i).getYVelocity());
            //setting the velocity of the balls
            ball.setVelocity(ballVelocity);
            //setting the game of the balls
            ball.setGame(this.environment);
            //adding the balls to the game by calling only for addSprite() function
            ball.addToGame(this);
        }

        // creating a levels.NameLevelIndicator variable
        NameLevelIndicator nameLevelIndicator = new NameLevelIndicator(levelInformation.levelName());
        //adding the NameLevelIndicator as a sprite to the game
        this.addSprite(nameLevelIndicator);
        // creating a buildgame.ScoreIndicator variable
        ScoreIndicator scoreIndicator = new ScoreIndicator(score);
        this.addSprite(scoreIndicator);
    }

    /**
     * getSprites -- return all the sprites of the game.
     * @return return all the sprites of the game.
     */
    public SpriteCollection getSprites() {
        return this.sprites;
    }

    /**
     * getCounter -- return the number of the blocks that are still in the game.
     * @return the number of the blocks that are still in the game.
     */
    public int getCounter() {
        return this.counter.getValue();
    }

    /**
     * getBallsCounter -- return the number of the balls that are still in the game.
     * @return the number of the balls that are still in the game.
     */
    public int getBallsCounter() {
        return this.ballsCounter.getValue();
    }

    /**
     * getScore -- return the current score of the game.
     * @return the current score of the game.
     */
    public int getScore() {
        return this.score.getValue();
    }

    /**
     * setScore -- adding 100 points to the score.
     */
    public void setScore() {
        score.increase(100);
    }

    /**
     * shouldStop -- the method helps us sign when we want to stop running and exit from the game.
     * @return if we should close the animation.
     */
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * doOneFrame -- Run the game(the logic from the previous run method).
     *
     * @param drawSurface the drawSurface we want to print on it.
     */
    public void doOneFrame(DrawSurface drawSurface) {
        // the logic from the previous run method goes here.
        // the `return` or `break` statements should be replaced with
        // this.running = false;

        // draw all the sprites to the screen
        this.sprites.drawAllOn(drawSurface);


        // notify all the sprites that time has passed
        this.sprites.notifyAllTimePassed();


        PauseScreen pauseScreen = new PauseScreen();
        KeyPressStoppableAnimation pauseStoppableAnimation = new
                KeyPressStoppableAnimation(keyboardSensor, SPACE, pauseScreen);

        //if the key p being pressed, we start running the buildgame.PauseScreen animation instead of the
        // Game one. The Game animation will resume as soon as we will return from the buildgame.PauseScreen animation.
        if (this.keyboardSensor.isPressed("p")) {
            //this.runner.run(new PauseScreen(this.keyboardSensor));
            runner.run(pauseStoppableAnimation);
        }


        //if the count is zero it means no more blocks are available so we want to clear the GUI
        // resources and close the window.
        if (counter.getValue() == ZERO) {
            score.increase(100);
            this.running = false;
            // gui.close();
        }
        //if the ballsCounter is zero it means no more balls are available so we want to clear the GUI
        // resources and close the window.
        if (ballsCounter.getValue() == ZERO) {
            this.running = false;
            // gui.close();
        }
    }

    /**
     * run -- Run the game, start the animation loop.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(NUM_OF_SECONDS, COUNT_FROM, sprites)); // countdown before turn starts.
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.running = true;
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this);

        /**
         Sleeper sleeper = new Sleeper();
         Sleeper sleeperForText = new Sleeper();
         //we want a smooth animations that displays 60 different frames in a second, if possible)
         int framesPerSecond = 60;
         //each frame in the animation can last 1000 / framesPerSecond milliseconds
         int millisecondsPerFrame = 1000 / framesPerSecond;
         // creating a buildgame.ScoreIndicator variable
         ScoreIndicator scoreIndicator = new ScoreIndicator(score);


         while (true) {
         long startTime = System.currentTimeMillis(); // timing
         DrawSurface drawSurface = gui.getDrawSurface();


         drawSurface.setColor(new Color(154, 198, 255));
         drawSurface.fillRectangle((int) VERTICAL_FRAME_BLOCK_WIDTH, (int) VERTICAL_FRAME_BLOCK_WIDTH,
         (int) BLUE_RECTANGLE_WIDTH, (int) VERTICAL_FRAME_BLOCK_HEIGHT);
         // draw all the sprites to the screen
         this.sprites.drawAllOn(drawSurface);
         //draw the score sprite on the screen
         scoreIndicator.drawOn(drawSurface);


         //show the drawsurface
         gui.show(drawSurface);
         // notify all the sprites that time has passed
         this.sprites.notifyAllTimePassed();
         // timing- Because we are now doing more work in the loop body, the time it takes to perform the work
         // may be non-negligible. We therefor subtract the time it takes to do the work from the sleep time of
         // millisecondsPerFrame milliseconds.
         long usedTime = System.currentTimeMillis() - startTime;
         long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
         if (milliSecondLeftToSleep > 0) {
         sleeper.sleepFor(milliSecondLeftToSleep);
         }
         //if the count is zero it means no more blocks are available so we want to clear the GUI
         // resources and close the window.
         if (counter.getValue() == ZERO) {
         score.increase(100);
         gui.close();
         }
         //if the ballsCounter is zero it means no more balls are available so we want to clear the GUI
         // resources and close the window.
         if (ballsCounter.getValue() == ZERO) {
         gui.close();
         }
         }
         **/
    }

    /**
     * removeCollidable -- remove the current collidable from the buildgame.GameEnvironment.
     *
     * @param c the collidable that should be removed.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCurrentCollidable(c);
    }

    /**
     * removeSprite -- remove the current sprite from the buildgame.SpriteCollection.
     *
     * @param s the sprite that should be removed.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeCurrentSprite(s);
    }
}