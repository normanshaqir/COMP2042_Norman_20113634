package froggerGame.models.actors;

/**
 * <h1>AnimatedActor</h1>
 * <p>
 * The {@code AnimatedActor} interface serves as an abstraction connecting 
 * actors that are animated (i.e. cycle through a set group of images). 
 * </p>
 * 
 * @author hfyns3
 * @see froggerGame.models.actors.DryTurtle 
 * @see froggerGame.models.actors.WetTurtle
 * @see froggerGame.models.actors.Crocodile
 */

public interface AnimatedActor {
	/**
	 * All concrete classes that use this interface must implement this class.
	 * It acts as a common method between animated actors.
	 * @param now -- time in nanoseconds
	 */
	public void animateActor(long now);
	
}
