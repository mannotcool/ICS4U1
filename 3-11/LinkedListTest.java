import java.util.Scanner;
 
class LinkedListTest {
    public static void main( String[] args ) {        
        String command;
        Scanner keyInput = new Scanner(System.in);
        LinkedList<String> myList = new LinkedList<>();
        
        while (true) {
            System.out.printf( "\nList Empty? %b   List Size? %d   %s\n", myList.isEmpty(), myList.size(), myList );
            System.out.print("Command >");
            command = keyInput.nextLine().toLowerCase().trim();
            if (command.startsWith("add")) {
                myList.addFirst(command.substring(4));
                System.out.println( "Added to front: " + myList.peekFirst() );
            } else if (command.startsWith("last")) {
                myList.addLast(command.substring(5).trim());
                System.out.println( "Added to end: " + command.substring(5).trim() );
            }
            else if (command.startsWith("peek")) {
                System.out.println( "Peeked at front: " + myList.peekFirst() );
            }
            else if (command.startsWith("rem")) {
                System.out.println( "Removed from front: " + myList.removeFirst() );
            }
            else if (command.startsWith("con")) {
                System.out.println( "Contains \"" + command.substring(4) +"\"? " + myList.contains(command.substring(4)) );
            }
            else if (command.startsWith("clear")) {
                myList.clear();
                System.out.println( "Cleared!" );
            }
            else if (command.startsWith("quit")) {
                System.out.println( "Bye-Bye!");
                break;
            }
            else {
                System.out.println( "I don't understand \""+command+"\".  Please use: add X, peek, last, rem, con X, clear, or quit" );
            }
        }
    }
}