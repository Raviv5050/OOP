// ID: 208387951

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

import java.util.Random;
import java.awt.Color;

/**
 * @author Raviv
 * The class use the GUI class.
 * The class is invoked from the commandline, and each argument is a size of a allsprites.Ball.
 * The class will create an animation with number of balls as the number of the arguments.
 * Each ball will start in a random location on the screen and Each ball will start with a different speed so
 * larger balls will be slower and balls above size 50 will all have the same slow speed- 1.
 * Each ball will change direction when hitting the window border.
 */
public class MultipleBouncingBallsAnimation {
    // the default width size of the gui
    public static final double GUI_WIDTH = 200;
    public static final int GUI_WIDTH_START_X = 0;
    // the default height size of the gui
    public static final double GUI_HEIGHT = 200;
    public static final int GUI_HEIGHT_START_X = 0;
    // the default speed
    public static final double SPEED = 100;
    public static final int BIG_BALL = 50;
    public static final int NO_SPEED = 0;
    public static final int LOWEST_SPEED = 1;
    public static final int CIRCLE_ANGLE = 360;

    /**
     * createABall -- creates a ball with a random location, size that we received as an argument in
     * the main and with a random color.
     *
     * @param size the size of the radius of the ball
     * @return the ball we just create.
     */
    public Ball createABall(int size) {
        Point randomPoint = generateRandomPoint(size);
        Ball ball = new Ball(randomPoint, size, Color.black);
        return ball;
    }

    /**
     * createBallVelocity -- creates the velocity of the ball with a random angle and each ball
     * will start with a different speed so larger balls will be slower.
     *
     * @param size        the size of the radius of the ball
     * @param currentBall the ball we just created
     */
    public void createBallVelocity(int size, Ball currentBall) {
        double angle;
        double speed = SPEED;
        Velocity velocity;
        //random an angle for the velocity
        angle = generateRandomAngle();
        //if the ball radius equals to half of the rectangle high an width we don't want the ball to move
        if ((currentBall.getSize() == (GUI_WIDTH - GUI_WIDTH_START_X) / 2)
                && (currentBall.getSize() == (GUI_HEIGHT - GUI_HEIGHT_START_X) / 2)) {
            velocity = Velocity.fromAngleAndSpeed(angle, NO_SPEED);
            //if the ball size is above size 50 it will have the slow speed: 1
        } else if (currentBall.getSize() >= BIG_BALL) {
            //creating the velocity
            velocity = Velocity.fromAngleAndSpeed(angle, LOWEST_SPEED);
            //creating velocity of the ball by dividing the speed with his radius so by this way
            // larger balls will be slower
        } else {
            velocity = Velocity.fromAngleAndSpeed(angle, speed / size);
        }
        //setting the velocity by the velocity we just create
        currentBall.setVelocity(velocity);
    }

    /**
     * generateRandomPoint -- create a random location.
     *
     * @param size the size of the radius of the ball
     * @return the point of the ball we just create.
     */
    public Point generateRandomPoint(int size) {
        // create a random-number generator
        Random rand = new Random();
        //we want the x value of the random point to be in the border of the gui width without his radius value
        //so it won't be outside the border. get integer in range size to (GUI_WIDTH-size)
        int x1 = rand.nextInt((((int) GUI_WIDTH - size) - size) + 1) + size;
        //we want the y value of the random point to be in the border of the gui width without his radius value
        //so it won't be outside the border. get integer in range size to (GUI_HEIGHT-size)
        int y1 = rand.nextInt((((int) GUI_HEIGHT - size) - size) + 1) + size;
        //creating the point with the random numbers we randed
        Point randomPoint = new Point(x1, y1);
        return randomPoint;
    }

    /**
     * generateRandomAngle -- create a random angle.
     *
     * @return the angle of the ball we just create.
     */
    public Double generateRandomAngle() {
        // create a random-number generator
        Random rand = new Random();
        // get integer in range 0-360
        double angle = rand.nextInt(CIRCLE_ANGLE) + 0;
        return angle;
    }

    /**
     * drawAnimation -- creates an drawing surface and create an animation with the moving balls.
     *
     * @param ballsArray the array of the balls we created
     */
    private static void drawAnimation(Ball[] ballsArray) {
        //Creating a new GUI object so by this we create a screen, with a title and dimensions.
        GUI gui = new GUI("MultipleBouncingBallsAnimation", (int) GUI_WIDTH, (int) GUI_HEIGHT);
        Sleeper sleeper = new Sleeper();
        //infinity loop so the ball will always move because of the velocity so the animation will never stop
        while (true) {
            //drawing on the screen by using 'DrawSurface'
            DrawSurface drawSurface = gui.getDrawSurface();
            //for loop to make move and draw each ball from the array of the balls.
            for (int i = 0; i < ballsArray.length; i++) {
                //making a move on each ball from the array by applying the velocity on the center point of the
                // ball and changing his direction when it touch the sides or the corners of the gui window
                ballsArray[i].moveOneStep();
                //draw the current ball from the array on the given DrawSurface
                ballsArray[i].drawOn(drawSurface);
            }
            //shows the surface
            gui.show(drawSurface);
            //waits for 50 milliseconds after showing the surface.
            sleeper.sleepFor(50);
        }
    }

    /**
     * main - gets integers from the command line, each argument is a size of a allsprites.Ball and runs.
     * the drawAnimation method accordingly
     *
     * @param args - each argument is a size of a allsprites.Ball
     */
    public static void main(String[] args) {
        MultipleBouncingBallsAnimation multipleBalls = new MultipleBouncingBallsAnimation();
        //creating array of balls with size of the number of the arguments
        Ball[] ballsArray = new Ball[args.length];
        //for loop to make move and build each ball in the array of balls.
        for (int i = 0; i < args.length; i++) {
            //creates a ball with a random location, the size that we received here as
            // an argument and with a random color
            ballsArray[i] = multipleBalls.createABall(Integer.parseInt(args[i]));
            //creates the velocity of the ball with a random angle and speed according his size
            multipleBalls.createBallVelocity(ballsArray[i].getSize(), ballsArray[i]);
        }
        //calling to 'drawAnimation' function with the array of balls we just create
        multipleBalls.drawAnimation(ballsArray);
    }
}
