package main.frogger_game.actors;

public class Obstacle extends AnimActor {
	
	public Obstacle(String imageType, int w, int h, int xpos, int ypos, int s) { // standard constructor for classes extending Actor
		super(imageType, w, h, xpos, ypos, s);
	}
	
	
	@Override
	public void act(long now) {
		move(getSpeed() , 0); // moves horizontally
		
		// move Obstacle (car/trucks) back to spawn point
		if (getX() > 600 && getSpeed()>0) // for obstacles moving from left to right
			setX(-200); 
		
		if (getX() < -50 && getSpeed()<0) // for obstacles moving from right to left
			setX(600);
	}
	
}
