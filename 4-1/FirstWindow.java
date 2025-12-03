import javax.swing.JFrame;

public class FirstWindow {
    public static void main(String[] args) {

        JFrame appWindow = new JFrame("Shape Pattern");

        MyPanel drawPanel = new MyPanel();
        appWindow.add(drawPanel);

        appWindow.setSize(400, 350);
        appWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appWindow.setVisible(true);
    }
}