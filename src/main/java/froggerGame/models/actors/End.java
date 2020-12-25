package froggerGame.models.actors;

import javafx.scene.image.Image;

import froggerGame.constants.ActorImages;
/**
 * <h1>End</h1>
 * <p>
 * The {@code End} class represents the win condition in the game. The player has to 'activate' or reach
 * all five of the End boxes at the end of the map. Once all five boxes are activated, the player wins.
 * 
 * This class implements only the {@code Actor} class as it is static and does not move.
 * @author User
 *
 */

public class End extends Actor{
	private boolean activated = false;
	
	/**
	 * The constructor invokes superclass {@code Actor} constructor, which takes in an image, specific dimensions, 
	 * and the x and y-coordinates. The image dimensions are predefined to be w = 60 and h = 60.
	 * @param x -- x-coordinate of the object
	 * @param y -- y-coordinate of the object
	 */
	
	public End(int x, int y) {
		super(ActorImages.IMG_END, 60, 60, x, y); // hole
	}
	
	/**
	 * Once the player has reached the hole, change its image to be a Frog in a hole, indicating that 
	 * the hole has been activated. The {@code activated} field will also be set to true.
	 */
	
	public void setEnd() {
		setImage(new Image(ActorImages.IMG_END_FROG, 70, 70, true, true)); // frog in hole
		activated = true;
	}
	
	/**
	 * Returns a boolean value 
	 * @return activated -- boolean value indicating whether the hole (or End) has been reached
	 */
	
	public boolean isActivated() { // to enable collision for holes that already have frogs in them
		return activated;
	}
	

}
