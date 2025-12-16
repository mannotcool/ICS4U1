import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
 
public class LinePainter {
    public static void main( String[] args ) {
        JFrame appWindow = new JFrame( "Line (rectangle) Painter App" );
        
        // Put statusLabel in NORTH to display mouse coordinates
        JLabel statusLabel = new JLabel();
        appWindow.add( statusLabel, BorderLayout.NORTH );
        
        // Put DrawPanel in CENTER and pass reference to statusLabel for updates
        appWindow.add( new DrawPanel( statusLabel ), BorderLayout.CENTER );        
                          
        appWindow.setSize( 320, 320 );
        appWindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        appWindow.setVisible( true );
    }    
}