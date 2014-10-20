package gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.ResourceBundle;

import controller.MainController;
import exceptions.ParsingException;
import exceptions.UnbalancedBracketsException;
import simulationObjects.Turtle;
import view.TurtleView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUIScene {

	/**
	 * Application scene is managed in this class
	 * @author Steven Pierre
	 * @author Kevin Rhine
	 * @model cellsociety_team15
	 */
	private Locale[] supportedLocales = { new Locale("en", "US"), new Locale("fr", "FR")};
	private Text statusText = new Text();
	protected TurtleView turtle;
	protected String userCommand = new String();
	private GridPane playground = new GridPane();
	private MainController controller = new MainController();
	public static double SCENE_WIDTH = 1280;
	public static double SCENE_HEIGHT = 720;
	public static double WRAP_LENGTH = 150;
	public static double WRAP_HEIGHT = 720 / 4;
	public static double GRID_TO_SCENE_RATIO = 0.8;
	private BorderPane layout = new BorderPane();
	private GridPane rightSide;
	private FlowPane flow;
	private ToolBar topToolBar;
	private Group root;
	private ResourceBundle guiText;

	public void createScene(Stage s) throws FileNotFoundException{
		Scene slogo = new Scene(layout, SCENE_WIDTH, SCENE_HEIGHT, Color.AQUA);
		s.setTitle("SLogo Team 05");
		s.setScene(slogo);
		s.show();
		Locale currentLocale = supportedLocales[0];
		guiText = ResourceBundle.getBundle("properties.LanguagesBundle", currentLocale);
		layout.setStyle("-fx-background-color: " + "GREY");
		layout.setTop(getTopToolBar());
		layout.setRight(getRightBox());
		layout.setLeft(addButtons());
		layout.setCenter(addGrid());
	}
	public GridPane getRightBox(){
		rightSide = new GridPane();
		HBox statusBar = new HBox();
		statusBar.setAlignment(Pos.TOP_LEFT);     
		statusBar.getChildren().addAll( new Label("Status:"), statusText);
		statusBar.setStyle("-fx-background-color: AQUA");

		final TextArea input = new TextArea();
		input.setWrapText(true);
		input.setPrefWidth(200);
		input.setPrefHeight((int)SCENE_HEIGHT/2);
		input.setStyle("-fx-background-color: DarkBlue");
		GridPane userInput = new GridPane();
		Button enter = new Button("Enter", input);
		enter.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				try {
					controller.passInput(input.getText());
				} catch (ParsingException e1) {
					input.clear();
					statusText.setText("Pass in a string fitting SLogo format");
				}
				turtle = new TurtleView(controller.getTurtle());
				input.clear();      

			}
		});
		userInput.add(input, 0,0);
		userInput.add(enter, 1,0);

		rightSide.setPrefSize(input.getMaxWidth(), SCENE_HEIGHT/2.5);
		rightSide.add(userInput, 0, 0);
		rightSide.add(statusBar, 0, 1);
		rightSide.setStyle("-fx-background-color: AQUA");        
		return rightSide;
	}
	public ToolBar getTopToolBar(){
		Button load = new Button("For future use");
		load.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent event) {

			}
		});
		topToolBar = new ToolBar(load);
		topToolBar.setOrientation(Orientation.HORIZONTAL); 
		topToolBar.setStyle("-fx-background-color: Black");
		return topToolBar;
	}
	public Group addGrid() throws FileNotFoundException{
		root = new Group();
		turtle = new TurtleView();

		playground.setHgap(10);
		for(int i=0; i<SCENE_WIDTH/15.5; i++){
			for(int j=0; j<SCENE_HEIGHT/10; j++){
				Text gridCreate = new Text("");
				playground.add(gridCreate, i, j);
			}
		}

		turtle.setPosition(SCENE_WIDTH/2, SCENE_HEIGHT/2);
		root.getChildren().add(turtle.turtImg);		
		root.getChildren().add(playground);

		return root;
	}
	public FlowPane addButtons() throws FileNotFoundException{
		flow = new FlowPane();
		flow.setPadding(new Insets(5, 0, 5, 0));
		flow.setVgap(4);
		flow.setHgap(4);
		flow.setPrefWrapLength(WRAP_LENGTH);
		flow.setPrefWidth(WRAP_LENGTH);
		flow.setStyle("-fx-background-color: DarkBlue");

		ImageView col= new ImageView(setImage(new FileInputStream(new File("src/images/BackgroundColor.png"))));
		Button color = new Button(guiText.getString("Color"), col);
		color.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent event) {
				statusText.setText(guiText.getString("Changing background color"));
				Buttons.changeColor();
			}
		});

		ImageView gdt= new ImageView(setImage(new FileInputStream(new File("src/images/Grid.png"))));
		Button gridT = new Button(guiText.getString("Grid Toggle"), gdt);
		gridT.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent event) {
				statusText.setText(guiText.getString("Toggling grid in simulation"));
				Buttons.gridToggle(playground);
			}
		});

		ImageView ttle= new ImageView(setImage(new FileInputStream(new File("src/images/Leonardo.png"))));
		Button turtleToggle= new Button(guiText.getString("Turtle Toggle"), ttle);
		turtleToggle.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent event) {
				statusText.setText(guiText.getString("Toggling turtle in simulation"));
				Buttons.turtleToggle();
			}
		});

		ImageView ttm= new ImageView(setImage(new FileInputStream(new File("src/images/Raphael.png"))));
		Button turtim= new Button(guiText.getString("Turtle Image"), ttm);
		turtim.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent event) {
				statusText.setText("Changing turtle image");
				Buttons.changeImage(turtle);
			}
		});

		Button language= new Button("Choose SLogo language");
		language.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent event) {
				Buttons.changeLang();
				ObservableList<String> options = FXCollections.observableArrayList("Option 1", "Option 2", "Option 3");
				ComboBox<String> comboBox = new ComboBox<String>(options);
				flow.getChildren().add(comboBox);
				Locale currentLocale = supportedLocales[0];
				guiText = ResourceBundle.getBundle("properties.LanguagesBundle", currentLocale);
			}
		});

		flow.getChildren().add(color);
		flow.getChildren().add(gridT);
		flow.getChildren().add(turtleToggle);
		flow.getChildren().add(turtim);
		flow.getChildren().add(language);

		return flow;
	}
	public Image setImage(FileInputStream input){	
		return new Image(input, WRAP_LENGTH/3, WRAP_HEIGHT/3, true, true);
	}
	public void update() throws FileNotFoundException{
		turtle = new TurtleView(controller.getTurtle());
	}
}
