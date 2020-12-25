package froggerGame.models.actors;

import froggerGame.constants.ActorImages;
/**
 * <h1>Digit</h1>
 * <p>
 * {@code Digit} serves as a utility class used in setting the score the player earns. The score is set in real
 * time by the methods {@code changeScore} and {@setScore} in {@code Player} and {@code Level} respectively.
 * </p>
 * @see froggerGame.models.actors.Player
 * @see froggerGame.models.levels.Level
 * 
 * @author hfyns3
 *
 */

public class Digit extends Actor {
	/**
	 * Invokes the superclass constructor and creates a digit corresponding to the {@code n} value.
	 * Output include digits 0 to 9.
	 * @param n -- input value for which digit to produce (0-9)
	 * @param imgSize -- universal value for both width and height dimensions
	 * @param x -- x-coordinate of the digit
	 * @param y -- y-coordinate of the digit
	 */
	public Digit(int n, int imgSize, int x, int y) { 
		super(ActorImages.IMG_DIGIT + n + ".png", imgSize, imgSize, x, y);
		
	}
	
}
