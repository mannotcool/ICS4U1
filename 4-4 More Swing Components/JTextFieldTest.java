import javax.swing.JFrame;
 
public class JTextFieldTest {
    public static void main( String[] args ) {
        ChangeCalculatorFrame appWindow = new ChangeCalculatorFrame();
         
        appWindow.setSize( 320, 400 );
        appWindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        appWindow.setVisible( true );
    }    
}