package simulationObjects;

import simulationObjects.Point;

public class Turtle {
    public static final double DEFAULT_X = 0;
    public static final double DEFAULT_Y = 0;
    public static final double DEFAULT_ROT = 90;
    public static final boolean DEFAULT_VIS = true;

    private double x;
    private double y;
    private double rotation;
    private boolean visible;
    
    /**
     * Constructor
     */
    public Turtle() {
    	
    }
    
    /**
     * Copy-constructor
     * @param turtle	a Turtle object whose data will be copied to the new Turtle instance.
     */
    public Turtle(Turtle turtle) {
    	//TODO: Clone me plz.
    }

    /**
     * Set the position within an x, y coordinate system.
     * @param x		a double representing the x-coordinate of the turtle
     * @param y		a double representing the y-coordinate of the turtle
     */
    public void setPos(double x, double y) {
    	this.x = x;
		this.y = y;
    }

    /**
     * get the current position of the turtle.
     * @return Point 	the turtle location within the x, y coordinate system
     * @see		Point
     */
    public Point getPos() {
    	return new Point(x, y);
    }

    /**
     * Get the rotation of the turtle.
     * @return double	the rotation of the turtle
     */
    public double getRotation() {
    	return rotation;
    }

    /**
     * Set the rotation of the turtle. Input outside of [0, 360] will be set to an equivalent angle within [0, 360].
     * @param rotation	a double representing the rotation of the turtle.
     */
    public void setRotation(double rotation) {
		if (rotation >= 360) {
		    this.rotation = rotation % 360;
		} else if (rotation < 0) {
		    this.rotation = 360 + (rotation % 360);
		} else {
			this.rotation = rotation;
		}
    }

    /**
     * Get the visibility of the turtle.
     * @return boolean 	the visibility state
     */
    public boolean isVisible() {
    	return visible;
    }

    /**
     * Set the visibility of the turtle.
     * @param visible	the visibility state
     */
    public void setVisible(boolean visible) {
    	this.visible = visible;
    }
}
