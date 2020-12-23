package actors;

import constants.ActorImages;
import javafx.scene.image.Image;

public class Crocodile extends MovingActor implements AnimatedActor {
	private Image crocodile1 = new Image(ActorImages.IMG_CROCODILE_1, getWidth(), getHeight(), true, true);
	private Image crocodile2 = new Image(ActorImages.IMG_CROCODILE_2, getWidth(), getHeight(), true, true);
	private Image crocodile3 = new Image(ActorImages.IMG_CROCODILE_3, getWidth(), getHeight(), true, true);
	
	private boolean mouthOpen = false;
	
	public Crocodile (int w, int h, int xpos, int ypos, double s) {
		super("file:src/main/resources/crocodiles/crocodile1.PNG", w, h, xpos, ypos, s);
	}


	@Override
	public void act(long now) {
		animateActor(now);
		move(getSpeed(), 0);
		despawnAndRespawnAnimActor();
		
		setRightDespawnPos(600);
		setLeftDespawnPos(-75);
		
		setRightRespawnPos(-200);
		setLeftRespawnPos(600);
		
	}
	
	@Override
	public void animateActor(long now) {
		mouthOpen = false;
		
		if (now/900000000  % 3 == 0) {
			setImage(crocodile1);
			
		}
		else if (now/900000000 % 3 == 1) {
			setImage(crocodile2);
			
		}
		else if (now/900000000 % 3 == 2) {
			setImage(crocodile3);
			mouthOpen = true;
			
		}
		
		
	}
	
	public boolean isMouthOpen() {
		return mouthOpen;
	}
}
