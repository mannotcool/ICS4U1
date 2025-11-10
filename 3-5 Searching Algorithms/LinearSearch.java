import java.util.Arrays;
import java.util.Random;
 
public class LinearSearch
{
    private int[] data;
    
    // Create array of given size and fill with random integers
    public LinearSearch( int size ) {
        data = new int[ size ];
        Random generator = new Random();        
        
        // fill array with random 2-digit integers in range 10-99
        for ( int i = 0; i < size; i++ )
            data[ i ] = 10 + generator.nextInt( 90 );
    } 
    
    // Performs an iterative linear search for the searchKey in the array.
    // Returns the index where searchKey is found, or -1 otherwise.
    public int iterativeLinearSearch( int searchKey ) {
        // loop through array sequentially
        for ( int index = 0; index < data.length; index++ )
            if ( data[ index ] == searchKey )
                return index; // return index of integer
        
        return -1; // integer was not found      
    } 
    
    // This is not actually a recursive method.  It is a PUBLIC method that 
    // calls the PRIVATE recursiveLinearSearch() method passing in the index 
    // of the first element of the data array to search.  This way, the user does 
    // not need to worry about internal details like indices.
    public int recursiveLinearSearch( int searchKey ) {
        return recursiveLinearSearch( searchKey, 0 );
    }
    
    // This PRIVATE recursive method performs a linear search for searchKey at the
    // index provided.  It returns the index where searchKey is found, or -1 otherwise.
    private int recursiveLinearSearch( int searchKey, int index ) {
        
        // base case: integer was not found
        if ( index >= data.length )
            return -1;
        
        // base case: integer was found
        if ( data[ index ] == searchKey )
            return index;
        
        // recursive case: search next element
        return recursiveLinearSearch( searchKey, index + 1 );
    } 
    
    // Returns a String of all elements in the array
    public String toString() {
        return Arrays.toString( data );
    } 
}