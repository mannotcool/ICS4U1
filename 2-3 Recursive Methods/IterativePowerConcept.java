/**
 * Nick Stoyanov
 * IterativePowerConcept 
 */
public class IterativePowerConcept {
    public static void main(String[] args) { 
        System.out.println(recursivePower(2, 8));
    }

    public static int recursivePower(int base, int exponent) {
        if ( exponent == 0) {                                
            return 1;                   
        } else {
            return base * recursivePower(base, exponent - 1);
        }
        
    }
    
   
}
