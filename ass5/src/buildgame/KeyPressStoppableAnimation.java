// ID: 208387951

package buildgame;


import all.interfaces.Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;



/**
 * @author Raviv
 * The KeyPressStoppableAnimation class support "waiting-for-key-press" behavior.
 * This class wrap an existing animation and add a "waiting-for-key" behavior to it.
 */
public class KeyPressStoppableAnimation implements Animation {
    private static final String SPACE = "s";
    // ...
    // think about the implementations of doOneFrame and shouldStop.

    private KeyboardSensor keyboard;
    private String key;
    private Animation animation;
    private boolean isAlreadyPressed;
    private boolean stop;
    //private Counter score;
    // private boolean isLose;
    // private GUI gui;

    /**
     * constructor with configurations- keyboardSensor that tells us what button is be in use, and
     * initialize "stop" value to false.
     *
     * @param sensor    keyboardSensor that tells us what button is be in use.
     * @param key       the current key.
     * @param animation return the current animation.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.keyboard = sensor;
        this.key = key;
        this.animation = animation;
        this.isAlreadyPressed = true;
        this.stop = false;
        //this.score = score;
        //  this.isLose = isLose;
        //this.gui = gui;
    }

    /**
     * doOneFrame -- Run the game, display the current screen with the message accordingly .
     *
     * @param drawSurface the drawSurface we want to print on it.
     */
    public void doOneFrame(DrawSurface drawSurface) {
        if ((this.keyboard.isPressed(key)) && !this.isAlreadyPressed) {
            this.stop = true;
        }
        if (!this.keyboard.isPressed(key)) {
            this.isAlreadyPressed = false;
        }
        this.animation.doOneFrame(drawSurface);
    }


    /**
     * shouldStop -- the method helps us sign when we want to stop running and exit from the game.
     * @return if we should close the animation.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}