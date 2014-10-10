package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
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
	 * @author Kevin Rhine
	 */
	private Text statusText = new Text();
	public static double SCENE_WIDTH = 1280;
    public static double SCENE_HEIGHT = 720;
    public static double WRAP_LENGTH = 150;
    public static double GRID_TO_SCENE_RATIO = 0.8;
	private BorderPane layout = new BorderPane();
	
	public void createScene(Stage s){
		Scene slogo = new Scene(layout, SCENE_WIDTH, SCENE_HEIGHT, Color.AQUA);
		s.setTitle("SLogo Team 05");
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
        statusBar.setPrefHeight(SCENE_HEIGHT/10);
        statusBar.setAlignment(Pos.BOTTOM_RIGHT);     
        statusBar.getChildren().addAll( new Label("let's hit the ground running"), statusText);
        TextField input = new TextField();
        input.setAlignment(Pos.TOP_LEFT);  
     
        bottom.add(input, 0, 0);
        bottom.add(statusBar, 0, 1);
        bottom.setStyle("-fx-background-color: DAE6F3");
        return bottom;
	}
	
	public ToolBar getTopToolBar(){
		Button load = new Button("Load simulation");
        load.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent event) {
                System.out.println("Making progress");
            }
        });
        ToolBar topToolBar = new ToolBar(load);
        topToolBar.setOrientation(Orientation.HORIZONTAL);     
        return topToolBar;
	}
	
	public GridPane addGrid(){
		GridPane playground = new GridPane();
		playground.setGridLinesVisible(true);
		return playground;
	}
	public FlowPane addButtons(){
		FlowPane flow = new FlowPane();
		flow.setPadding(new Insets(5, 0, 5, 0));
		flow.setVgap(4);
		flow.setHgap(4);
		flow.setPrefWrapLength(WRAP_LENGTH);
		flow.setStyle("-fx-background-color: DAE6F3");
		
		Button color = new Button("Colors");
		color.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent event) {
				Buttons.changeColor();
			}
		});
		
		Button gridT = new Button("Grid Toggle");
		gridT.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent event) {
				Buttons.gridToggle();
			}
		});
		
		Button turtleVisibility= new Button("Turtle Toggle");
		turtleVisibility.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent event) {
				Buttons.turtleToggle();
			}
		});
		
		Button turtleImg= new Button("Choose Turtle Image");
		turtleImg.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent event) {
				Buttons.changeImage();
			}
		});
		
		Button language= new Button("Choose SLogo Language");
		language.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent event) {
				Buttons.changeLang();
			}
		});
		
		flow.getChildren().add(color);
		flow.getChildren().add(gridT);
		flow.getChildren().add(turtleVisibility);
		flow.getChildren().add(turtleImg);
		flow.getChildren().add(language);
		return flow;
	}
	
	//TODO I think instead of the getCommand you may need a keyListener 
	//     such that when you hit enter you pass the commands in the text box
	//     to MainController	
	public String getCommand(){	
		return "";
	}
}
