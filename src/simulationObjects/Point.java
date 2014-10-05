package simulationObjects;

public class Point {

    private double x;
    private double y;

    /**
     * defines what is a point
     * 
     * @param x
     * @param y
     */
    public Point(double x, double y) {
	this.x = x;
	this.y = y;
    }

    /**
     * init the point at 0 , 0
     */
    public Point() {
	this(0, 0);
    }

    /**
     * get x value of point
     * 
     * @return x value
     */
    public double getX() {
	return x;
    }

    /**
     * get y value of point
     * 
     * @return y value
     */
    public double getY() {
	return y;
    }
}
