// ID: 208387951

import biuoop.DrawSurface;
import java.awt.Color;

/**
 * @author Raviv
 * The class receive The color of the block and a current rectangle.
 * The allsprites.Block class implementing the all.interfaces.Collidable interface. allsprites.Block is something we collide into.
 */
public class Block implements Collidable, Sprite {
    // no collision point
    public static final int NO_COLLISION = 0;
    // the left side of the collision point
    public static final int LEFT_SIDE = 1;
    // the right side of the collision point
    public static final int RIGHT_SIDE = 2;
    // the top side of the collision point
    public static final int TOP_SIDE = 3;
    // the down side of the collision point
    public static final int DOWN_SIDE = 4;
    // the corner of the collision point
    public static final int CORNER = 5;

    private Rectangle rectangle;
    private Color color;

    /**
     * constructor with configurable rectangle,color.
     *
     * @param rectangle The current rectangle.
     * @param color     The color of the block.
     */
    public Block(Rectangle rectangle, java.awt.Color color) {
        this.rectangle = rectangle;
        this.color = color;
    }

    /**
     * getColor -- return the color of this ball.
     *
     * @return color of this ball
     */
    public java.awt.Color getColor() {
        return this.color;
    }


    /**
     * getCollisionRectangle -- the "collision shape" of the block.
     *
     * @return collision shape of the block.
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * drawOn -- draw the rectangle on the given DrawSurface.
     *
     * @param surface the given DrawSurface to draw on him
     */
    public void drawOn(DrawSurface surface) {
        //setting the color to the color we receive from 'getColor' function
        surface.setColor(getColor());
        //the upper left point of this rectangle
        Point upperLeft = getCollisionRectangle().getUpperLeft();
        //the width of this rectangle
        double width = getCollisionRectangle().getWidth();
        //the height of this rectangle
        double height = getCollisionRectangle().getHeight();
        //drawing the rectangle by the parameters we got
        surface.fillRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) width, (int) height);
        surface.setColor(Color.black);
        surface.drawRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) width, (int) height);
    }

    /**
     * addToGame -- adding the block to the game, calling the appropriate game methods.
     *
     * @param game the game of this black.
     */
    public void addToGame(Game game) {
        game.addSprite(this);
        game.addCollidable(this);
    }

    /**
     * timePassed --the timePassed function of the block. this will update the blocks every
     */
    public void timePassed() {

    }

    /**
     * hitSide -- the side that the ball collision with.
     *
     * @param collisionPoint  the collision point of the ball with the "collision shape" (rectangle).
     * @param currentVelocity the current velocity of the ball.
     * @return the side that the ball collision with.
     */
    public int hitSide(Point collisionPoint, Velocity currentVelocity) {
        Line collisionPointLine = new Line(collisionPoint, collisionPoint);
        //the left vertical line of the rectangle.
        Line leftVerticalLine = this.rectangle.getLeftVerticalLine();
        //the right vertical line of the rectangle.
        Line rightVerticalLine = this.rectangle.getRightVerticalLine();
        //the top horizontal line of the rectangle.
        Line topHorizontalLine = this.rectangle.getTopHorizontalLine();
        //the down horizontal line of the rectangle.
        Line downHorizontalLine = this.rectangle.getDownHorizontalLine();
        boolean isLeft, isRight, isTop, isDown;
        isLeft = leftVerticalLine.isIntersecting(collisionPointLine);
        isRight = rightVerticalLine.isIntersecting(collisionPointLine);
        isTop = topHorizontalLine.isIntersecting(collisionPointLine);
        isDown = downHorizontalLine.isIntersecting(collisionPointLine);
        //if the ball hits one of the corners of the "collision shape" (rectangle) we want to change his direction.
        if ((((isLeft && isTop) || (isLeft && isDown)) || (isRight && isTop)) || (isRight && isDown)) {
            return CORNER;
        }
        //if the ball hits the left side of the "collision shape" (rectangle) we want to change his direction.
        if (isLeft) {
            return LEFT_SIDE;
        //if the ball hits the right side of the "collision shape" (rectangle) we want to change his direction.
        } else if (isRight) {
            return RIGHT_SIDE;
        //if the ball hits the top side of the "collision shape" (rectangle) we want to change his direction.
        } else if (isTop) {
            return TOP_SIDE;
        //if the ball hits the down side of the "collision shape" (rectangle) we want to change his direction.
        } else if (isDown) {
            return DOWN_SIDE;
        }
        //if the ball does't hit any side of the "collision shape" (rectangle) at all we don't want to
        // change his direction.
        return NO_COLLISION;
    }

    /**
     * hit -- return the new velocity expected after the hit (based on the force the object inflicted on us).
     *
     * @param collisionPoint  the collision point of the ball with the "collision shape" (rectangle).
     * @param currentVelocity the current velocity of the ball.
     * @return new velocity expected after the hit.
     */
    public Velocity hit(Point collisionPoint, Velocity currentVelocity) {
        Velocity velocity;
        //check by the "hitSide" function what change in the velocity should be
        switch (hitSide(collisionPoint, currentVelocity)) {
            //if the ball hits one of the corners of the "collision shape" (rectangle) we want to change his direction.
            case CORNER:
                velocity = new Velocity(-(currentVelocity.getXVelocity()), -(currentVelocity.getYVelocity()));
                currentVelocity = velocity;
                return currentVelocity;
            //if the ball hits the left side of the "collision shape" (rectangle) we want to change his direction.
            case LEFT_SIDE:
                //if the ball hits the right side of the "collision shape" (rectangle) we want to change his direction.
            case RIGHT_SIDE:
                velocity = new Velocity(-(currentVelocity.getXVelocity()), currentVelocity.getYVelocity());
                currentVelocity = velocity;
                return currentVelocity;
            //if the ball hits the top side of the "collision shape" (rectangle) we want to change his direction.
            case TOP_SIDE:
                //if the ball hits the down side of the "collision shape" (rectangle) we want to change his direction.
            case DOWN_SIDE:
                velocity = new Velocity(currentVelocity.getXVelocity(), -(currentVelocity.getYVelocity()));
                currentVelocity = velocity;
                return currentVelocity;
            //if there wasn't collusion we want the velocity to be the same velocity.
            case NO_COLLISION:
            default:
                return currentVelocity;
        }
    }
}
