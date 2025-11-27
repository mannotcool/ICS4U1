import java.util.Scanner;
import java.util.Random;

public class DynamicQueueTest {
    public static void main( String[] args ) {
        Scanner input = new Scanner( System.in );
        DynamicQueue<String> queue = new DynamicQueue<String>();

        // get usernames
        while (true) {
            System.out.println( "enter player:" );
            String userInput = input.nextLine();

            // if username is just enter, break
            if ( userInput.equals( "" ) ) {
                break;
            }
            queue.enqueue( userInput );
        }

        // simulate game
        while ( queue.size() > 1 ) {
            System.out.println( "\ncurrent Players: " + queue.toString() );
            Random rand = new Random();
            // between 0 and number of players - 1
            int n = rand.nextInt( queue.size() ) + 1;

            System.out.println( "\neliminate " + (n + 1) + "th player" );
            // run elimination process n times
            for (int i = 0; i < n; i++) {
                // dequeue front player and enqueue them back
                String playerIn = queue.dequeue();
                System.out.println( playerIn + " is safe!" );
                queue.enqueue( playerIn );
            }

            // dequeue first player
            String playerOut = queue.dequeue();
            System.out.println( playerOut + " is out!" );
        }

        System.out.println( "\nthe winner is " + queue.peek() + "!" );   
    }
}
