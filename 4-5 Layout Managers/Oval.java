import java.awt.Color;
import java.awt.Graphics;

public class Oval extends FillableShape {
    // Constructor to initialize all instance variables
    public Oval(int x1, int y1, int x2, int y2, Color color, boolean filled) {
        super(x1, y1, x2, y2, color, filled);
    }

    // Implement the draw method
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        int upperLeftX = getUpperLeftX();
        int upperLeftY = getUpperLeftY();
        int width = getWidth();
        int height = getHeight();
        
        if (filled) {
            g.fillOval(upperLeftX, upperLeftY, width, height);
        } else {
            g.drawOval(upperLeftX, upperLeftY, width, height);
        }
    }
}
