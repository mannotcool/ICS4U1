public class BubbleSortTest
{
   public static void main( String[] args ) {
      // create object to perform bubble sort
      BubbleSort sortArray = new BubbleSort( 100000, BubbleSort.RANDOM );
      
      System.out.println( "UNSORTED ARRAY: " + sortArray );
      sortArray.bubbleSortv3();
      System.out.println( "\nSORTED ARRAY: "  + sortArray);
   } 
} 