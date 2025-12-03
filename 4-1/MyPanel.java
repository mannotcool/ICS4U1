import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class MyPanel extends JPanel {
    private int choice; 

    public MyPanel() {
        // Ask the user for shape choice
        String input = JOptionPane.showInputDialog(
                "Enter 1 for rectangles or 2 for ovals:"
        );
        choice = Integer.parseInt(input);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = 20;
        int y = 20;
        int width = 40;
        int height = 25;

        // Draw 10 cascading shapes
        for (int i = 0; i < 10; i++) {

            if (choice == 1) {
                g.drawRect(x, y, width, height);
            } else {
                g.drawOval(x, y, width, height);
            }

            // Update values to create the cascade effect
            x += 15;
            y += 15;
            width += 10;
            height += 6;
        }
    }
}
