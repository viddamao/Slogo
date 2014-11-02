package JUnitTest;
//This code is part of my masterpiece
// Steven Pierre
import static org.junit.Assert.*;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import gui.Buttons;

public class MovementTester {
	protected static void main(String[] args){
		testMovement();
	}
	protected static void testMovement(){
		BorderPane s = new BorderPane();
		Scene sc = new Scene(s,30,30);
		sc.setOnKeyPressed(new EventHandler<KeyEvent>(){
			public void handle(KeyEvent event){
				assertEquals("fd 20", Buttons.updateMovement(event)); 
				assertEquals("rt 20", Buttons.updateMovement(event));
				assertEquals("bk 20", Buttons.updateMovement(event));
				assertEquals("lt 20", Buttons.updateMovement(event));
			}
		});
	}
}
