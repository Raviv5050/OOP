// ID: 208387951

package levels;


import all.interfaces.Sprite;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * @author Raviv
 * The class levels.FinalFour shows the background of the current level of the game in the giu window all the time.
 * The levels.FinalFour class implementing the all.interfaces.Sprite interface.
 */
public class FinalFour implements Sprite {

    private static final double UPPER_LEFT_X = 20;
    private static final double UPPER_LEFT_Y = 20;
    private static final double BACKGROUND_WIDTH = 760;
    private static final double BACKGROUND_HEIGHT = 580;

    // private static final double y1 = 80;
    // private static final double y2 = ;

    private int rain;
    private int snow;
    private int firstCloudX;
    private int secondCloudX;
    private boolean isRainUp;


    /**
     * constructor .
     */
    public FinalFour() {
        this.rain = 1;
        this.snow = 0;
        this.firstCloudX = 30;
        this.secondCloudX = 330;
        this.isRainUp = true;
    }

    /**
     * drawOn -- draw the score on the given DrawSurface.
     *
     * @param surface the given DrawSurface to draw on him
     */
    @Override
    public void drawOn(DrawSurface surface) {
        shapes.Point upperLeft = new shapes.Point(UPPER_LEFT_X, UPPER_LEFT_Y);
        surface.setColor(new Color(154, 198, 255));
        surface.fillRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) BACKGROUND_WIDTH,
                (int) BACKGROUND_HEIGHT);

        for (int i = 1; i < 200; ++i) {
            surface.setColor(new Color(251 - (int) (i / 10), 255 - (int) (i / 4), 253));
            surface.drawLine(20, 830, (750) / 100 * i, 520 + (int) (i / 2));
            surface.drawLine(33, 830, (750) / 100 * i, 520 + (int) (i / 2));
            surface.setColor(new Color(205, 238, 236));
            surface.drawLine(41, 830, (750) / 100 * i, 520 + (int) (i / 2));
        }
        surface.setColor(new Color(205, 238, 236));
        for (int i = 0; i < 780; ++i) {
            surface.drawLine(i, 600, i + 12, 570);
        }

        surface.setColor(new Color(205, 238, 236));
        for (int i = 0; i < 800; i++) {
            i = i + 100;
            surface.fillCircle(i, this.snow + 70, 5);
            surface.fillCircle(i - 50, this.snow - 47, 2);
            surface.fillCircle(i + 20, this.snow - 24, 3);
            surface.fillCircle(i + 20, this.snow - 150, 3);
            surface.fillCircle(i + 120, this.snow - 70, 3);
            surface.fillCircle(i - 50, this.snow - 147, 2);
            surface.fillCircle(i + 20, this.snow - 124, 3);
            surface.fillCircle(i + 20, this.snow - 250, 3);
            surface.fillCircle(i + 120, this.snow - 370, 3);
            surface.fillCircle(i - 50, this.snow + 500, 2);
            surface.fillCircle(i + 20, this.snow + 524, 3);
            surface.fillCircle(i + 20, this.snow + 450, 3);
            surface.fillCircle(i + 120, this.snow + 400, 3);
            surface.fillCircle(i, this.snow + 70, 5);
            surface.fillCircle(i - 50, this.snow + 47, 2);
            surface.fillCircle(i + 20, this.snow + 24, 3);
            surface.fillCircle(i + 20, this.snow + 150, 3);
            surface.fillCircle(i + 120, this.snow + 70, 3);
            surface.fillCircle(i + 200, this.snow + 450, 3);
            surface.fillCircle(i + 100, this.snow + 370, 3);
            surface.fillCircle(i + 50, this.snow + 580, 3);
            surface.fillCircle(i + 100, this.snow + 100, 3);
            surface.fillCircle(i + 230, this.snow + 310, 3);
            surface.fillCircle(i + 70, this.snow + 400, 3);
            surface.fillCircle(i + 300, this.snow + 590, 3);
        }

        surface.setColor(Color.WHITE);
        for (int i = 0; i < 12; ++i) {
            surface.drawLine(firstCloudX + 25 + i * 10, 380,
                    firstCloudX + i * 10, 520 + (2 * i) + this.rain);
        }

        surface.setColor(new Color(229, 233, 231));
        surface.fillCircle(this.firstCloudX + 40, 360, 28);
        surface.setColor(new Color(229, 233, 231));
        surface.fillCircle(this.firstCloudX + 60, 380, 32);
        surface.setColor(new Color(214, 218, 216));
        surface.fillCircle(this.firstCloudX + 80, 350, 34);
        surface.setColor(new Color(210, 213, 208));
        surface.fillCircle(this.firstCloudX + 100, 383, 27);
        surface.fillCircle(this.firstCloudX + 120, 360, 37);
        surface.setColor(new Color(229, 233, 231));
        surface.fillCircle(this.firstCloudX + 40, 360, 10);
        surface.setColor(new Color(229, 233, 231));
        surface.fillCircle(this.firstCloudX + 60, 380, 14);
        surface.setColor(new Color(214, 218, 216));
        surface.fillCircle(this.firstCloudX + 80, 350, 16);
        surface.setColor(new Color(210, 213, 208));
        surface.fillCircle(this.firstCloudX + 100, 383, 9);
        surface.fillCircle(this.firstCloudX + 120, 360, 19);


        surface.setColor(Color.WHITE);
        for (int i = 0; i < 12; ++i) {
            surface.drawLine(this.secondCloudX + 25 + i * 10, 346,
                    this.secondCloudX + i * 10, 520 + (2 * i) + this.rain);
        }

        surface.setColor(new Color(229, 233, 231));
        surface.fillCircle(this.secondCloudX + 40, 360, 28);
        surface.setColor(new Color(229, 233, 231));
        surface.fillCircle(this.secondCloudX + 60, 380, 32);
        surface.setColor(new Color(214, 218, 216));
        surface.fillCircle(this.secondCloudX + 80, 350, 34);
        surface.setColor(new Color(210, 213, 208));
        surface.fillCircle(this.secondCloudX + 100, 383, 27);
        surface.fillCircle(this.secondCloudX + 120, 360, 37);
        surface.setColor(new Color(229, 233, 231));
        surface.fillCircle(this.secondCloudX + 40, 360, 10);
        surface.setColor(new Color(229, 233, 231));
        surface.fillCircle(this.secondCloudX + 60, 380, 14);
        surface.setColor(new Color(214, 218, 216));
        surface.fillCircle(this.secondCloudX + 80, 350, 16);
        surface.setColor(new Color(210, 213, 208));
        surface.fillCircle(this.secondCloudX + 100, 383, 9);
        surface.fillCircle(this.secondCloudX + 120, 360, 19);
    }


    /**
     * timePassed --  move the current ball one step.
     */
    @Override
    public void timePassed() {

        if (this.rain == 0 && this.isRainUp) {
            this.isRainUp = false;
        } else if (this.rain == 50 && !this.isRainUp) {
            this.isRainUp = true;
        } else if (this.rain > 0 && this.isRainUp) {
            this.rain = this.rain - 1;
        } else if (this.rain < 50 && !this.isRainUp) {
            this.rain = this.rain + 1;
        }


        if (this.firstCloudX == 800) {
            this.firstCloudX = 0;
        } else if (this.firstCloudX < 800) {
            this.firstCloudX = this.firstCloudX + 1;
        }
        if (this.secondCloudX == 800) {
            this.secondCloudX = 0;
        } else if (this.secondCloudX < 800) {
            this.secondCloudX = this.secondCloudX + 1;
        }
        if (this.snow == 600) {
            this.snow = 0;
        } else if (this.snow < 600) {
            this.snow = this.snow + 1;
        }
    }
}
