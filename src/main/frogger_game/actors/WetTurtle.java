package main.frogger_game.actors;

import javafx.scene.image.Image;

public class WetTurtle extends AnimActor{
	private Image turtle1 = new Image(ActorImages.IMG_WET_TURTLE_1, getWidth(), getHeight(), true, true);
	private Image turtle2 = new Image(ActorImages.IMG_WET_TURTLE_2, getWidth(), getHeight(), true, true);;
	private Image turtle3 = new Image(ActorImages.IMG_WET_TURTLE_3, getWidth(), getHeight(), true, true);;
	private Image turtle4 = new Image(ActorImages.IMG_WET_TURTLE_4, getWidth(), getHeight(), true, true);;
	
	private boolean sunk = false;
	
	@Override
	public void act (long now) {
		
		animateTurtle(now);
		move(getSpeed(), 0);
		despawnAndRespawnAnimActor();
	}
	
	public WetTurtle(int xpos, int ypos, int s, int w, int h) {
		super(ActorImages.IMG_TURTLE_2, w, h, xpos, ypos, s);
		
		setRightDespawnPos(600);
		setLeftDespawnPos(-75);
		
		setRightRespawnPos(-200);
		setLeftRespawnPos(600);
		
	}
	
	public void animateTurtle(long now) {
		if (now/900000000  % 4 ==0) {
			setImage(turtle2);
			sunk = false;
			
		} else if (now/900000000 % 4 == 1) {
			setImage(turtle1);
			sunk = false;
			
		} else if (now/900000000 % 4 == 2) {
			setImage(turtle3);
			sunk = false;
			
		} else if (now/900000000 % 4 == 3) {
			setImage(turtle4);
			sunk = true;
		}
	}
	
	public boolean isSunk() {
		return sunk;
	}

}
