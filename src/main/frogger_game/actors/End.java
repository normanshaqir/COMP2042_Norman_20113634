package main.frogger_game.actors;


import javafx.scene.image.Image;

public class End extends Actor{
	private boolean activated = false;
	@Override
	public void act(long now) {
		// TODO Auto-generated method st
	}
	
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image(ActorImages.IMG_END, 60, 60, true, true)); // hole
	}
	
	public void setEnd() {
		setImage(new Image(ActorImages.IMG_END_FROG, 70, 70, true, true)); // frog in hole
		activated = true;
	}
	
	public boolean isActivated() { // to enable collision for holes that already have frogs in them
		return activated;
	}
	

}
