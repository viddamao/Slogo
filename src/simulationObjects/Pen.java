package simulationObjects;

import java.util.ArrayList;
import javafx.scene.paint.Color;

public class Pen {
	
	private Color myColor;
	private double myWidth;
	private boolean active;
	private String myStyle;
	protected ArrayList<SLogoLine> listOfLines;
	
	public Pen(){
		super();
		active=true;
		myColor = Color.BLACK;
		myStyle="Solid";
		myWidth = 1.0;
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
	
	public void setStyle(String sty){
		this.myStyle = sty;
	}

	public String getStyle(){
		return myStyle;
	}

	public boolean drawLine(Point a, Point b) {
		if(active){
			listOfLines.add(new SLogoLine(a,b,getColor(),myWidth));
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