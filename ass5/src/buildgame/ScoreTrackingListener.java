// ID: 208387951

package buildgame;

import all.interfaces.HitListener;
import allsprites.Ball;
import allsprites.Block;

/**
 * @author Raviv
 * The class buildgame.ScoreTrackingListener is updating the counter when blocks are being hit and removed, so
 * whenever the ball hits a block the player will receive  5 points.
 * The buildgame.ScoreTrackingListener class implementing the all.interfaces.HitListener interface.
 */

public class ScoreTrackingListener implements HitListener {
    private static final int FIVE_POINTS = 5;

    private Counter currentScore;

    /**
     * constructor with configurable scoreCounter.
     *
     * @param scoreCounter The current the score of the game.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * getCurrentScore -- return the score.
     *
     * @return the score.
     */
    public Counter getCurrentScore() {
        return currentScore;
    }

    /**
     * hitEvent --  updating the counter when blocks are being hit and removed.
     *
     * @param beingHit the block that have being hit.
     * @param hitter   the hitter ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        currentScore.increase(FIVE_POINTS);
    }
}