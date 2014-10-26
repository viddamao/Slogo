package gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import view.TurtleView;

public class Buttons {

    public static int factory(String value) {
	if (value.equals("English"))
	    return 0;
	if (value.equals("French"))
	    return 1;
	return 0;
    }

    public static void changeImage(TurtleView turtle) {
	FileChooser fileChooser = new FileChooser();
	fileChooser.getExtensionFilters()
	.add(new FileChooser.ExtensionFilter("JPG", "*.jpg", "PNG",
		"*.png"));
	fileChooser
	.setInitialDirectory(new File(System.getProperty("user.dir")));
	File file = fileChooser.showOpenDialog(new Stage());
	try {
	    Image image = new Image(new FileInputStream(file), 80, 60, true,
		    true);
	    turtle.setImage(image);
	} catch (IOException ex) {

	}

    }

    public static String status(List<String> status) {
	String fullHistory = "";
	for (int i = status.size(); i > 0; i--) {
	    fullHistory = fullHistory + status.get(i - 1) + "\n";
	}
	return fullHistory;

    }

    public static void changeLang() {
	// TODO Auto-generated method stub

    }

}
