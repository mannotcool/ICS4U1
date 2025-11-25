import java.util.Random;
import java.util.Arrays;

public class QuickSort {
    private int[] data;
    public static final int RANDOM = 0;
    public static final int ASCENDING = 1;
    public static final int DESCENDING = 2;

    // PUBLIC method to start the private recursive quickSort()
    // and pass in the first and last index of the data array.
    public void quickSort( ) {
        quickSort( 0, data.length - 1 );
    }
    
    // create array of given size and fill with integers in a specified order
    public QuickSort( int size, int order ) {
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

    // helper method to partition the array
    private int partitionIt(int leftIndex, int rightIndex) {
        int pivotValue = data[(leftIndex + rightIndex) / 2];
        
        while ( leftIndex <= rightIndex) {
            while ( data[leftIndex] < pivotValue )
                leftIndex++;
            while ( data[rightIndex] > pivotValue )
                rightIndex--;
            if ( leftIndex <= rightIndex ) {
                swap( leftIndex, rightIndex );
                leftIndex++;
                rightIndex--;
            }
        }
        
        return leftIndex;
    } 

    // PRIVATE recursive method to perform the quick sort, 
    // requires left and right indices (internal details).
    private void quickSort(int leftIndex, int rightIndex) {
        // base case: if subarray size is 1, then it's sorted
        if ( rightIndex - leftIndex <= 0 ) 
            return;
        // Otherwise, there are 2 or more elements in this subarray
        else {
            // Partition the subarray
            int indexOfPivot = partitionIt( leftIndex, rightIndex );
            
            // Sort the left side
            quickSort( leftIndex, indexOfPivot - 1 );
            
            // Sort the right side
            quickSort( indexOfPivot, rightIndex );  
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
