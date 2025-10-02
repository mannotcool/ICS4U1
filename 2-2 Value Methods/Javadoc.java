import java.util.Scanner;

/**
 * This class demonstrates basic <b>JavaDoc</b> creation.
 * 
 * @author Nick Stoyanov
 * @version Sept 25, 2025
 */
public class Javadoc {
    /*
     * This is the main() method, nothing fancy.
     */
    public static void main(String[] args) { 
        Scanner input = new Scanner ( System.in );
        
        // infinite loop
        while (true) {
            int x = input.nextInt();
            int y = input.nextInt();
            System.out.println(isMultiple(x,y));
        }
    }
    
    /**
     * This method checks to see if the first integer paramater 
     * is a multiple of the second.
     * 
     * @param numberOne First number to check
     * @param numberTwo Second number to check against
     */
    public static boolean isMultiple(int numberOne, int numberTwo) { 
        if (numberOne % numberTwo == 0) {
            return true;
        } else {
            return false;
            
        }    
     }
}

        
