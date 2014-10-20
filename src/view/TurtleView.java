package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import simulationObjects.Point;
import simulationObjects.Turtle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TurtleView extends Circle {
	private Point position = new Point();
	private double rotation = 90.0;
	private boolean visible = true;
	private Image myImage;
	public ImageView turtImg = new ImageView();

	/**
	 * Constructor
	 */
	public TurtleView() {
		position = new Point(0, 0);
		try {
			myImage = new Image(new FileInputStream(new File(
					"src/images/turtle.png")), 80, 60, true, true);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		turtImg.setImage(myImage);
	}

	/**
	 * Constructor
	 */
	public TurtleView(Turtle turtleModel) {
		this();
		setPosition(turtleModel.getPosition());
		this.rotation = turtleModel.getRotation();
		this.visible = true;
	}

	/**
	 * Copy-constructor
	 * 
	 * @param turtle
	 *            a TurtleView object whose data will be copied to the new
	 *            TurtleView instance.
	 */
	public TurtleView(TurtleView turtle) throws FileNotFoundException {
		this();
		if (turtle != null) {
			setPosition(turtle.getPosition());
			this.rotation = turtle.getRotation();
			this.visible = turtle.isVisible();
		}
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
		turtImg.setX(this.position.x);
		turtImg.setY(this.position.y);
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

	/**
	 * Get the visibility of the turtle.
	 * 
	 * @return boolean the visibility state
	 */
	public boolean isVisibility() {
		return visible;
	}

	/**
	 * Set the visibility of the turtle.
	 * 
	 * @param visible
	 *            the visibility state
	 */
	public void setVisibility(boolean visible) {
		this.visible = visible;
	}

	public void changeImage(Image img) {
		myImage = img;
	}
}
