package froggerGame.models.actors;

/**
 * <h1>MovingActor</h1>
 * <p>
 * The {@code MovingActor} is an abstract class expanding on {@code Actor}.
 * Objects of this type can move from point A to point B. 
 * The {@code MovingActor} class is the superclass of many mobs in the game.
 * It also implements respawning and despawning of mobs with 
 * {@code leftDespawnPos}, {@code rightDespawnPos}, {@code leftRespawnPos}, 
 * {@code rightRespawnPos} with left indicating that it travels from left to right,
 *  and from right to left for right.
 * </p>
 * @see froggerGame.models.actors.Log
 * @see froggerGame.models.actors.Car
 * @see froggerGame.models.actors.Truck
 * 
 * 
 * 
 * @author hfyns3
 *
 */

public abstract class MovingActor extends Actor {
	private double speed;
	
	private int leftDespawnPos;
	private int rightDespawnPos;
	
	private int leftRespawnPos;
	private int rightRespawnPos;
	
	/**
	 *  This constructor creates a {@MovingActor} object. 
	 *  It invokes the superclass {@code Actor}'s constructor. 
	 * @param filename -- location of  image file
	 * @param w -- width of the object
	 * @param h -- height of the object
	 * @param xpos -- set x-coordinate of the object
	 * @param ypos -- set y-coordinate of the object
	 * @param s -- speed of the object
	 */
	
	public MovingActor(String filename, int w, int h, int xpos, int ypos, double s) {
		this(filename, w, h, xpos, ypos);
		this.speed = s;
		
	}
	
	/**
	 * Alternate constructor, specfically for {@code Player} class.
	 * @param filename -- location of  image file
	 * @param w -- width of the object
	 * @param h -- height of the object
	 * @param xpos -- set x-coordinate of the object
	 * @param ypos -- set y-coordinate of the object
	 * @param s -- speed of the object
	 * 
	 * @see froggerGame.models.actors.Player
	 */
	
	public MovingActor(String filename, int w, int h, int xpos, int ypos) {
		super(filename, w, h, xpos, ypos);
	}
	
	/**
	 * Abstract method to be implemented by all subclasses. 
	 * @param now -- current time in nanoseconds
	 */
	
	public abstract void act(long now);
	
	/**
	 * Moves by getting current coordinates and adding speed. 
	 * @param dx -- x-value to move
	 * @param dy -- y-value to move
	 */
	
    public void move(double dx, double dy) { 
        setX(getX() + dx);
        setY(getY() + dy);
    }
	
    /**
     * Despawns an actor when it is out of bounds and respawns it.
     * Since mobs only move horizontally, it does not care about the y-coordinate
     * and only bothers with the x-coordinate.
     */
    
	public void despawnAndRespawnAnimActor() {
		if (getX() > getRightDespawnPos() && getSpeed() > 0) {
			setX(getRightRespawnPos());
		}
		
		if (getX() < getLeftDespawnPos() && getSpeed() < 0) {
			setX(getLeftRespawnPos());
		}
		
	}
	
	/**
	 * Returns value of speed
	 * @return speed -- value of speed
	 */
	
	public double getSpeed() {
		return speed;
	}
	
	/**
	 * Sets value of speed field to @param speed
	 * @param speed -- new speed value to be set
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	/**
	 * Returns the despawn position of a mob travelling from left to right.
	 * @return leftDespawnPos -- x-coordinate value 
	 */
	public int getLeftDespawnPos() {
		return leftDespawnPos;
	}
	
	/**
	 * Sets the despawn position of a mob travelling from left to right.
	 * @param leftDespawnPos -- new leftDespawnPos value to be set
	 */
	
	public void setLeftDespawnPos(int leftDespawnPos) {
		this.leftDespawnPos = leftDespawnPos;
	}
	
	/**
	 * Returns the despawn position of a mob travelling from right to left.
	 * @return rightDespawnPos -- x--coordinate value
	 */
	
	public int getRightDespawnPos() {
		return rightDespawnPos;
	}
	
	/**
	 * Sets the despawn position of a mob travelling from right to left.
	 * @param rightDespawnPos -- new rightDespawnPos value to be set
	 */
	
	public void setRightDespawnPos(int rightDespawnPos) {
		this.rightDespawnPos = rightDespawnPos;
	}
	
	/**
	 * Returns the respawn position of a mob travelling from left to right.
	 * @return leftRespawnPos -- x-coordinate value 
	 */
	
	public int getLeftRespawnPos() {
		return leftRespawnPos;
	}
	
	/**
	 * Sets the despawn position of a mob travelling from left to right.
	 * @param leftRespawnPos -- new leftRespawnPos value to be set
	 */
	
	public void setLeftRespawnPos(int leftRespawnPos) {
		this.leftRespawnPos = leftRespawnPos;
	}
	
	/**
	 * Returns the respawn position of a mob travelling from right to left.
	 * @return rightRespawnPos -- x-coordinate value 
	 */
	
	public int getRightRespawnPos() {
		return rightRespawnPos;
	}
	/**
	 * Sets the despawn position of a mob travelling from right to left.
	 * @param rightRespawnPos -- new rightRespawnPos value to be set
	 */
	public void setRightRespawnPos(int rightRespawnPos) {
		this.rightRespawnPos = rightRespawnPos;
	}
	
}



