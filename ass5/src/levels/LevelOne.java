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
 * The class present the first level.
 * The levels.LevelInformation class implementing the LevelInformation interface
 */
public class LevelOne implements LevelInformation {

    private static final int NUM_OF_BALLS = 1;
    private static final double ANGLE_BALL1 = 0;
    private static final double SPEED_BALL1 = 3;
    private static final int PADDLE_SPEED = 5;
    private static final int PADDLE_WIDTH = 110;
    private static final String LEVEL_NAME = "Direct Hit";
    private static final double UPPER_LEFT_X = 20;
    private static final double UPPER_LEFT_Y = 20;
    private static final double BACKGROUND_WIDTH = 760;
    private static final double BACKGROUND_HEIGHT = 580;
    private static final Point UPPER_LEFT_BLOCK = new Point(390, 154);
    private static final double BLOCK_WIDTH = 20;
    private static final double BLOCK_HEIGHT = 20;

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
        List<Velocity> velocities = new ArrayList<Velocity>();
        velocities.add(firstVelocity);
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
        DirectHit directHit = new DirectHit();
        return directHit;
    }


    /**
     * blocks -- returns a list of blocks that make up this level, each block contains its size, color and location.
     * @return a list of blocks that make up this level.
     */
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        Rectangle rectangle = new Rectangle(UPPER_LEFT_BLOCK, BLOCK_WIDTH, BLOCK_HEIGHT);
        Block block = new Block(rectangle, Color.red);
        blocks.add(block);
        return blocks;
    }


    /**
     * numberOfBlocksToRemove -- returns a number of blocks that should be removed  before the level is
     * considered to be "cleared" ( This number should be <= blocks.size(); ).
     * @return  a number of blocks that should be removed.
     */
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
