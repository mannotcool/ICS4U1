/**
 * Connect 4 Board Class
 * All methods required to manipulate the board are found here.
 * 
 * @author Nick Stoyanov
 * @version Dec 2, 2025
 */
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
        System.out.println("    1   2   3   4   5   6   7");
        System.out.println("  _____________________________");
        for (int i = 0; i < 6; i++) {
            // print each row number
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 7; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("  ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
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

    public void checkWinner() {
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
                    System.out.println("Winner: " + currentPiece);
                    return;
                }

                // check vertical
                if (i + 3 < 6 &&
                    currentPiece == board[i + 1][j] &&
                    currentPiece == board[i + 2][j] &&
                    currentPiece == board[i + 3][j]) {
                    System.out.println("Winner: " + currentPiece);
                    return;
                }

                // check diagonal (bottom-left to top-right)
                if (i + 3 < 6 && j + 3 < 7 &&
                    currentPiece == board[i + 1][j + 1] &&
                    currentPiece == board[i + 2][j + 2] &&
                    currentPiece == board[i + 3][j + 3]) {
                    System.out.println("Winner: " + currentPiece);
                    return;
                }

                // check diagonal (top-left to bottom-right)
                if (i - 3 >= 0 && j + 3 < 7 &&
                    currentPiece == board[i - 1][j + 1] &&
                    currentPiece == board[i - 2][j + 2] &&
                    currentPiece == board[i - 3][j + 3]) {
                    System.out.println("Winner: " + currentPiece);
                    return;
                }
            }
        }
    }
}
