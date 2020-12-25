package froggerGame.models.actors;
/**
 * <h1> Obstacle </h1>
 * <p>
 * The {@code Obstacle} class aims to represent all mobs, which on collision* with the frog/player, will cause 
 * the frog to die.
 * 
 * So far, three subclasses have been implemented: {@code Truck}, {@code Car}, and {@code Crocodile}.
 * 
 * In future implementations, if new mobs are to be implemented into the game, it will not require creation
 * of new classes or interfaces, as everything has been abstracted.
 * 
 * 
 * @author User
 *
 */
public class Obstacle extends MovingActor {
	
	/**
	 * Invokes the superclass constructor while also setting the respawn and despawn positions.
	 * @param w -- width of the object
	 * @param h -- height of the object
	 * @param xpos -- set x-coordinate of the object
	 * @param ypos -- set y-coordinate of the object
	 * @param s -- speed of the object
	 */
	public Obstacle(String filename, int w, int h, int xpos, int ypos, double s) { // standard constructor for classes extending Actor
		super(filename, w, h, xpos, ypos, s);
		setRightDespawnPos(600);
		setLeftDespawnPos(-50);
		
		setRightRespawnPos(-200);
		setLeftRespawnPos(600);
	}
	
	/**
	 * Calls methods move(x, y) and despawnAndRespawnAnimActor(). This method will be used in conjunction with 
	 * an AnimationTimer in other parts of the program.
	 */
	
	@Override
	public void act(long now) {
		move(getSpeed() , 0); // moves horizontally
		despawnAndRespawnAnimActor();
		
	}
	
	
}
