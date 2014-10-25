package simulationObjects;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;

public class Pen {
	
	private Color myColor;
	private double penWidth;
	private boolean active;
	protected ArrayList<SLogoLine> listOfLines;
	
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

	public boolean drawLine(Point a, Point b) {
		if(active){
			listOfLines.add(new SLogoLine(a,b,getColor(),penWidth));
		}
		return active;
	}

	public ArrayList<SLogoLine> getLines() {
		return listOfLines;
	}

	public void clearLines() {
		listOfLines.clear();
	}


}