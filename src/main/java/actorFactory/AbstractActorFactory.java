package actorFactory;

import models.Actor;

public interface AbstractActorFactory {
	Actor createActor(String name, int w, int h, int xpos, int ypos, double speed);
	
}
