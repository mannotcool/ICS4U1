public class QuickSortTest {
    public static void main( String[] args ) {
        long start, finish;
        
        // create object to perform bubble sort
        QuickSort sortArray = new QuickSort( 100000, QuickSort.ASCENDING );
        
        System.out.println( "Quick Sort (100000 ascending ordered integers): " );
        start = System.currentTimeMillis();
        sortArray.quickSort();
        finish = System.currentTimeMillis();
        System.out.println( (finish - start) + "ms." );     
    } 
}

// TIMINGS:
// Quick Sort (100000 randomly ordered integers): 9ms.
// Quick Sort (100000 descending ordered integers): 6ms.
// Quick Sort (100000 ascending ordered integers): 5ms.