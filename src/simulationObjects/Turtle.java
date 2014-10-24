package simulationObjects;

import simulationObjects.Point;

public class Turtle extends UpdateLocation{
    private Point position = new Point(370,300);
    private double rotation = 90;
    private boolean visible=true;
    private Pen myPen;
    private int idNum;

    /**
     * Constructor
     */
    public Turtle() {
	idNum = 0;
	myPen = new Pen();
	position=new Point(370,300);
	rotation = 90;
	visible = true;
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
	this.idNum=turtle.getIdNum();
    }

    public boolean getVisible() {
	return visible;
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
	
	return this;
    }

    public void setVisible(boolean b) {
	this.visible=b;
    }

    public Pen getPen() {
	return this.myPen;
    }

    public int getIdNum() {
	return idNum;
}

/**
 * set the idnum of the turtle
 * @param idNum
 */
public void setIdNum(int idNum) {
	this.idNum = idNum;
}
}