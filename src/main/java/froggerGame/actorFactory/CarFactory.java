package froggerGame.actorFactory;

import froggerGame.models.actors.Actor;
import froggerGame.models.actors.Car;
import froggerGame.constants.ActorImages;

/**
 * <h1>CarFactory</h1>
 * <p>
 * This class implements the interface {@code AbstractActorFactory}. The purpose of this class is to
 * act as a factory that creates {@code Car} objects. It will return a {@code Car} that will 
 * be treated as an {@code Actor}.
 * </p>
 * 
 * @author hfyns3
 *
 */

public class CarFactory implements AbstractActorFactory {
	/**
	 * Based on the input values, the car factory will create a car object corresponding to them.
	 * @param w -- width of the object
	 * @param h -- height of the object
	 * @param xpos -- set x-coordinate of the object
	 * @param ypos -- set y-coordinate of the object
	 * @param s -- speed of the object
	 * @return actor -- an actor object produced by the input arguments
	 */
	@Override
	public Actor createActor(String name, int w, int h, int xpos, int ypos, double speed) {
		switch (name) {
			case "IMG_CAR_LEFT_1":
				return new Car(ActorImages.IMG_CAR_LEFT_1, w, h, xpos, ypos, speed);
			case "IMG_CAR_RIGHT_1":
				return new Car(ActorImages.IMG_CAR_RIGHT_1, w, h, xpos, ypos, speed);
			default:
				return null;
		}
	}

}
