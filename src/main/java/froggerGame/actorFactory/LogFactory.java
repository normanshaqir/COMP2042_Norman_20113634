package froggerGame.actorFactory;

import froggerGame.models.Actor;
import froggerGame.models.Log;
import froggerGame.constants.ActorImages;

public class LogFactory implements AbstractActorFactory {
	
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
