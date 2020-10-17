// ID: 208387951

package buildgame;

import all.interfaces.Animation;
import biuoop.DrawSurface;
import biuoop.Sleeper;
import java.awt.Color;


/**
 * @author Raviv
 * The CountdownAnimation class  will display the given gameScreen, for numOfSeconds seconds, and on top of them it
 * will show a countdown from countFrom back to 1, where each number will appear on the screen for
 * (numOfSeconds / countFrom) seconds, before it is replaced with the next one.
 */
public class CountdownAnimation implements Animation {
    private static final double TO_MILI_SECONDS = 1000;


    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean stop;
    private Sleeper sleeper;
    private long currentCount;
    private boolean start;

    /**
     * constructor with configurations- numOfSeconds, countFrom, and gameScreen.
     *
     * @param numOfSeconds num of seconds that we want the countdown to show up.
     * @param countFrom    the countFrom number that we want the countdown to start from.
     * @param gameScreen   all the sprites of the game.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.stop = false;
        this.sleeper = new Sleeper();
        this.currentCount = countFrom;
        this.start = true;
    }

    /**
     * doOneFrame--  printing the countFrom from 3 to 1 and subtract 1 from the count number each time.
     *
     * @param drawSurface the current surface to draw on.
     */
    public void doOneFrame(DrawSurface drawSurface) {
        // draw all the sprites to the screen
        this.gameScreen.drawAllOn(drawSurface);
        drawSurface.setColor(new Color(219, 220, 229));
        drawSurface.drawText((drawSurface.getWidth() / 2) - 24,
                drawSurface.getHeight() / 2, "" + this.currentCount, 90);
        this.currentCount--;
        if (this.start) {
            this.start = false;
            return;
        }
        sleeper.sleepFor((long) (TO_MILI_SECONDS * (numOfSeconds / countFrom)));
    }


    /**
     * shouldStop -- the method helps us sign when we want to stop running the countdownAnimation game.
     * @return if we should close the animation.
     */
    public boolean shouldStop() {
        if (this.currentCount < 0) {
            return (!this.stop);
        }
        return (this.stop);
    }
}
