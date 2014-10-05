package gui;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUIScene {
	/**
	 * Application scene is managed in this class
	 * @author Steven Pierre
	 *
	 */
	public void createScene(Stage s){
		GridPane layout = new GridPane();
		Scene slogo = new Scene(layout, 1280, 720, Color.AQUA);
		s.setTitle("SLogo Team 05");
		s.setScene(slogo);
		s.show();
	}
	
	public void addButtons(GridPane layout){
		
	}
	
	
	
	public String getCommand(){	
		return "";
	}
}
