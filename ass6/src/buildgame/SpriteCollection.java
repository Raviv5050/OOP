// ID: 208387951

package buildgame;

import all.interfaces.Sprite;
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
     * removeCurrentSprite -- remove the current given sprite s from the sprites.
     *
     * @param s the sprite that should be removed.
     */
    public void removeCurrentSprite(Sprite s) {
        this.sprites.remove(s);
    }

    /**
     * notifyAllTimePassed -- call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        // Make a copy of the sprites before iterating over them.
        List<Sprite> tempSprites = new ArrayList<Sprite>(this.sprites);
        for (Sprite currentSprite : tempSprites) {
            currentSprite.timePassed();
        }
    }

    /**
     * drawAllOn -- call drawOn(d) on all sprites.
     *
     * @param d the drawsurface we want to draw the sprites on.
     */
    public void drawAllOn(DrawSurface d) {
        // Make a copy of the sprites before iterating over them.
        List<Sprite> tempSprites = new ArrayList<Sprite>(this.sprites);
        for (Sprite currentSprite : tempSprites) {
            currentSprite.drawOn(d);
        }
    }
}