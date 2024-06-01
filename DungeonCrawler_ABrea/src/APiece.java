
/**
 * APiece is an abstract class. It will add a character to represent a Piece's symbol
 *
 * @author (Ashley Brea)
 * @version (11/04/2023)
 */
public abstract class APiece
{
    /**
     * Uses a character to represent the symbol that
     * signifies what Piece is which on the game board.
     */
    char symbol;
    
    /**
     * Constructor for objects of class Piece
     * @param symbol - a character to represent the piece
     */
    public APiece(char symbol)
    {
        // initialise instance variables
        this.symbol = symbol;
    }

    /**
     * A toString() method that takes in no parameters
     * but converts a Piece's symbol to a string
     *
     * @return a string version of the symbol
     */
    public String toString() {
        return symbol + "";
    }
}
