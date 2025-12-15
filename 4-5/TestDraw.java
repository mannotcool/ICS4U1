import javax.swing.JFrame;
import java.awt.BorderLayout;
 
public class TestDraw {
    public static void main( String[] args ) {
        JFrame appWindow = new JFrame( "Abstract Art" );
        
        DrawPanel linePanel = new DrawPanel();
        appWindow.add( linePanel, BorderLayout.CENTER );
        appWindow.add( new javax.swing.JLabel( linePanel.toString() ), BorderLayout.SOUTH );

        
        appWindow.setSize( 300, 300 );
        appWindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        appWindow.setVisible( true );
    }    
}