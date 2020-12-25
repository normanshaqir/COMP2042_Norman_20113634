package froggerGame.models.actors;

/**<h1>BackgroundImage</h1>
 * <p>
 * The {@code} BackgroundImage class acts as an intermediary between the {@code Actor} class
 * and the {@code Image} class defined in the JavaFX API. The purpose of the class is to 
 * make attaching an image to the backgrounnd easier. 
 *</p>
 * It invokes its superclass {@code Actor}'s constructor.
 * @author hfyns3
 */


public class BackgroundImage extends Actor {

	/** Creates a {@code BackgroundImage} object with predefined values of 600px and 800px
	 *  for its width and height, corresponding with the game's window size.
	 * @param filename -- location of the image file
	 */
	public BackgroundImage(String filename) {
		super(filename, 600, 800, 0, 0);
		
	}

}
