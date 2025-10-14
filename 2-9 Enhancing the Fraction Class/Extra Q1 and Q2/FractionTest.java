/**
 * Auto Generated Java Class.
 */
public class FractionTest {
    public static void main(String[] args) { 
        Fraction f1 = new Fraction(4,6);
        Fraction f2 = new Fraction(2,3);
        
        Fraction fProd = Fraction.multiply(f1, f2);
        System.out.println(fProd.getNum());
        System.out.println(fProd.getDen());
    }
}
