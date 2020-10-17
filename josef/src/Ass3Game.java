// ID: 208387951

/**
 * @author Raviv
 * The class create a game and runs it by using the functions in the game class
 */

public class Ass3Game {
    /**
     * main -- calling the game class, so by that creates a ball and blocks, and the ball is bouncing around
     * the screen hitting blocks and changing directions).
     * @param args an empty args array
     */
    public static void main(String[] args) {
        //calling the game class
        Game game = new Game();
        //initialize the game by calling to initialize() function
        game.initialize();
        //run the game by calling to run() function
        game.run();
    }
}
