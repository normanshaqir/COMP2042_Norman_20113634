package main.frogger_game.actors;

public abstract class AnimActor extends Actor {
	private double speed;
	
	private int leftDespawnPos;
	private int rightDespawnPos;
	
	private int leftRespawnPos;
	private int rightRespawnPos;
	
	public AnimActor(String imageType, int w, int h, int xpos, int ypos, double s) {
		this(imageType, w, h, xpos, ypos);
		this.speed = s;
		
	}
	
	public AnimActor(String imageType, int w, int h, int xpos, int ypos) {
		super(imageType, w, h, xpos, ypos);
	}
	
	public void despawnAndRespawnAnimActor() {
		if (getX() > getRightDespawnPos() && getSpeed() > 0) {
			setX(getRightRespawnPos());
		}
		
		if (getX() < getLeftDespawnPos() && getSpeed() < 0) {
			setX(getLeftRespawnPos());
		}
		
	}
	
	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
    public abstract void act(long now);

	public int getLeftDespawnPos() {
		return leftDespawnPos;
	}

	public void setLeftDespawnPos(int leftDespawnPos) {
		this.leftDespawnPos = leftDespawnPos;
	}

	public int getRightDespawnPos() {
		return rightDespawnPos;
	}

	public void setRightDespawnPos(int rightDespawnPos) {
		this.rightDespawnPos = rightDespawnPos;
	}
	
	public int getLeftRespawnPos() {
		return leftRespawnPos;
	}

	public void setLeftRespawnPos(int leftRespawnPos) {
		this.leftRespawnPos = leftRespawnPos;
	}

	public int getRightRespawnPos() {
		return rightRespawnPos;
	}

	public void setRightRespawnPos(int rightRespawnPos) {
		this.rightRespawnPos = rightRespawnPos;
	}
	
}



