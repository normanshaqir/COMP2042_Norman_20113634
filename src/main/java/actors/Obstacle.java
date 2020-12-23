package actors;

public class Obstacle extends MovingActor {
	
	@Override
	public void act(long now) {
		move(getSpeed() , 0); // moves horizontally
		despawnAndRespawnAnimActor();
		
	}
	
	public Obstacle(String filename, int w, int h, int xpos, int ypos, double s) { // standard constructor for classes extending Actor
		super(filename, w, h, xpos, ypos, s);
		setRightDespawnPos(600);
		setLeftDespawnPos(-50);
		
		setRightRespawnPos(-200);
		setLeftRespawnPos(600);
	}
}
