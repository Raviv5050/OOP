// ID: 208387951

package all.interfaces;

import allsprites.Ball;
import allsprites.Block;

/**
 * @author Raviv
 * The all.interfaces.HitListener interface indicate that objects that implement it want to be notified of hit events.
 * this objectas needs to register themselves with a all.interfaces.HitNotifier object using its addHitListener method.
 */

public interface HitListener {

    /**
     * hitEvent --  This method is called whenever the beingHit object is hit.
     * The hitter parameter is the allsprites.Ball that's doing the hitting.
     *
     * @param beingHit the block that have being hit.
     * @param hitter   the hitter ball.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
