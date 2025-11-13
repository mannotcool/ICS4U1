import java.util.Random;
import java.util.Arrays;
 
public class SelectionSort {
    private int[] data;
    public static final int RANDOM = 0;
    public static final int ASCENDING = 1;
    public static final int DESCENDING = 2;
    
    // create array of given size and fill with random integers
    public SelectionSort( int size ) {
        this( size, RANDOM );
    }
    
    // create array of given size and fill with integers in a specified order
    public SelectionSort( int size, int order ) {
        Random generator = new Random();
        
       data = new int[ size ];
       
       for ( int i = 0; i < size; i++ ) {
           // data[ i ] = 100 + generator.nextInt(900);
           data[ i ] = generator.nextInt();
       }
       
       if (order == RANDOM)
           return;
       else {
           Arrays.sort(data);
           if (order == ASCENDING)
               return;
           else if (order == DESCENDING) {
               for(int i=0; i < data.length / 2; i++) {
                   // swap the elements
                   swap( i, data.length-(i+1) );
               }
           }
       }
    }
    
    // sort array using selection sort
    public void selectionSort1() {
        for ( int pass=1; pass < data.length; pass++ ) {
            // save index of smallest element
            int smallestIndex = pass - 1;
            for ( int index=pass; index < data.length; index++ ) {
                if ( data[index] < data[smallestIndex] ) {
                    smallestIndex = index;
                }
            }
            swap( smallestIndex, pass - 1 );
            // Output for testing purposes only, REMOVE if timing the algorithm!
            // System.out.printf( "After pass #%2d, array is: %s", pass, this );
        } 
    }

    // helper method to swap values in two data elements
    private void swap( int first, int second ) {
        int temporary = data[ first ];  
        data[ first ] = data[ second ]; 
        data[ second ] = temporary;     
    } 
    
    // Return string representing all elements in array
    public String toString() {
        return Arrays.toString( data ) + "\n";
    } 
} 