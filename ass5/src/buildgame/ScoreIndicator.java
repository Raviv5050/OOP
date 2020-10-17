// ID: 208387951

package buildgame;

import all.interfaces.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author Raviv
 * The class buildgame.ScoreIndicator shows the score of the game in the giu window all the time
 * The buildgame.ScoreIndicator class implementing the all.interfaces.Sprite interface.
 */

public class ScoreIndicator implements Sprite {

    private static final int TEXT_SIZE = 17;
    private static final int TEXT_Y_LOCATION = 16;
    private static final int TEXT_X_LOCATION = 385;

    private Counter currentScore;

    /**
     * constructor with configurable scoreCounter.
     *
     * @param scoreCounter The current the score of the game.
     */
    public ScoreIndicator(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * drawOn -- draw the score on the given DrawSurface.
     *
     * @param surface the given DrawSurface to draw on him
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.white);
        surface.drawText(TEXT_X_LOCATION, TEXT_Y_LOCATION, "Score: " + currentScore.getValue(), TEXT_SIZE);
    }

    /**
     * timePassed --  move the current ball one step.
     */
    @Override
    public void timePassed() {
    }
}
