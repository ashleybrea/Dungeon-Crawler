import java.util.Scanner;
/**
 * The Dungeon class holds
 * all game play
 *
 * @author (Ashley Brea)
 * @version (11/05/23)
 */
public class Dungeon {
    /**
     * Board room -> initializes a new Board
     *               called room, to null
     * int totalScore -> the amount of $ from
     *                  treasures collected within one round
     * int highScore -> the highest amount of $ from treasures collected
     * int size -> dictates the size of the board, and is used in play
     *              for error handling
     *
     */
    Board room = null;
    int totalScore;
    int highScore;
    int size;

    /**
     * Holds all the game play
     * that dictates how the game functions
     * and how the user will interact with it
     */
    public void play() {
        boolean newGame = true;
        while (newGame) {
            this.totalScore = 0;
            Scanner scanner = new Scanner(System.in);
            System.out.println("WELCOME TO ASHLEY'S");
            System.out.println(".----. .-. .-..-. .-. .---. .----..----. .-. .-.    .---. .----.   .--.  .-. . .-..-.   ");
            System.out.println("| {}  \\| { } ||  `| |/   __}| {_ /  {}  \\|  `| |   /  ___}| {}  } / {} \\ | |/ \\| || |   ");
            System.out.println("|     /| {_} || |\\  |\\  {_ }| {__\\      /| |\\  |   \\     }| .-. \\/  /\\  \\|  .'.  || `--.");
            System.out.println("`----' `-----'`-' `-' `---' `----'`----' `-' `-'    `---' `-' `-'`-'  `-'`-'   `-'`----'");

            System.out.println("---------------------------------------------------------");
            System.out.println("Choose a number from 3 to 9 to be the size of the board");
            while (true) {
                int size = -1;
                boolean validInput = true;
                while (validInput) {
                    try {
                        size = Integer.parseInt(scanner.nextLine());
                        if (size < 10 && size > 2) {
                            this.size = size;
                            validInput = false;
                            break;
                        } else {
                            System.out.println("Let's try again. Choose a number from 3-9");
                        }
                    } catch (Exception e) {
                        System.out.println("Let's try again. Choose a number from 3-9");
                        continue;
                    }
                }
                // initial set up
                boolean gamePlay = true;

                int level = 1;

                System.out.println("------------------- LEVEL " + level + " -------------------");

                while (gamePlay) {

                    // initial set up
                    init(level, this.size);

                    boolean gameLoop = true;
                    while (gameLoop) {
                        String retResult = "";

                        retResult = (playerTurn());

                        if (retResult.equals("GAME OVERRRRR")) {
                            Player endLevelPlayer = (Player) room.board[room.myLoc.row][room.myLoc.col];
                            this.totalScore += endLevelPlayer.score;
                            System.out.println("    )\\.-.     /`-.    )\\   )\\   )\\.---.         .-./(       .-.   )\\.---.    _/`-. ");
                            System.out.println("   / .-._)  .' _  \\  (  './ /  (   .-._(      .'     )  )\\  /  ) (   .-._(  )  _  \\");
                            System.out.println(" (  .   __ (  '-' (   )    (    \\  '-.       (   _  (  (  ) | (   \\  '-.   (  '-' (");
                            System.out.println("  ) '._\\ _) )   _  ) (  \\(\\ \\    ) .-`        ) (_)  ) )  \\/ /     ) .-`    )  _ .'");
                            System.out.println(" (  .   (  (  /  ) \\  ).) /  )  (  ``-.      (      (  (     (    (  ``-.  (  ' ) \\");
                            System.out.println("  )/\\.__/   )/    )/ ( /  '.(    ).--.(       )/____/   )/../      ).--.(   )/   )/");
                            System.out.println("Looks like you ran into an enemy :( ");

                            break;
                        }

                        if (retResult.equals("Level is over. Moving onto next level")) {
                            Player endLevelPlayer = (Player) room.board[room.myLoc.row][room.myLoc.col];
                            this.totalScore += endLevelPlayer.score;

                            System.out.println("EXIT REACHED, Here's your level score: " + endLevelPlayer.score + " || Here's your total score: " + this.totalScore);
                            level++;
                            if(level + 5 + 1 - this.size * this.size == 0){
                                System.out.println("⚠ The board is too small to continue ⚠");
                                break;
                            } else {
                                System.out.println("------------------- LEVEL " + level + " -------------------");
                                init(level, this.size);
                                continue;
                            }
                        }
                        // Checks to see if the Enemy collided with Player
                       String enRetResult = room.moveEnemies();
                        if (enRetResult.equals("GAME OVERR")){
                                Player endLevelPlayer = (Player) room.board[room.myLoc.row][room.myLoc.col];
                                this.totalScore += endLevelPlayer.score;
                                System.out.println("    )\\.-.     /`-.    )\\   )\\   )\\.---.         .-./(       .-.   )\\.---.    _/`-. ");
                                System.out.println("   / .-._)  .' _  \\  (  './ /  (   .-._(      .'     )  )\\  /  ) (   .-._(  )  _  \\");
                                System.out.println(" (  .   __ (  '-' (   )    (    \\  '-.       (   _  (  (  ) | (   \\  '-.   (  '-' (");
                                System.out.println("  ) '._\\ _) )   _  ) (  \\(\\ \\    ) .-`        ) (_)  ) )  \\/ /     ) .-`    )  _ .'");
                                System.out.println(" (  .   (  (  /  ) \\  ).) /  )  (  ``-.      (      (  (     (    (  ``-.  (  ' ) \\");
                                System.out.println("  )/\\.__/   )/    )/ ( /  '.(    ).--.(       )/____/   )/../      ).--.(   )/   )/");
                                System.out.println("Looks like you got eaten by an enemy :( ");
                                break;
                        }

                        System.out.println(retResult);
                        System.out.println(enRetResult);
                        System.out.println(room);
                    }
                    //check high score
                    if (this.totalScore > this.highScore) {
                        this.highScore = this.totalScore;
                        System.out.println("\n" + "Congratulations, you've reached a new high score of: " + this.highScore + "!" + "\n");
                    }
                    System.out.println("Here are your stats:" + "\n" + "-----------------");
                    System.out.println("Level Died On: " + level + "\n" + "Total Score: " + this.totalScore + "\n" + "Current High Score: " + this.highScore);
                    break;
                }
                break;
            }
            System.out.println("Press q to quit or press any other key to continue playing");
            String nextGame = scanner.nextLine().toLowerCase();

            if (nextGame.equals("q")) {
                break;
            } else {
                continue;
            }
        }
    }

