// ID: 208387951

import java.util.ArrayList;
import java.util.List;

/**
 * @author Raviv
 * The class receive 1 upper left point and the width and height of this rectangle and create a rectangle from this
 * values. the class also make a list of the intersection points of the rectangle with a line.
 */
public class Rectangle {
    //the upper left point of this rectangle
    private Point upperLeft;
    //the width of this rectangle
    private double width;
    //the height of this rectangle
    private double height;

    /**
     * constructor with configurable of the upperLeft point, the width and the height of this rectangle.
     *
     * @param upperLeft the upper left point of this rectangle
     * @param width     the width of this rectangle
     * @param height    the height of this rectangle
     */
    // Create a new rectangle with location and width/height.
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * enterToIntersectionList -- enter the intersection point of the lines to the list.
     *
     * @param intersectionList list of intersection points with the specified line and the current line of the rectangle
     * @param line             the specified line
     * @param other            the current line of the rectangle
     */
    public void enterToIntersectionList(java.util.List intersectionList, Line line, Line other) {
        Point intersectionPoint = line.intersectionWith(other);
        if (intersectionPoint != null) {
            intersectionList.add(intersectionPoint);
        }
    }

    /**
     * intersectionPoints -- Return a (possibly empty) List of intersection points with the specified line.
     *
     * @param line the specified line
     * @return List of intersection points with the line
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> intersectionList = new ArrayList<Point>();
        //calculating the value of the upper right point of the rectangle.
        Point upperRight = getUpperRight();
        //calculating the value of the down left point of the rectangle.
        Point downLeft = getDownLeft();
        //calculating the value of the down right point of the rectangle.
        Point downRight = getDownRight();
        //the left vertical line of the rectangle.
        Line leftVerticalLine = getLeftVerticalLine();
        //the right vertical line of the rectangle.
        Line rightVerticalLine = getRightVerticalLine();
        //the top horizontal line of the rectangle.
        Line topHorizontalLine = getTopHorizontalLine();
        //the down horizontal line of the rectangle.
        Line downHorizontalLine = getDownHorizontalLine();
        //send the line that we got and topHorizontalLine line that we created to the "enterToIntersectionList"
        //function to check if the lines are intersect, ans add this point if they are intersect
        enterToIntersectionList(intersectionList, line, topHorizontalLine);
        //send the line that we got and downHorizontalLine line that we created to the "enterToIntersectionList"
        //function to check if the lines are intersect, ans add this point if they are intersect
        enterToIntersectionList(intersectionList, line, downHorizontalLine);
        //send the line that we got and leftVerticalLine line that we created to the "enterToIntersectionList"
        //function to check if the lines are intersect, ans add this point if they are intersect
        enterToIntersectionList(intersectionList, line, leftVerticalLine);
        //send the line that we got and rightVerticalLine line that we created to the "enterToIntersectionList"
        //function to check if the lines are intersect, ans add this point if they are intersect
        enterToIntersectionList(intersectionList, line, rightVerticalLine);


        //return the List of intersection points with the specified line.
        return intersectionList;
    }

    /**
     * getWidth -- Return the width of the rectangle.
     *
     * @return the rectangle width.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * getHeight -- Return the height of the rectangle.
     *
     * @return the rectangle height.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * getUpperLeft -- Return the upper-left point of the rectangle.
     *
     * @return the rectangle upper-left point.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * getUpperRight -- Return the upper-right point of the rectangle.
     *
     * @return the rectangle upper-right point.
     */
    public Point getUpperRight() {
        //calculating the value of the upper right point of the rectangle.
        Point upperRight = new Point(upperLeft.getX() + this.width, upperLeft.getY());
        return upperRight;
    }

    /**
     * getDownLeft -- Return the down-left point of the rectangle.
     *
     * @return the rectangle down-left point.
     */
    public Point getDownLeft() {
        //calculating the value of the down left point of the rectangle.
        Point downLeft = new Point(upperLeft.getX(), upperLeft.getY() + this.height);
        return downLeft;
    }

    /**
     * getDownRight -- Return the down-right point of the rectangle.
     *
     * @return the rectangle down-right point.
     */
    public Point getDownRight() {
        //calculating the value of the down right point of the rectangle.
        Point downRight = new Point(upperLeft.getX() + this.width, upperLeft.getY() + this.height);
        return downRight;
    }

    /**
     * getLeftVerticalLine -- left vertical line of the rectangle.
     *
     * @return the left vertical line of the rectangle.
     */
    public Line getLeftVerticalLine() {
        //the left vertical line of the rectangle.
        Line leftVerticalLine = new Line(this.upperLeft, getDownLeft());
        return leftVerticalLine;
    }

    /**
     * getRightVerticalLine -- right vertical line of the rectangle.
     *
     * @return the right vertical line of the rectangle.
     */
    public Line getRightVerticalLine() {
        //the right vertical line of the rectangle.
        Line rightVerticalLine = new Line(getUpperRight(), getDownRight());
        return rightVerticalLine;
    }

    /**
     * getTopHorizontalLine -- top horizontal line of the rectangle.
     *
     * @return the top horizontal line of the rectangle.
     */
    public Line getTopHorizontalLine() {
        //the top horizontal line of the rectangle.
        Line topHorizontalLine = new Line(this.upperLeft, getUpperRight());
        return topHorizontalLine;
    }

    /**
     * getDownHorizontalLine -- down horizontal line of the rectangle.
     *
     * @return the down horizontal line of the rectangle.
     */
    public Line getDownHorizontalLine() {
        //the down horizontal line of the rectangle.
        Line downHorizontalLine = new Line(getDownLeft(), getDownRight());
        return downHorizontalLine;
    }
}