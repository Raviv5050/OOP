// ID: 208387951

import biuoop.DrawSurface;
import java.awt.Color;

/**
 * @author Raviv
 * The class use the GUI class.
 * The class receive size (radius), color, and location (a shapes.Point) and build a ball by this values.
 * The class also know how to draw each ball on a DrawSurface.
 */
public class Ball implements Sprite {
    // the default width size of the gui
    public static final double GUI_WIDTH = 1000;
    // the default height size of the gui
    public static final double GUI_HEIGHT = 1000;
    // the default x value of the start point of the gui
    public static final double GUI_START_X = 0;
    // the default y value of the start point of the gui
    public static final double GUI_START_Y = 0;

    private Point center;
    private int radius;
    private Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;

    /**
     * constructor with configurable center,r,color.
     *
     * @param center The center point of the ball
     * @param r      The radius of the ball
     * @param color  The color of the ball
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.radius = r;
        this.color = color;
        this.gameEnvironment = new GameEnvironment();
    }

    /**
     * constructor with configurable centerX,centerY,r,color.
     *
     * @param centerX The x value of the center
     * @param centerY The y value of the center
     * @param r       The radius of the ball
     * @param color   The color of the ball
     */
    public Ball(int centerX, int centerY, int r, java.awt.Color color) {
        this(new Point(centerX, centerY), r, color);
    }

    // accessors

