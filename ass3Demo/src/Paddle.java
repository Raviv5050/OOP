// ID: 208387951

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * @author Raviv
 * The allsprites.Paddle class is the player in the game. It is a rectangle that is controlled by the arrow keys, and moves
 * according to the player key presses. It should implement the all.interfaces.Sprite and the all.interfaces.Collidable interfaces.
 * It's also know how to move to the left and to the right by using timePassed method .
 */
public class Paddle implements Sprite, Collidable {
    public static final double PART_TWO = 2;
    public static final double PART_THREE = 3;
    public static final double PART_FOUR = 4;
    public static final double FIVE_PARTS = 5;
    public static final double ANGLE_REGION_ONE = 300;
    public static final double ANGLE_REGION_TWO = 330;
    public static final double ANGLE_REGION_FOUR = 30;
    public static final double ANGLE_REGION_FIVE = 60;
    // no collision point
    public static final int NO_COLLISION = 0;
    // the most left side of the paddle
    public static final int REGION_ONE = 1;
    // the left side (that more close to the middle) of the paddle
    public static final int REGION_TWO = 2;
    // the middle side of the paddle
    public static final int MIDDLE_REGION_THREE = 3;
    // the right side (that more close to the middle) of the paddle
    public static final int REGION_FOUR = 4;
    // the most right side of the paddle
    public static final int REGIONE_FIVE = 5;
    // the most right side of the paddle
    public static final int RIGHT_RIB = 6;
    // the most right side of the paddle
    public static final int LEFT_RIB = 7;
    //the distance the paddle should move after pressing right on the keyboard
    public static final double PADDLE_RIGHT_CHANGE = 5;
    //the distance the paddle should move after pressing left on the keyboard
    public static final double PADDLE_LEFT_CHANGE = 5;

    //the KeyboardSensor for the moving
    private biuoop.KeyboardSensor keyboard;
    //the paddle block
    private Block paddleBlock;

    /**
     * constructor that create the block for the paddle and the keyboard.
     *
     * @param keyboardSensor the keyboard of this paddle
     * @param paddleBlock    the block of this paddle
     */
    public Paddle(KeyboardSensor keyboardSensor, Block paddleBlock) {
        this.keyboard = keyboardSensor;
        this.paddleBlock = paddleBlock;
    }

