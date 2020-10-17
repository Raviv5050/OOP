// ID: 208387951

package buildgame;

import all.interfaces.Collidable;
import shapes.Point;

/**
 * @author Raviv
 * The class receive The point at which the collision occurs and the collidable object involved in the collision
 * and create an buildgame.CollisionInfo object.
 */
public class CollisionInfo {

    private Point pointOfCollision;
    private Collidable object;

    /**
     * constructor with configurable pointOfCollision,object.
     *
     * @param pointOfCollision The current point of the collision.
     * @param object           The object of the collision.
     */
    public CollisionInfo(Point pointOfCollision, Collidable object) {
        this.pointOfCollision = pointOfCollision;
        this.object = object;
    }

    /**
     * collisionPoint -- the point at which the collision occurs.
     *
     * @return point at which the collision occurs.
     */
    public Point collisionPoint() {
        return this.pointOfCollision;
    }

    /**
     * collisionPoint -- the collidable object involved in the collision.
     *
     * @return collidable object.
     */
    public Collidable collisionObject() {
        return this.object;
    }
}