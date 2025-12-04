/**
 * Nick's super not epic connect-4 recreation
 * 
 * @author Nick Stoyanov
 * @version Dec 2, 2025
 */
import java.util.Scanner;

public class Game {
    private int currentPlayer = 0;
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Board board = new Board();

        board.getBoard();
        // do a while loop here to keep the game going until a player wins or the board is full

        Scanner scanner = new Scanner(System.in);
        while (board.getEmptyCells() > 0) {
            System.out.println("Player " + (board.getEmptyCells() % 2 == 0 ? "●" : "○") + ", enter a column (1-7) to place your piece:");
            int col = scanner.nextInt() - 1; // adjust for 0-indexed array
            if (col < 0 || col > 6) {
                System.out.println("Invalid column. Please choose a column between 1 and 7.");
                continue;
            }
            board.placeCell(col, board.getEmptyCells() % 2 == 0 ? '●' : '○');
            board.checkWinner();
            board.getBoard();
        }
        System.out.println("Game over! It's a draw.");
    }
}

