/**
 * Auto Generated Java Class.
 */
public class Fraction {
    private int num = 0;
    private int den = 1;
    
    public Fraction(int num, int den) { 
        setNum(num);
        setDen(den);
    }
    
    // accessor for numerator 
    public int getNum() { 
        return num;
    }
    
    // accessor for denomerator 
    public int getDen() { 
        return den;
    }
    
    // mutator for numerator 
    public void setNum(int newNum) { 
        num = newNum;
        return;
    }
   
    private int gcd( int a, int b ) {
        if ( b == 0 ) { 
            return a;
        }
        else {
            return gcd( b, a % b );  
        }
    }
    
    public void reduce() {
        int greatestCommonFactor = gcd( num, den );
        num = num / greatestCommonFactor;
        den = den / greatestCommonFactor;        
    }
    
    
    // multiply method
    public static Fraction multiply(Fraction fractionA, Fraction fractionB) { 
        int newNum = fractionA.getNum() * fractionB.getNum();
        int newDen = fractionA.getDen() * fractionB.getDen();
        Fraction product = new Fraction(newNum, newDen);
        product.reduce();
        return product;
    }
    
    // mutator for denomerator 
    public void setDen(int newDen) { 
        if (newDen == 0) {
            System.err.println("denominator of 0 is not permitted");
            return;
        } else {
            den = newDen;
            return;
        }
    }
    
    
    
}
