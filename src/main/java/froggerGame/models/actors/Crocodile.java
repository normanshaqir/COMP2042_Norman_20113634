package froggerGame.models.actors;

import froggerGame.constants.ActorImages;
import javafx.scene.image.Image;

/**
 * <h1>Crocodile</h1>
 * 
 * <p>
 * The {@code Crocodile} class is a subclass of {@code Obstacle} and also implements
 * the interface {@code AnimatedActor}. 
 * 
 * The player can manuver across the water in the second half of the game by moving onto the crocodile's back.
 * It acts in a similar fashion to the {@code WetTurtle} class. If the frog is on the crocodile 
 * when {@code mouthOpen} is true, the frog will die. Otherwise it is safe.
 * </p>
 * 
 * @see froggerGame.models.actors.WetTurtle
 * 
 * @author hfyns3
 *	
 */

public class Crocodile extends Obstacle implements AnimatedActor {
	private Image crocodile1 = new Image(ActorImages.IMG_CROCODILE_1, getWidth(), getHeight(), true, true);
	private Image crocodile2 = new Image(ActorImages.IMG_CROCODILE_2, getWidth(), getHeight(), true, true);
	private Image crocodile3 = new Image(ActorImages.IMG_CROCODILE_3, getWidth(), getHeight(), true, true);
	
	private boolean mouthOpen = false;
	
	/**
	 * Constructor invokes the superclass constructor and sets the respawn and despawn positions.
	 * The file location of an image is not necessary amongst the three classes that implement 
	 * the interface {@code AnimatedActor}. The images to cycle through will have already been 
	 * instantiated within the classes. 
	 * 
	 * @param w -- width of the object
	 * @param h -- height of the object
	 * @param xpos -- set x-coordinate of the object
	 * @param ypos -- set y-coordinate of the object
	 * @param s -- speed of the object
	 */
	
	public Crocodile (int w, int h, int xpos, int ypos, double s) {
		super("file:src/main/resources/crocodiles/crocodile1.PNG", w, h, xpos, ypos, s);
		
		setRightDespawnPos(600);
		setLeftDespawnPos(-300);
		
		setRightRespawnPos(-180);
		setLeftRespawnPos(700);
	}

	/** 
	 * Calls methods {@code animateActor(now)}, {@code move(x,y)}, 
	 * and {@code despawnAndRespawnAnimActor}
	 * 
	 * The act method is called in every frame by an AnimationTimer in {@code World}.
	 * 
	 * @see froggerGame.models.World
	 * 
	 * @param now -- time in nanoseconds
	 */
	
	@Override
	public void act(long now) {
		animateActor(now);
		move(getSpeed(), 0);
		despawnAndRespawnAnimActor();
		
	}
	/**
	 * Implements its interface {@code AnimatedActor} method animateActor.
	 * Cycles through three different images, and in its last image, 
	 * change {@code mouthOpen} to true. Sets {@code mouthOpen} back to false
	 * at the start of the method.
	 * 
	 * @param now -- time in nanoseconds
	 */
	@Override
	public void animateActor(long now) {
		mouthOpen = false;
		
		if (now/900000000  % 3 == 0) {
			setImage(crocodile1);
			
		}
		else if (now/900000000 % 3 == 1) {
			setImage(crocodile2);
			
		}
		else if (now/900000000 % 3 == 2) {
			setImage(crocodile3);
			mouthOpen = true;
			
		}
		
		
	}
	
	/**
	 * Returns the value of mouthOpen
	 * @return mouthOpen -- boolean value
	 */
	public boolean isMouthOpen() {
		return mouthOpen;
	}
}
