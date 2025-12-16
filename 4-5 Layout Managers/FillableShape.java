import java.awt.Color;

public abstract class FillableShape extends Shape {
    // filled , get upper left x and y, width and height methods and set filled
    protected boolean filled;

    // Constructor to initialize all instance variables
    public FillableShape(int x1, int y1, int x2, int y2, Color color, boolean filled) {
        super(x1, y1, x2, y2, color);
        this.filled = filled;
    }

    // Getter for filled
    public boolean getFilled() {
        return filled;
    }
    // Setter for filled
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public int getUpperLeftX() {
        return Math.min(x1, x2);
    }
    public int getUpperLeftY() {
        return Math.min(y1, y2);
    }
    public int getWidth() {
        return Math.abs(x2 - x1);
    }
    public int getHeight() {
        return Math.abs(y2 - y1);
    }
    
}