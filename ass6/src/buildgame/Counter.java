// ID: 208387951

package buildgame;

/**
 * @author Raviv
 * The class buildgame.Counter is a simple class that is used for counting things
 */

public class Counter {

    private int count;

    /**
     * constructor that initialize the counter with configurable num.
     *
     * @param num the value of the counter
     */
    public Counter(int num) {
        this.count = num;
    }

    /**
     * increase -- add number to current count.
     *
     * @param number the number to add.
     */
    public void increase(int number) {
        this.count = this.count + number;
    }

    /**
     * decrease -- subtract number from current count.
     *
     * @param number the number to decrease.
     */
    public void decrease(int number) {
        this.count = this.count - number;
    }

    /**
     * getValue -- get current count.
     *
     * @return count -the current count.
     */
    public int getValue() {
        return this.count;
    }
}