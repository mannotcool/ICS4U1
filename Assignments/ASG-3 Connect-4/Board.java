/**
 * Connect 4 Board Class
 * All methods required to manipulate the board are found here.
 * 
 * @author Nick Stoyanov
 * @version Dec 2, 2025
 */

import java.util.Random;

public class Board {
    // game board pieces i will use: ● and ○

    // keep a tally of empty cells
    private int emptyCells;
    private char[][] board;

    public Board() {
        ClearBoard();
    }

    /**
     * Accessor method to get the number of empty cells on the board.
     * @return number of empty cells on the board
     */
    public int getEmptyCells() {
        return emptyCells;
    }

    // method to display the board
    public void getBoard() {
        System.out.println("  1   2   3   4   5   6   7");
        System.out.println("_____________________________");
        for (int i = 0; i < 6; i++) {
            // print each row number
            for (int j = 0; j < 7; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
    }

    public void ClearBoard() {
        board = new char[6][7];
        emptyCells = 42;
        for (int i = 0; i < 6; i ++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public boolean isColumnFull(int col) {
        return board[0][col] != ' ';
    }

    public void placeCell(int col, char piece) {
        // place piece in lowest available row in specified column
        for (int i = 5; i >= 0; i--) {
            if (board[i][col] == ' ') {
                board[i][col] = piece;
                break;
            }
        }

        emptyCells--;
    }

    public boolean aiBlockVictory() {
        for (int col = 0; col < 7; col++) {
            // skip full columns
            if (board[0][col] != ' ') continue;

            // find the row where a piece would land in this column
            int rowToTry = -1;
            for (int row = 5; row >= 0; row--) {
                if (board[row][col] == ' ') {
                    rowToTry = row;
                    break;
                }
            }
            if (rowToTry == -1) continue;  // should not happen, but just in case

            // simulate opponent move
            board[rowToTry][col] = '●';
            boolean opponentWins = (getWinner() != null && getWinner().charAt(0) == '●');

            // undo the simulation
            board[rowToTry][col] = ' ';

            if (opponentWins) {
                board[rowToTry][col] = '○';
                return true; // block the opponent's winning move
            }
        }
        return false;
    }

    public boolean aiTryToWin() {
        // scan board to see if there are any winning moves available for the AI
        for (int col = 0; col < 7; col++) {
            // skip full columns
            if (board[0][col] != ' ') continue;

            // find the lowest empty row in this column
            int placedRow = -1;
            for (int row = 5; row >= 0; row--) {
                if (board[row][col] == ' ') {
                    placedRow = row;
                    break;
                }
            }
            if (placedRow == -1) continue; // safety

            // simulate placing the AI piece
            board[placedRow][col] = '○';

            // check if this move wins the game
            boolean aiWins = (getWinner() != null && getWinner().charAt(0) == '○');

            // undo the simulation
            board[placedRow][col] = ' ';

            // if it wins, actually play this move
            if (aiWins) {
                placeCell(col, '○');
                return true;
            }
        }
        return false;
    }


    public boolean aiConstructThree() {
        for (int col = 0; col < 7; col++) {
            // skip full columns
            if (board[0][col] != ' ') continue;

            // find the lowest empty row in this column
            int placedRow = -1;
            for (int row = 5; row >= 0; row--) {
                if (board[row][col] == ' ') {
                    placedRow = row;
                    break;
                }
            }
            if (placedRow == -1) continue;  // column somehow full

            // simulate placing the AI piece
            board[placedRow][col] = '○';

            boolean makesThree = false;
            for (int i = 0; i < 6 && !makesThree; i++) {
                for (int j = 0; j < 7 && !makesThree; j++) {
                    char cur = board[i][j];

                    // only check for AI pieces
                    if (cur != '○') continue;

                    // horizontal 3
                    if (j + 2 < 7 && cur == board[i][j + 1] && cur == board[i][j + 2]) {
                        makesThree = true;
                    }
                    // vertical 3
                    else if (i + 2 < 6 && cur == board[i + 1][j] && cur == board[i + 2][j]) {
                        makesThree = true;
                    }
                    // diagonal down-right
                    else if (i + 2 < 6 && j + 2 < 7 && cur == board[i + 1][j + 1] && cur == board[i + 2][j + 2]) {
                        makesThree = true;
                    }
                    // diagonal up-right
                    else if (i - 2 >= 0 && j + 2 < 7 && cur == board[i - 1][j + 1] && cur == board[i - 2][j + 2]) {
                        makesThree = true;
                    }
                }
            }

            // undo simulation
            board[placedRow][col] = ' ';

            if (makesThree) {
                placeCell(col, '○');
                return true;
            }
        }
        return false;
    }

    public void aiExecuteBestMove() {
        // as a computer, the ai should prevent winning moves, try to win, and otherwise play the best move
        if (aiBlockVictory() || aiTryToWin() || aiConstructThree()) return;

        // otherwise, play a random valid move
        Random rand = new Random();
        int col = rand.nextInt(7);

        while (board[0][col] != ' ') {
            col = rand.nextInt(7);
        }

        placeCell(col, '○');
    }

    
    public String getWinner() {
        // begin with bottom left cell, scan each direction to find 4 in a row
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                char currentPiece = board[i][j];
                if (currentPiece == ' ') {
                    continue; // skip empty cells
                }

                // check horizontal
                if (j + 3 < 7 &&
                    currentPiece == board[i][j + 1] &&
                    currentPiece == board[i][j + 2] &&
                    currentPiece == board[i][j + 3]) {
                    return String.valueOf(currentPiece);
                }

                // check vertical
                if (i + 3 < 6 &&
                    currentPiece == board[i + 1][j] &&
                    currentPiece == board[i + 2][j] &&
                    currentPiece == board[i + 3][j]) {
                    return String.valueOf(currentPiece);
                }

                // check diagonal (bottom-left to top-right)
                if (i + 3 < 6 && j + 3 < 7 &&
                    currentPiece == board[i + 1][j + 1] &&
                    currentPiece == board[i + 2][j + 2] &&
                    currentPiece == board[i + 3][j + 3]) {
                    return String.valueOf(currentPiece);
                }

                // check diagonal (top-left to bottom-right)
                if (i - 3 >= 0 && j + 3 < 7 &&
                    currentPiece == board[i - 1][j + 1] &&
                    currentPiece == board[i - 2][j + 2] &&
                    currentPiece == board[i - 3][j + 3]) {
                    return String.valueOf(currentPiece);
                }
            }
        }
        return null;
    }
}
