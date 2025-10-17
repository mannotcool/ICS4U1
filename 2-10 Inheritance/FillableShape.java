public class FillableShape {
    private int x1;
    private int x2;
    private int y1;
    private int y2;
       
    private boolean filledShape;

    public FillableShape(int x1, int x2, int y1, int y2, boolean filledShape2) {
        setx1(0);
        setx2(0);
        sety1(0);
        sety2(0);
        setFilledShape(false);
    }

    // Accessor for x1 instance variable
    public void setx1 (int newx1) {
        if (newx1 < 0) {
            System.err.println("X must be greater than 0.");
            x1 = 0;
        }
        else {
            x1 = newx1;
        }
    }
    
    // Accessor for x1 instance variable
    public void setx2 (int newx2) {
        if (newx2 < 0) {
            System.err.println("X must be greater than 0.");
            x2 = 0;
        }
        else {
            x2 = newx2;
        }
    }

    // Accessor for x1 instance variable
    public int getx1() {
        return x1;
    }
    
    // Accessor for x2 instance variable
    public int getx2() {
        return x2;
    }
    
    // Accessor for y1 instance variable
    public int gety1() {
        return y1;
    }
    
    // Accessor for y2 instance variable
    public int gety2() {
        return y2;
    }
    
    // Accessor for filledShape instance variable
    public boolean getfilledShape() {
        return filledShape;
    }

    // Mutator for shapeFilled variable
    public void setFilledShape (boolean newFilledShape) {
        filledShape = newFilledShape;
    }

    // Mutator for y1 instance variable
    public void sety1 (int newy1) {
        if (newy1 < 0) {
            System.err.println("Y must be greater than 0.");
            y1 = 0;
        }
        else {
            y1 = newy1;
        }
    }
    
    // Mutator for y2 instance variable
    public void sety2 (int newy2) {
        if (newy2 < 0) {
            System.err.println("Y must be greater than 0.");
            y2 = 0;
        }
        else {
            y2 = newy2;
        }
    }

    // Get the difference between x1 and x2 values
    public int getWidth() {
        return Math.abs((x1 - x2));
    }
    
    // Get the difference between y1 and y2 values
    public int getHeight() {
        return Math.abs((y1 - y2));
    }

    // Get the smallest of the X values
    public int getUpperLeftX() {
        if (x1 < x2) {
            return x1;
        } else {
            return x2;
        }
    }
    
    // Get the smallest of the Y values
    public int getUpperLeftY() {
        if (y1 < y2) {
            return y1;
        } else {
            return y2;
        }
    }
    
    public String toString() {
        return getx1() + "," + getx2() + "," + gety1() + "," + getx2() + "," + getfilledShape();
    }

}
