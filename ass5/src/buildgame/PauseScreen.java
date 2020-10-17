// ID: 208387951

package buildgame;

import all.interfaces.Animation;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * @author Raviv
 * The class adding an option to pause the game when pressing the p key. It is a very simple animation, that
 * will display a screen with the message paused -- press space to continue until a key is pressed.
 */
public class PauseScreen implements Animation {
    private boolean stop;

    /**
     * constructor with configurations- keyboardSensor that tells us what button is be in use, and
     * initialize "stop" value to false.
     */
    public PauseScreen() {
        this.stop = false;
    }

    /**
     * doOneFrame -- Run the game, display a screen with the message paused -- press space to continue
     * until a key is pressed.
     *
     * @param drawSurface the drawSurface we want to print on it.
     */
    public void doOneFrame(DrawSurface drawSurface) {
        drawSurface.setColor(new Color(154, 198, 255));
        drawSurface.fillRectangle((int) GameLevel.VERTICAL_FRAME_BLOCK_WIDTH,
                (int) GameLevel.VERTICAL_FRAME_BLOCK_WIDTH,
                (int) GameLevel.BLUE_RECTANGLE_WIDTH, (int) GameLevel.VERTICAL_FRAME_BLOCK_HEIGHT);
        drawSurface.setColor(new Color(185, 205, 185));
        drawSurface.drawText(148, (drawSurface.getHeight() / 2) - 2, "paused -- press space to continue", 32);
        drawSurface.setColor(new Color(35, 62, 8));
        drawSurface.drawText(150, drawSurface.getHeight() / 2, "paused -- press space to continue", 32);
    }

    /**
     * shouldStop -- the method helps us sign when we want to stop running and exit from the game.
     * @return if we should stop the animation
     */
    public boolean shouldStop() {
        return this.stop;
    }
}