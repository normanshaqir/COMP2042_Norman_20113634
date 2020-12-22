package actors;

public class Obstacle extends AnimActor {
	
	@Override
	public void act(long now) {
		move(getSpeed() , 0); // moves horizontally
		despawnAndRespawnAnimActor();
		
	}
	
	public Obstacle(String imageType, int w, int h, int xpos, int ypos, int s) { // standard constructor for classes extending Actor
		super(imageType, w, h, xpos, ypos, s);
		setRightDespawnPos(600);
		setLeftDespawnPos(-50);
		
		setRightRespawnPos(-200);
		setLeftRespawnPos(600);
	}
}
