import javax.swing.JFrame;
 
public class FirstWindow {
    public static void main( String[] args ) {
        JFrame appWindow = new JFrame( "Wonderful Window!" );
        // appWindow.setTitle("New Title Text!");
        
        appWindow.setSize( 320, 240 );
        appWindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        appWindow.setVisible( true );
    }    
}