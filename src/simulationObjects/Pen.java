package simulationObjects;

import javafx.scene.paint.Color;

public class Pen {
	
	private Color myColor;
	private double penWidth;
	private boolean active;
	
	public Pen(){
		super();
	}
	
	public void setColor(Color color) {
		this.myColor = color;
	}

	public Color getColor() {
		return myColor;
	}

	public void setWidth(double width) {
		this.penWidth = width;
	}

	public double getWidth() {
		return penWidth;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean getActive() {
		return active;
	}


}