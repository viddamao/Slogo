package simulationObjects;

import simulationObjects.Point;

public class Turtle extends UpdateLocation{
    private Point position = new Point();
    private double rotation = 0;
    private boolean visible=true;
    private Pen myPen;

    /**
     * Constructor
     */
    public Turtle() {

    }

    /**
     * Copy-constructor
     * 
     * @param turtle
     *            a Turtle object whose data will be copied to the new Turtle
     *            instance.
     */
    public Turtle(Turtle turtle) {
	this.position = turtle.getPosition();
	this.rotation = turtle.getRotation();
	this.visible=turtle.getVisible();
	this.myPen=turtle.getPen();
    }

    public boolean getVisible() {
	return visible;
    }

    /**
     * Set the position within an x, y coordinate system.
     * 
     * @param x
     *            a double representing the x-coordinate of the turtle
     * @param y
     *            a double representing the y-coordinate of the turtle
     */
    public void setPosition(double x, double y) {
	this.position.x = x;
	this.position.y = y;
    }

    /**
     * Set the position within an x, y coordinate system.
     * 
     * @param position
     *            a Point object representing the position of the turtle
     * @see Point
     */
    public void setPosition(Point position) {
	this.position = position;
    }

    /**
     * get the current position of the turtle.
     * 
     * @return Point the turtle location within the x, y coordinate system
     * @see Point
     */
    public Point getPosition() {
	return position;
    }

    /**
     * Get the rotation of the turtle.
     * 
     * @return double the rotation of the turtle
     */
    public double getRotation() {
	return rotation;
    }

    /**
     * Set the rotation of the turtle. Input outside of [0, 360] will be set to
     * an equivalent angle within [0, 360].
     * 
     * @param rotation
     *            a double representing the rotation of the turtle.
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

    public Turtle getTurtle() {
	// TODO Auto-generated method stub
	return this;
    }

    public void setVisible(boolean b) {
	this.visible=b;
    }

    public Pen getPen() {
	return this.myPen;
    }
}