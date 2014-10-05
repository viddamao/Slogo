package GUI;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Application is launched in this class
 * @author Steven Pierre
 *
 */
public class GUILaunch extends Application {

	public static void main (String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		GUIScene guiScene = new GUIScene();
		guiScene.createScene(stage);
	}
}