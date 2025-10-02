import java.util.Scanner;

public class TranslationLayer {
    
    public static void main(String[] args) { 
        Scanner input = new Scanner ( System.in );
        
        while(true) {
            translate(input.nextLine());
        }
    }
    
    public static void translate(String name) {
        if (name.equalsIgnoreCase("yes")) {
            System.out.println("oui");
        } else if (name.equalsIgnoreCase("no")) {
            System.out.println("non");
        } else if (name.equalsIgnoreCase("please")) {
            System.out.println("s’il vous plait");
        } else if (name.equalsIgnoreCase("thank you")) {
            System.out.println("merci");
        } else if (name.equalsIgnoreCase("you're welcome")) {
            System.out.println("il n’y a pas de quoi");
        } else if (name.equalsIgnoreCase("goodbye")) {
            System.out.println("au revoir");
        } else {
            System.out.println("unknown English word/phrase");
        }
        
        
    }
    
    
}
