package simulationObjects;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class UpdateLocation {
	public boolean goup = false, goright = false, godown = false, goleft = false;
	
	public UpdateLocation(){
		
	}

	public int[] updateLocation(int x, int y){		
		if(goup) y+=50;
		if(godown) y-=50;
		if(goleft) x-=50;
		if(goright) x+=50;
		int[] newLocation = new int[]{x,y};
		return newLocation;		
	}

	public void updatemovement(Scene scene){
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			public void handle(KeyEvent event){
				switch (event.getCode()) {
				case UP: goup = true; break;
				case RIGHT:	goright = true; break;
				case DOWN: godown = true; break;		
				case LEFT: goleft = true; break;						
				default: break;
				}
			}
		});
	}

	public void regressmovement(Scene scene){
		scene.setOnKeyReleased(new EventHandler<KeyEvent>(){
			public void handle(KeyEvent event){
				switch (event.getCode()) {
				case UP: goup = false; break;
				case RIGHT: goright = false; break;
				case DOWN:  godown = false; break;
				case LEFT:  goleft = false; break;
				default: break;
				}
			}
		});
	}

}
