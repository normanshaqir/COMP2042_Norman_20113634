package actors;

import java.util.ArrayList;


import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import constants.*;


public class Player extends MovingActor { // Animal.class aka Frogger (player) deals with animating the sprite, handling collision, and player score.
	private Image imgW1;
	private Image imgA1;
	private Image imgS1;
	private Image imgD1;
	
	private Image imgW2;
	private Image imgA2;
	private Image imgS2;
	private Image imgD2; // images to cycle through for animation
	
	private int points = 0;
	private int lives = 5;
	private int numberOfEndsActivated = 0;
	
	private boolean second = false;
	private boolean noMove = false;
	
	private static final double FROGGER_MOVEMENT_Y = 13.3333333*2;
	private static final double FROGGER_MOVEMENT_X = 10.666666*2;
	private static final int FROGGER_IMG_SIZE = 40; // width and height of image - corresponds with hitbox as well
	
	private static final int WATER = 413;
	
	private boolean carDeath = false;
	private boolean waterDeath = false;
	private boolean changeScore = false;
	
	private int carD = 0;
	private double distanceLeftTillEnd = 800;
	
	private ArrayList<End> inter;
	
	private static Player instance = new Player("file:src/main/resources/frogger/froggerUp.png");
	
	private Player (String filename) {
		super(filename, FROGGER_IMG_SIZE, FROGGER_IMG_SIZE, 300, (int) (679.8+FROGGER_MOVEMENT_Y));

		imgW1 = new Image(FroggerImages.IMG_FROGGER_UP, FROGGER_IMG_SIZE, FROGGER_IMG_SIZE, true, true);
		imgA1 = new Image(FroggerImages.IMG_FROGGER_LEFT, FROGGER_IMG_SIZE, FROGGER_IMG_SIZE, true, true);
		imgS1 = new Image(FroggerImages.IMG_FROGGER_DOWN, FROGGER_IMG_SIZE, FROGGER_IMG_SIZE, true, true);
		imgD1 = new Image(FroggerImages.IMG_FROGGER_RIGHT, FROGGER_IMG_SIZE, FROGGER_IMG_SIZE, true, true);
		
		imgW2 = new Image(FroggerImages.IMG_FROGGER_UP_MOVING, FROGGER_IMG_SIZE, FROGGER_IMG_SIZE, true, true);
		imgA2 = new Image(FroggerImages.IMG_FROGGER_LEFT_MOVING, FROGGER_IMG_SIZE, FROGGER_IMG_SIZE, true, true);
		imgS2 = new Image(FroggerImages.IMG_FROGGER_DOWN_MOVING, FROGGER_IMG_SIZE, FROGGER_IMG_SIZE, true, true);
		imgD2 = new Image(FroggerImages.IMG_FROGGER_RIGHT_MOVING, FROGGER_IMG_SIZE, FROGGER_IMG_SIZE, true, true);
		
		handleOnKeyPressed();
		handleOnKeyReleased();
	}
	
	@Override
	public void act(long now) {
		preventPlayerFromGoingOutOfBounds();
		handleCollisionWithMobs();
		handleDeathFlags(now);
		
		if (getLives() == 0) {
			System.exit(0);
		}
		
	}
	
