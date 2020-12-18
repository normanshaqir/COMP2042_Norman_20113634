package main.frogger_game.actors;

import javafx.scene.image.Image;

public class Truck extends Obstacle {
	
	public Truck (String obstacleType, int xpos, int ypos, int s, int w, int h) {
		super(xpos, ypos, s, w, h);
		
		Image truck1Left = new Image(FileNames.IMG_TRUCK_LEFT_1, w, h, true, true);
		Image truck1Right = new Image(FileNames.IMG_TRUCK_RIGHT_1, w, h, true, true);
		Image truck2Left = new Image(FileNames.IMG_TRUCK_LEFT_2, w, h, true, true);
		Image truck2Right = new Image(FileNames.IMG_TRUCK_RIGHT_2, w, h, true, true);
		
		if (obstacleType.equals("truck1Left")) {
			setImage(truck1Left);
			
		} else if (obstacleType.equals("truck1Right")) {
			setImage(truck1Right);
			
		} else if (obstacleType.equals("truck2Left")) {
			setImage(truck2Left);
			
		} else if (obstacleType.equals("truck2Right")) {
			setImage(truck2Right);
			
		}
	}

}
