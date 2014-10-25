package gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import simulationObjects.Pen;
import simulationObjects.Turtle;

import javax.imageio.ImageIO;

import javafx.scene.control.ColorPicker;
import simulationObjects.Turtle;
import view.TurtleView;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Buttons {

	public static void changeColor(final Pane playground, final FlowPane flow, final Pen pen) {
		final ColorPicker bgColor = new ColorPicker(Color.WHITE);
		final Text bgLabel = new Text("Background"); 
		bgLabel.setFill(Color.WHITE);
		flow.getChildren().add(bgLabel);
		flow.getChildren().add(bgColor);
		bgColor.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e){
				playground.setStyle("-fx-background-color: "+ toRGBString(bgColor.getValue()));
				flow.getChildren().remove(bgColor);
				flow.getChildren().remove(bgLabel);
			}
		});
		
		final ColorPicker penColor = new ColorPicker(pen.getColor());
		final Text penLabel = new Text("Pen"); 
		penLabel.setFill(Color.WHITE);
		flow.getChildren().add(penLabel);
		flow.getChildren().add(penColor);
		penColor.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e){
				pen.setColor(penColor.getValue());
				flow.getChildren().remove(penColor);
				flow.getChildren().remove(penLabel);
			}
		});
	}
	
	public static String toRGBString(Color c){
		 return "rgb("
                 + (int)(c.getRed()*255)
           + "," + (int)(c.getGreen()*255)
           + "," + (int)(c.getBlue()*255)
    + ")";
	}

	public static int factory(String value){
		if(value.equals("English")) return 0;
		if(value.equals("French")) return 1;
		return 0;
	}

	public static void changeImage(TurtleView turtle) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JPG", "*.jpg", "PNG", "*.png"));
		fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
		File file = fileChooser.showOpenDialog(new Stage());
		try {
			Image image = new Image(new FileInputStream(file), 80, 60, true, true);
			turtle.setImage(image);
		} catch (IOException ex) {

		}

	}

	public static void changeLang() {
		// TODO Auto-generated method stub

	}

	public static void changePen(BorderPane layout, FlowPane flow, Pen myPen) {
//		final ColorPicker bgColor = new ColorPicker(Color.WHITE);
//		final Text bgLabel = new Text("Background"); 
//		bgLabel.setFill(Color.WHITE);
//		flow.getChildren().add(bgLabel);
//		flow.getChildren().add(bgColor);
//		bgColor.setOnAction(new EventHandler<ActionEvent>(){
//			@Override
//			public void handle(ActionEvent e){
//				playground.setStyle("-fx-background-color: "+ toRGBString(bgColor.getValue()));
//				flow.getChildren().remove(bgColor);
//				flow.getChildren().remove(bgLabel);
//			}
//		});
	}

}
