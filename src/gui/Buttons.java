package gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import simulationObjects.Turtle;
import view.TurtleView;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Buttons {

    public void makeButtons(PaintArea grid) {

    }

    private Button makeButton(String property, EventHandler<ActionEvent> handler) {
	Button result = new Button();
	// result.setText(myResources.getString(property));
	result.setOnAction(handler);
	return result;
    }

    public static void changeColor() {
	// TODO Auto-generated method stub

    }

    public static void gridToggle(GridPane playground) {
	// TODO Auto-generated method stub
	playground.setGridLinesVisible(!playground.isGridLinesVisible());
    }

    public static void turtleToggle() {
	// TODO Auto-generated method stub

    }

    public static void changeImage(TurtleView turtle) {
	FileChooser fileChooser = new FileChooser();
	fileChooser.getExtensionFilters().add(
		new FileChooser.ExtensionFilter("JPG", "*.jpg"));
	fileChooser
		.setInitialDirectory(new File(System.getProperty("user.dir")));
	File file = fileChooser.showOpenDialog(new Stage());
	try {
	    BufferedImage bufferedImage = ImageIO.read(file);
	    Image image = SwingFXUtils.toFXImage(bufferedImage, null);
	    turtle.changeImage(image);
	} catch (IOException ex) {
		
	}

    }

    public static void changeLang() {
	// TODO Auto-generated method stub

    }

}
