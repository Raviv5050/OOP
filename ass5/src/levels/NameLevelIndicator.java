// ID: 208387951

package levels;

import all.interfaces.Sprite;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * @author Raviv
 * The class levels.NameLevelIndicator shows the name of the current level of the game in the giu window all the time.
 * The levels.NameLevelIndicator class implementing the all.interfaces.Sprite interface.
 */
public class NameLevelIndicator implements Sprite {
    private static final int TEXT_SIZE = 14;
    private static final int TEXT_Y_LOCATION = 16;
    private static final int TEXT_X_LOCATION = 632;

    private String nameLevel;

    /**
     * constructor with configurable nameLevel.
     *
     * @param nameLevel The current the name of the level in the game.
     */
    public NameLevelIndicator(String nameLevel) {
        this.nameLevel = nameLevel;
    }

    /**
     * drawOn -- draw the score on the given DrawSurface.
     *
     * @param surface the given DrawSurface to draw on him
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.white);
        surface.drawText(TEXT_X_LOCATION, TEXT_Y_LOCATION, "Level Name: " + nameLevel, TEXT_SIZE);
    }

    /**
     public void addTo(GameLevel level) {
     level.addSprite(this);
     }


     public void removeFrom(GameLevel level) {
     level.removeSprite(this);
     }
     **/


    /**
     * timePassed --  move the current ball one step.
     */
    @Override
    public void timePassed() {
    }
}

