package froggerGame.models;

import froggerGame.constants.ActorImages;

public class Digit extends Actor {
	
	public Digit(int n, int imgSize, int x, int y) { // constructor for images used in score
		super(ActorImages.IMG_DIGIT + n+ ".png", imgSize, imgSize, x, y);
		
	}
	
}
