package froggerGame.models.actors;

import javafx.scene.image.Image;

import froggerGame.constants.*;

/**
 * <h1>DryTurtle</h1>
 * <p>
 * This class is a subclass of the class {@code MovingActor} and implements the interface {@code AnimatedActor}.
 * Hence it will be required to implement the methods {@code act(now)} and {@code animateActor(now)}.
 * 
 * Alongside {@code Crocodile} and {@code WetTurtle}, the {@code DryTurtle} helps 
 * the player to manuver across the water in the second half of the game.
 * The dry turtle will never submerge into water like its counterpart the {@code WetTurtle}.
 *</p>
 * @see froggerGame.models.actors.Crocodile
 * @see froggerGame.models.actors.WetTurtle
 *
 * @see froggerGame.models.actors.MovingActor
 * @see froggerGame.models.actors.AnimatedActor
 * 
 * @author hfyns3
 *
 */

public class DryTurtle extends MovingActor implements AnimatedActor {
	private Image turtle1 = new Image(ActorImages.IMG_TURTLE_1, getWidth(), getHeight(), true, true);
	private Image turtle2 = new Image(ActorImages.IMG_TURTLE_2, getWidth(), getHeight(), true, true);
	private Image turtle3 = new Image(ActorImages.IMG_TURTLE_3, getWidth(), getHeight(), true, true);
	
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
	
	public DryTurtle(int w, int h, int xpos, int ypos, double s) { 
															
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
	public void act(long now) {
		animateActor(now);
		move(getSpeed(), 0); // moves horizontally
		despawnAndRespawnAnimActor();
	}
	
	/**
	 * Implements its interface {@code AnimatedActor} method animateActor.
	 * Cycles through three different images.
	 * 
	 * @param now -- time in nanoseconds
	 */
	
	public void animateActor(long now) {
		if (now/900000000  % 3 == 0) {
			setImage(turtle2);
			
		}
		else if (now/900000000 % 3 == 1) {
			setImage(turtle1);
			
		}
		else if (now/900000000 % 3 == 2) {
			setImage(turtle3);
			
		}
	}

}
