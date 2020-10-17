// ID: 208387951

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import java.awt.Color;

/**
 * @author Raviv
 * The class use the GUI class.
 * The class receive 4 integers in the main from the command line and runs the drawAnimation method accordingly.
 */
public class BouncingBallAnimation {
    // the default width size of the gui
    public static final double GUI_WIDTH = 200;
    // the default height size of the gui
    public static final double GUI_HEIGHT = 200;
    //the radius of the ball
    public static final int RADIUS = 30;

    /**
     * drawAnimation -- creates an drawing surface, give our ball some speed and direction and
     * create an animation with a moving ball.
     *
     * @param start the start point of the center point of the ball
     * @param dx    the dx of the given velocity
     * @param dy    the dy of the given velocity
     */
     private static void drawAnimation(Point start, double dx, double dy) {
        //Creating a new GUI object so by this we create a screen, with a title and dimensions.
        GUI gui = new GUI("BouncingBallAnimation", (int) GUI_WIDTH, (int) GUI_HEIGHT);
        Sleeper sleeper = new Sleeper();
        //creating a ball according the point we got
        Ball ball = new Ball((int) start.getX(), (int) start.getY(), RADIUS, Color.pink);
        //setting the velocity by the dx and dy of the velocity we got
        ball.setVelocity(dx, dy);
        //infinity loop so the ball will always move because of the velocity so the animation will never stop
        while (true) {
            //making a move by applying the velocity on the center point of the ball and changing his
            //direction when it touch the sides or the corners of the gui window
            ball.moveOneStep();
            //drawing on the screen by using 'DrawSurface'
            DrawSurface drawSurface = gui.getDrawSurface();
            //draw the ball on the given DrawSurface
            ball.drawOn(drawSurface);
            //shows the surface
            gui.show(drawSurface);
            //waits for 50 milliseconds after showing the surface.
            sleeper.sleepFor(50);
        }
    }

    /**
     * main - gets 4 integers from the command line and runs the drawAnimation method accordingly.
     *
     * @param args - args[0] is the x value of the point, args[1] is the y value of the point,
     *             args[2] is the dx value of the velocity of the point and args[3] is the dy
     *             value of the velocity of the point.
     */
    public static void main(String[] args) {

        //creating the point so args[0] is the x value of the point and args[1] is the y value of the point
        Point newPoint = new Point(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
        //check if the x and y values of the starting point is in the range of the GUI board
        if ((newPoint.getX() < RADIUS || newPoint.getX() > (GUI_WIDTH - RADIUS))
                && (newPoint.getY() < RADIUS || newPoint.getY() > (GUI_HEIGHT - RADIUS))) {
            System.out.println("x and y values must be in range");
        } else if (newPoint.getX() < RADIUS || newPoint.getX() > (GUI_WIDTH - RADIUS)) {
            System.out.println("x value must be in range");
        } else if (newPoint.getY() < RADIUS || newPoint.getY() > (GUI_HEIGHT - RADIUS)) {
            System.out.println("y value must be in range");
        } else {
            //calling to 'drawAnimation' function with the point we just create and the dx and dy we received.
            drawAnimation(newPoint, Double.parseDouble(args[2]), Double.parseDouble(args[3]));
        }
    }
}
