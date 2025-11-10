import java.util.Scanner;
 
public class LinearSearchTest
{
    public static void main( String args[] ) {
        int searchKey; 
        int foundIndex; 
        Scanner input = new Scanner( System.in );
        
        // create 10 element, random array and display it
        LinearSearch searchArray = new LinearSearch( 10 );
        System.out.println( searchArray ); // print array
        
        // get search key from user
        System.out.print( "please enter an integer search key (-1 to quit): " );
        searchKey = input.nextInt(); 
        
        // repeatedly input a search key; -1 terminates the program
        while ( searchKey != -1 )
        {
            // perform linear search for the key
            foundIndex = searchArray.iterativeLinearSearch( searchKey );
            
            if ( foundIndex != -1 ) 
                System.out.println( "Integer " + searchKey + " was found at index " + foundIndex + "." );
            else 
                System.out.println( "Integer " + searchKey + " was not found." );
            
            System.out.print( "please enter an integer value (-1 to quit): " );
            searchKey = input.nextInt(); 
        } 
    }
} 