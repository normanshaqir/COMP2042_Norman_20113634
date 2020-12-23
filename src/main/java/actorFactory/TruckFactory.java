package actorFactory;

import actors.Actor;
import actors.Truck;
import constants.ActorImages;

public class TruckFactory implements AbstractActorFactory {
	
	@Override
	public Actor createActor(String name, int xpos, int ypos, double speed) {
		switch (name) {
			case "TRUCK_LEFT_1":
				return new Truck(ActorImages.IMG_TRUCK_LEFT_1, 3, 3, xpos, ypos, speed);
			case "TRUCK_LEFT_2":
				return new Truck(ActorImages.IMG_TRUCK_LEFT_2, 3, 3, xpos, ypos, speed);
			case "TRUCK_RIGHT_1":
				return new Truck(ActorImages.IMG_TRUCK_RIGHT_1, 3, 3, xpos, ypos, speed);
			case "TRUCK_RIGHT_2":
				return new Truck(ActorImages.IMG_TRUCK_LEFT_2, 3, 3, xpos, ypos ,speed);
			default:
				return null;
		}
	}
}
