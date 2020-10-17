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
 * The class will create two frames with an animation with number of balls as the number of the arguments.
 * one of them is a grey rectangle from (50,50) to (500,500), and the other is a yellow rectangle from (450,450)
 * to (600,600) so the first half of the balls will bounce inside the first frame in a random location,
 * and the second half of the balls will bounce inside the second frame in a random location.
 * Each ball will start with a different speed so larger balls will be slower and balls above
 * size 50 will all have the same slow speed- 1.
 * Each ball will change direction when hitting his window border.
 */
public class MultipleFramesBouncingBallsAnimation {
    // the default width size of the gui
    public static final double GUI_WIDTH = 700;
    // the default height size of the gui
    public static final double GUI_HEIGHT = 600;
    // the default x start value of width size of the gray rectangle
    public static final int GREY_RECTANGLE_START_X = 50;
    // the default y start value of height size of the gray rectangle
    public static final int GREY_RECTANGLE_START_Y = 50;
    // the default x end value of width size of the gray rectangle
    public static final int GREY_RECTANGLE_END_X = 500;
    // the default y end value of height size of the gray rectangle
    public static final int GREY_RECTANGLE_END_Y = 500;
    // the default x start value of width size of the yellow rectangle
    public static final int YELLOW_RECTANGLE_START_X = 450;
    // the default y start value of height size of the yellow rectangle
    public static final int YELLOW_RECTANGLE_START_Y = 450;
    // the default x end value of width size of the yellow rectangle
    public static final int YELLOW_RECTANGLE_END_X = 600;
    // the default y end value of height size of the yellow rectangle
    public static final int YELLOW_RECTANGLE_END_Y = 600;
    public static final int BIG_BALL = 50;
    public static final int NO_SPEED = 0;
    public static final int LOWEST_SPEED = 1;
    // the default speed
    public static final double SPEED = 100;
    public static final int CIRCLE_ANGLE = 360;

    /**
     * createABall -- create a ball with a random location in the gray or yellow rectangle respectively,
     * with size that we received as an argument in the main and with a random color.
     *
     * @param isGrey 'true' if the ball should be in the gray rectangle, 'false' otherwise
     * @param size   the size of the radius of the ball
     * @return the ball we just create.
     */
    public Ball createABall(boolean isGrey, int size) {
        //get a random color for the ball
        Color randomColor = generateRandomColor(isGrey);
        Point randomPoint;
        //create a random location in the gray or yellow rectangle respectively
        if (isGrey) {
            randomPoint = generateGreyRandomPoint(size);
        } else {
            randomPoint = generateYellowRandomPoint(size);
        }
        //creating the ball with the location of the point,the size and the color we created
        Ball ball = new Ball(randomPoint, size, randomColor);
        return ball;
    }

    /**
     * createBallVelocity -- create the velocity of the ball with a random angle so each ball will start with
     * a different speed. according the size that we received as an argument in the main, larger balls will be
     * slower and balls above size 50 will all have the same slow speed :1.
     *
     * @param isGrey      'true' if the ball should be in the gray rectangle, 'false' otherwise
     * @param size        the size of the radius of the ball
     * @param currentBall the current ball from the array of the balls
     */
    public void createBallVelocity(boolean isGrey, int size, Ball currentBall) {
        double angle;
        double speed = SPEED;
        Velocity velocity;
        //random an angle for the velocity
        angle = generateRandomAngle();
        //if the ball in the gray rectangle and his radius equals to half of the gray rectangle high an width we
        // don't want the ball to move
        if (isGrey && (currentBall.getSize() == (GREY_RECTANGLE_END_X - GREY_RECTANGLE_START_X) / 2)
                && (currentBall.getSize() == (GREY_RECTANGLE_END_Y - GREY_RECTANGLE_START_Y) / 2)) {
            velocity = Velocity.fromAngleAndSpeed(angle, NO_SPEED);
            //if the ball in the yellow rectangle and his radius equals to half of the yellow rectangle high an width we
            //don't want the ball to move
        } else if (!isGrey && (currentBall.getSize() == (YELLOW_RECTANGLE_END_X - YELLOW_RECTANGLE_START_X) / 2)
                && (currentBall.getSize() == (YELLOW_RECTANGLE_END_Y - YELLOW_RECTANGLE_START_Y) / 2)) {
            velocity = Velocity.fromAngleAndSpeed(angle, NO_SPEED);
            //if the ball size is above size 50 it will have the slow speed: 1
        } else if (currentBall.getSize() >= BIG_BALL) {
            //creating the velocity
            velocity = Velocity.fromAngleAndSpeed(angle, LOWEST_SPEED);
            //creating velocity of the ball by dividing the speed with his radius so by this way larger
            // balls will be slower
        } else {
            velocity = Velocity.fromAngleAndSpeed(angle, speed / size);
        }
        //setting the velocity by the velocity we just create
        currentBall.setVelocity(velocity);
    }

