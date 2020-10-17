// ID: 208387951

package buildgame;

import all.interfaces.Animation;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * @author Raviv
 * The buildgame.AnimationRunner class is the animations in the game
 */
public class AnimationRunner {
    private static final Object GUI_WIDTH = 800;
    private static final Object GUI_HEIGHT = 600;

    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;

    /**
     * constructor that create GUI window and set the framesPerSecond value.
     *
     * @param gui the gui window.
     */
    public AnimationRunner(GUI gui) {
        this.gui = gui;
        //we want a smooth animations that displays 60 different frames in a second, if possible)
        this.framesPerSecond = 60;
        this.sleeper = new Sleeper();
    }

    /**
     * run -- The AnimationRunner takes an Animation object and runs it. we implement the task-specific
     * information in the Animation object, and run it using the loop in the AnimationRunner class.
     *
     * @param animation an animation object.
     */
    public void run(Animation animation) {
        /**
         Sleeper sleeper = new Sleeper();
         Sleeper sleeperForText = new Sleeper();
         //we want a smooth animations that displays 60 different frames in a second, if possible)
         int framesPerSecond = 60;
         //each frame in the animation can last 1000 / framesPerSecond milliseconds
         int millisecondsPerFrame = 1000 / framesPerSecond;
         // creating a buildgame.ScoreIndicator variable
         ScoreIndicator scoreIndicator = new ScoreIndicator(score);
         while (true) {
         long startTime = System.currentTimeMillis(); // timing
         DrawSurface drawSurface = gui.getDrawSurface();
         drawSurface.setColor(new Color(154, 198, 255));
         drawSurface.fillRectangle((int) VERTICAL_FRAME_BLOCK_WIDTH, (int) VERTICAL_FRAME_BLOCK_WIDTH,
         (int) BLUE_RECTANGLE_WIDTH, (int) VERTICAL_FRAME_BLOCK_HEIGHT);
         // draw all the sprites to the screen
         this.sprites.drawAllOn(drawSurface);
         //draw the score sprite on the screen
         scoreIndicator.drawOn(drawSurface);
         //show the drawsurface
         gui.show(drawSurface);
         // notify all the sprites that time has passed
         this.sprites.notifyAllTimePassed();
         // timing- Because we are now doing more work in the loop body, the time it takes to perform the work
         // may be non-negligible. We therefor subtract the time it takes to do the work from the sleep time of
         // millisecondsPerFrame milliseconds.
         long usedTime = System.currentTimeMillis() - startTime;
         long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
         if (milliSecondLeftToSleep > 0) {
         sleeper.sleepFor(milliSecondLeftToSleep);
         }
         //if the count is zero it means no more blocks are available so we want to clear the GUI
         // resources and close the window.
         if (counter.getValue() == ZERO) {
         score.increase(100);
         gui.close();
         }
         //if the ballsCounter is zero it means no more balls are available so we want to clear the GUI
         // resources and close the window.
         if (ballsCounter.getValue() == ZERO) {
         gui.close();
         }
         }
         **/

        //each frame in the animation can last 1000 / framesPerSecond milliseconds
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d);

            //show the drawsurface
            gui.show(d);
            // notify all the sprites that time has passed


            // timing- Because we are now doing more work in the loop body, the time it takes to perform the work
            // may be non-negligible. We therefor subtract the time it takes to do the work from the sleep time of
            // millisecondsPerFrame milliseconds.
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}
