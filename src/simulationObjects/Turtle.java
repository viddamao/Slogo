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
     * set the x y position
     * 
     * @param x
     * @param y
     */
    public void setPos(double x, double y) {
	// TODO drawLine(new Point(this.x, this.y), new Point(x,y));
	this.x = x;
	this.y = y;
    }

    /**
     * get the current position of the turtle
     * 
     * @return point where the turtle is located
     */
    public Point getPos() {
	return new Point(x, y);
    }

    /**
     * get the rotation of the turtle
     * 
     * @return rotation
     */
    public double getRotation() {
	return rotation;
    }

    /**
     * set the rotation of the turtle
     * 
     * @param rotation
     */
    public void setRotation(double rotation) {
	this.rotation = rotation;
	if (this.rotation >= 360) {
	    this.rotation = this.rotation % 360;
	}
	if (this.rotation < 0) {
	    this.rotation = 360 + this.rotation % 360;
	}
    }

    /**
     * check the visibility of the turtle
     * 
     * @return boolean
     */
    public boolean isVisible() {
	return visible;
    }

    /**
     * set the visibility of the turtle
     * 
     * @param visible
     */
    public void setVisible(boolean visible) {
	this.visible = visible;
    }

}
