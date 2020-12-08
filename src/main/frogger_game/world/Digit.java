package main.frogger_game.world;

import javafx.scene.image.Image;
import main.frogger_game.actors.Actor;

public class Digit extends Actor {
	int dim;
	Image im1;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	public Digit(int n, int dim, int x, int y) { // constructor for images used in score
		im1 = new Image("file:src/main/resources/digits/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
	
}
