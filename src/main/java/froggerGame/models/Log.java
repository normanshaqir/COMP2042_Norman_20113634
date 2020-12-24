package froggerGame.models;

public class Log extends MovingActor {

	@Override
	public void act(long now) {
		move(getSpeed(), 0); // move horizontally
		despawnAndRespawnAnimActor();
		
	}
	
	public Log(String filename, int size, int xpos, int ypos, double speed) {
		super(filename, size, size, xpos, ypos, speed);
		
		setRightDespawnPos(600);
		setLeftDespawnPos(-300);
		
		setRightRespawnPos(-180);
		setLeftRespawnPos(700);
	}
	
}
