// ID: 208387951

import biuoop.GUI;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.Random;

/**
 * @author Raviv
 * The class use the GUI class to generate random pictures of 10 lines, drawn in black.
 * The middle point in each line is indicated in blue and the intersection points between the
 * lines are indicated in red (all the points are filled circles with a radius of 3).
 */
public class AbstractArtDrawing {
    /**
     * manageDraw -- create with drawSurfacethe random pictures of 10 lines, drawn in black with blue point
     * in the middle of each line and with red point in the intersection points between the lines, and print
     * this random picture.
     */
    public void manageDraw() {
        //Creating a new GUI object so like this we create a screen, with a title and dimensions.
        GUI gui = new GUI("Random line Example", 400, 300);
        //drawing on the screen by using 'DrawSurface'
        DrawSurface drawSurface = gui.getDrawSurface();
        //Creating an array of lines in size 10
        Line[] randomLines = new Line[10];
        //for loop from 0 to 10 so we can create 10 lines and enter them to the array
        for (int i = 0; i < 10; ++i) {
            //adding a new random line to the array
            randomLines[i] = generateRandomLine();
            //printing the line and a blue point in the middle of this line by using 'drawLine' function
            drawLine(randomLines[i], drawSurface);
            //another for loop from 0 to the current line we just create so we can check intersect between
            //this line and all the previous lines in the array.
            for (int j = 0; j < i; ++j) {
                //check intersection between the line and the current line in index i
                if (randomLines[i].isIntersecting(randomLines[j])) {
                    //setting the color to red so the point will be in red color
                    drawSurface.setColor(Color.red);
                    //getting the intersection point by using 'intersectionWith' function
                    Point meeting = randomLines[i].intersectionWith(randomLines[j]);
                    //drawing the red point in the exactly direction in the line whit size 3
                    drawSurface.fillCircle((int) meeting.getX(), (int) meeting.getY(), 3);
                }
            }
        }
        //to display the drawing we created on the screen
        gui.show(drawSurface);
    }

    /**
     * generateRandomLine -- return the random line we just create.
     *
     * @return the random line
     */
    public Line generateRandomLine() {
        // create a random-number generator
        Random rand = new Random();
        // get integer in range 1-400
        int x1 = rand.nextInt(400) + 1;
        // get integer in range 1-300
        int y1 = rand.nextInt(300) + 1;
        // get integer in range 1-400
        int x2 = rand.nextInt(400) + 1;
        // get integer in range 1-300
        int y2 = rand.nextInt(300) + 1;
        //creating the line from the 4 points we random
        Line randomLine = new Line(x1, y1, x2, y2);
        return randomLine;
    }

    /**
     * drawLine -- drawing the line in black and a blue point in the middle of this line.
     *
     * @param line        get a line
     * @param drawSurface get the same drawSurface to continue drawing in the same draw
     */
    public void drawLine(Line line, DrawSurface drawSurface) {
        //setting the color to black so the line will be in black
        drawSurface.setColor(Color.black);
        //drawing the current line in black
        drawSurface.drawLine((int) line.start().getX(), (int) line.start().getY(),
                (int) line.end().getX(), (int) line.end().getY());
        Point middlePoint = line.middle();
        //setting the color to blue so the middle point will be in blue
        drawSurface.setColor(Color.blue);
        //drawing the blue point in the exactly direction in the line whit size 3
        drawSurface.fillCircle((int) middlePoint.getX(), (int) middlePoint.getY(), 3);
    }

    /**
     * main - calling the functions to draw the random picture.
     *
     * @param args the args from the main
     */
    public static void main(String[] args) {
        AbstractArtDrawing abstractDrawingLine = new AbstractArtDrawing();
        //calling 'manageDraw' function to draw the random picture
        abstractDrawingLine.manageDraw();

    }
}
