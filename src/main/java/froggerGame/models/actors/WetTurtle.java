package froggerGame.models.actors;

import javafx.scene.image.Image;

import froggerGame.constants.*;

/**
 * <h1>WetTurtle</h1>
 * 
 * <p>
 * The {@code WetTurtle} class is a subclass of {@code Obstacle} and also implements
 * the interface {@code AnimatedActor}. 
 * 
 * The player can manuver across the water in the second half of the game by stepping onto the wet turtle.
 * However, the player should care as the turtle will occassionally submerge into the water, drowning the frog
 * if it is on the turtle at that time. 
 * 
 * If the frog is on the turtle when {@code sunk} is true, the frog will die; otherwise it is safe.
 * </p>
 * 
 * @see froggerGame.models.actors.Crocodile
 * @see froggerGame.models.actors.DryTurle
 * 
 * @author hfyns3
 *	
 */

public class WetTurtle extends MovingActor implements AnimatedActor {
	private Image turtle1 = new Image(ActorImages.IMG_WET_TURTLE_1, getWidth(), getHeight(), true, true);
	private Image turtle2 = new Image(ActorImages.IMG_WET_TURTLE_2, getWidth(), getHeight(), true, true);
	private Image turtle3 = new Image(ActorImages.IMG_WET_TURTLE_3, getWidth(), getHeight(), true, true);
	private Image turtle4 = new Image(ActorImages.IMG_WET_TURTLE_4, getWidth(), getHeight(), true, true);
	
	private boolean sunk = false;
	
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
	
	public WetTurtle(int w, int h, int xpos, int ypos, double s) {
		super(ActorImages.IMG_TURTLE_2, w, h, xpos, ypos, s);
		
		setRightDespawnPos(600);
		setLeftDespawnPos(-75);
		
		setRightRespawnPos(-200);
		setLeftRespawnPos(600);
		
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
	public void act (long now) {
		
		animateActor(now);
		move(getSpeed(), 0);
		despawnAndRespawnAnimActor();
	}
	
	/**
	 * Implements its interface {@code AnimatedActor} method animateActor.
	 * Cycles through four different images, and in its last image, 
	 * change {@code sunk} to true. Sets {@code sunk} back to true
	 * at the start of the method.
	 * 
	 * @param now -- time in nanoseconds
	 */
	
	public void animateActor(long now) {
		sunk = false;
		
		if (now/900000000  % 4 == 0) {
			setImage(turtle2);
			
		} else if (now/900000000 % 4 == 1) {
			setImage(turtle1);
			
		} else if (now/900000000 % 4 == 2) {
			setImage(turtle3);
			
		} else if (now/900000000 % 4 == 3) {
			setImage(turtle4);
			sunk = true;
		}
		
	}
	
	/**
	 * Returns the value of sunk
	 * @return sunk -- boolean value
	 */
	
	public boolean isSunk() {
		return sunk;
	}

}
