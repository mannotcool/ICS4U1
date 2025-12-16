import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends FillableShape {
    // Constructor to initialize all instance variables
    public Rectangle(int x1, int y1, int x2, int y2, Color color, boolean filled) {
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
            g.fillRect(upperLeftX, upperLeftY, width, height);
        } else {
            g.drawRect(upperLeftX, upperLeftY, width, height);
        }
    }
    
}
