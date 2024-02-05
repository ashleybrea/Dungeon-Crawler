
/**
 * The Exit class extends APiece.
 *
 * @author (Ashley Brea)
 * @version (11/04/23)
 */
public class Exit extends APiece
{
    /**
     * Instance Variables
     * char symbol - uses a character to represent the Exit piece on the game board
     */
    char symbol;

    /**
     * Constructor for objects of class Exit
     * Uses the APiece class to assign Player the '@' character
     */
    public Exit()
    {
        // initialise instance variables
        super('@');
    }

}
