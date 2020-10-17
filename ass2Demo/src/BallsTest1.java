import biuoop.GUI;
import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.Color;


public class BallsTest1 {
    public static final double guiWidth = 200;
    public static final double guiHeight = 200;

    static private void drawAnimation(Point start, double dx, double dy) {
        GUI gui = new GUI("title", (int) guiWidth, (int) guiHeight);
        Sleeper sleeper = new Sleeper();
        Ball ball = new Ball((int) start.getX(), (int) start.getY(), 30, Color.black);
        Velocity v = Velocity.fromAngleAndSpeed(90, 1);
        ball.setVelocity(v);
        //ball.setVelocity(dx, dy);
        while (true) {
            ball.moveOneStep();
            DrawSurface d = gui.getDrawSurface();
            ball.drawOn(d);
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }

    public static void main(String[] args) {
        Point p1 = new Point(100, 50);
        drawAnimation(p1, 10, 10);

        /**
         GUI gui = new GUI("Balls Test 1", 400, 400);
         DrawSurface d = gui.getDrawSurface();

         allsprites.Ball b1 = new allsprites.Ball(100,100,30,java.awt.Color.RED);
         allsprites.Ball b2 = new allsprites.Ball(100,150,10,java.awt.Color.BLUE);
         allsprites.Ball b3 = new allsprites.Ball(80,249,50,java.awt.Color.GREEN);

         b1.drawOn(d);
         b2.drawOn(d);
         b3.drawOn(d);

         gui.show(d);
         **/
        /**
         GUI gui = new GUI("title",500,600);
         biuoop.Sleeper sleeper = new biuoop.Sleeper();
         java.util.Random rand = new java.util.Random();
         while (true) {
         DrawSurface d = gui.getDrawSurface();
         allsprites.Ball ball = new allsprites.Ball(rand.nextInt(400), rand.nextInt(200), 25, Color.black);
         ball.drawOn(d);
         gui.show(d);
         sleeper.sleepFor(20);  // wait for 50 milliseconds.
         }
         **/
    }
}