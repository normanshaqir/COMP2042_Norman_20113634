package froggerGame.actorFactory;

import froggerGame.models.Actor;
import froggerGame.models.Car;
import froggerGame.constants.ActorImages;

public class CarFactory implements AbstractActorFactory {
	
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
