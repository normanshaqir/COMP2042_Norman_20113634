package main.frogger_game.actors;

import javafx.scene.image.Image;

public class Turtle extends AnimActor{
	private Image turtle1;
	private Image turtle2;
	private Image turtle3;

	int i = 1;

	
	@Override
	public void act(long now) {

				if (now/900000000  % 3 ==0) {
					setImage(turtle2);
					
				}
				else if (now/900000000 % 3 == 1) {
					setImage(turtle1);
					
				}
				else if (now/900000000 %3 == 2) {
					setImage(turtle3);
					
				}
			
		move(getSpeed(), 0); // moves horizontally
		
		if (getX() > 600 && getSpeed() > 0)
			setX(-200); // for turtles moving from left to right
		if (getX() < -75 && getSpeed() < 0)
			setX(600); // for turtles moving from right to left
	}
	
	public Turtle(int xpos, int ypos, int s, int w, int h) { // on constructor call, create one instance of Turtle object
															// with images to cycle through for animation
		super(ActorImages.IMG_TURTLE_2, w, h, xpos, ypos, s);
		
		turtle1 = new Image(ActorImages.IMG_TURTLE_1, w, h, true, true);
		turtle2 = new Image(ActorImages.IMG_TURTLE_2, w, h, true, true);
		turtle3 = new Image(ActorImages.IMG_TURTLE_3, w, h, true, true); 

	}

}
