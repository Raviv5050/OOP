// ID: 208387951

package levels;

import all.interfaces.LevelInformation;
import all.interfaces.Sprite;
import allsprites.Block;
import shapes.Point;
import shapes.Rectangle;
import shapes.Velocity;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Raviv
 * The class present the second level.
 * The levels.LevelInformation class implementing the LevelInformation interface
 */
public class LevelTwo implements LevelInformation {

    private static final int NUM_OF_BALLS = 10;
    private static final double ANGLE_BALL1 = 310;
    private static final double SPEED_BALL1 = 6;
    private static final double ANGLE_BALL2 = 320;
    private static final double SPEED_BALL2 = 6;
    private static final double ANGLE_BALL3 = 330;
    private static final double SPEED_BALL3 = 6;
    private static final double ANGLE_BALL4 = 340;
    private static final double SPEED_BALL4 = 6;
    private static final double ANGLE_BALL5 = 350;
    private static final double SPEED_BALL5 = 6;
    private static final double ANGLE_BALL6 = 10;
    private static final double SPEED_BALL6 = 6;
    private static final double ANGLE_BALL7 = 20;
    private static final double SPEED_BALL7 = 6;
    private static final double ANGLE_BALL8 = 30;
    private static final double SPEED_BALL8 = 6;
    private static final double ANGLE_BALL9 = 40;
    private static final double SPEED_BALL9 = 6;
    private static final double ANGLE_BALL10 = 50;
    private static final double SPEED_BALL10 = 6;
    private static final int PADDLE_SPEED = 5;
    private static final int PADDLE_WIDTH = 500;
    private static final String LEVEL_NAME = "Wide Easy";
    private static final double UPPER_LEFT_X = 20;
    private static final double UPPER_LEFT_Y = 20;
    private static final double BACKGROUND_WIDTH = 760;
    private static final double BACKGROUND_HEIGHT = 580;
    private static final double BLOCKS_Y_START = 200;
    //Tthe x value we want the blocks to start from
    public static final double BLOCKS_X_START = 20;
    public static final double BLOCKS_WIDTH = 50.6429;
    public static final double BLOCKS_HEIGHT = 30;


    /**
     * numberOfBalls -- return the number of the balls in this level.
     * @return the number of the balls in this level.
     */
    public int numberOfBalls() {
        return NUM_OF_BALLS;
    }


    /**
     * initialBallVelocities -- return The initial velocity of each ball in this level
     * (always initialBallVelocities().size() == numberOfBalls()).
     * @return The initial velocity of each ball in this level.
     */
    public List<Velocity> initialBallVelocities() {
        //creating the velocity of the balls
        Velocity firstVelocity = Velocity.fromAngleAndSpeed(ANGLE_BALL1, SPEED_BALL1);
        Velocity secondVelocity = Velocity.fromAngleAndSpeed(ANGLE_BALL2, SPEED_BALL2);
        Velocity thirdVelocity = Velocity.fromAngleAndSpeed(ANGLE_BALL3, SPEED_BALL3);
        Velocity fourthVelocity = Velocity.fromAngleAndSpeed(ANGLE_BALL4, SPEED_BALL4);
        Velocity fifthVelocity = Velocity.fromAngleAndSpeed(ANGLE_BALL5, SPEED_BALL5);
        Velocity sixthVelocity = Velocity.fromAngleAndSpeed(ANGLE_BALL6, SPEED_BALL6);
        Velocity seventhVelocity = Velocity.fromAngleAndSpeed(ANGLE_BALL7, SPEED_BALL7);
        Velocity eighthVelocity = Velocity.fromAngleAndSpeed(ANGLE_BALL8, SPEED_BALL8);
        Velocity ninthVelocity = Velocity.fromAngleAndSpeed(ANGLE_BALL9, SPEED_BALL9);
        Velocity tenthVelocity = Velocity.fromAngleAndSpeed(ANGLE_BALL10, SPEED_BALL10);
        List<Velocity> velocities = new ArrayList<Velocity>();
        velocities.add(firstVelocity);
        velocities.add(secondVelocity);
        velocities.add(thirdVelocity);
        velocities.add(fourthVelocity);
        velocities.add(fifthVelocity);
        velocities.add(sixthVelocity);
        velocities.add(seventhVelocity);
        velocities.add(eighthVelocity);
        velocities.add(ninthVelocity);
        velocities.add(tenthVelocity);
        return velocities;
    }

    /**
     * paddleSpeed -- return the speed of the paddle in this level.
     * @return  the speed of the paddle in this level.
     */
    public int paddleSpeed() {
        return PADDLE_SPEED;
    }

    /**
     * paddleWidth -- return the width of the paddle in this level.
     * @return the width of the paddle in this level.
     */
    public int paddleWidth() {
        return PADDLE_WIDTH;
    }


    /**
     * levelName -- return the name of this level, the level name will be displayed at the top of the screen.
     * @return the name of this level.
     */
    public String levelName() {
        return LEVEL_NAME;
    }

    /**
     * getBackground -- returns a sprite with the background of the level.
     * @return a sprite with the background of the level.
     */
    public Sprite getBackground() {
        WideEasy wideEasy = new WideEasy();
        return wideEasy;
    }


    /**
     * blocks -- returns a list of blocks that make up this level, each block contains its size, color and location.
     * @return a list of blocks that make up this level
     */
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();

        //creating colors for the blocks for the game
        Color colorOrange = new Color(255, 206, 105);
        Color colorRed = new Color(255, 72, 75);
        Color colorYellow = new Color(251, 255, 50);
        Color colorBlue = new Color(101, 255, 226);
        Color colorPink = new Color(255, 189, 208);
        //array of colors
        Color[] colorArray = {colorRed, colorRed, colorOrange, colorOrange, colorYellow, colorYellow, Color.GREEN,
                Color.GREEN, Color.GREEN, colorBlue, colorBlue, colorPink, colorPink, Color.blue, Color.blue};
        double pointX;
        double pointY;
        int indexColor;
        for (int i = 0; i <= 14; i++) {
            //the y value of upper left point of the current block
            pointY = BLOCKS_Y_START;
            //the x value of upper left point of the current block
            pointX = BLOCKS_X_START + (BLOCKS_WIDTH * (i));
            //creating the upper left point of the current block
            Point upperLeft = new Point(pointX, pointY);
            //creating the current rectangle block
            Rectangle rectangle = new Rectangle(upperLeft, BLOCKS_WIDTH, BLOCKS_HEIGHT);
            if (i == 15) {
                //creating the new block
                Block lastBlock = new Block(rectangle, colorArray[i - 1]);
                blocks.add(lastBlock);
            } else {
                //creating the new block
                Block block = new Block(rectangle, colorArray[i]);
                blocks.add(block);
            }
        }
        return blocks;

    }


    /**
     * numberOfBlocksToRemove -- returns a number of blocks that should be removed  before the level is
     * considered to be "cleared" ( This number should be <= blocks.size(); ).
     * @return a number of blocks that should be removed .
     */
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
