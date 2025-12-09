import javax.swing.JFrame;
 
public class JButtonTest {
    public static void main( String[] args ) {
        JButtonFrame appWindow = new JButtonFrame();
         
        appWindow.setSize( 320, 240 );
        appWindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        appWindow.setVisible( true );
    }    
}