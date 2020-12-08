package main.frogger_game.world;


import javafx.scene.image.Image;
import main.frogger_game.actors.Actor;

public class End extends Actor{
	boolean activated = false;
	@Override
	public void act(long now) {
		// TODO Auto-generated method st
	}
	
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/main/resources/misc/End.png", 60, 60, true, true)); // hole
	}
	
	public void setEnd() {
		setImage(new Image("file:src/main/resources/misc/FrogEnd.png", 70, 70, true, true)); // frog in hole
		activated = true;
	}
	
	public boolean isActivated() { // to enable collision for holes that already have frogs in them
		return activated;
	}
	

}
