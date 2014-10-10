package gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUIScene {
	/**
	 * Application scene is managed in this class
	 * @author Steven Pierre
	 *
	 */
	private Text statusText = new Text();
	
	public static double SCENE_WIDTH = 1280;
    public static double SCENE_HEIGHT = 720;
    public static double WRAP_LENGTH = 150;
    public static double WRAP_HEIGHT= 720/4;
    public static double GRID_TO_SCENE_RATIO = 0.8;
	private BorderPane layout = new BorderPane();
	
	public void createScene(Stage s) throws FileNotFoundException{
		Scene slogo = new Scene(layout, SCENE_WIDTH, SCENE_HEIGHT, Color.AQUA);
		s.setTitle("SLogo");
		s.setScene(slogo);
		s.show();
		layout.setTop(getTopToolBar());
		layout.setRight(getRightBox());
		layout.setLeft(addButtons());
		layout.setCenter(addGrid());
	}
	
	public GridPane getRightBox(){
		GridPane bottom = new GridPane();
		HBox statusBar = new HBox();
        statusBar.setPrefHeight(SCENE_HEIGHT/2);
        statusBar.setAlignment(Pos.TOP_LEFT);     
        statusBar.getChildren().addAll( new Label("Status:"), statusText);
        statusBar.setStyle("-fx-background-color: AQUA");
        
        TextArea input = new TextArea();
        input.setWrapText(true);
        input.setPrefWidth(200);
        input.setPrefHeight((int)SCENE_HEIGHT/2);
        input.setStyle("-fx-background-color: DarkBlue");
        
        bottom.add(input, 0, 0);
        bottom.add(statusBar, 0, 1);
        bottom.setStyle("-fx-background-color: AQUA");
        
        return bottom;
	}
	
	public ToolBar getTopToolBar(){
		Button load = new Button("For future use");
        load.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent event) {
                System.out.println("Making progress");
            }
        });
        ToolBar topToolBar = new ToolBar(load);
        topToolBar.setOrientation(Orientation.HORIZONTAL); 
        topToolBar.setStyle("-fx-background-color: Black");
        return topToolBar;
	}
	
	public GridPane addGrid(){
		GridPane playground = new GridPane();
		playground.setGridLinesVisible(true);
		return playground;
	}
	public FlowPane addButtons() throws FileNotFoundException{
		FlowPane flow = new FlowPane();
		flow.setPadding(new Insets(5, 0, 5, 0));
		flow.setVgap(4);
		flow.setHgap(4);
		flow.setPrefWrapLength(WRAP_LENGTH);
		flow.setPrefWidth(WRAP_LENGTH);
		flow.setStyle("-fx-background-color: DarkBlue");
		
		ImageView col= new ImageView(setImage(new FileInputStream(new File("src/images/BackgroundColor.png"))));
		Button color = new Button("color", col);
		
		ImageView gdt= new ImageView(setImage(new FileInputStream(new File("src/images/Grid.png"))));
		Button gridT = new Button("Grid Toggle", gdt);
	
		ImageView ttle= new ImageView(setImage(new FileInputStream(new File("src/images/Leonardo.png"))));
		Button turtle= new Button("Turtle Toggle", ttle);
		
		ImageView ttm= new ImageView(setImage(new FileInputStream(new File("src/images/Raphael.png"))));
		Button turtim= new Button("Turtle image", ttm);
	
		flow.getChildren().add(color);
		flow.getChildren().add(gridT);
		flow.getChildren().add(turtle);
		flow.getChildren().add(turtim);
		return flow;
	}
	
	public Image setImage(FileInputStream input){	
		return new Image(input, WRAP_LENGTH, WRAP_HEIGHT, true, true);
	}
}
