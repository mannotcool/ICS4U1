/**
 * Connect 4 Board Class
 * All methods required to manipulate the board are found here.
 * 
 * @author Nick Stoyanov
 * @version Dec 2, 2025
 */

public class Board {
    private int emptyCells;
    private char[][] board;

    /**
     * No argument constructor for Board class. Only clears the board.
     */
    public Board() {
        clearBoard();
    }

    /**
     * Accessor method to get the number of empty cells on the board.
     * @return number of empty cells on the board
     */
    public int getEmptyCells() {
        return emptyCells;
    }

    /**
     * Accessor method to get the current board state.
     * @return 2D char array representing the board
     */
    public char[][] getBoard() {
        return board;
    }

    /**
     * Method to check for a winner on the board. It scans the board for 4 in a row.
     * @return "●" if player wins, "○" if AI wins, null if no winner yet.
     */
    public String getWinner() {
        // begin with bottom left cell, scan each direction to find 4 in a row
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                char currentPiece = board[i][j];
                if (currentPiece == ' ') {
                    continue; // skip empty cells
                }

                // check horizontal
                if (j + 3 < 7 && currentPiece == board[i][j + 1] && currentPiece == board[i][j + 2] && currentPiece == board[i][j + 3]) {
                    return String.valueOf(currentPiece);
                }

                // check vertical
                if (i + 3 < 6 && currentPiece == board[i + 1][j] && currentPiece == board[i + 2][j] && currentPiece == board[i + 3][j]) {
                    return String.valueOf(currentPiece);
                }

                // check diagonal (bottom-left to top-right)
                if (i + 3 < 6 && j + 3 < 7 && currentPiece == board[i + 1][j + 1] && currentPiece == board[i + 2][j + 2] && currentPiece == board[i + 3][j + 3]) {
                    return String.valueOf(currentPiece);
                }

                // check diagonal (top-left to bottom-right)
                if (i - 3 >= 0 && j + 3 < 7 && currentPiece == board[i - 1][j + 1] && currentPiece == board[i - 2][j + 2] && currentPiece == board[i - 3][j + 3]) {
                    return String.valueOf(currentPiece);
                }
            }
        }
        return null;
    }

    /**
     * Method to clear the board. Resets all cells to empty and resets empty cell count.
     */
    public void clearBoard() {
        board = new char[6][7];
        emptyCells = 42;
        for (int i = 0; i < 6; i ++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = ' ';
            }
        }
    }

    /**
     * Method to check if a column is full.
     * @param col column to check
     * @return true if column is full, false otherwise
     */
    public boolean isColumnFull(int col) {
        return board[0][col] != ' ';
    }

    /**
     * Method to place a piece in a specified column.
     * @param col column to place piece in
     * @param piece character representing the piece to place
     */
    public void placeCell(int col, char piece) {
        // make sure the cell is not off the board
        if (col < 0 || col >= 7) {
            System.err.println("Error: Attempted to set cell outside of board boundaries.");
            return;
        }

         // place piece in lowest available row in specified column
        for (int i = 5; i >= 0; i--) {
            if (board[i][col] == ' ') {
                board[i][col] = piece;
                break;
            }
        }

        emptyCells--;
    }

    /**
     * Method to print the current state of the board.
     * @return String representation of the board
     */
    public String toString() {
        return "\n  1   2   3   4   5   6   7\n" +
        "_____________________________\n" +
        "| " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " | " + board[0][3] + " | " + board[0][4] + " | " + board[0][5] + " | " + board[0][6] + " |\n" +
        "| " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " | " + board[1][3] + " | " + board[1][4] + " | " + board[1][5] + " | " + board[1][6] + " |\n" +
        "| " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " | " + board[2][3] + " | " + board[2][4] + " | " + board[2][5] + " | " + board[2][6] + " |\n" +
        "| " + board[3][0] + " | " + board[3][1] + " | " + board[3][2] + " | " + board[3][3] + " | " + board[3][4] + " | " + board[3][5] + " | " + board[3][6] + " |\n" +
        "| " + board[4][0] + " | " + board[4][1] + " | " + board[4][2] + " | " + board[4][3] + " | " + board[4][4] + " | " + board[4][5] + " | " + board[4][6] + " |\n" +
        "| " + board[5][0] + " | " + board[5][1] + " | " + board[5][2] + " | " + board[5][3] + " | " + board[5][4] + " | " + board[5][5] + " | " + board[5][6] + " |\n" +
        "‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾";
    }
}