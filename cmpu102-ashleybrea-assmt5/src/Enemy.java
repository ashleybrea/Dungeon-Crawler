
/**
 * The Enemy class extends APiece.
 *
 * @author (Ashley Brea)
 * @version (11/04/23)
 */
public class Enemy extends APiece
{
    /**
     * Instance Variables
     * char symbol - uses a character to represent the Enemy piece on the game board
     */
    char symbol;

    /**
     * Constructor for objects of class Enemy
     * Uses the APiece class to assign Player the '&' character
     */
    public Enemy()
    {
        // initialise instance variables
        super('&');
    }

    /**
     * Collide method gets called upon the enemy after movement
     * If the enemy goes to an occupied place on the board
     * there are different results dependent of the Piece
     * the enemy collides with
     *
     * @param piece - Takes in the piece of the enemy ('&').
     * @return A string that corresponds with the piece that the enemy
     * collided with according to game logic.
     */
    public String collide(APiece piece){
        if (piece instanceof Treasure){
            return "Enemy the collided with and ATE the treasure";
        } else if(piece instanceof Player){
            return "GAME OVERR";
        }
        return null;
    }
}
