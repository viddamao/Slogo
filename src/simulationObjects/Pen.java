package simulationObjects;

import javafx.scene.paint.Color;

public class Pen {
	
	private Color myColor;
	private double myWidth;
	private boolean active;
	private boolean myStyle;
	
	public Pen(){
		super();
		active=true;
		myColor = Color.BLACK;
	}
	
	public void setColor(Color color) {
		myColor = color;
	}

	public Color getColor() {
		return myColor;
	}

	public void setWidth(double width) {
		this.myWidth = width;
	}

	public double getWidth() {
		return myWidth;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean getActive() {
		return active;
	}
	
	public void setStyle(boolean sty){
		this.myStyle = sty;
	}

	public boolean getOffset(){
		return myStyle;
	}

}