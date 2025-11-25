public class SelectionSortTest
{
     public static void main( String[] args ) {
        long start, finish;
        
        // create object to perform bubble sort
        SelectionSort sortArray = new SelectionSort( 100000, SelectionSort.ASCENDING );

        System.out.println( "Selection Sort (100000 random ordered integers): " );
        start = System.currentTimeMillis();
        sortArray.selectionSort1();
        finish = System.currentTimeMillis();
        System.out.println( (finish - start) + "ms." );     
    }
} 

// TIMEINGS:
// Selection Sort (100000 descending ordered integers): 3125ms
// Selection Sort (100000 random ordered integers): 3634ms.
// Selection Sort (100000 ascending ordered integers): 847ms.