package froggerGame.actorFactory;

import froggerGame.models.actors.Actor;

public interface AbstractActorFactory {
	Actor createActor(String name, int w, int h, int xpos, int ypos, double speed);
	
}
