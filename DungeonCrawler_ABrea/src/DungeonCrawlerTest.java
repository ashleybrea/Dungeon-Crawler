

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class DungeonCrawlerTest.
 *
 * @author  (Ashley Brea)
 * @version (10/31/23)
 */
public class DungeonCrawlerTest
{
    /**
     * Default constructor for test class DungeonCrawlerTest
     */
    public DungeonCrawlerTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    @Test
    public void BoardToStringTest(){
        Board mini = new Board(3);
        String actual = mini.toString();
        String expect = 
         "   1 2 3 \n" +
         "   ______ \n" +
         "A |_ _ _ |\n" +
         "B |_ _ _ |\n" +
         "C |_ _ _ |\n" +
         "   ______";
            
        assertEquals(expect, actual);
        
        Board a = new Board(4);
         actual = a.toString();
         expect = 
         "   1 2 3 4 \n" +
         "   ________ \n" +
         "A |_ _ _ _ |\n" +
         "B |_ _ _ _ |\n" +
         "C |_ _ _ _ |\n" +
         "D |_ _ _ _ |\n" +
         "   ________";
            
        assertEquals(expect, actual);

        Board bmini = new Board(5);
         actual = bmini.toString();
         expect = 
         "   1 2 3 4 5 \n" +
         "   __________ \n" +
         "A |_ _ _ _ _ |\n" +
         "B |_ _ _ _ _ |\n" +
         "C |_ _ _ _ _ |\n" +
         "D |_ _ _ _ _ |\n" +
         "E |_ _ _ _ _ |\n" +
         "   __________";
            
        assertEquals(expect, actual);
        
        Board med = new Board(6);
         actual = med.toString();
         expect = 
         "   1 2 3 4 5 6 \n" +
         "   ____________ \n" +
         "A |_ _ _ _ _ _ |\n" +
         "B |_ _ _ _ _ _ |\n" +
         "C |_ _ _ _ _ _ |\n" +
         "D |_ _ _ _ _ _ |\n" +
         "E |_ _ _ _ _ _ |\n" +
         "F |_ _ _ _ _ _ |\n" +
         "   ____________";
            
        assertEquals(expect, actual);
        
        Board bmed = new Board(7);
         actual = bmed.toString();
         expect = 
         "   1 2 3 4 5 6 7 \n" +
         "   ______________ \n" +
         "A |_ _ _ _ _ _ _ |\n" +
         "B |_ _ _ _ _ _ _ |\n" +
         "C |_ _ _ _ _ _ _ |\n" +
         "D |_ _ _ _ _ _ _ |\n" +
         "E |_ _ _ _ _ _ _ |\n" +
         "F |_ _ _ _ _ _ _ |\n" +
         "G |_ _ _ _ _ _ _ |\n" +
         "   ______________";
            
        assertEquals(expect, actual);
        
        Board lrg = new Board(8);
         actual = lrg.toString();
         expect = 
         "   1 2 3 4 5 6 7 8 \n" +
         "   ________________ \n" +
         "A |_ _ _ _ _ _ _ _ |\n" +
         "B |_ _ _ _ _ _ _ _ |\n" +
         "C |_ _ _ _ _ _ _ _ |\n" +
         "D |_ _ _ _ _ _ _ _ |\n" +
         "E |_ _ _ _ _ _ _ _ |\n" +
         "F |_ _ _ _ _ _ _ _ |\n" +
         "G |_ _ _ _ _ _ _ _ |\n" +
         "H |_ _ _ _ _ _ _ _ |\n" +
         "   ________________";
            
        assertEquals(expect, actual);
        
        Board xlrg = new Board(9);
         actual = xlrg.toString();
         expect = 
         "   1 2 3 4 5 6 7 8 9 \n" +
         "   __________________ \n" +
         "A |_ _ _ _ _ _ _ _ _ |\n" +
         "B |_ _ _ _ _ _ _ _ _ |\n" +
         "C |_ _ _ _ _ _ _ _ _ |\n" +
         "D |_ _ _ _ _ _ _ _ _ |\n" +
         "E |_ _ _ _ _ _ _ _ _ |\n" +
         "F |_ _ _ _ _ _ _ _ _ |\n" +
         "G |_ _ _ _ _ _ _ _ _ |\n" +
         "H |_ _ _ _ _ _ _ _ _ |\n" +
         "I |_ _ _ _ _ _ _ _ _ |\n" +
         "   __________________";
            
        assertEquals(expect, actual);
    }
    
