package main.frogger_game.actors;

import javafx.scene.image.Image;

public class Obstacle extends Actor {
	private int speed;
	@Override
	public void act(long now) {
		move(speed , 0); // moves horizontally
		
		// move Obstacle (car/trucks) back to spawn point
		if (getX() > 600 && speed>0) // for obstacles moving from left to right
			setX(-200); 
		
		if (getX() < -50 && speed<0) // for obstacles moving from right to left
			setX(600);
	}
	
	public Obstacle(String imageLink, int xpos, int ypos, int s, int w, int h) { // standard constructor for classes extending Actor
		setImage(new Image(imageLink, w,h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

}
