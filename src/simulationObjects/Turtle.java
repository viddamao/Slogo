package simulationObjects;

import simulationObjects.Point;

public class Turtle {
    private Point position = new Point();
    private double rotation = 90.0;

    /**
     * Constructor
     */
<<<<<<< HEAD
    public Turtle() throws FileNotFoundException {
    	this.position.x = 0;
    	this.position.y = 0;
    	myImage = new Image(new FileInputStream(new File("src/properties/turtle.png")), 80, 100, false, true);
    	turtImg.setImage(myImage);
=======
    public Turtle() {

>>>>>>> 266ff812318c8cfc72b6e62863977a3ca85678af
    }

    /**
     * Copy-constructor
     * 
     * @param turtle
     *            a Turtle object whose data will be copied to the new Turtle
     *            instance.
     */
<<<<<<< HEAD
    public Turtle(Turtle turtle) throws FileNotFoundException {
    	this.position = turtle.getPosition();
    	this.rotation = turtle.getRotation();
    	this.visible = turtle.isVisible();
    	myImage = new Image(new FileInputStream(new File("src/properties/turtle.png")), 80, 100, false, true);
    	turtImg.setImage(myImage);
=======
    public Turtle(Turtle turtle) {
	this.position = turtle.getPosition();
	this.rotation = turtle.getRotation();
>>>>>>> 266ff812318c8cfc72b6e62863977a3ca85678af
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
}
