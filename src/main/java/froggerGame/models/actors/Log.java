package froggerGame.models.actors;
/**
 * <h1>Log</h1>
 * <p>
 * {@code Log} is implemented in the seconnd half of the map, where it is a major mechanic in allowing the
 * frog to get across the water safely to the {@code End} hole.
 * </p>
 * 
 * @author hfyns3
 *
 */
public class Log extends MovingActor {
	
	/**
	 * Invokes the superclass constructor while also setting the respawn and despawn positions.
	 * 
	 * @param filename - location of an image file
	 * @param w - the width of the {@code Actor} object to be set
	 * @param h - height of image to be set
	 * @param xpos - xpos of image to be set
	 * @param ypos - ypos of image to be set
	 */
	
	public Log(String filename, int size, int xpos, int ypos, double speed) {
		super(filename, size, size, xpos, ypos, speed);
		
		setRightDespawnPos(600);
		setLeftDespawnPos(-300);
		
		setRightRespawnPos(-180);
		setLeftRespawnPos(700);
	}
	/**
	 * Calls methods move(x, y) and despawnAndRespawnAnimActor(). This method will be used in conjunction with 
	 * an AnimationTimer in other parts of the program.
	 */
	@Override
	public void act(long now) {
		move(getSpeed(), 0); // move horizontally
		despawnAndRespawnAnimActor();
		
	}
	
	
	
}
