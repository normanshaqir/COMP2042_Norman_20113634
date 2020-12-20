package main.frogger_game.actors;

import javafx.scene.image.Image;

public class Car extends Obstacle {
	
	public Car (String obstacleType, int xpos, int ypos, int s, int w, int h) {
		super(xpos, ypos, s, w, h);
		
		Image car1Left = new Image(ActorImages.IMG_CAR_LEFT_1, w, h, true, true);
		Image car1Right = new Image(ActorImages.IMG_CAR_RIGHT_1, w, h, true, true);
		
		if (obstacleType.equals("car1Left")) {
			setImage(car1Left);
			
		} else if (obstacleType.equals("car1Right")) {
			setImage(car1Right);
		}
		
	}
}