    /**
     * generateRandomColor -- create a random color.
     *
     * @param isGrey 'true' if the ball should be in the gray rectangle, 'false' otherwise
     * @return the random color we just create.
     */
    public Color generateRandomColor(boolean isGrey) {
        // create a random-number generator
        Random rand = new Random();
        //create an initialize new color
        Color randomColor;
        //rand number from 1 to 24
        int randomNumber = rand.nextInt(24) + 1;
        //each number will give us a color
        switch (randomNumber) {
            case 1:
                randomColor = Color.black;
                break;
            case 2:
                randomColor = Color.blue;
                break;
            case 3:
                randomColor = Color.darkGray;
                break;
            case 4:
                randomColor = Color.pink;
                break;
            case 5:
                randomColor = Color.red;
                break;
            case 6:
                //we don't want yellow ball to be in the yellow rectangle
                if (!isGrey) {
                    randomColor = new Color(154, 198, 255);
                } else {
                    randomColor = Color.yellow;
                }

                break;
            case 7:
                //we don't want gray ball to be in the gray rectangle
                if (isGrey) {
                    randomColor = new Color(225, 255, 215);
                } else {
                    randomColor = Color.gray;
                }

                break;
            case 8:
                randomColor = Color.green;
                break;
            case 9:
                randomColor = Color.CYAN;
                break;
            case 10:
                randomColor = Color.magenta;
                break;
            case 11:
                randomColor = Color.LIGHT_GRAY;
                break;
            case 12:
                randomColor = Color.white;
                break;
            case 13:
                randomColor = Color.orange;
                break;
            case 14:
                randomColor = new Color(198, 207, 255);
                break;
            case 15:
                //we don't want yellow ball to be in the yellow rectangle
                if (!isGrey) {
                    randomColor = new Color(118, 255, 209);
                } else {
                    randomColor = new Color(255, 255, 160);
                }

                break;
            case 16:
                randomColor = new Color(255, 142, 133);
                break;
            case 17:
                randomColor = new Color(255, 222, 252);
                break;
            case 18:
                randomColor = new Color(255, 191, 197);
                break;
            case 19:
                randomColor = new Color(164, 255, 238);
                break;
            case 20:
                randomColor = new Color(135, 255, 135);
                break;
            case 21:
                randomColor = new Color(60, 151, 255);
                break;
            case 22:
                //we don't want yellow ball to be in the yellow rectangle
                if (!isGrey) {
                    randomColor = new Color(63, 115, 96);
                } else {
                    randomColor = new Color(255, 206, 140);
                }
                break;
            case 23:
                //we don't want yellow ball to be in the yellow rectangle
                if (!isGrey) {
                    randomColor = new Color(255, 15, 81);
                } else {
                    randomColor = new Color(215, 255, 24);
                }
                break;
            case 24:
                randomColor = new Color(231, 85, 54);
                break;
            default:
                randomColor = Color.black;
        }
        return randomColor;
    }

    /**
     * generateGreyRandomPoint -- create a random location in the grey rectangle.
     *
     * @param size the size of the radius of the ball
     * @return the point of the ball we just create.
     */
    public Point generateGreyRandomPoint(int size) {
        // create a random-number generator
        Random rand = new Random();
        //the minimum x value on the grey rectangle
        int greyRectangleMinX = GREY_RECTANGLE_START_X + size;
        //the minimum y value on the grey rectangle
        int greyRectangleMinY = GREY_RECTANGLE_START_Y + size;
        //the maximum x value on the grey rectangle
        int greyRectangleMaxX = GREY_RECTANGLE_END_X - size;
        //the maximum y value on the grey rectangle
        int greyRectangleMaxY = GREY_RECTANGLE_END_Y - size;
        //we want the x value of the random point to be in the border of the grey rectangle width without his
        //radius value so it won't be outside the border. get integer in range greyRectangleMinX to greyRectangleMaxX
        int x1 = rand.nextInt((greyRectangleMaxX - greyRectangleMinX) + 1) + greyRectangleMinX;
        //we want the y value of the random point to be in the border of the grey rectangle height without his
        //radius value so it won't be outside the border. get integer in range greyRectangleMinY to greyRectangleMaxY
        int y1 = rand.nextInt((greyRectangleMaxY - greyRectangleMinY) + 1) + greyRectangleMinY;
        //creating the point with the random numbers we randed
        Point greyRandomPoint = new Point(x1, y1);
        return greyRandomPoint;
    }