    @Test
    public void isValidMoveTest(){
        Board bmin = new Board(4);
        Move one = new Move(-1, 5);
        Move two = new Move(1, 3);
        Move three = new Move(3, 3);
        
        assertEquals(false, bmin.isValid(one));
        assertEquals(true, bmin.isValid(two));
        assertEquals(true, bmin.isValid(three));
        
        
        Board bLrg = new Board(8);
        Move four = new Move(7, -4);
        Move five = new Move(7, 7);
        
        assertEquals(false, bLrg.isValid(four));
        assertEquals(true, bLrg.isValid(five));

    }
    
    @Test
    public void setPlayerTest(){
        int bSize = 5;
        Board medium = new Board(bSize);

        Move playerSet = new Move(bSize - 1, bSize - 1);
        medium.setPlayer(playerSet);

        assertEquals('*', ((APiece)(medium.board[bSize - 1][bSize - 1])).symbol);
        assertEquals('*', ((APiece)(medium.board[medium.myLoc.row][medium.myLoc.col])).symbol);

    }

    @Test
    public void setExit() {
        Board b = new Board(7);

        b.setExit();

        int exitCount = 0;
        for(int i = 0; i < b.size; i++){
            for(int j = 0; j < b.size; j++){
                if(b.board[i][j] != null && ((APiece)(b.board[i][j])).symbol == '@'){
                    exitCount++;
                }
            }
        }
        assertEquals(1,exitCount);
    }

    @Test
    public void setEnemy(){
        int size = 8;
        Board board = new Board(size);

        board.setEnemies(3);

        int enCount = 0;
        for(int i = 0; i < board.size; i++){
            for(int j = 0; j < board.size; j++){
                if((board.board[i][j] != null) && (((APiece)board.board[i][j])).symbol == '&'){
                    enCount++;
                }
            }
        }
        assertEquals(3, enCount);

        for(int i = 0; i < board.enemies.length; i++){
            Move loc = board.enemies[i];
            assertEquals('&', ((APiece)(board.board[loc.row][loc.col])).symbol);
        }
    }

    @Test
    public void setTreasure(){
        Board b = new Board(9);
        b.setTreasure(4);
        int val = -1;
        boolean allSame = true;
        int countTreasure = 0;
        for(int i=0;i<b.size;i++){
            for(int j=0;j<b.size;j++){
                if(b.board[i][j] != null && ((APiece)(b.board[i][j])).symbol == '$'){
                    Treasure t = (Treasure)b.board[i][j];
                    assertTrue(t.value >= 100);
                    assertTrue(t.value <= 1000);
                    assertEquals(0,t.value%100);
                    if(val < 0){
                        val = t.value;
                    }
                    if(t.value != val){
                        allSame = false;
                    }
                    countTreasure++;
                }
            }
        }
        assertFalse(allSame);
        assertEquals(4,countTreasure);
    }

