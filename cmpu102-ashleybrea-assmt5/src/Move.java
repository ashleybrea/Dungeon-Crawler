
/**
 * The class Move constructs ordered pairs
 * to represent locations on game board.
 *
 * @author (Ashley Brea)
 * @version (11/04/23)
 */
public class Move
{
    /**
     * Instance Variables:
     * int row - uses integers to represent rows on the game board
     * int col - uses integers to represent columns on the game board
     */
    int row;
    int col;
    /**
     * Constructor for objects of class Move
     * Uses inputs for row and col to initialise
     */
    public Move(int row, int col)
    {
        // initialise instance variables
        this.row = row;
        this.col = col;
    }

    /**
     * toString() method to visually represent
     * a Move object
     * @param row -> int that represents the game boards row
     * @param col -> int that represents the game boards row
     * @return -> a string of an ordered pair to represent a move
     *             on the board
     */
    public String toString(int row, int col)
    {
        // put your code here
        return "(" + this.row + ", " + this.col + ")";
    }
}
