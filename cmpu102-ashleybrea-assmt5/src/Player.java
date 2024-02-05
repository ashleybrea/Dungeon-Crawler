
/**
 * The Player class extends APiece
 *
 * @author (Ashley Brea)
 * @version (11/04/23)
 */
public class Player extends APiece
{
    /**
     * Instance Variables
     * char symbol - uses a character to represent the player on the game board
     * int score - as the player collects prizes from colliding with treasures,
     *             score keeps track of the dollar amount of the prizes
     */
    char symbol;
    int score = 0;

    /**
     * Constructor for objects of class Player
     * Uses the APiece class to assign Player the '*' character
     */
    public Player()
    {
        // initialise instance variables
        super('*');
    }

    /**
     * Collide method gets called upon the player after movement
     * If the player goes to an occupied place on the board
     * there are different results dependent of the Piece
     * the player collides with
     *
     * @param piece - Takes in the piece of the player ('*').
     * @return A string that corresponds with the piece that the player
     * collided with according to game logic.
     */
    public String collide(APiece piece){
    // gets called upon the player when they go to an occupied place on the board

        if (piece instanceof Treasure treasure){
            this.score += treasure.value;
            return "You just found $" + treasure.value + "!";
        } else if (piece instanceof Enemy) {
            return "GAME OVERRRRR";
        } else if(piece instanceof Exit){
            return "Level is over. Moving onto next level";

        }
        return null;
    }
}
