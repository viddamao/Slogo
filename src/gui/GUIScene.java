package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUIScene {
    /**
     * Application scene is managed in this class
     * 
     * @author Steven Pierre
     *
     */
    public void createScene(Stage s) throws FileNotFoundException, Exception {
	GridPane layout = new GridPane();
	Scene slogo = new Scene(layout, 1280, 720, Color.AQUA);
	s.setTitle("SLogo Team 05");
	s.setScene(slogo);
	s.show();
    }

    class pressedEnter implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
	    // TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
	    // TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
	    // TODO Auto-generated method stub

	}

    }

    public void addButtons(GridPane layout) {

    }

    public String getCommand() {
	return "";
    }
}
