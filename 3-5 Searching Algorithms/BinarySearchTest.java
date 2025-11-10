import java.util.Scanner;
 
public class BinarySearchTest
{
    public static void main( String args[] ) {
        int searchKey; 
        int foundIndex; 
        Scanner input = new Scanner( System.in );
              
        // create 15 element, sorted array and display it
        BinarySearch searchArray = new BinarySearch( 15 );
        System.out.println( searchArray );
        
        // get search key from user
        System.out.print( "Please enter an integer value (-1 to quit): " );
        searchKey = input.nextInt(); 
        
        // repeatedly input a search key; -1 terminates the program
        while ( searchKey != -1 )
        {
            // perform binary search for the key
            foundIndex = searchArray.recursiveBinarySearch( searchKey );
            
            if ( foundIndex != -1 )
                System.out.println( "Integer " + searchKey + " was found at index " + foundIndex + ".\n" );
            else
                System.out.println( "Integer " + searchKey + " was not found.\n" );
            
            System.out.print( "Please enter an integer value (-1 to quit): " );
            searchKey = input.nextInt(); 
        } 
    } 
} 