    @Test
    public void collidePlayerTest(){
        Board board = new Board(6);

        // Tests for null
        Player playerOne = new Player();
        Move playerLoc = new Move(2,4);

        assertEquals(null, playerOne.collide(playerOne));

        // Tests for enemy collision
        Player playerTwo = new Player();
        Move player2Loc = new Move(3,5);

        Enemy enemyOne = new Enemy();
        Move enemyLoc = new Move(3,5);
        assertEquals("GAME OVERRRRR", playerTwo.collide(enemyOne));


        //Tests for exit collision
        Player playerThree = new Player();
        Move player3Loc = new Move(4,4);

        Exit exitOne = new Exit();
        Move exitLoc = new Move(4,4);

        assertEquals("Level is over. Moving onto next level", playerThree.collide(exitOne));

        //Tests for Treasure collision
        Player playerFour = new Player();
        Move player4Loc = new Move(4,4);


        Treasure treasureOne = new Treasure();
        treasureOne.value = 500;

        Move treasureLoc = new Move(5,4);

        //Treasure string return test
        assertEquals("You just found $" + "500" + "!", playerFour.collide(treasureOne));

        int playerFourActualScore = playerFour.score;
        assertEquals(500, playerFourActualScore);

    }

    @Test
    public void collideEnemyTest(){
        Board board = new Board(7);

        // Tests for enemy collision
        Enemy enemyTwo = new Enemy();
        Move en2Loc = new Move(4,5);


        //Tests for Treasure collision
        Enemy enFour = new Enemy();
        Move en4Loc = new Move(6,7);


        Treasure treasureOne = new Treasure();

        Move treasureLoc = new Move(6,7);

        //String return test
        assertEquals("Enemy the collided with and ATE the treasure", enFour.collide(treasureOne));
    }

    @Test
    public void movePlayerTest(){
        Board b = new Board(8);

        //tests moving player and enemy collision
        Move loc = new Move(5, 6);
        b.setPlayer(loc);

        Enemy enOne = new Enemy();
        Move enLoc = new Move(6,7);
        b.board[6][7] = enOne;
        

        String actual = b.movePlayer(1,1);
        assertEquals("GAME OVERRRRR", actual);

        //tests moving player and treasure collision
        Move locTwo = new Move(4, 5);
        b.setPlayer(locTwo);
        Treasure chest = new Treasure();
        chest.value = 400;
        Move tChest = new Move(5,5);
        b.board[5][5] = chest;

        String act = b.movePlayer(1,0);
        assertEquals("You just found $" + "400" + "!",act);

        //tests moving player and exit collision
        Move locThree = new Move(6,5);
        b.setPlayer(locThree);
        Exit exit = new Exit();
        Move xExit = new Move(5,4);
        b.board[5][4] = exit;

        String retVal = b.movePlayer(-1,-1);
        assertEquals("Level is over. Moving onto next level", retVal);

        //tests for a non-valid move
        Move locFour = new Move(7,7);
        b.setPlayer(locFour);

        String retInValid = b.movePlayer(1,1);
        assertEquals("Move is invalid, try again", retInValid);
    }

    // A -> move left (+0)(-1)
    // D -> move right (col/ +0) (+1)
    // S -> move down (+1) (+0)
    // W -> move up (-1) (+0)
    //////// test isValidEnemyMove
    @Test
    public void isValidEnemyMoveTest(){
        Board b = new Board(9);

        //Enemy location that we want to change
        Enemy enToMove = new Enemy();
        Move ogEnMove = new Move(4,6);
        b.board[4][6] = enToMove;

        //Enemy on Board - on the right 'D'
        Enemy en1 = new Enemy();
        Move enOne = new Move(4,7);
        b.board[4][7] = en1;

        //Enemy on Board - on the left 'A'
        Enemy en2 = new Enemy();
        Move enTwo = new Move(4,5);
        b.board[4][5] = en2;

        // Exit on Board - above 'W'
        Exit xIT1 = new Exit();
        Move exitOne = new Move(3,6);
        b.board[3][6] = xIT1;

        //Exit on Board - below 'S'
        Exit xIT2 = new Exit();
        Move exitTwo = new Move(5,6);
        b.board[5][6] = xIT2;

       // boolean actual = b.isValidEnemyMove(enOne);
       // assertEquals(false, actual);

        boolean actual3 = b.isValidEnemyMove(exitTwo);
        assertEquals(false, actual3);

        Move actual4 = b.getValidEnemyMove(ogEnMove);
        assertEquals(6, actual4.col);
        assertEquals(4, actual4.row);
    }


    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
}
