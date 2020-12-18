package main.frogger_game.actors;

import javafx.scene.image.Image;

public class Log extends Actor {

	private double speed;
	
	@Override
	public void act(long now) {
		move(speed, 0); // move horizontally
		
		// move back to spawn point after moving out of scene
		if (getX()>600 && speed>0) // for logs moving right
			setX(-180);
		
		if (getX()<-300 && speed<0) // for logs moving left
			setX(700);
		
	}
	
	public Log(String logType, int size, int xpos, int ypos, double s) {
		Image log1 = new Image(FileNames.IMG_LOG_1, size, size, true, true);
		Image log2 = new Image(FileNames.IMG_LOG_2, size, size, true, true);
		Image log3 = new Image(FileNames.IMG_LOG_3, size, size, true, true);
		
		if (logType.equals("log1")) { 
			setImage(log1);
		} else if (logType.equals("log2")) {
			setImage(log2);
		} else if (logType.equals("log3")) {
			setImage(log3); 
		}

		setX(xpos);
		setY(ypos);
		speed = s;
		
	}
	
	public boolean getLeft() {
		return speed < 0;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
}
