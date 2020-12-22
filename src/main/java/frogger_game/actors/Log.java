package actors;

import javafx.scene.image.Image;

public class Log extends AnimActor {

	@Override
	public void act(long now) {
		move(getSpeed(), 0); // move horizontally
		
		// move back to spawn point after moving out of scene
		if (getX()>600 && getSpeed()>0) // for logs moving right
			setX(-180);
		
		if (getX()<-300 && getSpeed()<0) // for logs moving left
			setX(700);
		
	}
	
	public Log(String logType, int size, int xpos, int ypos, double speed) {
		super(logType, size, size, xpos, ypos, speed);
		
		setRightDespawnPos(600);
		setLeftDespawnPos(-300);
		
		setRightRespawnPos(-180);
		setLeftRespawnPos(700);
	}
	
}
