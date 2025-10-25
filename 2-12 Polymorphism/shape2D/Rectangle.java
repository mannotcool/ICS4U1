package shape2D;

/**
 * Auto Generated Java Class.
 */
public class Rectangle extends FillableShape {
    private static int numberOfRectangles = 0;
    
    // No-Argument constructor method
    public Rectangle() {
        this( 0, 0, 0, 0, false );
    }
    
    // Parameterized constructor method
    public Rectangle( int x1, int x2, int y1, int y2, boolean filledShape ) {
        super(x1, x2, y1, y2, filledShape);
        numberOfRectangles++;
    }
    
    // Accessor for numberOfRectangles
    public int getNumberOfRectangles () {
        return numberOfRectangles;
    }
    
    // Get area (bh=a^2)
    public double calcArea() {
        return (getWidth() * getHeight());
    }

    // See if other rectangle object is within bounding box of another 
    public boolean isOverlapping(Rectangle otherRectangle) {    
      return ((this.getUpperLeftX() >= otherRectangle.getUpperLeftX()) && 
              (this.getUpperLeftX() + getWidth()) <= (otherRectangle.getUpperLeftX() + otherRectangle.getWidth()) && 
              (this.getUpperLeftY() >= otherRectangle.getUpperLeftY()) && 
              (this.getUpperLeftY() + getHeight()) <= (otherRectangle.getUpperLeftY() + otherRectangle.getHeight()));
    }
    
    
}
