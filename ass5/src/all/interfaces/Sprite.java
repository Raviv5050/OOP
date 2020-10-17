// ID: 208387951

package all.interfaces;

import biuoop.DrawSurface;

/**
 * @author Raviv
 * The interface all.interfaces.Sprite is a game object that can be drawn to the screen, Sprites can be drawn on the
 * screen, and can be notified that time has passed.
 */
public interface Sprite {
    /**
     * drawOn -- draw the sprite to the screen.
     *
     * @param d the given DrawSurface to draw on him
     */
    void drawOn(DrawSurface d);

    /**
     * timePassed --notify the sprite that time has passed.
     */
    void timePassed();
}