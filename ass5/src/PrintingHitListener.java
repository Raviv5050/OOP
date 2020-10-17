// ID: 208387951

import all.interfaces.HitListener;
import allsprites.Ball;
import allsprites.Block;

/**
 * @author Raviv
 * The PrintingHitListener class implement a simple all.interfaces.HitListener that prints a message to the
 * screen whenever a block is hit.
 */

public class PrintingHitListener implements HitListener {

    /**
     * hitEvent -- when ever the balls hit the blocks the function will print a massage to the gui screen.
     *
     * @param beingHit the block that have been hit.
     * @param hitter   the ball that hit the block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        System.out.println("A allsprites.Block was hit.");
    }
}