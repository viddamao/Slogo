package view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import simulationObjects.Turtle;
import simulationObjects.UpdateLocation;

public class TurtleView extends ImageView {
	public UpdateLocation location = new UpdateLocation();
	public TurtleView(Image image) {
		super(image);
	}

	public void setData(Turtle turtleModel) {
		this.setX(turtleModel.getPosition().x);
		this.setY(turtleModel.getPosition().y);
		this.setRotate(turtleModel.getRotation());
	}


	/**
	 * Copy-constructor
	 * 
	 * @param turtle
	 *            a TurtleView object whose data will be copied to the new
	 *            TurtleView instance.
	 */
	public TurtleView(TurtleView turtle) {
		this(turtle.getImage());
		this.setX(turtle.getX());
		this.setY(turtle.getY());
		this.setRotate(turtle.getRotate());
	}
}
