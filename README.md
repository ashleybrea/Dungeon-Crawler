# Dungeon-Crawler 

## Description 
Dungeon Crawler is a command-line program that utilizes the 2-D array data structure for game board visualization. The program has a user-interactive design as it relies on user input for the game to progress. 

## Game Logic 👾
The game board consists of different players:
1. '*' -> Player 👤: Signifies where the player is on the board. To move across the board utilize the a(left), d(right, w(up), and s(down) keys.
2. & -> Enemies (ง'̀-'́)ง: Once the player collides with an enemy the game is OVERRR. As the player advances the number of enemies on the game board increases. The enemies are also randomly moving simultaneously as the player moves. 
3. $ -> Treasure 🏴‍☠️: Each treasure contains a randomly generated amount of Prize Money, prize money dictates the score. As the player advances to different levels the level score and the total score are communicated
4. @ -> Exit 🚫: This is your key to freedom! The player only advances to the next level once they reach the exit. Unlike treasures and enemies, there is only one exit.

## How to Clone This Repository
-> To run this code, first ensure you have cloned the repository as such:
   ```bash
   git clone https://gitfront.io/r/abrea/wSBmWGN8Zhb/Dungeon-Crawler.git
   ```

## How to Run from an IDE

-> Open the file on your preferred IDE e.g. IntelliJ or Visual Studio Code

-> Run the Main class and then follow the instructions :)

## How to Run From The Command Line
-> First, move into the directory of the Main class:
```bash
   cd Dungeon-Crawler/sc
   ```
-> Then, run the Main class as so
```bash
   javac Main.java
   java Main
   ```




