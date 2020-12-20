package main.frogger_game.actors;

import javafx.scene.image.Image;

public class Digit extends Actor {
	private Image im1;
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	public Digit(int n, int imgSize, int x, int y) { // constructor for images used in score
		super("file:src/main/resources/digits/"+n+".png", imgSize, imgSize, x, y);
		
	}
	
}
