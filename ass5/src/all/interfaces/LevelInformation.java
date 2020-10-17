// ID: 208387951

package all.interfaces;

import allsprites.Block;
import shapes.Velocity;

import java.util.List;

/**
 * @author Raviv
 * The interface all.interfaces.LevelInformation specifies the information required to fully describe a level
 */
public interface LevelInformation {

    /**
     * numberOfBalls -- return the number of the balls in this level.
     * @return the number of the balls in this level.
     */
    int numberOfBalls();

    /**
     * initialBallVelocities -- return The initial velocity of each ball in this level
     * (always initialBallVelocities().size() == numberOfBalls()).
     * @return The initial velocity of each ball in this level
     */
    List<Velocity> initialBallVelocities();

    /**
     * paddleSpeed -- return the speed of the paddle in this level.
     * @return the speed of the paddle in this level.
     */
    int paddleSpeed();

    /**
     * paddleWidth -- return the width of the paddle in this level.
     * @return the width of the paddle in this level.
     */
    int paddleWidth();

    /**
     * levelName -- return the name of this level, the level name will be displayed at the top of the screen.
     * @return the name of this level.
     */
    String levelName();

    /**
     * getBackground -- returns a sprite with the background of the level.
     * @return a sprite with the background of the level
     */
    Sprite getBackground();

    /**
     * blocks -- returns a list of blocks that make up this level, each block contains its size, color and location.
     * @return a list of blocks that make up this level.
     */
    List<Block> blocks();

    /**
     * numberOfBlocksToRemove -- returns a number of blocks that should be removed  before the level is
     * considered to be "cleared" ( This number should be <= blocks.size(); ).
     * @return a number of blocks that should be removed.
     */
    int numberOfBlocksToRemove();
}