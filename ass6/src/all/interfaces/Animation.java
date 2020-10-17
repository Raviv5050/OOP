// ID: 208387951

package all.interfaces;

import biuoop.DrawSurface;

/**
 * @author Raviv
 * The interface all.interfaces.Animation is a
 */
public interface Animation {
    /**
     * constructor with configurations- keyboardSensor that tells us what button is be in use, and
     * initialize "stop" value to false.
     * @param d the drawSurface
     */
    void doOneFrame(DrawSurface d);

    /**
     * shouldStop -- the method helps us sign when we want to stop running and exit from the game.
     * @return if we should stop the animation
     */
    boolean shouldStop();
}
