package main.frogger_game.actors;

public abstract class AnimActor extends Actor {
	private double speed;
	
	public AnimActor(String imageType, int w, int h, int xpos, int ypos, double s) {
		this(imageType, w, h, xpos, ypos);
		this.speed = s;
		
	}
	
	public AnimActor(String imageType, int w, int h, int xpos, int ypos) {
		super(imageType, w, h, xpos, ypos);
	}
	
	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
    public abstract void act(long now);
}
