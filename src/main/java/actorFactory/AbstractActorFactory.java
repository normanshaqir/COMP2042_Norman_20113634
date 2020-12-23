package actorFactory;

import actors.Actor;

public interface AbstractActorFactory {
	Actor createActor(String name, int xpos, int ypos, double speed);
}
