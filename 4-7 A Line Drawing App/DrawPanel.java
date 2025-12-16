import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
 
public class DrawPanel extends JPanel {
    private JLabel statusBar; 
    private int freeIndex = 0;
    private Rectangle currentRectangle = null;
    private Rectangle[] rectangles = new Rectangle[1000];
    
    // Constructor instantiates an array of 10 Random Line objects
    public DrawPanel( JLabel statusLabel ) {
        statusBar = statusLabel;
        setBackground( Color.WHITE ); 
        
        // Create and register listener for mouse and mouse motion events
        MouseEventListener drawPanelListener = new MouseEventListener(); 
        addMouseListener( drawPanelListener ); 
        addMouseMotionListener( drawPanelListener );       
    } 
    
    // Inner class to handle mouse events
    class MouseEventListener extends MouseAdapter {
        // Mouse press indicates a new line has been started
        @Override
        public void mousePressed( MouseEvent event ) {
            currentRectangle = new Rectangle( event.getX(), event.getY(), event.getX(), event.getY(), Color.RED, false );
            // Tell JVM to call paintComponent( g )
            repaint();
        } 
        
        // Mouse release indicates the new line is finished
        @Override
        public void mouseReleased( MouseEvent event ) {
            // Update ending coordinates and switch color to BLACK
            currentRectangle.setX2( event.getX() );
            currentRectangle.setY2( event.getY() );
            currentRectangle.setColor( Color.BLACK );
            
            // If there's space, add the new line to our array
            if ( freeIndex < rectangles.length ) {
                rectangles[freeIndex] = currentRectangle;
                freeIndex++;
            }
            
            // Get ready for the next line to be drawn
            currentRectangle = null;
            repaint();            
        } 
        
        // As mouse is dragged, update ending coordinates of currentLine and statusBar
        @Override
        public void mouseDragged( MouseEvent event ) {
            currentRectangle.setX2( event.getX() );
            currentRectangle.setY2( event.getY() );
            statusBar.setText( String.format( "Mouse at (%d, %d)", 
                                             event.getX(), event.getY() ) );
            repaint();
        } 
        
        // As mouse is moved, just update the statusBar
        @Override
        public void mouseMoved( MouseEvent event ) {
            statusBar.setText( String.format( "Mouse at (%d, %d)", 
                                             event.getX(), event.getY() ) );
        } 
    } 
    
    // This method is called automatically by the JVM when the window needs to be (re)drawn.
    @Override
    public void paintComponent( Graphics g ) {
        super.paintComponent( g );
        // Call the draw() method for each Line object in the array
        for ( int i = 0; i < freeIndex; i++ ) 
            rectangles[i].draw( g );
        
        // If a line is in progress, draw it on top of all others
        if ( currentRectangle != null )
            currentRectangle.draw( g );
    } 
} 