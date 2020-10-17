// ID: 208387951

package levels;


import all.interfaces.Sprite;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * @author Raviv
 * The class levels.WideEasy shows the background of the current level of the game in the giu window all the time.
 * The levels.WideEasy class implementing the all.interfaces.Sprite interface.
 */
public class WideEasy implements Sprite {

    private static final double UPPER_LEFT_X = 20;
    private static final double UPPER_LEFT_Y = 20;
    private static final double BACKGROUND_WIDTH = 760;
    private static final double BACKGROUND_HEIGHT = 580;

    // private static final double y1 = 80;
    // private static final double y2 = ;

    private int yValue;
    private int yValueBig;
    private int fishX;
    private int fishY;
    private boolean isFlyUp;
    private boolean isFlyUpBig;
    private boolean isFishTailUp;

    /**
     * constructor .
     */
    public WideEasy() {
        this.yValue = 80;
        this.yValueBig = 110;
        this.isFlyUp = true;
        this.isFlyUpBig = true;
        this.fishX = 60;
        this.fishY = 500;
        this.isFishTailUp = true;
    }

    /**
     * drawOn -- draw the score on the given DrawSurface.
     *
     * @param surface the given DrawSurface to draw on him
     */
    @Override
    public void drawOn(DrawSurface surface) {
        shapes.Point upperLeft = new shapes.Point(UPPER_LEFT_X, UPPER_LEFT_Y);
        surface.setColor(Color.white);
        surface.fillRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) BACKGROUND_WIDTH,
                (int) BACKGROUND_HEIGHT);

        for (int i = 1; i < 200; ++i) {
            surface.setColor(new Color(234, 224 - (int) (i / 4), 164));
            surface.drawLine(750, 50, (750) / 100 * i, 196 + (int) (i / 4));
        }

        for (int i = 1; i < 200; ++i) {
            surface.setColor(new Color(134 - (int) (i / 10), 234 - (int) (i / 4), 229));
            //surface.setColor(new Color(234, 224 - (int) (i / 4), 164));
            surface.drawLine(20, 830, (750) / 100 * i, 400 + (int) (i / 2));
        }

        for (int i = 0; i < 780; ++i) {
            surface.setColor(new Color(238, 214, 36));
            surface.drawLine(i, 600, i + 10, 550);
        }

        surface.setColor(new Color(251, 183, 16));
        surface.fillCircle(this.fishX, 500, 15);
        surface.setColor(new Color(251, 183, 16));
        surface.fillCircle(this.fishX - 19, this.fishY, 7);
        surface.setColor(Color.white);
        surface.fillCircle(this.fishX + 7, 497, 4);
        surface.setColor(Color.black);
        surface.fillCircle(this.fishX + 8, 497, 2);
        surface.drawLine(this.fishX + 4, 500, this.fishX + 9, 500);


        surface.setColor(new Color(234, 224, 164));
        surface.fillCircle(750, 50, 75);
        surface.setColor(new Color(246, 221, 68));
        surface.fillCircle(750, 50, 65);
        surface.setColor(new Color(251, 239, 23));
        surface.fillCircle(750, 50, 55);
        surface.setColor(new Color(251, 190, 10));
        surface.fillCircle(750, 50, 30);
        surface.setColor(new Color(251, 243, 10));
        surface.fillCircle(750, 50, 28);


        surface.setColor(Color.black);
        surface.drawLine(200, 102, 228, this.yValueBig);
        surface.drawLine(200, 102, 195, 110);
        surface.drawLine(195, 110, 190, 102);
        surface.drawLine(190, 102, 165, this.yValueBig);
        surface.drawLine(95, 72, 115, this.yValue);
        surface.drawLine(95, 72, 90, 80);
        surface.drawLine(90, 80, 85, 72);
        surface.drawLine(85, 72, 65, this.yValue);
    }


    /**
     * timePassed --  move the current ball one step.
     */
    @Override
    public void timePassed() {
        if (this.yValue == 73 && this.isFlyUp) {
            this.isFlyUp = false;
        } else if (this.yValue == 86 && !this.isFlyUp) {
            this.isFlyUp = true;
        } else if (this.yValue > 73 && this.isFlyUp) {
            this.yValue = this.yValue - 1;
        } else if (this.yValue < 86 && !this.isFlyUp) {
            this.yValue = this.yValue + 1;
        }

        if (this.yValueBig == 100 && this.isFlyUpBig) {
            this.isFlyUpBig = false;
        } else if (this.yValueBig == 117 && !this.isFlyUpBig) {
            this.isFlyUpBig = true;
        } else if (this.yValueBig > 100 && this.isFlyUpBig) {
            this.yValueBig = this.yValueBig - 1;
        } else if (this.yValueBig < 117 && !this.isFlyUpBig) {
            this.yValueBig = this.yValueBig + 1;
        }


        if (this.fishX == 800) {
            this.fishX = 0;
        } else if (this.fishX < 800) {
            this.fishX = this.fishX + 1;
        }
        if (this.fishY == 496 && this.isFishTailUp) {
            this.isFishTailUp = false;
        } else if (this.fishY == 504 && !this.isFishTailUp) {
            this.isFishTailUp = true;
        } else if (this.fishY > 496 && this.isFishTailUp) {
            this.fishY = this.fishY - 1;
        } else if (this.fishY < 504 && !this.isFishTailUp) {
            this.fishY = this.fishY + 1;
        }

    }
}
