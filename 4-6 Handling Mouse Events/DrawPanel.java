import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import javax.swing.JFrame;
 
public class DrawPanel extends JFrame {
    private JPanel mousePanel; 
    
    // Constructor
    public DrawPanel() {
        super("Mouse Motion Demo");

        mousePanel = new JPanel();
        MouseEventListener listener = new MouseEventListener();
        add(mousePanel);

        mousePanel.addMouseMotionListener( listener );
    }
 

    class MouseEventListener implements MouseMotionListener {
        // These 2 methods override those in MouseMotionListener interface
        // handle event when user drags mouse with button pressed
        @Override
        public void mouseMoved(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            int midX = getWidth() / 2;
            int midY = getHeight() / 2;
            
            // Determine quadrant and set color
            if (x < midX && y < midY) {
                mousePanel.setBackground(Color.RED); // Top-left
            } else if (x >= midX && y < midY) {
                mousePanel.setBackground(Color.BLUE); // Top-right
            } else if (x < midX && y >= midY) {
                mousePanel.setBackground(Color.GREEN); // Bottom-left
            } else {
                mousePanel.setBackground(Color.YELLOW); // Bottom-right
            }
        }
        
        // handle event when user moves mouse
        @Override
        public void mouseDragged(MouseEvent e) {
            mouseMoved(e); // Handle dragging same as moving
        }
    }
    
}