// ID: 208387951

package shapes;

/**
 * @author Raviv
 * The shapes.Velocity class helps us to achieve Animation by drawing different pictures
 * on the same area one after the other.
 * The class receive to numbers - dx and dy and by this gives our ball some speed and direction.
 * shapes.Velocity specifies the change in position on the `x` and the `y` axes.
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * constructor with configurable dx,dy.
     *
     * @param dx The distance we want to move the center of the ball in the x axes
     * @param dy The distance we want to move the center of the ball in the y axes
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * fromAngleAndSpeed -- create new instances for us by taking an angle an a speed and converting them to
     * dx and dy of the velocity.
     *
     * @param angle The angle we want to move the ball.
     * @param speed The speed we want the ball to move
     * @return the velocity we just calculate
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        //converting the angel to radians
        double dx = Math.toRadians(angle);
        double dy = Math.toRadians(angle);
        //finding the dx of the velocity by making 'sinus' to the angel and double it with the speed
        dx = Math.sin(dx) * speed;
        //finding the dy of the velocity by making 'cosines' to the angel and double it with the speed and -1
        dy = -(Math.cos(dy) * speed);
        return new Velocity(dx, dy);
    }

    /**
     * applyToPoint -- Take a point with position (x,y) and return a new point with position (x+dx, y+dy).
     *
     * @param p The center point of the ball we want to move according the velocity.
     * @return the point with the new place after the changing we calculate
     */
    public Point applyToPoint(Point p) {
        double newX = p.getX() + this.dx;
        double newY = p.getY() + this.dy;
        Point newPoint = new Point(newX, newY);
        return newPoint;
    }

    /**
     * getXVelocity -- return the dx value of the velocity of this ball.
     *
     * @return the dx of the velocity
     */
    public double getXVelocity() {
        return this.dx;
    }

    /**
     * getYVelocity -- return the dy value of the velocity of this ball.
     *
     * @return the dy of the velocity
     */
    public double getYVelocity() {
        return this.dy;
    }
}