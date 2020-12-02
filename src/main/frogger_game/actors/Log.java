package main.frogger_game.actors;

import javafx.scene.image.Image;
import main.frogger_game.world.*;

public class Log extends Actor {

	private double speed;
	@Override
	public void act(long now) {
		move(speed, 0); // move horizontally
		
		// move back to spawn point after moving out of scene
		if (getX()>600 && speed>0) // for logs moving right
			setX(-180);
		
		if (getX()<-300 && speed<0) // for logs moving left
			setX(700);
		
	}
	
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size, size, true, true)); // standard constructor for classes extending Actor
		setX(xpos);
		setY(ypos);
		speed = s;
		
	}
	
	public boolean getLeft() {
		return speed < 0;
	}
}