    /**
     * generateYellowRandomPoint -- create a random location in the yellow rectangle.
     *
     * @param size the size of the radius of the ball
     * @return the point of the ball we just create.
     */
    public Point generateYellowRandomPoint(int size) {
        // create a random-number generator
        Random rand = new Random();
        //the minimum x value on the yellow rectangle
        int yellowRectangleMinX = YELLOW_RECTANGLE_START_X + size;
        //the minimum y value on the yellow rectangle
        int yellowRectangleMinY = YELLOW_RECTANGLE_START_Y + size;
        //the maximum x value on the yellow rectangle
        int yellowRectangleMaxX = YELLOW_RECTANGLE_END_X - size;
        //the maximum y value on the yellow rectangle
        int yellowRectangleMaxY = YELLOW_RECTANGLE_END_Y - size;
        //we want the x value of the random point to be in the border of the yellow rectangle width without his
        //radius value so it won't be outside the border.get integer in range yellowRectangleMinX to yellowRectangleMinX
        int x1 = rand.nextInt((yellowRectangleMaxX - yellowRectangleMinX) + 1) + yellowRectangleMinX;
        //we want the y value of the random point to be in the border of the yellow rectangle height without his
        //radius value so it won't be outside the border.get integer in range yellowRectangleMinY to yellowRectangleMaxY
        int y1 = rand.nextInt((yellowRectangleMaxY - yellowRectangleMinY) + 1) + yellowRectangleMinY;
        //creating the point with the random numbers we randed
        Point yellowRandomPoint = new Point(x1, y1);
        return yellowRandomPoint;
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
     * sortBySize -- sort the ballsArray so by this method big size of balls will be upon the smaller one.
     *
     * @param startIndexToSort the start index we want to sort the array of the balls from this index
     * @param lastIndexToSort  the last index we want to sort the array of the balls from this index
     * @param ballsArray       the balls array we build
     */
    public void sortBySize(int startIndexToSort, int lastIndexToSort, Ball[] ballsArray) {
        //index if we have made a change in the location of the balls in the array
        boolean isChange = true;
        Ball tempBall;
        //for loop from the end of the array to the start index to sort. if no change have been in the
        //last running in the for loop it means the array is already sorted and we can stop.
        for (int i = lastIndexToSort; i > startIndexToSort && isChange; i--) {
            isChange = false;
            for (int j = startIndexToSort; j < i; j++) {
                //if the ball size is smaller then the size of the next ball in the array we want to switch between them
                if (ballsArray[j].getSize() > ballsArray[j + 1].getSize()) {
                    tempBall = ballsArray[j];
                    ballsArray[j] = ballsArray[j + 1];
                    ballsArray[j + 1] = tempBall;
                    isChange = true;
                }
            }
        }
    }

    /**
     * drawAnimation -- creates an drawing surface and create an animation with the moving balls.
     *
     * @param maxGreyIndex the last index from the array, of the ball that should be in grey rectangle
     * @param ballsArray   the array of the balls we created
     */
    private static void drawAnimation(int maxGreyIndex, Ball[] ballsArray) {
        int size;
        int greyRectangleMinX, greyRectangleMinY, greyRectangleMaxX, greyRectangleMaxY;
        int yellowRectangleMinX, yellowRectangleMinY, yellowRectangleMaxX, yellowRectangleMaxY;
        //Creating a new GUI object so by this we create a screen, with a title and dimensions.
        GUI gui = new GUI("MultipleFramesBouncingBallsAnimation", (int) GUI_WIDTH, (int) GUI_HEIGHT);
        Sleeper sleeper = new Sleeper();
        //infinity loop so the ball will always move because of the velocity so the animation will never stop
        while (true) {
            //drawing on the screen by using 'DrawSurface'
            DrawSurface drawSurface = gui.getDrawSurface();
            drawSurface.setColor(Color.gray);
            //drawing the grey rectangle
            drawSurface.fillRectangle(50, 50, 450, 450);
            drawSurface.setColor(Color.yellow);
            //drawing the yellow rectangle
            drawSurface.fillRectangle(450, 450, 150, 150);
            //for loop to make move and draw each ball from the array of the balls.
            for (int i = 0; i < ballsArray.length; i++) {
                size = ballsArray[i].getSize();
                if (i <= maxGreyIndex) {
                    greyRectangleMinX = GREY_RECTANGLE_START_X + size;
                    greyRectangleMinY = GREY_RECTANGLE_START_Y + size;
                    greyRectangleMaxX = GREY_RECTANGLE_END_X - size;
                    greyRectangleMaxY = GREY_RECTANGLE_END_Y - size;
                    //making a move on each ball in the grey rectangle by applying the velocity on the center point of
                    //the ball and changing his direction when it touch the sides or the corners of the grey rectangle
                    ballsArray[i].moveOneStepInRange(greyRectangleMinX, greyRectangleMinY,
                            greyRectangleMaxX, greyRectangleMaxY);
                } else {
                    yellowRectangleMinX = YELLOW_RECTANGLE_START_X + size;
                    yellowRectangleMinY = YELLOW_RECTANGLE_START_Y + size;
                    yellowRectangleMaxX = YELLOW_RECTANGLE_END_X - size;
                    yellowRectangleMaxY = YELLOW_RECTANGLE_END_Y - size;
                    //making a move on each ball in the yellow rectangle by applying the velocity on the center point of
                    //the ball and changing his direction when it touch the sides or the corners of the yellow rectangle
                    ballsArray[i].moveOneStepInRange(yellowRectangleMinX, yellowRectangleMinY,
                            yellowRectangleMaxX, yellowRectangleMaxY);
                }
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
     * main - gets integers from the command line, each argument is a size of a allsprites.Ball and runs
     * the drawAnimation method accordingly.
     *
     * @param args - each argument is a size of a allsprites.Ball
     */
    public static void main(String[] args) {
        MultipleFramesBouncingBallsAnimation multipleFramesBalls = new MultipleFramesBouncingBallsAnimation();
        //creating array of balls with size of the number of the arguments
        Ball[] ballsArray = new Ball[args.length];
        int startIndexToSort, lastIndexToSort, maxGreyIndex = 0;
        boolean isEven, isGrey;
        //check if the number of the balls will be even or odd
        if (args.length % 2 == 0) {
            isEven = true;
        } else {
            isEven = false;
        }
        //for loop to make move and build each ball in the array of balls.
        for (int i = 0; i < args.length; i++) {
            //we want to save the last index of the grey ball
            if ((isEven && i < args.length / 2) || ((!isEven) && i <= args.length / 2)) {
                isGrey = true;
                maxGreyIndex = i;
            } else {
                isGrey = false;
            }
            //creates a ball with a random location in the gray or yellow rectangle respectively, the size that
            //we received here as an argument and with a random color
            ballsArray[i] = multipleFramesBalls.createABall(isGrey, Integer.parseInt(args[i]));
            //creates the velocity of the ball with a random angle and speed according his size
            multipleFramesBalls.createBallVelocity(isGrey, ballsArray[i].getSize(), ballsArray[i]);
        }
        startIndexToSort = 0;
        lastIndexToSort = maxGreyIndex;
        //sort the array by the size of the balls from smallest to biggest, just for balls in the grey rectangle.
        multipleFramesBalls.sortBySize(startIndexToSort, lastIndexToSort, ballsArray);
        startIndexToSort = lastIndexToSort + 1;
        lastIndexToSort = ballsArray.length - 1;
        //sort the array by the size of the balls from smallest to biggest, just for balls in the yellow rectangle.
        multipleFramesBalls.sortBySize(startIndexToSort, lastIndexToSort, ballsArray);
        //calling to 'drawAnimation' function with the array of balls we just create
        multipleFramesBalls.drawAnimation(maxGreyIndex, ballsArray);
    }
}
