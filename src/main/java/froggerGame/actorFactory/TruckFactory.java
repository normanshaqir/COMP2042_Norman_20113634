package froggerGame.actorFactory;

import froggerGame.models.actors.Actor;
import froggerGame.models.actors.Truck;
import froggerGame.constants.ActorImages;

public class TruckFactory implements AbstractActorFactory {
	
	@Override
	public Actor createActor(String name, int w, int h, int xpos, int ypos, double speed) {
		switch (name) {
			case "IMG_TRUCK_LEFT_1":
				return new Truck(ActorImages.IMG_TRUCK_LEFT_1, w, h, xpos, ypos, speed);
			case "IMG_TRUCK_LEFT_2":
				return new Truck(ActorImages.IMG_TRUCK_LEFT_2, w, h, xpos, ypos, speed);
			case "IMG_TRUCK_RIGHT_1":
				return new Truck(ActorImages.IMG_TRUCK_RIGHT_1, w, h, xpos, ypos, speed);
			case "IMG_TRUCK_RIGHT_2":
				return new Truck(ActorImages.IMG_TRUCK_RIGHT_2, w, h, xpos, ypos ,speed);
			default:
				return null;
		}
	}
}
