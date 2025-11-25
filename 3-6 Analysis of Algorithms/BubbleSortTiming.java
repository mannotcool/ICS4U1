public class BubbleSortTiming
{
    public static void main( String[] args ) {
        long start, finish;
        
        // create object to perform bubble sort
        BubbleSort sortArray = new BubbleSort( 100000, BubbleSort.ASCENDING );
        
        System.out.println( "Bubble Sort v3.0 (100000 descending ordered integers): " );
        start = System.currentTimeMillis();
        sortArray.bubbleSortv3();
        finish = System.currentTimeMillis();
        System.out.println( (finish - start) + "ms." );     
    } 
} 

// TIMINGS:
// Bubble Sort v3.0 (100000 randomly ordered integers): 11752ms.
// Bubble Sort v3.0 (100000 descending ordered integers): 6950ms.
// Bubble Sort v3.0 (100000 ascending ordered integers): 1ms.