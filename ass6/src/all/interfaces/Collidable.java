// ID: 208387951

package all.interfaces;

import shapes.Point;
import shapes.Rectangle;
import shapes.Velocity;
import allsprites.Ball;


/**
 * @author Raviv
 * The interface all.interfaces.Collidable will be used by things that can be collided with.
 */
public interface Collidable {
    /**
     * getCollisionRectangle -- the "collision shape" of the block.
     *
     * @return collision shape of the block.
     */
    Rectangle getCollisionRectangle();

    /**
     * hit -- Notify the object that we collided with it at collisionPoint with  a given velocity.
     * return the new velocity expected after the hit (based on the force the object inflicted on us).
     *
     * @param collisionPoint  the collision point of the ball with the "collision shape" (rectangle).
     * @param currentVelocity the current velocity of the ball.
     * @param hitter          The hitter parameter is the allsprites.Ball that's doing the hitting.
     * @return new velocity expected after the hit.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}