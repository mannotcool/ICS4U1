/**
 * Nick's super not epic connect-4 recreation
 * 
 * @author Nick Stoyanov
 * @version Dec 2, 2025
 */
import java.util.Random;
import java.util.Scanner;

public class Game {
    /**
     * Main line method to run the connect-4 game.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("\nWelcome to Nick's super epic connect-4 recreation!");

        Board connectFourBoard = new Board();
        System.out.println(connectFourBoard);
        
        System.out.println("You are '●' and the CPU is '○'.");
        Scanner scanner = new Scanner(System.in);

        // end game conditions: board full or winner found
        while (connectFourBoard.getEmptyCells() > 0 && connectFourBoard.getWinner() == null) {
            // the player will be '●' and the CPU will be '○'
            System.out.print("Enter the column (1-7) you would like to place your piece in: ");
            playerMove(connectFourBoard, scanner);
            System.out.println("\nCPU is making its move...\n");
            cpuExecuteBestMove(connectFourBoard);
            System.out.println(connectFourBoard);

        }

        // game over messages
        if (connectFourBoard.getWinner() == null) {
            System.out.println("It's a tie!");
        } else {
            System.out.println("Game over!");
            String winner = connectFourBoard.getWinner();
            System.out.println("\nThe winner is... " + winner + "!");
        }
    }

    /**
     * Method to handle the player's move input and validation.
     * @param connectFourBoard The game board
     * @param scanner Scanner object for input
     */
    public static void playerMove(Board connectFourBoard, Scanner scanner) {
        // get and validate player input
        int playerCol = scanner.nextInt() - 1;
        while (playerCol < 0 || playerCol > 6 || connectFourBoard.isColumnFull(playerCol)) {
            System.out.print("Invalid column. Please enter a different column (1-7): ");
            playerCol = scanner.nextInt() - 1;
        }

        connectFourBoard.placeCell(playerCol, '●');
        System.out.println(connectFourBoard);
    }

    /**
     * Method for the CPU to execute the best move based on current board state.
     * @param connectFourBoard The game board
     */
    public static void cpuExecuteBestMove(Board connectFourBoard) {
        // as a computer, the CPU should prevent winning moves, try to win, and otherwise play the best move
        if (cpuBlockVictory(connectFourBoard) || cpuTryToWin(connectFourBoard) || cpuConstructThree(connectFourBoard)) return;

        // otherwise, play a random valid move
        Random rand = new Random();
        int col = rand.nextInt(7);

        while (connectFourBoard.isColumnFull(col)) {
            col = rand.nextInt(7);
        }

        connectFourBoard.placeCell(col, '○');
    }

    /**
     * Method for the CPU to block opponent's winning move if available.
     * @param connectFourBoard The game board
     * @return true if a blocking move was made, false otherwise
     */
    public static boolean cpuBlockVictory(Board connectFourBoard) {
        // pull the current board reference
        char[][] currentBoard = connectFourBoard.getBoard();
        
        for (int col = 0; col < 7; col++) {
            // skip full columns
            if (currentBoard[0][col] != ' ') continue;

            // find the row where a piece would land in this column
            int rowToTry = -1;
            for (int row = 5; row >= 0; row--) {
                if (currentBoard[row][col] == ' ') {
                    rowToTry = row;
                    break;
                }
            }
            if (rowToTry == -1) continue;  // should not happen, but just in case

            // simulate opponent move using copy of the board
            currentBoard[rowToTry][col] = '●';
            boolean opponentWins = (connectFourBoard.getWinner() != null && connectFourBoard.getWinner().charAt(0) == '●');

            // undo the simulation
            currentBoard[rowToTry][col] = ' ';
            if (opponentWins) {
                currentBoard[rowToTry][col] = '○'; // place CPU piece to block
                return true; // block the opponent's winning move
            }
        }
        return false;
    }

    /**
     * Method for the CPU to try to win if a winning move is available by scanning the board.
     * @param connectFourBoard The game board
     * @return true if a winning move was made, false otherwise
     */
    public static boolean cpuTryToWin(Board connectFourBoard) {
        // pull the current board reference
        char[][] currentBoard = connectFourBoard.getBoard();

        // scan board to see if there are any winning moves available for the CPU
        for (int col = 0; col < 7; col++) {
            // skip full columns
            if (currentBoard[0][col] != ' ') continue;

            // find the lowest empty row in this column
            int placedRow = -1;
            for (int row = 5; row >= 0; row--) {
                if (currentBoard[row][col] == ' ') {
                    placedRow = row;
                    break;
                }
            }
            if (placedRow == -1) continue; // safety

            // simulate placing the CPU piece
            currentBoard[placedRow][col] = '○';

            // check if this move wins the game
            boolean cpuWins = (connectFourBoard.getWinner() != null && connectFourBoard.getWinner().charAt(0) == '○');
            // undo the simulation
            currentBoard[placedRow][col] = ' ';

            // if it wins, actually play this move
            if (cpuWins) {
                connectFourBoard.placeCell(col, '○');
                return true;
            }
        }
        return false;
    }


    /**
     * Method for the CPU to try to create three in a row for itself, thus setting up a future win.
     * @param connectFourBoard The game board
     * @return true if a move creating three in a row was made, false otherwise
     */
    public static boolean cpuConstructThree(Board connectFourBoard) {
        // scan board to see if there are any moves that create 3 in a row for the CPU
        char[][] currentBoard = connectFourBoard.getBoard();
        for (int col = 0; col < 7; col++) {
            // skip full columns
            if (currentBoard[0][col] != ' ') continue;

            // find the lowest empty row in this column
            int placedRow = -1;
            for (int row = 5; row >= 0; row--) {
                if (currentBoard[row][col] == ' ') {
                    placedRow = row;
                    break;
                }
            }
            if (placedRow == -1) continue;  // column somehow full

            // simulate placing the CPU piece
            currentBoard[placedRow][col] = '○';

            boolean makesThree = false;
            for (int i = 0; i < 6 && !makesThree; i++) {
                for (int j = 0; j < 7 && !makesThree; j++) {
                    char cur = currentBoard[i][j];

                    // only check for CPU pieces
                    if (cur != '○') continue;

                    // horizontal 3
                    if (j + 2 < 7 && cur == currentBoard[i][j + 1] && cur == currentBoard[i][j + 2]) {
                        makesThree = true;
                    }
                    // vertical 3
                    else if (i + 2 < 6 && cur == currentBoard[i + 1][j] && cur == currentBoard[i + 2][j]) {
                        makesThree = true;
                    }
                    // diagonal down-right
                    else if (i + 2 < 6 && j + 2 < 7 && cur == currentBoard[i + 1][j + 1] && cur == currentBoard[i + 2][j + 2]) {
                        makesThree = true;
                    }
                    // diagonal up-right
                    else if (i - 2 >= 0 && j + 2 < 7 && cur == currentBoard[i - 1][j + 1] && cur == currentBoard[i - 2][j + 2]) {
                        makesThree = true;
                    }
                }
            }

            // undo simulation
            currentBoard[placedRow][col] = ' ';

            if (makesThree) {
                connectFourBoard.placeCell(col, '○');
                return true;
            }
        }
        return false;
    }
}