// ID: 208387951

package buildgame;

import all.interfaces.HitListener;
import allsprites.Ball;
import allsprites.Block;

/**
 * @author Raviv
 * The class buildgame.BlockRemover is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 * The buildgame.BlockRemover class implementing the all.interfaces.HitListener interface.
 */

public class BlockRemover implements HitListener {

    private static final int ONE = 1;

    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * constructor with configurable game,removedBlocks.
     *
     * @param game          The current game (buildgame.Game object), in order to be able to remove blocks from it.
     * @param removedBlocks The remaining number of blocks, so that we could recognize when no more blocks are available
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * hitEvent --  removing the block that have being hit from the game. remove this listener from the current
     * "being hit" block that is being removed from the game.
     *
     * @param beingHit the block that have being hit.
     * @param hitter   the hitter ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeHitListener(this);
        remainingBlocks.decrease(ONE);
        beingHit.removeFromGame(this.game);
    }
}