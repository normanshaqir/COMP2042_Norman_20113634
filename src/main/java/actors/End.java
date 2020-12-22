package actors;

import javafx.scene.image.Image;

import constants.*;


public class End extends Actor{
	private boolean activated = false;
	
	public End(int x, int y) {
		super(ActorImages.IMG_END, 60, 60, x, y); // hole
	}
	
	public void setEnd() {
		setImage(new Image(ActorImages.IMG_END_FROG, 70, 70, true, true)); // frog in hole
		activated = true;
	}
	
	public boolean isActivated() { // to enable collision for holes that already have frogs in them
		return activated;
	}
	

}