    /**
     * moveLeft -- move the paddle accordingly if the "left" key is pressed.
     */
    public void moveLeft() {
        //the rectangle of this paddle
        Rectangle paddleRectangle = paddleBlock.getCollisionRectangle();
        //the upper left point of the rectangle of this paddle
        Point paddleUpperLeft = paddleBlock.getCollisionRectangle().getUpperLeft();
        //check if the "left" key is pressed
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            //check if after the left move change the paddle will still be in the window width range
            if (paddleUpperLeft.getX() - PADDLE_LEFT_CHANGE >= Game.BOTTOM_BLOCK_START_WIDTH) {
                //updating the new location of the paddle so the paddle will move left
                paddleBlock.getCollisionRectangle().getUpperLeft().setX(paddleUpperLeft.getX() - PADDLE_LEFT_CHANGE);
            }
        }
    }

    /**
     * moveLeft -- move the paddle accordingly if the "right" key is pressed.
     */
    public void moveRight() {
        //the rectangle of this paddle
        Rectangle paddleRectangle = paddleBlock.getCollisionRectangle();
        //the upper left point of the rectangle of this paddle
        Point paddleUpperLeft = paddleBlock.getCollisionRectangle().getUpperLeft();
        //check if the "right" key is pressed
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            //check if after the right move change the paddle will still be in the window width range
            if (paddleUpperLeft.getX() + PADDLE_RIGHT_CHANGE <= Game.BOTTOM_BLOCK_WIDTH - paddleRectangle.getWidth()) {
                //updating the new location of the paddle so the paddle will move right
                paddleBlock.getCollisionRectangle().getUpperLeft().setX(paddleUpperLeft.getX() + PADDLE_RIGHT_CHANGE);
            }
        }
    }

    /**
     * timePassed --   all.interfaces.Sprite- check if the "left" or "right" keys are pressed, and if so move the paddle accordingly.
     */
    public void timePassed() {
        //calling to "moveLeft()" function
        this.moveLeft();
        //calling to "moveRight()" function
        this.moveRight();
    }

    /**
     * drawOn -- draw the paddle on the given DrawSurface.
     *
     * @param drawSurface the given DrawSurface to draw on him
     */
    public void drawOn(DrawSurface drawSurface) {
        //setting the color to the color we receive from 'getColor' function
        drawSurface.setColor(paddleBlock.getColor());
        //the upper left point of this paddle (rectangle)
        Point upperLeft = paddleBlock.getCollisionRectangle().getUpperLeft();
        //the width of this paddle (rectangle)
        double width = paddleBlock.getCollisionRectangle().getWidth();
        //the height of this paddle (rectangle)
        double height = paddleBlock.getCollisionRectangle().getHeight();
        //drawing the rectangle by the parameters we got
        drawSurface.fillRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) width, (int) height);
    }

    /**
     * getCollisionRectangle -- the "collision shape" of the paddle.
     *
     * @return collision shape of the paddle.
     */
    // all.interfaces.Collidable
    public Rectangle getCollisionRectangle() {
        return this.paddleBlock.getCollisionRectangle();
    }

    /**
     * hitSide -- the side and the region of the paddle that the ball collision with.
     *
     * @param collisionPoint  the collision point of the ball with the paddle (rectangle).
     * @param currentVelocity the current velocity of the ball.
     * @return the region of the paddle that the ball collision with.
     */
    public int hitSide(Point collisionPoint, Velocity currentVelocity) {
        //the upper left point of the paddle (rectangle)
        Point upperLeft = this.getCollisionRectangle().getUpperLeft();
        //the width of the paddle
        double paddleWidth = this.getCollisionRectangle().getWidth();
        //the width of the first part of the paddle
        double partOne = paddleWidth / FIVE_PARTS;
        //the width of the second part of the paddle (including the first part width)
        double partTwo = PART_TWO * (paddleWidth / FIVE_PARTS);
        //the width of the third part of the paddle (including the second part width)
        double partThree = PART_THREE * (paddleWidth / FIVE_PARTS);
        //the width of the fourth part of the paddle (including the third part width)
        double partFour = PART_FOUR * (paddleWidth / FIVE_PARTS);
        //the width of the fifth part of the paddle (including all the previous parts width)
        double partFive = paddleWidth;
        //creating a line from the point "collisionPoint" so the function "isIntersecting" can check if the point
        // (that now we send her to the function as line that present a point) is in the other line
        Line collisionPointLine = new Line(collisionPoint, collisionPoint);
        //the top horizontal line of the paddle rectangle.
        Line paddleTopSide = this.paddleBlock.getCollisionRectangle().getTopHorizontalLine();
        //the left vertical line of the rectangle.
        Line paddleLeftSide = this.paddleBlock.getCollisionRectangle().getLeftVerticalLine();
        //the right vertical line of the rectangle.
        Line paddleRightSide = this.paddleBlock.getCollisionRectangle().getRightVerticalLine();
        //check if the collision point is in the left side of the paddle
        if (paddleLeftSide.isIntersecting(collisionPointLine)) {
            return LEFT_RIB;
        }
        //check if the collision point is in the right side of the paddle
        if (paddleRightSide.isIntersecting(collisionPointLine)) {
            return RIGHT_RIB;
        }
        //check if the collision point is in the top side of the paddle
        if (paddleTopSide.isIntersecting(collisionPointLine)) {
            //the x value of the collision point
            double xIntersectionPoint = collisionPoint.getX();
            //the difference between the x value of the collision point to the x value of the upper left point of
            //the rectangle of the paddle
            double intersectionLocation = xIntersectionPoint - upperLeft.getX();
            //check if the difference between the x value of the collision point to the x value of the upper left point
            //of the paddle is smaller then the width of the first part of the paddle
            if (intersectionLocation < partOne) {
                return REGION_ONE;
            }
            //check if the difference between the x value of the collision point to the x value of the upper left point
            //of the paddle is smaller then the width of the second part of the paddle (including the first part width)
            if (intersectionLocation < partTwo) {
                return REGION_TWO;
            }
            //check if the difference between the x value of the collision point to the x value of the upper left point
            //of the paddle is smaller then the width of the third part of the paddle (including the second part width)
            if (intersectionLocation < partThree) {
                return MIDDLE_REGION_THREE;
            }
            //check if the difference between the x value of the collision point to the x value of the upper left point
            //of the paddle is smaller then the width of the fourth part of the paddle (including the third part width)
            if (intersectionLocation < partFour) {
                return REGION_FOUR;
            }
            //check if the difference between the x value of the collision point to the x value of the upper left
            //point of the paddle is smaller then the width of the fifth part of the paddle (including all
            // the previous parts width)
            if (intersectionLocation < partFive) {
                return REGIONE_FIVE;
            }
        }
        //if the ball does't hit any side of the paddle (rectangle) at all we don't want to
        // change his direction.
        return NO_COLLISION;
    }

    /**
     * hit -- return the new velocity expected after the hit (based on the force the object inflicted on us).
     *
     * @param collisionPoint  the collision point of the ball with the "collision shape"- paddle (rectangle).
     * @param currentVelocity the current velocity of the ball.
     * @return new velocity expected after the hit.
     */
    public Velocity hit(Point collisionPoint, Velocity currentVelocity) {
        //creating a new velocity
        Velocity velocity;
        //we want to save the previous velocity of the ball so the speed of the ball won't change at all. calculating
        //the speed by using pythagoras sentence.
        double speed = Math.sqrt(Math.pow(currentVelocity.getXVelocity(), 2)
                + Math.pow(currentVelocity.getYVelocity(), 2));
        //check by the "hitSide" function what change in the velocity should be done
        switch (hitSide(collisionPoint, currentVelocity)) {
            //if the ball hits the right or left side of the paddle we want the ball to change his direction in the
            //x axes.
            case LEFT_RIB:
            case RIGHT_RIB:
                //creating the new velocity
                velocity = new Velocity(-(currentVelocity.getXVelocity()), currentVelocity.getYVelocity());
                currentVelocity = velocity;
                return currentVelocity;
            //if the ball hits the first left region side of the paddle the ball should bounce back with an
            // angle of 300 degrees (-60), regardless of where it came from.
            case REGION_ONE:
                //creating the new velocity
                velocity = Velocity.fromAngleAndSpeed(ANGLE_REGION_ONE, speed);
                currentVelocity = velocity;
                return currentVelocity;
            //if the ball hits the region 2 side of the paddle the ball should bounce back with an
            // angle of 330 degrees, regardless of where it came from.
            case REGION_TWO:
                //creating the new velocity
                velocity = Velocity.fromAngleAndSpeed(ANGLE_REGION_TWO, speed);
                currentVelocity = velocity;
                return currentVelocity;
            //if the ball hits the region 3 (the middle) side of the paddle the ball it should keep its horizontal
            // direction and only change its vertical one (like when hitting a block)
            case MIDDLE_REGION_THREE:
                //creating the new velocity
                velocity = new Velocity(currentVelocity.getXVelocity(), -(currentVelocity.getYVelocity()));
                currentVelocity = velocity;
                return currentVelocity;
            //if the ball hits the region 4 side of the paddle the ball should bounce back with an
            // angle of 30 degrees, regardless of where it came from.
            case REGION_FOUR:
                //creating the new velocity
                velocity = Velocity.fromAngleAndSpeed(ANGLE_REGION_FOUR, speed);
                currentVelocity = velocity;
                return currentVelocity;
            //if the ball hits the region 5 side of the paddle the ball should bounce back with an
            // angle of 360 degrees, regardless of where it came from.
            case REGIONE_FIVE:
                //creating the new velocity
                velocity = Velocity.fromAngleAndSpeed(ANGLE_REGION_FIVE, speed);
                currentVelocity = velocity;
                return currentVelocity;
            //if there wasn't collusion we want the velocity to be the same velocity.
            case NO_COLLISION:
            default:
                return currentVelocity;
        }
    }

    /**
     * addToGame -- adding this paddle to the game, calling the appropriate game methods.
     *
     * @param game the game of this paddle.
     */
    public void addToGame(Game game) {
        //add the given paddle (sprite) to the sprites
        game.addSprite(this);
        //add the given paddle (collidable) to the environment
        game.addCollidable(this);
    }
}