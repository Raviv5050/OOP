// ID: 208387951

import java.util.ArrayList;
import java.util.List;

/**
 * @author Raviv
 * The class receive a new ArrayList whose elements type is also all.interfaces.Collidable and make collidables point to it.
 */

public class GameEnvironment {
    //create a new ArrayList whose elements type is also all.interfaces.Collidable.
    private List<Collidable> collidables;

    /**
     * constructor that create ArrayList whose elements type is also all.interfaces.Collidable and make collidables point to it.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<Collidable>();
    }

    /**
     * collidable -- add the given collidable to the environment.
     *
     * @param c the new collidable c.
     */
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }

    /**
     * getClosestCollision -- Assume an object moving from line.start() to line.end(). If this object will
     * not collide with any of the collidables in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     *
     * @param trajectory the new line that simulates the moving of the ball from line.start() to line.end().
     * @return an new buildgame.CollisionInfo
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        //the current rectangle of this collision.
        Rectangle currentRectangle;
        //the current collision point (the closest intersection point to start of the line from all the
        // intersection points with this current rectangle).
        Point collisionPoint = null;
        //boolean value to show us if we already insert a point to "minCollisionPoint" point or not.
        boolean firstTimeMin = true;
        //the distance between the minimum collision point to the start of the line .
        double minDistance = 0;
        //the collision point with the minimum distance between the point  to the the start of the line .
        Point minCollisionPoint = null;
        Collidable object = null;
        CollisionInfo collisionInfo;
        //for-each loop to traverse the elements (collidables) in the list
        for (Collidable c : collidables) {
            //the current rectangle of this collision.
            currentRectangle = c.getCollisionRectangle();
            //the current collision point (the closest intersection point to start of the line from all the
            // intersection points with this current rectangle).
            collisionPoint = trajectory.closestIntersectionToStartOfLine(currentRectangle);
            //check if we still didn't insert a point to "minCollisionPoint"
            if (firstTimeMin) {
                //if there is a collision point with this current rectangle of this collision
                if (collisionPoint != null) {
                    //initialize "minCollisionPoint" value to be "collisionPoint"
                    minCollisionPoint = collisionPoint;
                    //initialize "minDistance" value to be the distance between the minimum collision point
                    // to the start of the line
                    minDistance = minCollisionPoint.distance(trajectory.start());
                    //initialize "object" value to be the current collidable value 'c' that we've got
                    object = c;
                    //update the boolean value "firstTimeMin" to false so it will show us that we already
                    // insert a point to "minCollisionPoint" point
                    firstTimeMin = false;
                }
            //if we already insert a point to "minCollisionPoint"
            } else {
                //if there is a collision point with this current rectangle of this collision and if this point
                // distance between this collision point to the start of the line is smaller then the
                // distance between the minimum collision point to the start of the line
                if (collisionPoint != null && collisionPoint.distance(trajectory.start()) < minDistance) {
                    //update the "minCollisionPoint" value to be "collisionPoint"
                    minCollisionPoint = collisionPoint;
                    //update "minDistance" value to be the current distance between the minimum collision point
                    // to the start of the line
                    minDistance = minCollisionPoint.distance(trajectory.start());
                    //update "object" value to be the current collidable value 'c' that we've got
                    object = c;
                }
            }
        }
        // check if there is a collision point with one of the shapes of the collisions it means also there
        // is a "minCollisionPoint"
        if (minCollisionPoint != null) {
            //create the "collisionInfo" value that we want to return with the minimum collision point and it's
            // collidable
            collisionInfo = new CollisionInfo(minCollisionPoint, object);
            return collisionInfo;
        }
        //if there isn't any collision point with one of the shapes of the collisions it means the
        // object is not collide with any of the collidables in this collection,so we will return null.
        return null;
    }
}