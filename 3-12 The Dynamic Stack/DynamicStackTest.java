import java.util.Scanner;

public class DynamicStackTest {
    public static void main( String[] args ) {
        Scanner input = new Scanner( System.in );
        System.out.println( "enter expression " );
        String userInput = input.nextLine();
        
        DynamicStack<Character> stack = new DynamicStack<Character>();
        boolean balanced = true;
        
        // go through each character in the input string
        for ( int i = 0; i < userInput.length(); i++ ) {
            char ch = userInput.charAt( i );
            // check if its one of the brackets
            if ( ch == '(' || ch == '{' || ch == '[' ) {
                // push opening brackets onto the stack
                stack.push( ch );

                // print stack status
                System.out.println( "pushed " + ch + ", stack: " + stack.toString() );
            } else if ( ch == ')' || ch == '}' || ch == ']' ) {
                // for closing brackets, check if stack is empty
                if ( stack.isEmpty() ) {
                    balanced = false;
                    break;
                }
                
                // pop from stack and check for matching opening bracket
                char topOfStack = stack.pop();
                System.out.println( "popped " + topOfStack + ", stack: " + stack.toString() );
                if ( ( ch == ')' && topOfStack != '(' ) || ( ch == '}' && topOfStack != '{' ) || ( ch == ']' && topOfStack != '[' ) ) {
                    balanced = false;
                    break;
                }
            }
        }

        // after processing all characters, check if stack is empty for balance
        if ( balanced && stack.isEmpty() ) {
            System.out.println( "the brackets are properly balanced." );
        } else {
            System.out.println( "the brackets are not properly balanced." );
        }
    }
}