    /**
     * getX -- return the x value of the center point of this ball.
     *
     * @return x value of the center point
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * getY -- return the y value of the center point of this ball.
     *
     * @return y value of the center point
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * getSize -- return the radius of this ball.
     *
     * @return radius of this ball
     */
    public int getSize() {
        return this.radius;
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
     * getVelocity -- return the velocity of this ball.
     *
     * @return the velocity of this ball
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * getGame -- return the current game of this ball.
     *
     * @return the current game of this ball.
     */
    public GameEnvironment getGame() {
        return this.gameEnvironment;
    }

    /**
     * drawOn -- draw the ball on the given DrawSurface.
     *
     * @param surface the given DrawSurface to draw on him
     */
    public void drawOn(DrawSurface surface) {
        //setting the color to color we receive from 'getColor' function
        surface.setColor(getColor());
        //drawing the ball by the parameters we got
        surface.fillCircle((int) center.getX(), (int) center.getY(), radius);
    }

    /**
     * setVelocity -- setting the velocity by the velocity we got.
     *
     * @param currentVelocity the given velocity
     */
    public void setVelocity(Velocity currentVelocity) {
        this.velocity = currentVelocity;
    }

    /**
     * setVelocity -- setting the velocity by the dx and dy of the velocity we got.
     *
     * @param dx the dx of the given velocity
     * @param dy the dy of the given velocity
     */
    public void setVelocity(double dx, double dy) {
        Velocity newVelocity = new Velocity(dx, dy);
        this.velocity = newVelocity;
    }

    /**
     * setGame -- set the current game of this ball.
     *
     * @param environment the game environment for this ball.
     */
    public void setGame(GameEnvironment environment) {
        this.gameEnvironment = environment;
    }

    /**
     * addToGame -- adding the ball to the game, calling the appropriate game methods.
     *
     * @param game the game of this ball.
     */
    public void addToGame(Game game) {
        game.addSprite(this);
    }

    /**
     * timePassed --  move the current ball one step.
     */
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * moveOneStep -- making a move by applying the velocity on the center point of the ball.
     */
    public void moveOneStep() {
        //the minimum x value on the current gui window
        int guiMinX = (int) GUI_START_X + this.radius;
        //the minimum y value on the current gui window
        int guiMinY = (int) GUI_START_Y + this.radius;
        //the maximum x value on the current gui window
        int guiMaxX = (int) GUI_WIDTH - this.radius;
        //the maximum y value on the current gui window
        int guiMaxY = (int) GUI_HEIGHT - this.radius;
        //by using 'changeDirectionByRange' function the ball will change his direction when it touch the sides
        // or the corners of the gui window
        changeDirectionByBlock();
        //////////////////////////////changeDirectionByRange(guiMinX, guiMinY, guiMaxX, guiMaxY);
        //if the velocity is not null we want to update the center according the change of the velocity
        if (this.velocity != null) {
            this.center = this.velocity.applyToPoint(this.center);
        }
    }

    /**
     * moveOneStepInRange -- making a move by applying the velocity on the center point of the ball.
     *
     * @param guiMinX the minimum x value on the current gui window
     * @param guiMinY the minimum y value on the current gui window
     * @param guiMaxX the maximum x value on the current gui window
     * @param guiMaxY the maximum y value on the current gui window
     */
    public void moveOneStepInRange(int guiMinX, int guiMinY, int guiMaxX, int guiMaxY) {
        //by using 'changeDirectionByRange' function the ball will change his direction when it touch the sides
        // or the corners of the gui window
        changeDirectionByBlock();
        //////////////////////////////changeDirectionByRange(guiMinX, guiMinY, guiMaxX, guiMaxY);
        //if the velocity is not null we want to update the center according the change of the velocity
        if (this.velocity != null) {
            this.center = this.velocity.applyToPoint(this.center);
        }
    }

    /**
     * changeDirectionByRange -- making a change in the direction to the moving of the ball when it touch
     * the sides or the corners of the gui window.
     *
     * @param guiMinX the minimum x value on the current gui window
     * @param guiMinY the minimum y value on the current gui window
     * @param guiMaxX the maximum x value on the current gui window
     * @param guiMaxY the maximum y value on the current gui window
     */
    public void changeDirectionByRange(int guiMinX, int guiMinY, int guiMaxX, int guiMaxY) {
        // if there isn't a collision point with one of the shapes of the collisions we want to change the velocity
        // of the ball when it touch the sides or the corners of the gui window.

        //if after the change of the velocity the ball will be in the bottom right corner we
        // want to change its direction
        if ((this.center.getX() + this.velocity.getXVelocity() >= guiMaxX)
                && (this.center.getY() + this.velocity.getYVelocity() >= guiMaxY)) {
            this.setVelocity(-(this.velocity.getXVelocity()), -(this.velocity.getYVelocity()));
            //if after the change of the velocity the ball is in the top right corner we
            // want to change its direction
        } else if ((this.center.getX() + this.velocity.getXVelocity() >= guiMaxX)
                && (this.center.getY() + this.velocity.getYVelocity() <= guiMinY)) {
            setVelocity(-(this.velocity.getXVelocity()), -(this.velocity.getYVelocity()));
            //if after the change of the velocity the ball is in the bottom left corner we
            // want to change its direction
        } else if ((this.center.getX() + this.velocity.getXVelocity() <= guiMinX)
                && (this.center.getY() + this.velocity.getYVelocity() >= guiMaxY)) {
            setVelocity(-(this.velocity.getXVelocity()), -(this.velocity.getYVelocity()));
            //if after the change of the velocity the ball is in the top left corner we want to change its direction
        } else if ((this.center.getX() + this.velocity.getXVelocity() <= guiMinX)
                && (this.center.getY() + this.velocity.getYVelocity() <= guiMinY)) {
            setVelocity(-(this.velocity.getXVelocity()), -(this.velocity.getYVelocity()));
            //if after the change of the velocity the ball is in the right edge side we want to change its direction
        } else if (this.center.getX() + this.velocity.getXVelocity() >= guiMaxX) {
            setVelocity(-(this.velocity.getXVelocity()), this.velocity.getYVelocity());
            //if after the change of the velocity the ball is in the left edge side we want to change its direction
        } else if (this.center.getX() + this.velocity.getXVelocity() <= guiMinX) {
            setVelocity(-(this.velocity.getXVelocity()), this.velocity.getYVelocity());
            //if after the change of the velocity the ball is in the bottom edge we want to change its direction
        } else if (this.center.getY() + this.velocity.getYVelocity() >= guiMaxY) {
            setVelocity(this.velocity.getXVelocity(), -(this.velocity.getYVelocity()));
            //if after the change of the velocity the ball is in the top edge we want to change its direction
        } else if (this.center.getY() + this.velocity.getYVelocity() <= guiMinY) {
            setVelocity(this.velocity.getXVelocity(), -(this.velocity.getYVelocity()));
        }
    }

    /**
     * changeDirectionByBlock -- making a change in the ball velocity so it will change his direction
     * when it touch the sides or the corners of the block.
     */
    public void changeDirectionByBlock() {
        //for loop that runs 4 times so after we changed the velocity we will check if we should make any other change
        for (int i = 0; i < 4; i++) {
            //calculating the point that the ball will be at after adding the velocity twice (the next next step)
            Point nextStepPoint = new Point(this.center.getX() + this.velocity.getXVelocity(),
                    this.center.getY() + this.velocity.getYVelocity());
            //line starting at current location and ending where the velocity will take the ball if
            // no collisions  will occur
            Line trajectory = new Line(this.center, nextStepPoint);
            // creating the collisionInfo by the value of this gameEnvironment that will return from the
            // "getClosestCollision" function with the line that we send to the function.
            CollisionInfo collisionInfo = gameEnvironment.getClosestCollision(trajectory);
            //check if there is a collision point with one of the shapes of the collisions it means also there
            //is a collisionInfo
            if (collisionInfo != null) {
                //saving the current collision point of the collisionInfo.
                Point currentCollisionPoint = collisionInfo.collisionPoint();
                //saving the current all.interfaces.Collidable of the collisionInfo.
                Collidable object = collisionInfo.collisionObject();
                //the new velocity expected after the hit with the current object and the current collision point.
                //changing the velocity by the new velocity that should be after the hit.
                this.velocity = object.hit(currentCollisionPoint, this.velocity);
                //if we didn't change anything in the velocity we don't want to continue in the  check
            } else {
                break;
            }
        }
    }
}
