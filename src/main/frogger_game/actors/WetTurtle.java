package main.frogger_game.actors;

import javafx.scene.image.Image;

public class WetTurtle extends Actor{
	private Image turtle1;
	private Image turtle2;
	private Image turtle3;
	private Image turtle4;
	private int speed;
	private boolean sunk = false;
	
	@Override
	public void act(long now) {

				if (now/900000000  % 4 ==0) {
					setImage(turtle2);
					sunk = false;
					
				}
				else if (now/900000000 % 4 == 1) {
					setImage(turtle1);
					sunk = false;
				}
				else if (now/900000000 %4 == 2) {
					setImage(turtle3);
					sunk = false;
				} else if (now/900000000 %4 == 3) {
					setImage(turtle4);
					sunk = true;
				}
			
		move(speed, 0);
		
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}
	public WetTurtle(int xpos, int ypos, int s, int w, int h) { 
		turtle1 = new Image(ActorImages.IMG_WET_TURTLE_1, w, h, true, true);
		turtle2 = new Image(ActorImages.IMG_WET_TURTLE_2, w, h, true, true);
		turtle3 = new Image(ActorImages.IMG_WET_TURTLE_3, w, h, true, true); 
		turtle4 = new Image(ActorImages.IMG_WET_TURTLE_4, w, h, true, true); // cycling through animations.
		setX(xpos);
		setY(ypos); // set x,y coordinates of ImageView object
		speed = s;
		setImage(turtle2); // all wet turtles spawn with turtle2 image
	}
	
	public boolean isSunk() {
		return sunk;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
