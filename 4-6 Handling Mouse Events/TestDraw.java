import javax.swing.JFrame;
 
public class TestDraw {
    public static void main( String[] args ) {
        DrawPanel appWindow = new DrawPanel();

        appWindow.setSize( 400, 400 ); 
        appWindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        appWindow.setVisible( true ); 
    }    
}