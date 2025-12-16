import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;
 
public class DrawPanel extends JPanel {
    // We'll use a shared array to store 20 Shape objects
    private Shape[] shapes = new Shape[20];
    
    // Instance variables to track shape counts
    private int lineCount = 0;
    private int ovalCount = 0;
    private int rectangleCount = 0;
    
    // Constructor instantiates an array of 20 Random Shape objects
    public DrawPanel() {
        // We'll use the Random class to simplify picking random integers
        Random randomNumber = new Random();   
        setBackground( Color.WHITE );
        
        // Create 10 Line objects with random coordinates and colours
        for ( int count = 0; count < 10; count++ ) {
            // generate random coordinates
            int x1 = randomNumber.nextInt( 300 );
            int y1 = randomNumber.nextInt( 300 );
            int x2 = randomNumber.nextInt( 300 );
            int y2 = randomNumber.nextInt( 300 );
            
            // generate a random color
            Color color = new Color( randomNumber.nextInt( 256 ), 
                                    randomNumber.nextInt( 256 ), randomNumber.nextInt( 256 ) );
            
            // add the line to the array of lines to be displayed
            shapes[ count ] = new Line( x1, y1, x2, y2, color );
            lineCount++;
        }
        
        // Create 10 random shapes
        for ( int count = 10; count < shapes.length; count++ ) {
            // generate random coordinates
            int x1 = randomNumber.nextInt( 300 );
            int y1 = randomNumber.nextInt( 300 );
            int x2 = randomNumber.nextInt( 300 );
            int y2 = randomNumber.nextInt( 300 );
            // generate a random color
            Color color = new Color( randomNumber.nextInt( 256 ), randomNumber.nextInt( 256 ), randomNumber.nextInt( 256 ) );

            // randomly decide to create a Rectangle or an Oval
            boolean filled = randomNumber.nextBoolean();
            if ( randomNumber.nextBoolean() ) {
                shapes[ count ] = new Rectangle( x1, y1, x2, y2, color, filled );
                rectangleCount++;
            } else {
                shapes[ count ] = new Oval( x1, y1, x2, y2, color, filled );
                ovalCount++;
            }
        }
    } 
    
    // This method is called automatically by the JVM when the window needs to be (re)drawn.
    @Override
    public void paintComponent( Graphics g ) {
        super.paintComponent( g );
        
        // Call the draw() method for each Line object in the array
        for ( Shape shape : shapes ) {
            shape.draw( g );
        }
    }
    
    // Returns a string with the count of each shape type
    @Override
    public String toString() {
        return "Lines: " + lineCount + ", Ovals: " + ovalCount + ", Rectangles: " + rectangleCount;
    }
}