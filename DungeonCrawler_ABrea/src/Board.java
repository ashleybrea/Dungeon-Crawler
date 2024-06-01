import java.util.LinkedList;
import java.util.List;

/**
 * The Board class visualizes the game board, the 'room'
 * and holds all methods that deals with piece movement
 *
 * @author (Ashley Brea)
 * @version (11/04/23)
 */
public class Board
{
    /**
     *Instance Variables:
     * int size: creates a square board based on the given integer
     * APiece[][] board: a 2D array of Pieces representing every square of the room we can enter
     * Move myLoc : the ordered pair location of our player ('*')
     * Move[] enemies – an array that keeps track of all the enemies on the board based on their locations
     */
    int size;
    APiece[][] board;
    Move myLoc;   
    Move[] enemies;
    
    /**
     * Constructor for objects of class Board
     * @param size -> the dimensions of the board a number between 1 and 9 and initialize a square board.
     *             that sets all elements to null
     */
    public Board(int size)
    {
        // initialise instance variables
        if (size >= 1 && size <= 9){
            this.size = size;
        }
        this.board = new APiece[this.size][this.size];
        for (int i=0; i < board.length; i++) {
            for (int j=0; j < board[i].length; j++) {
            board[i][j] = null;
            }
        }
    }

    /**
     * Assesses whether a move is within the bounds of the room.
     * @param m -> the Move to determine if its valid
     * @return true if the move is vslid, and false otherwise
     */
    public boolean isValid(Move m){
        if (m.row >= this.size || m.col >= this.size ||
            m.row < 0 || m.col < 0) {
            return false;
        } else {
        return true; 
        }
    }

    /**
     * Assesses whether a move is valid for an Enemy
     * depending on if the move is within the bounds of the room
     * and whether another Enemy is there, or an exit
     *
     * @param m -> the Move the enemy wants to take
     * @return true if it's a valid move, and false if it's not
     */
    public boolean isValidEnemyMove(Move m){
       if( (isValid(m)) && (!(this.board[m.row][m.col] instanceof Enemy)
       &&  !(this.board[m.row][m.col] instanceof Exit))){

           return true;
        }
       return false;
    }

    /**
     * A helper method that gets a random location
     * on the board that is not already occupied
     * by a piece
     * @return a Move that locates an empty spot
     * on the board
     */
    public Move getRandomLoc(){
        while (true){
            int r = (int) (this.size * Math.random());
            int c = (int) (this.size * Math.random());
            if (this.board[r][c] == null){
                Move rando = new Move(r, c);
                return rando;
            } else {
            }
        }
    }

    /**
     * Places the player on the board based
     * on a given Move/location
     * @param loc -> The Move where the player
     *            is meant to be placed
     */
        
    public void setPlayer(Move loc){
        Player player = new Player();
        board[loc.row][loc.col] = player;
        this.myLoc = loc;
    }

    /**
     * Moves the player either up, down, or side to side
     * Uses the collide() method if the player
     * wants to move to a non-empty location
     *
     * @param deltaRow -> int to increase row by
     * @param deltaCol -> int to increase column by
     * @return a string representing a collision with a
     *          piece, an invalid move, or en empty string
     *          if the move is valid and location is null
     */
    public String movePlayer(int deltaRow, int deltaCol) {
        String msg = "";
        Move move = new Move(this.myLoc.row + deltaRow, this.myLoc.col + deltaCol);
        if (isValid(move)) {
            Player player = (Player) board[this.myLoc.row][this.myLoc.col];
            if (board[move.row][move.col] != null) {
                APiece piece = board[move.row][move.col];
                msg = player.collide(piece);
            }
            board[move.row][move.col] = player;
            board[this.myLoc.row][this.myLoc.col] = null;
            this.myLoc = move;
            return msg;
            } else {
            return  "Move is invalid, try again";
        }
    }

    /**
     * Places a given number of enemies on the board
     * randomly and adds the moves to the enemies array
     * @param num -> the amount of enemies to
     *              be placed on the board
     */
    public void setEnemies(int num){
        this.enemies = new Move[num];
        for (int i = 0; i < num; i++) {
            Move m = getRandomLoc();
            enemies[i] = m;
            board[m.row][m.col] = new Enemy();
        }
    }

