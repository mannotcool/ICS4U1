import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;
 
public class DrawPanel extends JPanel {
    // We'll use a shared array to store 10 Line objects
    private Line[] lines = new Line[10];
    
    // Constructor instantiates an array of 10 Random Line objects
    public DrawPanel() {
        // We'll use the Random class to simplify picking random integers
        Random randomNumber = new Random();   
        setBackground( Color.WHITE );
        
        // Create 10 Line objects with random coordinates and colours
        for ( int count = 0; count < lines.length; count++ ) {
            // generate random coordinates
            int x1 = randomNumber.nextInt( 300 );
            int y1 = randomNumber.nextInt( 300 );
            int x2 = randomNumber.nextInt( 300 );
            int y2 = randomNumber.nextInt( 300 );
            
            // generate a random color
            Color color = new Color( randomNumber.nextInt( 256 ), 
                                    randomNumber.nextInt( 256 ), randomNumber.nextInt( 256 ) );
            
            // add the line to the array of lines to be displayed
            lines[ count ] = new Line( x1, y1, x2, y2, color );
        } 
    } 
    
    // This method is called automatically by the JVM when the window needs to be (re)drawn.
    @Override
    public void paintComponent( Graphics g ) {
        super.paintComponent( g );
        
        // Call the draw() method for each Line object in the array
        for ( Line line : lines )
            line.draw( g );

        // draw random 10 shapes using FillableShape, Rectangle, and Oval classes
        Random rnd = new Random();
        for ( int count = 0; count < 10; count++ ) {
            // generate random coordinates
            int x1 = rnd.nextInt( 300 );
            int y1 = rnd.nextInt( 300 );
            int x2 = rnd.nextInt( 300 );
            int y2 = rnd.nextInt( 300 );
            // generate a random color
            Color color = new Color( rnd.nextInt( 256 ), rnd.nextInt( 256 ), rnd.nextInt( 256 ) );

            // randomly decide to create a Rectangle or an Oval
            FillableShape shape;
            boolean filled = rnd.nextBoolean();
            if ( rnd.nextBoolean() ) {
                shape = new Rectangle( x1, y1, x2, y2, color, filled );
            } else {
                shape = new Oval( x1, y1, x2, y2, color, filled );
            }
            shape.draw(g);
        }
    }
}