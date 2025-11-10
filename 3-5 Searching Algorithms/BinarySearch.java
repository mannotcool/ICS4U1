import java.util.Arrays;
import java.util.Random;
 
public class BinarySearch
{
    private int[] data; 
    
    // create array of given size and fill with sorted random integers
    public BinarySearch( int size ) {
        data = new int[ size ];
        Random generator = new Random();
        
        // fill array with random 2-digit integers in range 10-99
        for ( int i = 0; i < size; i++ )
            data[ i ] = 10 + generator.nextInt( 90 );
        
        // Put the array in numeric order
        Arrays.sort( data );
    }
 
    // This is not actually a recursive method.  It is a PUBLIC method that 
    // calls the PRIVATE recursiveBinarySearch() method passing in the index 
    // of the first and last item of the data array.  This way, the user does 
    // not need to worry about internal details like indices.
    public int recursiveBinarySearch( int searchKey ) {
        return recursiveBinarySearch( searchKey, 0, data.length -1 );
    }
    
    // This PRIVATE recursive method performs a binary search for searchKey 
    // between the low and high indices provided.  It returns the index where 
    // searchKey is found, or -1 otherwise.
    private int recursiveBinarySearch( int searchKey, int low, int high ) {
        // There are no elements left to be searched, searchKey not found.
        if (low > high) {
            return -1;
        }
 
        int middle = ( low + high ) / 2; 
                
        // Display progress of current search (for demonstration only!)
        System.out.print( searchProgress( low, middle, high ) );
        
        // Match!  Return the index.
        if (searchKey == data[middle]) {
            return middle;
        }
        // The searchKey must be in the first half of the data, search there.
        else if (searchKey < data[middle]) {
            return recursiveBinarySearch( searchKey, low, middle - 1 );
        }
        // The searchKey must be in the second half of the data, search there.
        else {
            return recursiveBinarySearch( searchKey, middle + 1, high );
        }
    } 
    
    // Performs an iterative binary search for the searchKey in the array.
    // This method only requires the searchKey, and returns the index where 
    // searchKey is found, or -1 otherwise. 
    public int iterativeBinarySearch( int searchKey ) {
        
        int low = 0;
        int high = data.length - 1;
        int middle;
        // loop until the searchKey is found or the search space is empty
        while ( low <= high ) {
            middle = ( low + high ) / 2;
            // current search results so ik what im doin
            System.out.print( searchProgress( low, middle, high ) );

            if ( searchKey == data[ middle ] )
                return middle; // searchKey found
            else if ( searchKey < data[ middle ] )
                high = middle - 1; // search low end of array
            else
                low = middle + 1; // search high end of array
                
        }
        
        return -1;
    } 
    
    // helper method to produce a string showing the range being searched and the current middle.
    private String searchProgress( int low, int middle, int high ) {
        String result = "";
        
        // output spaces for alignment
        for ( int i = 0; i < low; i++ )
            result += "   ";
        
        // output elements remaining to the searched 
        for ( int i = low; i <= high; i++ )
            result += data[ i ] + " ";
        result += "\n";
        
        // next line, output spaces for alignment
        for ( int i = 0; i < middle; i++ )
            result += "   ";
        result += "*\n";  // indicate current middle with an asterisk (*)
        
        return result;
    }     
    
    // Returns a String of all elements in the array and indicates the middle element with a *
    public String toString() {
        return searchProgress( 0, (data.length - 1) / 2, data.length - 1 );
    } 
} 