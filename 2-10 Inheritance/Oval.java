/**
 * Auto Generated Java Class.
 */
public class Oval extends FillableShape {
    private static int numberOfOvals = 0;
    
    // No-Argument constructor method
    public Oval() {
        this( 0, 0, 0, 0, false );
    }
    
    // Parameterized constructor method
    public Oval(int x1, int x2, int y1, int y2, boolean filledShape ) {
        super(x1, x2, y1, y2, filledShape);
        numberOfOvals++;
    }
    
    // Accessor for numberOfOvals
    public int getNumberOfOvals () {
        return numberOfOvals;
    }
    
    // Get area (A = pieR^2)
    public double calcArea() {
        return Math.pow((getWidth() / 2), 2) * Math.PI;
    }

    // See if other oval object is within bounding box of another 
    public boolean isOverlapping(Oval otherOval) {    
      return ((this.getUpperLeftX() >= otherOval.getUpperLeftX()) && 
              (this.getUpperLeftX() + getWidth()) <= (otherOval.getUpperLeftX() + otherOval.getWidth()) && 
              (this.getUpperLeftY() >= otherOval.getUpperLeftY()) && 
              (this.getUpperLeftY() + getHeight()) <= (otherOval.getUpperLeftY() + otherOval.getHeight()));
    }

    
}
