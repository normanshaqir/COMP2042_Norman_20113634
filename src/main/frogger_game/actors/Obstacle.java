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
	
	public Obstacle(int xpos, int ypos, int s, int w, int h) { // standard constructor for classes extending Actor
		setX(xpos);
		setY(ypos);
		speed = s;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
