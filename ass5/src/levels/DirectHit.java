// ID: 208387951

package levels;

import all.interfaces.Sprite;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * @author Raviv
 * The class levels.DirectHit shows the background of the current level of the game in the giu window all the time.
 * The levels.DirectHit class implementing the all.interfaces.Sprite interface.
 */
public class DirectHit implements Sprite {

    private static final double UPPER_LEFT_X = 20;
    private static final double UPPER_LEFT_Y = 20;
    private static final double BACKGROUND_WIDTH = 760;
    private static final double BACKGROUND_HEIGHT = 580;


    /**
     * constructor .
     */
    public DirectHit() {

    }

    /**
     * drawOn -- draw the score on the given DrawSurface.
     *
     * @param surface the given DrawSurface to draw on him
     */
    @Override
    public void drawOn(DrawSurface surface) {
        shapes.Point upperLeft = new shapes.Point(UPPER_LEFT_X, UPPER_LEFT_Y);
        //shapes.Rectangle rectangle = new Rectangle(upperLeft, BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
        //Block backgroundBlock = new Block(rectangle, Color.black);
        surface.setColor(Color.black);
        surface.fillRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) BACKGROUND_WIDTH,
                (int) BACKGROUND_HEIGHT);

        surface.setColor(new Color(255, 230, 38));
        surface.drawCircle(400, 165, 80);
        surface.setColor(new Color(44, 255, 19));
        surface.drawCircle(400, 165, 100);
        surface.setColor(new Color(255, 230, 38));
        surface.drawCircle(400, 165, 120);
        surface.setColor((new Color(44, 255, 19)));
        surface.drawCircle(400, 165, 140);

        surface.setColor(Color.BLUE);
        surface.drawLine(400, 210, 400, 302);
        surface.drawLine(440, 162, 540, 162);
        surface.drawLine(364, 162, 260, 162);
        surface.drawLine(400, 126, 400, 22);


        surface.setColor(new Color(255, 230, 38));
        surface.drawCircle(100, 500, 10);
        surface.setColor(new Color(44, 255, 19));
        surface.drawCircle(100, 500, 20);
        surface.setColor(new Color(255, 230, 38));
        surface.drawCircle(100, 500, 30);
        surface.setColor((new Color(44, 255, 19)));
        surface.drawCircle(100, 500, 40);

        surface.setColor(new Color(255, 230, 38));
        surface.drawCircle(700, 500, 10);
        surface.setColor(new Color(44, 255, 19));
        surface.drawCircle(700, 500, 20);
        surface.setColor(new Color(255, 230, 38));
        surface.drawCircle(700, 500, 30);
        surface.setColor((new Color(44, 255, 19)));
        surface.drawCircle(700, 500, 40);

        surface.setColor(Color.blue);
        surface.drawLine(412, 505, 648, 505);
        surface.drawLine(152, 505, 388, 505);
        surface.drawLine(87, 455, 395, 149);
        surface.drawLine(713, 455, 402, 148);
    }


    /**
     * timePassed --  move the current ball one step.
     */
    @Override
    public void timePassed() {
    }
}
