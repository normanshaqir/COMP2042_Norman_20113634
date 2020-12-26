package froggerGame.actorFactory;

import froggerGame.models.actors.Actor;

import froggerGame.models.actors.Log;
import froggerGame.constants.ActorImages;

/**
 * <h1>LogFactory</h1>
 * <p>
 * This class implements the interface {@code AbstractActorFactory}. The purpose of this class is to
 * act as a factory that creates {@code Log} objects. It will return a {@code Log} that will 
 * be treated as an {@code Actor}.
 * </p>
 * 
 * @author hfyns3
 *
 */

public class LogFactory implements AbstractActorFactory {
	/**
	 * Based on the input values, the log factory will create a log object corresponding to them.
	 * @param w -- width of the object
	 * @param h -- height of the object
	 * @param xpos -- set x-coordinate of the object
	 * @param ypos -- set y-coordinate of the object
	 * @param s -- speed of the object
	 * @return actor -- an actor object produced by the input arguments
	 */
	
	@Override
	public Actor createActor(String name, int w, int h, int xpos, int ypos, double speed) {
		if (name.equalsIgnoreCase("IMG_LOG_1")) {
			return (new Log(ActorImages.IMG_LOG_1, w, xpos, ypos, speed));
			
		} else if (name.equalsIgnoreCase("IMG_LOG_2")) {
			return (new Log(ActorImages.IMG_LOG_2, w, xpos, ypos, speed));
			
		} else if (name.equalsIgnoreCase("IMG_LOG_3")) {
			return (new Log(ActorImages.IMG_LOG_3, w, xpos, ypos, speed));
		} else {
			return null;
		}
		
		
	}

}
