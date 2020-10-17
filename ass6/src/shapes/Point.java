// ID: 208387951

package shapes;

/**
 * @author Raviv
 * The class receive 2 decimal numbers and make a point from them (because A point has an x and a y value).
 * The class measure the distance to other points, and check if it is equal to another point.
 */
public class Point {
    //The x value of the point
    private double x;
    //The y value of the point
    private double y;

    /**
     * constructor with configurable x,y.
     *
     * @param x The x value of the point
     * @param y The y value of the point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * distance -- return the distance of this point to the other point.
     *
     * @param other the other point we want to calculate the distance with.
     * @return the distance between this point to the other point
     */
    public double distance(Point other) {
        return Math.sqrt(((other.x - this.x) * (other.x - this.x)) + ((other.y - this.y) * (other.y - this.y)));
    }

    /**
     * equals -- return true if the points are equal, false otherwise.
     *
     * @param other the other point we want to check if it equal to this point.
     * @return 'true' if the points are equal, 'false' otherwise
     */
    public boolean equals(Point other) {
        if ((other.x == this.x) && (other.y == this.y)) {
            return true;
        }
        return false;
    }

    /**
     * getX -- return the x value of this point.
     *
     * @return x value of this point
     */
    public double getX() {
        return this.x;
    }

    /**
     * getY -- return the y value of this point.
     *
     * @return y value of this point
     */
    public double getY() {
        return this.y;
    }

    /**
     * setX -- update the x value of this point.
     *
     * @param pointX value for this point
     */
    public void setX(double pointX) {
        this.x = pointX;
    }

    /**
     * setY -- update the y value of this point.
     *
     * @param pointY value for this point
     */
    public void setY(double pointY) {
        this.y = pointY;
    }
}
