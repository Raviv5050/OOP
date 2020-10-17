// ID: 208387951

package shapes;

import java.util.List;

/**
 * @author Raviv
 * The class receive 2 points -- a start point and an end point and make a line (actually a line-segment)
 * that connects this two points.
 * The class calculate the length of each line, check if the line intersect with other lines,
 * and check if it is the same line as another line segment.
 */
public class Line {
    //the intersection point of this line with other lines
    private Point intersection;
    //the start point of this line
    private Point start;
    //the middle point of this line
    private Point thisMiddle;
    //the end point of this line
    private Point end;

    /**
     * constructor with configurable of the start point and the end point of the line.
     *
     * @param start The start point of the line
     * @param end   The end point of the line
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * constructor with configurable of the x,y values of the start and end point of the line.
     *
     * @param x1 The x value of the start point of the line
     * @param y1 The y value of the start point of the line
     * @param x2 The x value of the end point of the line
     * @param y2 The y value of the end point of the line
     */
    public Line(double x1, double y1, double x2, double y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    /**
     * length -- Return the length of the line.
     *
     * @return the length of the line.
     */
    public double length() {
        //"distance" function will return the distance between this points and this is the length of the line
        return start.distance(end);
    }

    /**
     * middle -- Returns the middle point of the line.
     *
     * @return the middle point.
     */
    public Point middle() {
        //calculating the middle by doing average to start and end x value and  average to start and end y value
        this.thisMiddle = new Point((start.getX() + end.getX()) / 2, (start.getY() + end.getY()) / 2);
        return thisMiddle;
    }

    /**
     * start -- Returns the start point of the line.
     *
     * @return the start point.
     */
    public Point start() {
        return this.start;
    }

    /**
     * end -- Returns the end point of the line.
     *
     * @return the end point.
     */
    public Point end() {
        return this.end;
    }

    /**
     * maxXPoint --  Returns the point with the biggest x value.
     *
     * @param startPoint The start point of the line
     * @param endPoint   The end point of the line
     * @return The point with the biggest x value
     */
    public Point maxXPoint(Point startPoint, Point endPoint) {
        //check which point (start or end) has bigger x value
        if (startPoint.getX() > endPoint.getX()) {
            return startPoint;
        }
        return endPoint;
    }

    /**
     * minXPoint --  Returns the point with with the lowest x value.
     *
     * @param startPoint The start point of the line
     * @param endPoint   The end point of the line
     * @return The point with the lowest x value
     */
    public Point minXPoint(Point startPoint, Point endPoint) {
        //check which point (start or end) has lower x value
        if (startPoint.getX() < endPoint.getX()) {
            return startPoint;
        }
        return endPoint;
    }

    /**
     * maxYPoint --  Returns the point with with the biggest y value.
     *
     * @param startPoint The start point of the line
     * @param endPoint   The end point of the line
     * @return The point with the biggest y value
     */
    public Point maxYPoint(Point startPoint, Point endPoint) {
        //check which point (start or end) has bigger y value
        if (startPoint.getY() > endPoint.getY()) {
            return startPoint;
        }
        return endPoint;
    }

    /**
     * minYPoint --  Returns the point with with the lowest y value.
     *
     * @param startPoint The start point of the line
     * @param endPoint   The end point of the line
     * @return The point with the lowest y value
     */
    public Point minYPoint(Point startPoint, Point endPoint) {
        //check which point (start or end) has lower y value
        if (startPoint.getY() < endPoint.getY()) {
            return startPoint;
        }
        return endPoint;
    }

    /**
     * isParallelXAxis --  Returns true if the line is parallel to the x axis, false otherwise.
     *
     * @param startPoint The start point of the line
     * @param endPoint   The end point of the line
     * @return 'true' if the line is parallel to the x axis, 'false' otherwise.
     */
    public boolean isParallelXAxis(Point startPoint, Point endPoint) {
        //check if the y start value equals to end y value and if it's not the same point so line is Parallel to x axis
        if ((startPoint.getY() == endPoint.getY()) && (startPoint.getX() != endPoint.getX())) {
            return true;
        }
        return false;
    }

    /**
     * isParallelYAxis --  Returns true if the line is parallel to the y axis, false otherwise.
     *
     * @param startPoint The start point of the line
     * @param endPoint   The end point of the line
     * @return 'true' if the line is parallel to the y axis, 'false' otherwise.
     */
    public boolean isParallelYAxis(Point startPoint, Point endPoint) {
        //check if the x start value equals to end x value and if it's not the same point so line is Parallel to y axis
        if ((startPoint.getX() == endPoint.getX()) && (startPoint.getY() != endPoint.getY())) {
            return true;
        }
        return false;
    }

    /**
     * isXPointInLine --  Returns true if the x parameter of the point in the line, false otherwise.
     *
     * @param xIntersection The x point value that we want to check if it's in the line
     * @param startPoint    The start point of the line
     * @param endPoint      The end point of the same line
     * @return 'true' if the x parameter of the point in the line, 'false' otherwise.
     */
    public boolean isXPointInLine(double xIntersection, Point startPoint, Point endPoint) {
        double currentMinX, currentMaxX;
        // variable that save the minimum X value from the start point and the end point
        currentMinX = Math.min(startPoint.getX(), endPoint.getX());
        // variable that save the maximum X value from the start point and the end point
        currentMaxX = Math.max(startPoint.getX(), endPoint.getX());
        // check if the X value of the point is bigger then the minimum X and smaller then the maximum X
        if ((xIntersection >= currentMinX) && (xIntersection <= currentMaxX)) {
            // the x parameter of the point in the line - return true
            return true;
        }
        // the x parameter of the point isn't in the line - return false
        return false;
    }

    /**
     * isYPointInLine --  Returns true if the Y parameter of the point in the line, false otherwise.
     *
     * @param yIntersection The y point value that we want to check if it's in the line
     * @param startPoint    The start point of the line
     * @param endPoint      The end point of the same line
     * @return 'true' if the y parameter of the point in the line, 'false' otherwise.
     */
    public boolean isYPointInLine(double yIntersection, Point startPoint, Point endPoint) {
        double currentMinY, currentMaxY;
        // variable that save the maximum y value from the start point and the end point
        currentMaxY = Math.max(startPoint.getY(), endPoint.getY());
        // variable that save the minimum y value from the start point and the end point
        currentMinY = Math.min(startPoint.getY(), endPoint.getY());
        // check if the y value of a point is bigger then the minimum y and smaller then the maximum y
        if ((yIntersection >= currentMinY) && (yIntersection <= currentMaxY)) {
            // the y parameter of the point is in the line - return true
            return true;
        }
        // the y parameter of the point isn't in the line - return false
        return false;
    }

    /**
     * yPointIntersection --  Returns the y parameter of the intersection point.
     *
     * @param xIntersection The x point value of the intersection
     * @param startPoint    The start point of the line
     * @param endPoint      The end point of the same line
     * @return Returns the y intersection.
     */
    public double yPointIntersection(double xIntersection, Point startPoint, Point endPoint) {
        // variable of the incline , variable save the intersection with the y axis , variable of the y intersection
        double currentIncline, currentB, yIntersection;
        //incline is the difference between y start and end values divide in the difference between x start and end
        currentIncline = (endPoint.getY() - startPoint.getY()) / (endPoint.getX() - startPoint.getX());
        //the 'b' parameter of the equation "y =m*x + b" is the y value of one of the points minos difference the
        // incline of the line dual the x value of the point
        currentB = startPoint.getY() - (currentIncline * startPoint.getX());
        //the y intersection value equals to the incline of the line dual the x intersection value plus the current b
        yIntersection = (currentIncline * xIntersection) + currentB;
        return yIntersection;
    }

    /**
     * isPointInLine --  Returns true if the point in the line, false otherwise.
     *
     * @param suspiciousPoint The point that maybe it's the intersection point between the lines
     * @param startPoint      The start point of the line
     * @param endPoint        The end point of the same line
     * @return 'true' if the point in the line, 'false' otherwise
     */
    public boolean isPointInLine(Point suspiciousPoint, Point startPoint, Point endPoint) {
        double xIntersection, yIntersection;
        //the x value of the suspiciousPoint
        xIntersection = suspiciousPoint.getX();
        //the y value of the suspiciousPoint according to the same x value in the second line
        yIntersection = yPointIntersection(xIntersection, startPoint, endPoint);
        //if the x value of the suspicious intersection point in the second line and the y value that we found equals to
        //the y value of the suspicious intersection point so the lines intersect and this is the intersection point
        if (isXPointInLine(suspiciousPoint.getX(), startPoint, endPoint) && yIntersection == suspiciousPoint.getY()) {
            this.intersection = new Point(xIntersection, yIntersection);
            return true;
        }
        return false;
    }

    /**
     * isParallelLineIntersect--Returns true if parallel line to y axis intersect with the other line,false otherwise.
     *
     * @param startPoint    The start point of the line
     * @param endPoint      The end point of the same line
     * @param startParallel The start point of the parallel line
     * @param endParallel   The end point of the same parallel line
     * @return 'true' if the the parallel y line intersect with the other line, 'false' otherwise
     */
    public boolean isParallelLineIntersect(Point startPoint, Point endPoint, Point startParallel, Point endParallel) {
        double xIntersection, yIntersection;
        //the x value of the start point of the parallel line
        xIntersection = startParallel.getX();
        //the y value of the suspiciousPoint according to the x of the of the parallel line
        yIntersection = yPointIntersection(xIntersection, startPoint, endPoint);
        //if the x value of the parallel line in the second line and the y value that we found in the parallel line
        //so the lines intersect and this is the intersection point
        if (isXPointInLine(startParallel.getX(), startPoint, endPoint)
                && isYPointInLine(yIntersection, startParallel, endParallel)) {
            this.intersection = new Point(xIntersection, yIntersection);
            return true;
        }
        return false;
    }

    /**
     * isIntersecting --  Returns true if the lines intersect, false otherwise.
     *
     * @param other an other line
     * @return 'true' if the lines intersect, 'false' otherwise
     */
    public boolean isIntersecting(Line other) {
        double currentMinX, currentMaxX, otherMinX, otherMaxX, xIntersection, yIntersection;
        double currentIncline, otherIncline, currentB, otherB;
        //check if both of the lines are a point and check if it's the same point, if yes they are intersect
        if (this.start.equals(this.end) && other.start.equals(other.end)) {
            if (this.start.equals(other.start)) {
                xIntersection = this.start.getX();
                yIntersection = this.start.getY();
                this.intersection = new Point(xIntersection, yIntersection);
                return true;
            }
            return false;
            //check if one of the lines is a point and check if the point on the other line, if yes they are intersect
        } else if (this.start.equals(this.end) || other.start.equals(other.end)) {
            //check this case if the line is parallel to y axis
            if (isParallelYAxis(this.start, this.end)) {
                //if the x value of the point equals to the x value of the parallel line and the y value of the point
                //in the parallel line so the lines intersect and this is the intersection point
                if ((other.start.getX() == this.start.getX())
                        && isYPointInLine(other.start.getY(), this.start, this.end)) {
                    xIntersection = other.start.getX();
                    yIntersection = other.start.getY();
                    this.intersection = new Point(xIntersection, yIntersection);
                    return true;
                }
                return false;
                //check this case if the other line is parallel to y axis
            } else if (isParallelYAxis(other.start, other.end)) {
                //if the x value of the point equals to the x value of the parallel 'other' line and the y value of
                //the point in the parallel line so the lines intersect and this is the intersection point
                if ((this.start.getX() == other.start.getX())
                        && isYPointInLine(this.start.getY(), other.start, other.end)) {
                    xIntersection = this.start.getX();
                    yIntersection = this.start.getY();
                    this.intersection = new Point(xIntersection, yIntersection);
                    return true;
                }
                return false;
                //check this case if this.line is parallel to x axis
            } else if (isParallelXAxis(this.start, this.end)) {
                //if the y value of the point equals to the y value of the parallel line and the x value of the point
                //in the parallel line so the lines intersect and this is the intersection point
                if ((other.start.getY() == this.start.getY())
                        && isXPointInLine(other.start.getX(), this.start, this.end)) {
                    xIntersection = other.start.getX();
                    yIntersection = other.start.getY();
                    this.intersection = new Point(xIntersection, yIntersection);
                    return true;
                }
                return false;
                //check this case if the line other is parallel to x axis
            } else if (isParallelXAxis(other.start, other.end)) {
                //if the y value of the point equals to the y value of the parallel 'other' line and the x value
                //of the point in the parallel line so the lines intersect and this is the intersection point
                if ((this.start.getY() == other.start.getY())
                        && isXPointInLine(this.start.getX(), other.start, other.end)) {
                    xIntersection = this.start.getX();
                    yIntersection = this.start.getY();
                    this.intersection = new Point(xIntersection, yIntersection);
                    return true;
                }
                return false;
                //check if 'this' lines is a point and check if the point on the other line, if yes they are intersect
            } else if (this.start.equals(this.end) && isPointInLine(this.start, other.start, other.end)) {
                return true;
                //check if 'other' is a point and check if the point on the other line, if yes they are intersect
            } else if (other.start.equals(other.end) && isPointInLine(other.start, this.start, this.end)) {
                return true;
            }
            return false;
            //check the case if the both of the lines are parallel to y axis
        } else if (isParallelYAxis(this.start, this.end) && isParallelYAxis(other.start, other.end)) {
            //check if the highest point in one line equals to the lowest point in the other line, if yes they
            //have only one intersection and this is the intersection point.
            if ((maxYPoint(this.start, this.end)).equals(minYPoint(other.start, other.end))) {
                xIntersection = (maxYPoint(this.start, this.end)).getX();
                yIntersection = (maxYPoint(this.start, this.end)).getY();
                this.intersection = new Point(xIntersection, yIntersection);
                return true;
                //check if the lowest point in one line equals to the highest point in the other line, if yes they
                //have only one intersection and this is the intersection point.
            } else if ((minYPoint(this.start, this.end)).equals(maxYPoint(other.start, other.end))) {
                xIntersection = (minYPoint(this.start, this.end)).getX();
                yIntersection = (minYPoint(this.start, this.end)).getY();
                this.intersection = new Point(xIntersection, yIntersection);
                return true;
            }
            return false;
            //check the case if 'this' line is parallel to y axis and the 'other' line is a regular line, if they are
            // intersect in one point they are intersect.
        } else if (isParallelYAxis(this.start, this.end)) {
            if (isParallelLineIntersect(other.start, other.end, this.start, this.end)) {
                return true;
            }
            return false;
            //check the case if the 'other' line is parallel to y axis and 'this' line is a regular line, if they are
            // intersect in one point they are intersect.
        } else if (isParallelYAxis(other.start, other.end)) {
            if (isParallelLineIntersect(this.start, this.end, other.start, other.end)) {
                return true;
            }
            return false;
        }
        //incline is the difference between y start and end values divide in the difference between x start and end
        currentIncline = (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
        otherIncline = (other.end.getY() - other.start.getY()) / (other.end.getX() - other.start.getX());
        //the b parameter of the equation is the y of one point difference the line incline dual the x of the point.
        currentB = this.start.getY() - (currentIncline * this.start.getX());
        otherB = other.start.getY() - (otherIncline * other.start.getX());
        //check the case if the lines have the same incline
        if (currentIncline == otherIncline) {
            //check if the highest point in one line equals to the lowest point in the other line, if yes they
            //have only one intersection and this is the intersection point.
            if ((maxXPoint(this.start, this.end)).equals(minXPoint(other.start, other.end))) {
                xIntersection = (maxXPoint(this.start, this.end)).getX();
                yIntersection = (maxXPoint(this.start, this.end)).getY();
                this.intersection = new Point(xIntersection, yIntersection);
                return true;
                //check if the lowest point in one line equals to the highest point in the other line, if yes they
                //have only one intersection and this is the intersection point.
            } else if ((minXPoint(this.start, this.end)).equals(maxXPoint(other.start, other.end))) {
                xIntersection = (minXPoint(this.start, this.end)).getX();
                yIntersection = (minXPoint(this.start, this.end)).getY();
                this.intersection = new Point(xIntersection, yIntersection);
                return true;
            }
            return false;
        }
        //the x intersection value equals to the difference between the current b to the other b dividing the
        // difference between their incline.
        xIntersection = (currentB - otherB) / (otherIncline - currentIncline);
        //the y intersection value equals to the incline of the line dual the x intersection value plus the current b
        yIntersection = (otherIncline * xIntersection) + otherB;
        //the x value of the point with the lowest x value in the current line
        currentMinX = Math.min(this.start.getX(), this.end.getX());
        //the x value of the point with the highest x value in the current line
        currentMaxX = Math.max(this.start.getX(), this.end.getX());
        //the x value of the point with the lowest x value in the other line
        otherMinX = Math.min(other.start.getX(), other.end.getX());
        //the x value of the point with the highest x value in the other line
        otherMaxX = Math.max(other.start.getX(), other.end.getX());
        //check if the x intersection value that we found in the edge of both of the lines, if yes they are
        // intersect and this is the intersection point.
        if (((xIntersection >= currentMinX) && (xIntersection <= currentMaxX))
                && ((xIntersection >= otherMinX) && (xIntersection <= otherMaxX))) {
            this.intersection = new Point(xIntersection, yIntersection);
            return true;
        }
        return false;
    }

    /**
     * intersectionWith --  Returns the intersection point if the lines intersect, and null otherwise.
     *
     * @param other The other line
     * @return The intersection point of the lines, if they are not intersect the function return null
     */
    public Point intersectionWith(Line other) {
        if (isIntersecting(other)) {
            //the intersection point
            return this.intersection;
        }
        return null;
    }

    /**
     * closestIntersectionToStartOfLine --  Returns the closest intersection point to start of the line,null otherwise.
     *
     * @param rect The rectangle we want to check
     * @return The closest intersection point to start of the line, if it doesn't intersect the function return null
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        //minDistance parameter to find and save the minimum distance between the points.
        double minDistance;
        Point closestIntersectionPoint;
        List<Point> intersectionList = rect.intersectionPoints(this);
        //if the list isn't empty we want to run over the list of the intersection points
        if (!intersectionList.isEmpty()) {
            // initialise the minDistance parameter to the first distance between the intersection
            // point to start of the line .
            minDistance = (intersectionList.get(0)).distance(this.start);
            // initialise the closestIntersectionPoint parameter to the first point in the intersection
            // list that we got.
            closestIntersectionPoint = intersectionList.get(0);
            //for loop that run over the list of the intersection points from the second index
            for (int i = 1; i < intersectionList.size(); i++) {
                //check if the distance between the current intersection points from the list to the start of
                //the line is smaller then the minimum distance that we saved in the "minDistance" parameter
                if ((intersectionList.get(i)).distance(this.start) < minDistance) {
                    //update the minDistance parameter to be the new smallest distance
                    minDistance = (intersectionList.get(i)).distance(this.start);
                    //update the "closestIntersectionPoint" parameter according the new minDistance parameter
                    closestIntersectionPoint = intersectionList.get(i);
                }
            }
            //after running over the whole list we want to return the closest intersection point to start of the line
            return closestIntersectionPoint;
        }
        //If this line does not intersect with the rectangle, return null.
        return null;
    }

    /**
     * equals --  return true if the lines are equal, false otherwise.
     *
     * @param other The other line
     * @return 'true' if the lines are equal, 'false' otherwise
     */
    public boolean equals(Line other) {
        //check if the start point and the end point of the lines are equals, if yes the lines are equals
        if (this.start.equals(other.start) && this.end.equals(other.end)) {
            return true;
        }
        return false;
    }
}