	public void handleOnKeyPressed() {
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){ // cycling through animations and handling movement and handling score
				if (noMove) {
					
				}
				else {
				if (second) {
					if (event.getCode() == KeyCode.W) {	  
		                move(0, -FROGGER_MOVEMENT_Y);
		                changeScore = false;
		                setImage(imgW1);
		                second = false;
		            }
		            else if (event.getCode() == KeyCode.A) {	            	
		            	 move(-FROGGER_MOVEMENT_X, 0);
		            	 setImage(imgA1);
		            	 second = false;
		            }
		            else if (event.getCode() == KeyCode.S) {	            	
		            	 move(0, FROGGER_MOVEMENT_Y);
		            	 setImage(imgS1);
		            	 second = false;
		            }
		            else if (event.getCode() == KeyCode.D) {	            	
		            	 move(FROGGER_MOVEMENT_X, 0);
		            	 setImage(imgD1);
		            	 second = false;
		            }
				}
				else if (event.getCode() == KeyCode.W) {	            	
	                move(0, -FROGGER_MOVEMENT_Y);
	                setImage(imgW2);
	                second = true;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	 move(-FROGGER_MOVEMENT_X, 0);
	            	 setImage(imgA2);
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	 move(0, FROGGER_MOVEMENT_Y);
	            	 setImage(imgS2);
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	 move(FROGGER_MOVEMENT_X, 0);
	            	 setImage(imgD2);
	            	 second = true;
	            }
	        }
			}
		});	
	}
	
	public void handleOnKeyReleased() {
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (noMove) {}
				else {
				if (event.getCode() == KeyCode.W) {	  
					if (getY() < distanceLeftTillEnd) {
						changeScore = true;
						distanceLeftTillEnd = getY(); // ensures that player cannot get points by going back and forth
						points+=10;
					}
	                move(0, -FROGGER_MOVEMENT_Y);
	                setImage(imgW1);
	                second = false;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	 move(-FROGGER_MOVEMENT_X, 0);
	            	 setImage(imgA1);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	 move(0, FROGGER_MOVEMENT_Y);
	            	 setImage(imgS1);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	 move(FROGGER_MOVEMENT_X, 0);
	            	 setImage(imgD1);
	            	 second = false;
	            }
	        }
			}
			
		});
	}
	
	public void preventPlayerFromGoingOutOfBounds() {
		if (getY()>734) { // prevents player from going out of y bounds
			//setX(300);
			//setY(679.8+movement);
			move(0, -FROGGER_MOVEMENT_Y);
		}
		
		if (getX()<0) { // prevents player from going out of bounds
			move(FROGGER_MOVEMENT_Y, 0);
		}
		
		if (getX()>600) { // prevents player from going out of X bounds
			move(-FROGGER_MOVEMENT_Y, 0);
		}
	}
	
	public void handleCollisionWithMobs() {
		if (getIntersectingObjects(Obstacle.class).size() >= 1) { // check for collision, if yes trigger carDeath animation and move to spawn
			carDeath = true;
			
		}

		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) { // if player is on Log, move player alongside the Log
				move(getOneIntersectingObject(Log.class).getSpeed(),0); 
			
		}
		else if (getIntersectingObjects(DryTurtle.class).size() >= 1 && !noMove) { // if player is on Turtle, move player alongside the Turtle
			move(getOneIntersectingObject(DryTurtle.class).getSpeed(),0); // move left (all turtles move to the left)
			
		}
		else if (getIntersectingObjects(Crocodile.class).size() >= 1) {
			if (getOneIntersectingObject(Crocodile.class).isMouthOpen()) {
				waterDeath = true;
			} else {
				move(getOneIntersectingObject(Crocodile.class).getSpeed(), 0);
			}
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) { // similar to Turtle class, except for isSunk
			if (getOneIntersectingObject(WetTurtle.class).isSunk()) {
				waterDeath = true; // trigger waterDeath if isSunk returns true
				
			} else {
				move(getOneIntersectingObject(WetTurtle.class).getSpeed(), 0); // move left
				
			}
			
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class); // TODO: modify how score is updated. Currently returns a new ArrayList everytime.
			
			if (getOneIntersectingObject(End.class).isActivated()) { // if player collides with frog in hole, deduct points
				numberOfEndsActivated--;
				points-=50;
			}
			
			points+=50;
			changeScore = true;
			distanceLeftTillEnd = 800;
			
			getOneIntersectingObject(End.class).setEnd(); // put frog in hole
			numberOfEndsActivated++; // increment end, end == 5 triggers game over screen
			
			setX(300);
			setY(679.8+FROGGER_MOVEMENT_Y); // move player back to spawn
		}
		else if (getY()<WATER) { // if player collides/falls into water
			waterDeath = true;

		}
	}
	
	public void handleDeathFlags(long now) {
		Image froggerDeath = new Image("file:src/main/resources/frogger/froggerUp.png", FROGGER_IMG_SIZE, FROGGER_IMG_SIZE, true, true);
		
		Image imgWaterDeath1 = new Image(FroggerImages.IMG_FROGGER_WATER_DEATH_1, FROGGER_IMG_SIZE,FROGGER_IMG_SIZE, true, true);
		Image imgWaterDeath2 = new Image(FroggerImages.IMG_FROGGER_WATER_DEATH_2, FROGGER_IMG_SIZE,FROGGER_IMG_SIZE, true, true);
		Image imgWaterDeath3 = new Image(FroggerImages.IMG_FROGGER_WATER_DEATH_3, FROGGER_IMG_SIZE,FROGGER_IMG_SIZE, true, true);
		Image imgWaterDeath4 = new Image(FroggerImages.IMG_FROGGER_WATER_DEATH_4, FROGGER_IMG_SIZE,FROGGER_IMG_SIZE, true, true);
		
		Image imgCarDeath1 = new Image(FroggerImages.IMG_FROGGER_CAR_DEATH_1, FROGGER_IMG_SIZE, FROGGER_IMG_SIZE, true, true);
		Image imgCarDeath2 = new Image(FroggerImages.IMG_FROGGER_CAR_DEATH_2, FROGGER_IMG_SIZE, FROGGER_IMG_SIZE, true, true);
		Image imgCarDeath3 = new Image(FroggerImages.IMG_FROGGER_CAR_DEATH_3, FROGGER_IMG_SIZE, FROGGER_IMG_SIZE, true, true);
		
		if (carDeath) { // cycling through death animation when collide with car/truck		
			noMove = true; // now determines how quickly animations are cycled through (higher = slower)
			if ((now)% 11 ==0) { //
				carD++;
			}
			if (carD==1) {
				setImage(imgCarDeath1);
			}
			if (carD==2) {
				setImage(imgCarDeath2);
			}
			if (carD==3) {
				setImage(imgCarDeath3);
			}
			if (carD == 4) { // after three cycles of animation, move frogger back to spawn
				setImage(froggerDeath);
				setX(300);
				setY(679.8+FROGGER_MOVEMENT_Y);
				carDeath = false;
				carD = 0;
				
				noMove = false;
				
				if (points>50) {
					points-=50;
					changeScore = true; // if player dies, deduct score.
				}
				
				if (lives > 0) {
					lives--;
				}
			}
			
		} // now determines how quickly animations are cycled through (higher = slower)
		if (waterDeath) { // cycling through death animation when collide fall into water in second half 		
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(imgWaterDeath1);
			}
			if (carD==2) {
				setImage(imgWaterDeath2);
			}
			if (carD==3) {
				setImage(imgWaterDeath3);
			}
			if (carD == 4) {
				setImage(imgWaterDeath4);
			}
			if (carD == 5) { // after three cycles of animation, move frogger back to spawn
				setX(300);
				setY(679.8+FROGGER_MOVEMENT_Y);
				waterDeath = false;
				carD = 0;
				setImage(froggerDeath);
				noMove = false;
				
				if (points>50) {
					points-=50;
					changeScore = true; // if player dies, deduct score.
				}
				
				if (lives > 0) {
					lives--;
				}
			}
			
		}
	}
	
	public static Player getInstance() { // Singleton design pattern
		return instance;
	}
	
	public boolean getStop() { // game over function, called when all five holes are filled with frogs
		return numberOfEndsActivated == 5;
	}
	
	public int getPoints() { // for use in displaying score
		return points;
	}
	
	public boolean changeScore() { // get value of changeScore
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	
	public int getLives() {
		return lives;
	}	

}
