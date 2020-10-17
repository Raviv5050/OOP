// ID: 208387951

package buildgame;

import all.interfaces.Animation;
import biuoop.DrawSurface;
import biuoop.GUI;
import java.awt.Color;

/**
 * @author Raviv
 * The EndScreen class support displaying the final score.
 * If the game ended with the player dying the end screen display "Game Over. Your score is X"., If the game
 * ended by clearing all the levels the end screen display "You Win! Your score is X".
 * <p>
 * The "end screen" persist until the space key is pressed. After the space key is pressed, program should terminate.
 */
public class EndScreen implements Animation {

    private boolean stop;
    private Counter score;
    private boolean isLose;
    private GUI gui;

    /**
     * constructor with configurations- keyboardSensor that tells us what button is be in use, and
     * initialize "stop" value to false.
     *
     * @param score  the current score.
     * @param isLose return true if the player loose.
     * @param gui    the current gui window.
     */
    public EndScreen(Counter score, boolean isLose, GUI gui) {
        this.stop = false;
        this.score = score;
        this.isLose = isLose;
        this.gui = gui;
    }

    /**
     * doOneFrame -- Run the game, display a end screen with the message
     * "Game Over. Your score is X"/"You Win! Your score is X". until a key is pressed.
     *
     * @param drawSurface the drawSurface we want to print on it.
     */
    public void doOneFrame(DrawSurface drawSurface) {
        drawSurface.setColor(new Color(154, 198, 255));
        drawSurface.fillRectangle((int) GameLevel.VERTICAL_FRAME_BLOCK_WIDTH,
                (int) GameLevel.VERTICAL_FRAME_BLOCK_WIDTH,
                (int) GameLevel.BLUE_RECTANGLE_WIDTH, (int) GameLevel.VERTICAL_FRAME_BLOCK_HEIGHT);
        if (this.isLose) {
            drawSurface.setColor(new Color(76, 71, 63));
            drawSurface.drawText((drawSurface.getWidth() / 2) - 106,
                    (drawSurface.getHeight() / 2) + 3, "Game Over.", 40);
            drawSurface.setColor(new Color(201, 0, 11));
            drawSurface.drawText((drawSurface.getWidth() / 2) - 108,
                    drawSurface.getHeight() / 2, "Game Over.", 40);
            drawSurface.drawText((drawSurface.getWidth() / 2) - 128,
                    (drawSurface.getHeight() / 2) + 100, "Your score is " + this.score.getValue(), 32);
        } else {
            drawSurface.setColor(new Color(154, 144, 127));
            drawSurface.drawText((drawSurface.getWidth() / 2) - 83,
                    (drawSurface.getHeight() / 2) + 3, "You Win!", 40);
            drawSurface.setColor(new Color(79, 190, 10));
            drawSurface.drawText((drawSurface.getWidth() / 2) - 85,
                    drawSurface.getHeight() / 2, "You Win!", 40);
            drawSurface.drawText((drawSurface.getWidth() / 2) - 127,
                    (drawSurface.getHeight() / 2) + 100, "Your score is "
                    + this.score.getValue(), 32);
        }
    }

    /**
     * shouldStop -- the method helps us sign when we want to stop running and exit from the game.
     * @return if we should close the animation.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
