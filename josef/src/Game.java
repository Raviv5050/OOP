// ID: 208387951

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import java.awt.Color;

/**
 * @author Raviv
 * The buildgame.Game class will hold the sprites and the collidables, and will be in charge of the animation .
 * the class creats the GUI, adding the blocks in a nice pattern, adding the ball ,associating the ball with the
 * buildgame.GameEnvironment and adding any other game objects (such as the paddle)
 */
public class Game {
    //the width of the gui window
    public static final double GUI_WIDTH = 800;
    //the height of the gui window
    public static final double GUI_HEIGHT = 600;
    //the width of the paddle in this game
    public static final double PADDLE_WIDTH = 80;
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
    public static final double VERTICAL_FRAME_BLOCK_HEIGHT = 560;
    //the width the frame horizontal blocks in this game
    public static final double HORIZONTAL_FRAME_BLOCK_WIDTH = 800;
    //the height the frame horizontal blocks in this game
    public static final double HORIZONTAL_FRAME_BLOCK_HEIGHT = 20;
    //the start width of the block in the bottom of the window
    public static final double BOTTOM_BLOCK_START_WIDTH = VERTICAL_FRAME_BLOCK_WIDTH;
    //the width of the block in the bottom of the window
    public static final double BOTTOM_BLOCK_WIDTH = HORIZONTAL_FRAME_BLOCK_WIDTH - 20;
    //the angle of the first ball in this game
    public static final double ANGLE_BALL1 = 15;
    //the angle of the two ball in this game
    public static final double ANGLE_BALL2 = 40;
    //the speed of the first ball in this game
    public static final double SPEED_BALL1 = 5;
    //the speed of the two ball in this game
    public static final double SPEED_BALL2 = 5;
    //the width of the blue rectangle
    public static final double BLUE_RECTANGLE_WIDTH = (int) HORIZONTAL_FRAME_BLOCK_WIDTH - 40;


    //the buildgame.SpriteCollection of this game
    private SpriteCollection sprites;
    //the buildgame.GameEnvironment of this game
    private GameEnvironment environment;
    //the gui of the game
    private GUI gui;

    /**
     * constructor that create ArrayList whose elements type is also all.interfaces.Collidable and ArrayList whose
     * elements type is also all.interfaces.Sprite.
     */
    public Game() {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
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
     * initialize -- Initialize a new game: create the Blocks and allsprites.Ball (and allsprites.Paddle) and add them to the game.
     */
    public void initialize() {
        gui = new GUI("game title", (int) GUI_WIDTH, (int) GUI_HEIGHT);
        biuoop.KeyboardSensor keyboardSensor = gui.getKeyboardSensor();
        //the center of the first ball
        Point centerFirstBall = new Point(40, 100);
        //the center of the second ball
        Point centerSecondBall = new Point(60, 120);
        //creating the balls
        Ball firstBall = new Ball(centerFirstBall, (int) BALL_RADIUS, Color.blue);
        Ball secondBall = new Ball(centerSecondBall, (int) BALL_RADIUS, Color.red);
        //creating the velocity of the balls
        Velocity firstVelocity = Velocity.fromAngleAndSpeed(ANGLE_BALL1, SPEED_BALL1);
        Velocity secondVelocity = Velocity.fromAngleAndSpeed(ANGLE_BALL2, SPEED_BALL2);
        //setting the velocity of the balls
        firstBall.setVelocity(firstVelocity);
        secondBall.setVelocity(secondVelocity);
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
        Point upperLeftBlock4 = new Point(0, 580);
        //creating black frame blocks in the limits of the game
        Block block1 = new Block(new Rectangle(upperLeftBlock1, HORIZONTAL_FRAME_BLOCK_WIDTH,
                HORIZONTAL_FRAME_BLOCK_HEIGHT), color1);
        Block block2 = new Block(new Rectangle(upperLeftBlock2, VERTICAL_FRAME_BLOCK_WIDTH,
                VERTICAL_FRAME_BLOCK_HEIGHT), color2);
        Block block3 = new Block(new Rectangle(upperLeftBlock3, VERTICAL_FRAME_BLOCK_WIDTH,
                VERTICAL_FRAME_BLOCK_HEIGHT), color2);
        Block block4 = new Block(new Rectangle(upperLeftBlock4, HORIZONTAL_FRAME_BLOCK_WIDTH,
                HORIZONTAL_FRAME_BLOCK_HEIGHT), color1);
        //creating an array of blocks with all the block we just created
        Block[] blocks = new Block[]{block1, block2, block3, block4};
        //for loop that run over all the blocks in the array of blocks
        for (Block block : blocks) {
            //adding each block to the game by calling for both addSprite and add all.interfaces.Collidable functions
            block.addToGame(this);
        }
        //creating colors for the blocks for the game
        Color colorOrange = new Color(255, 206, 105);
        Color colorRed = new Color(255, 72, 75);
        Color colorYellow = new Color(251, 255, 50);
        Color colorBlue = new Color(101, 255, 226);
        Color colorPink = new Color(255, 189, 208);
        //array of colors
        Color[] colorArray = {colorOrange, colorRed, colorYellow, colorBlue, colorPink, Color.GREEN};
        double pointX;
        double pointY;
        for (int i = 0; i < colorArray.length; i++) {
            for (int j = 0; j < (2 * colorArray.length) - i; j++) {
                //the y value of upper left point of the current block
                pointY = BLOCKS_Y_START + (BLOCKS_HEIGHT * (i + 1));
                //the x value of upper left point of the current block
                pointX = BLOCKS_X_START - (BLOCKS_WIDTH * (j));
                //creating the upper left point of the current block
                Point upperLeft = new Point(pointX, pointY);
                //creating the current rectangle block
                Rectangle rectangle = new Rectangle(upperLeft, BLOCKS_WIDTH, BLOCKS_HEIGHT);
                //creating the new block
                Block block = new Block(rectangle, colorArray[i]);
                //adding the block to the game
                block.addToGame(this);
            }
        }
        //the upper left point of the paddle block
        Point paddleUpperLeft = new Point(355, 567);
        //setting the color of the paddle
        Color paddleColor = new Color(255, 255, 160);
        // creating the paddle block
        Block paddleBlock = new Block(new Rectangle(paddleUpperLeft, PADDLE_WIDTH, PADDLE_HEIGHT), paddleColor);
        Paddle paddle = new Paddle(keyboardSensor, paddleBlock);
        paddle.addToGame(this);
        //setting the game of the balls
        firstBall.setGame(this.environment);
        secondBall.setGame(this.environment);
        //adding the balls to the game by calling only for addSprite() function
        firstBall.addToGame(this);
        secondBall.addToGame(this);
    }

    /**
     * run -- Run the game, start the animation loop.
     */
    public void run() {
        Sleeper sleeper = new Sleeper();
        //we want a smooth animations that displays 60 different frames in a second, if possible)
        int framesPerSecond = 60;
        //each frame in the animation can last 1000 / framesPerSecond milliseconds
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (true) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface drawSurface = gui.getDrawSurface();
            drawSurface.setColor(new Color(154, 198, 255));
            drawSurface.fillRectangle((int) VERTICAL_FRAME_BLOCK_WIDTH, (int) VERTICAL_FRAME_BLOCK_WIDTH,
                    (int) BLUE_RECTANGLE_WIDTH, (int) VERTICAL_FRAME_BLOCK_HEIGHT);
            // draw all the sprites to the screen
            this.sprites.drawAllOn(drawSurface);
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
        }
    }
}