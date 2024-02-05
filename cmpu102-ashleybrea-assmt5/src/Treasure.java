
/**
 * The Treasure class extends APiece.
 *
 * @author (Ashley Brea)
 * @version (11/04/23)
 */
public class Treasure extends APiece
{
    /**
     * Instance Variables:
     * char symbol - uses a character to represent the Treasure piece on the game board
     * int value -  the dollar amount of the prize within a treasure piece
     */
    char symbol;
    int value;
    
    /**
     * Constructor for objects of class Treasure
     * Uses the APiece class to assign Player the '$' character
     * Assigns the value to each piece randomly in increments of 100's
     */
    public Treasure()
    {
        // initialise instance variables
        super('$');
        this.value = (int) (10 * Math.random() + 1) * 100;
        
    }

}
