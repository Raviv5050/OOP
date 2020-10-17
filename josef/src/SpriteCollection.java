// ID: 208387951

import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Raviv
 * The class receive a new ArrayList whose elements type is also sprite, so by this way buildgame.SpriteCollection
 * will hold a collection of sprites, and the class will call timePassed()  and drawOn(d) functions on all sprites.
 */
public class SpriteCollection {
    //create a new ArrayList whose elements type is also sprite.
    private List<Sprite> sprites;

    /**
     * constructor that create ArrayList whose elements type is also all.interfaces.Sprite and make sprite to it.
     */
    public SpriteCollection() {
        this.sprites = new ArrayList<Sprite>();
    }

    /**
     * addSprite -- add the given sprite s to the sprites.
     *
     * @param s the new sprite s.
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /**
     * notifyAllTimePassed -- call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        for (Sprite currentSprite : sprites) {
            currentSprite.timePassed();
        }
    }

    /**
     * drawAllOn -- call drawOn(d) on all sprites.
     *
     * @param d the drawsurface we want to draw the sprites on.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite currentSprite : sprites) {
            currentSprite.drawOn(d);
        }
    }
}