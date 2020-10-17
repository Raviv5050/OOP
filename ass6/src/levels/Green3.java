// ID: 208387951

package levels;


import all.interfaces.Sprite;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * @author Raviv
 * The class levels.Green3 shows the background of the current level of the game in the giu window all the time.
 * The levels.Green3 class implementing the all.interfaces.Sprite interface.
 */

public class Green3 implements Sprite {
    private static final double UPPER_LEFT_X = 20;
    private static final double UPPER_LEFT_Y = 20;
    private static final double BACKGROUND_WIDTH = 760;
    private static final double BACKGROUND_HEIGHT = 580;

    // private static final double y1 = 80;
    // private static final double y2 = ;

    private int colorChange;
    private boolean isColorUp;
    private int circleChange;
    private boolean circleBig;

    /**
     * constructor .
     */
    public Green3() {
        this.colorChange = 0;
        this.circleChange = 0;
        this.isColorUp = true;
        this.circleBig = true;

    }

    /**
     * drawOn -- draw the score on the given DrawSurface.
     *
     * @param surface the given DrawSurface to draw on him
     */
    @Override
    public void drawOn(DrawSurface surface) {
        shapes.Point upperLeft = new shapes.Point(UPPER_LEFT_X, UPPER_LEFT_Y);
        surface.setColor(new Color(78, 115, 41));
        surface.fillRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) BACKGROUND_WIDTH,
                (int) BACKGROUND_HEIGHT);


        surface.setColor(Color.black);
        surface.fillRectangle(60, 120, 200, 580);
        surface.setColor(new Color(97, 108, 110));
        surface.fillRectangle(68, 506, 182, 580);
        surface.setColor(Color.black);
        surface.fillRectangle(140, 532, 45, 580);
        surface.setColor(Color.WHITE);
        surface.fillCircle(147, 568, 2);
        surface.setColor(Color.WHITE);
        surface.drawLine(150, 568, 153, 568);

        for (int i = 0; i < 12; ++i) {
            surface.setColor(new Color(0 + (20 * i), 218 - (10 * i) - this.colorChange, 208));
            for (int j = 0; j < 8; ++j) {

                surface.fillRectangle(68 + 24 * j, 128 + i * 32, 15, 25);
            }
        }

        surface.setColor(Color.black);
        surface.fillRectangle(109, 95, 5, 97);
        surface.setColor(new Color(246, 123, 70));
        surface.fillCircle(111, 95, 8 + this.circleChange);
        surface.setColor(new Color(246, 224, 26));
        surface.drawCircle(111, 95, 18 + this.circleChange);
        surface.setColor(new Color(255, 59, 28));
        surface.fillCircle(111, 95, 8);
        surface.setColor(Color.WHITE);
        surface.fillCircle(111, 95, 3);

    }


    /**
     * timePassed --  move the current ball one step.
     */
    @Override
    public void timePassed() {

        if (this.colorChange == 100 && this.isColorUp) {
            this.isColorUp = false;
        } else if (this.colorChange == 0 && !this.isColorUp) {
            this.isColorUp = true;
        } else if (this.colorChange < 100 && this.isColorUp) {
            this.colorChange = this.colorChange + 1;
        } else if (this.colorChange > 0 && !this.isColorUp) {
            this.colorChange = this.colorChange - 1;
        }


        if (this.circleChange == 5 && this.circleBig) {
            this.circleBig = false;
        } else if (this.circleChange == 0 && !this.circleBig) {
            this.circleBig = true;
        } else if (this.circleChange < 5 && this.circleBig) {
            this.circleChange = this.circleChange + 1;
        } else if (this.circleChange > 0 && !this.circleBig) {
            this.circleChange = this.circleChange - 1;
        }
    }
}
