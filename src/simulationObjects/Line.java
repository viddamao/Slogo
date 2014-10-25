package simulationObjects;

import javafx.scene.paint.Color;


public class Line{
	
	private Point a;
	private Point b;
	private Color color;
	private double width;

	/**
	 * defines the line
	 * @param a
	 * @param b
	 * @param color
	 * @param width
	 */
	public Line(Point a, Point b, Color color, double width){ 
		this.a = a;
		this.b = b;
		this.color = color;
		this.width = width;
	}

	/**
	 * get the current color of the line
	 * @return JGColorModified color
	 */
	public Color getColor(){
		return color;
	}
	/**
	 * get the width of the pen
	 * @return width
	 */
	public double getWidth(){
		return width;
	}
	
	/**
	 * get point a
	 * @return a
	 */
	public Point getPointA(){
		return a;
	}
	
	/**
	 * get point b
	 * @return  b
	 */
	public Point getPointB(){
		return b;
	}
	
	
}
