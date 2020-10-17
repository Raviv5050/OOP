// ID: 208387951

package buildgame;

import all.interfaces.HitListener;
import allsprites.Ball;
import allsprites.Block;

/**
 * @author Raviv
 * The class buildgame.BallRemover is in charge of removing balls from the game when hiting the "death region", as well
 * as updating an availabe-balls counter.
 * The buildgame.BallRemover class implementing the all.interfaces.HitListener interface.
 */

public class BallRemover implements HitListener {
    private static final int ONE = 1;

    private GameLevel game;
    private Counter remainingBalls;

    /**
     * constructor with configurable game,removedBlocks.
     *
     * @param game         The current game (buildgame.Game object), in order to be able to remove balls from it.
     * @param removedBalls The remaining number of balls, so that we could recognize when no more balls are available
     */
    public BallRemover(GameLevel game, Counter removedBalls) {
        this.game = game;
        this.remainingBalls = removedBalls;
    }

    /**
     * hitEvent --  removing the ball that have being hit the "death region" in the game. remove this
     * listener from the current "being hit" block when removing the last ball that is being removed from the game.
     *
     * @param beingHit the block that have being hit with the "death region".
     * @param hitter   the hitter ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        /**
         if (remainingBalls.getValue() == 0) {
         beingHit.removeHitListener(this);
         } **/
        remainingBalls.decrease(ONE);
        hitter.removeFromGame(this.game);
    }
}
