package main.frogger_game.actors;

import javafx.scene.image.Image;

public class Obstacle extends Actor {
	private int speed;
	
	@Override
	public void act(long now) {
		move(speed , 0); // moves horizontally
		
		// move Obstacle (car/trucks) back to spawn point
		if (getX() > 600 && speed>0) // for obstacles moving from left to right
			setX(-200); 
		
		if (getX() < -50 && speed<0) // for obstacles moving from right to left
			setX(600);
	}
	
	public Obstacle(String obstacleType, int xpos, int ypos, int s, int w, int h) { // standard constructor for classes extending Actor
		Image car1Left = new Image("file:src/main/resources/obstacles/car1Left.png", w, h, true, true);
		Image car1Right = new Image("file:src/main/resources/obstacles/car1Right.png", w, h, true, true);

		Image truck1Left = new Image("file:src/main/resources/obstacles/truck1Left.png", w, h, true, true);
		Image truck1Right = new Image("file:src/main/resources/obstacles/truck1Right.png", w, h, true, true);
		Image truck2Left = new Image("file:src/main/resources/obstacles/truck2Left.png", w, h, true, true);
		Image truck2Right = new Image("file:src/main/resources/obstacles/truck2Right.png", w, h, true, true);
		
		if (obstacleType.equals("car1Left")) {
			setImage(car1Left);
			
		} else if (obstacleType.equals("car1Right")) {
			setImage(car1Right);
			
		} else if (obstacleType.equals("truck1Left")) {
			setImage(truck1Left);
			
		} else if (obstacleType.equals("truck1Right")) {
			setImage(truck1Right);
			
		} else if (obstacleType.equals("truck2Left")) {
			setImage(truck2Left);
			
		} else if (obstacleType.equals("truck2Right")) {
			setImage(truck2Right);
			
		}
		setX(xpos);
		setY(ypos);
		speed = s;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
