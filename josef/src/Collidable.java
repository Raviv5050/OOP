// ID: 208387951

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
     * @return new velocity expected after the hit.
     */
    Velocity hit(Point collisionPoint, Velocity currentVelocity);
}