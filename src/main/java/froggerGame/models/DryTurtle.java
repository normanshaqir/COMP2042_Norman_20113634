package froggerGame.models;

import javafx.scene.image.Image;

import froggerGame.constants.*;

public class DryTurtle extends MovingActor implements AnimatedActor {
	private Image turtle1 = new Image(ActorImages.IMG_TURTLE_1, getWidth(), getHeight(), true, true);
	private Image turtle2 = new Image(ActorImages.IMG_TURTLE_2, getWidth(), getHeight(), true, true);
	private Image turtle3 = new Image(ActorImages.IMG_TURTLE_3, getWidth(), getHeight(), true, true);;

	@Override
	public void act(long now) {
		animateActor(now);
		move(getSpeed(), 0); // moves horizontally
		despawnAndRespawnAnimActor();
	}
	
	public DryTurtle(int w, int h, int xpos, int ypos, double s) { // on constructor call, create one instance of Turtle object
															// with images to cycle through for animation
		super(ActorImages.IMG_TURTLE_2, w, h, xpos, ypos, s);

		setRightDespawnPos(600);
		setLeftDespawnPos(-75);
		
		setRightRespawnPos(-200);
		setLeftRespawnPos(600);

	}
	
	public void animateActor(long now) {
		if (now/900000000  % 3 == 0) {
			setImage(turtle2);
			
		}
		else if (now/900000000 % 3 == 1) {
			setImage(turtle1);
			
		}
		else if (now/900000000 % 3 == 2) {
			setImage(turtle3);
			
		}
	}

}
