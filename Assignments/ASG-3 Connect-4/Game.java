/**
 * Nick's super not epic connect-4 recreation
 * 
 * @author Nick Stoyanov
 * @version Dec 2, 2025
 */
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        System.out.println("Welcome to nick's super epic connect-4 recreation!");
        Board board = new Board();
        board.getBoard();
        
        Scanner scanner = new Scanner(System.in);
        while (board.getEmptyCells() > 0 && board.getWinner() == null) {
            // the player will be '●' and the ai will be '○'
            System.out.print("Enter the column (1-7) you would like to place your piece in: ");
            int playerCol = scanner.nextInt() - 1;
            while (playerCol < 0 || playerCol > 6 || board.isColumnFull(playerCol)) {
                System.out.print("Invalid column. Please enter a different column (1-7): ");
                playerCol = scanner.nextInt() - 1;
            }
            board.placeCell(playerCol, '●');
            board.getBoard();

            board.aiExecuteBestMove();
            board.getBoard();

        }
        String winner = board.getWinner();
        System.out.println("\n The winner is... " + winner + "!");
    }
}

