// ID: 208387951
// temp change
package all.interfaces;

/**
 * @author Raviv
 * The all.interfaces.HitNotifier interface indicate that objects that implement it send
 * notifications when they are being hit.
 */

public interface HitNotifier {

    /**
     * addHitListener -- adding the hl as a listener to hit events.
     *
     * @param hl the listener we want to add as a hit listener.
     */
    void addHitListener(HitListener hl);

    /**
     * removeHitListener -- removing the hl from the list of listeners to hit events.
     *
     * @param hl the listener we want to remove from the list of listeners.
     */
    void removeHitListener(HitListener hl);
}