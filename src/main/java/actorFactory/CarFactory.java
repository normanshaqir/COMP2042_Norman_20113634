package actorFactory;

import actors.Actor;
import actors.Car;
import constants.ActorImages;

public class CarFactory implements AbstractActorFactory {
	
	@Override
	public Actor createActor(String name, int xpos, int ypos, double speed) {
		switch (name) {
			case "CAR_LEFT_1":
				return new Car(ActorImages.IMG_CAR_LEFT_1, 3, 3, xpos, ypos, speed);
			case "CAR_RIGHT_1":
				return new Car(ActorImages.IMG_CAR_RIGHT_1, 3, 3, xpos, ypos, speed);
			default:
				return null;
		}
	}

}