        /**
         * Asks for the users input and
         * then moves the plauer on the board
         * either up, down, or side to side
         * @return a String if the player collides
         *          with another piece, or if the user
         *          gives an invalid input
         */

        public String playerTurn () {
            String retVal = "";
            Scanner scanner = new Scanner(System.in);

            boolean input = true;
            while (input) {

                System.out.println("Lets move your player");
                System.out.println("Use keys A, D, W, or S to navigate the board");

                String direct = scanner.nextLine();
                boolean valKey = true;
                while (valKey) {
                    try {
                        if (direct.equals("a") || direct.equals("d") || direct.equals("s") || direct.equals("w")) {
                            valKey = false;
                            break;
                        } else {
                            System.out.println("That doesn't look like a valid input, lets try that again.");
                            direct = scanner.nextLine();
                        }
                    } catch (Exception e) {
                        System.out.println("That doesn't look like a valid input, lets try that again.");
                        continue;
                    }
                }

                if (direct.equals("a")) {
                    return this.room.movePlayer(0, -1);
                }
                if (direct.equals("d")) {
                    return this.room.movePlayer(0, 1);
                }
                if (direct.equals("s")) {
                    return this.room.movePlayer(1, 0);
                }
                if (direct.equals("w")) {
                    return this.room.movePlayer(-1, 0);
                }

            }
            return retVal;
        }

    /**
     * Initializes the game board // room
     * at the very beginning of the game
     * @param level -> the level the player is on,
     *                 setEnemies, is dependent
     *                  on the level
     * @param size -> initializes a square board
     *                  based on given size
     */
    public void init(int level, int size){
            room = new Board(size);
            Move plyr = new Move(room.size - 1, room.size - 1);
            room.setPlayer(plyr);
            room.setTreasure(5);
            room.setEnemies(level);
            room.setExit();
            System.out.println(room);
        }
    }