    /**
     * Based on an enemy's location, will determine
     * if an enemy can move up, down, or side to side.
     * Places all possible moves into a Linked List
     * and then randomly chooses a move to execute.
     *
     * @param loc -> the original location of the enemy
     * @return a random new Move for the enemy to move
     *          to if there are valid moves, or returns
     *          its original location if there are none.
     */
    // Moves with corresponding keys
    // A -> move left (+0)(-1)
    // D -> move right (col/ +0) (+1)
    // S -> move down (+1) (+0)
    // W -> move up (-1) (+0)
    public Move getValidEnemyMove(Move loc){
        // Linked list of avail. moves
        List<Move> enMoves = new LinkedList<Move>();
        Move a = new Move(loc.row, loc.col - 1);
        Move d = new Move(loc.row, loc.col + 1);
        Move s = new Move(loc.row + 1, loc.col);
        Move w = new Move(loc.row - 1, loc.col);

        if (isValidEnemyMove(a)){
            enMoves.add(a);
        }
        if (isValidEnemyMove(d)){
            enMoves.add(d);
        }
        if (isValidEnemyMove(s)){
            enMoves.add(s);
        }

        if (isValidEnemyMove(w)) {
            enMoves.add(w);
        }

        //gets random move based on valid moves
        if(enMoves.size() == 0){
            //stays where it was originally
            return loc;
        }
        int randoIdx = (int) (Math.random() * enMoves.size());
        Move retVal = enMoves.get(randoIdx);

        return retVal;
    }

    /**
     * Moves an enemy from their old location
     * on the board, to its new location if there
     * are any valid moves, and makes the old
     * location null
     * Edits the enemies array to reflect the change
     * @return a string representing a collision with a
     *         piece, an invalid move, or en empty string
     *         if the move is valid and location is null
     */
    public String moveEnemies(){
        String res = "";
        for(int i = 0; i < this.enemies.length; i++){
            Move oldMove = this.enemies[i];
            Move newMove = getValidEnemyMove(oldMove);
            Enemy enemy = (Enemy) this.board[oldMove.row][oldMove.col];

            if (this.board[newMove.row][newMove.col] != null){
                APiece piece = this.board[newMove.row][newMove.col];
                if(piece instanceof Player){
                    return enemy.collide(piece);
                    } else {
                     res += enemy.collide(piece);
                    if (res.length() > 0){
                        res += "\n";
                    }
                }
            }
            this.enemies[i] = newMove;
            this.board[oldMove.row][oldMove.col] = null;
            this.board[newMove.row][newMove.col] = enemy;
        }
        return res;
    }

    /**
     *  Places a given number of treasures on the
     *  board randomly
     * @param num -> amount of treasures to place
     *              onto the board
     */
    public void setTreasure(int num){
        for(int i = 0; i < num; i++){
            Move t = getRandomLoc();
            board[t.row][t.col] = new Treasure();
        }
    }

    /**
     * Places a single Exit on the
     * board randomly
     */
    public void setExit(){
        Move e = getRandomLoc();
        board[e.row][e.col] = new Exit();

    }

    /**
     * Visualizes the square board with
     * boarders, numbered columns, and
     * alphabetized rows
     * Uses '_' to represent an empty space
     * @return a string of the game board
     */
    public String toString(){
        String retval = "   ";
        for (int i = 1; i <= this.size; i++) {
            retval += i + " ";
        }
        retval += "\n" + "   ";
        
        for (int i = 1; i < this.size + 1; i++) {
            retval += "__";
        }
        retval += " \n";

        for (int i = 0; i < board.length; i++) {
            retval += (char) ('A' + i) + " |";
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == null) {
                   retval += "_ "; 
                } else {
                retval += "" + board[i][j] + " ";
                }    
            } 
            retval += "|\n";
        }
        retval += "   ";
        
        for (int i = 1; i < this.size + 1; i++) {
            retval += "__";
        }
        return retval; 
    }
}
