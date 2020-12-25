package froggerGame.models.actors;
/**
 * <h1>Car</h1>
 * <p>
 * The {@code Car} class invokes the superclass {@Code Obstacle} constructor.
 * It is an obstacle and if the frog collides with it, it will die.
 * 
 * The class inherits the act method from {@Code Obstacle}, which is later used with an AnimationTimer.
 * </p>
 * 
 * @see froggerGame.models.actors.Obstacle
 * 
 * @author hfyns3
 *
 */
public class Car extends Obstacle {
	/**
	 * Invokes the superclass constructor while also setting the respawn and despawn positions.
	 * 
	 * @param filename - location of an image file
	 * @param w - the width of the {@code Actor} object to be set
	 * @param h - height of image to be set
	 * @param xpos - xpos of image to be set
	 * @param ypos - ypos of image to be set
	 */
	public Car (String filename, int w, int h, int xpos, int ypos, double s) {
		super(filename, w, h, xpos, ypos, s);
		
		setRightDespawnPos(600);
		setLeftDespawnPos(-50);
		
		setRightRespawnPos(-200);
		setLeftRespawnPos(600);
		
	}
}
