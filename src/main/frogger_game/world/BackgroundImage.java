package main.frogger_game.world;

import javafx.scene.image.Image;
import main.frogger_game.actors.Actor;

public class BackgroundImage extends Actor {

	@Override
	public void act(long now) {
		
		
	}
	
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 800, true, true));
		
	}

}
