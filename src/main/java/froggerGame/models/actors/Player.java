package froggerGame.models.actors;

import java.util.ArrayList;


import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import froggerGame.constants.*;


public class Player extends MovingActor { 
	private Image imgW1;
	private Image imgA1;
	private Image imgS1;
	private Image imgD1;
	
	private Image imgW2;
	private Image imgA2;
	private Image imgS2;
	private Image imgD2; 
	
	private int points = 0;
	private int lives = 5;
	private int numberOfEndsActivated = 0;
	
	private boolean second = false;
	private boolean noMove = false;
	
	/**
	 * Constant storing the value that the frog travels each step along the y-axis
	 */
	
	private static final double FROGGER_MOVEMENT_Y = 13.3333333*2;
	
	/**
	 * Constant storing the value that the frog travels each step along the x-axis
	 */
	
	private static final double FROGGER_MOVEMENT_X = 10.666666*2;
	
	/**
	 * Constant storing the dimensions of the frog
	 * 
	 */
	private static final int FROGGER_IMG_SIZE = 40; 
	
	/**
	 * Constant storing the value of the y-coordinate where there is water beyond
	 */
	
	private static final int WATER = 413;
	
	private boolean carDeath = false;
	private boolean waterDeath = false;
	private boolean changeScore = false;
	
	private int carD = 0;
	private double distanceLeftTillEnd = 800;
	
	private ArrayList<End> inter;
	
	private static Player instance = new Player();
	
	private Player () {
		super(FroggerImages.IMG_FROGGER_UP, FROGGER_IMG_SIZE, FROGGER_IMG_SIZE, 300, (int) (679.8+FROGGER_MOVEMENT_Y));

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
	
	/**
	 * Changes the image of the frog when a WASD key is pressed.
	 */
	
	public void handleOnKeyPressed() {
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){ // cycling through animations and handling movement and handling score
				if (noMove) {
					
				}
				else {
				if (second) {
					second = false;
					if (event.getCode() == KeyCode.W) {	  
		                move(0, -FROGGER_MOVEMENT_Y);
		                changeScore = false;
		                setImage(imgW1);
		                
		            }
		            else if (event.getCode() == KeyCode.A) {	            	
		            	 move(-FROGGER_MOVEMENT_X, 0);
		            	 setImage(imgA1);
		            	 
		            }
		            else if (event.getCode() == KeyCode.S) {	            	
		            	 move(0, FROGGER_MOVEMENT_Y);
		            	 setImage(imgS1);

		            }
		            else if (event.getCode() == KeyCode.D) {	            	
		            	 move(FROGGER_MOVEMENT_X, 0);
		            	 setImage(imgD1);

		            }
				} else {
					second = true;
					
					if (event.getCode() == KeyCode.W) {	            	
		                move(0, -FROGGER_MOVEMENT_Y);
		                setImage(imgW2);
		                
		            }
		            else if (event.getCode() == KeyCode.A) {	            	
		            	 move(-FROGGER_MOVEMENT_X, 0);
		            	 setImage(imgA2);

		            }
		            else if (event.getCode() == KeyCode.S) {	            	
		            	 move(0, FROGGER_MOVEMENT_Y);
		            	 setImage(imgS2);

		            }
		            else if (event.getCode() == KeyCode.D) {	            	
		            	 move(FROGGER_MOVEMENT_X, 0);
		            	 setImage(imgD2);

		            }
				}
				
				
	        }
			}
		});	
	}
	
	/**
	 * Changes the image of the frog when a WASD key is released, as well as modify a variable storing the 
	 * distance left till the frog reaches the end of the map. This variable is updated everytime the player 
	 * presses W, so as to ensure that the player does not earn double points if he goes forward and backward again and again.
	 * 
	 */
	
	public void handleOnKeyReleased() {
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (noMove) {}
				else {
				if (event.getCode() == KeyCode.W) {	  
					if (getY() < distanceLeftTillEnd) {
						changeScore = true;
						distanceLeftTillEnd = getY(); 
						points+=10;
					}
	                move(0, -FROGGER_MOVEMENT_Y);
	                setImage(imgW1);

	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	 move(-FROGGER_MOVEMENT_X, 0);
	            	 setImage(imgA1);

	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	 move(0, FROGGER_MOVEMENT_Y);
	            	 setImage(imgS1);

	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	 move(FROGGER_MOVEMENT_X, 0);
	            	 setImage(imgD1);

	            }
				second = false;
	        }
			}
			
		});
	}
	/**
	 * If the player tries to move out of the window, move the player back into the window.
	 */
	public void preventPlayerFromGoingOutOfBounds() {
		if (getY()>734) { 
			move(0, -FROGGER_MOVEMENT_Y);
		}
		
		if (getX()<0) { 
			move(FROGGER_MOVEMENT_Y, 0);
		}
		
		if (getX()>600) { 
			move(-FROGGER_MOVEMENT_Y, 0);
		}
	}
	
	/**
	 * Handle collision with different mobs. If the player is on a Log or a Turtle, dynamically move the player
	 * according to the speed of the Log/Turtle. 
	 * 
	 * If the player collides with an obstacle or falls into the water, set respective death flags to true.
	 * 
	 * If the player reaches the end of the map (hole), activate the hole reached and add points, and then respawn the player.
	 * 
	 * 
	 */
	
	public void handleCollisionWithMobs() {
		if (getIntersectingObjects(Obstacle.class).size() >= 1) { 
			carDeath = true;
			
		}

		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) { 
				move(getOneIntersectingObject(Log.class).getSpeed(),0); 
			
		}
		else if (getIntersectingObjects(DryTurtle.class).size() >= 1 && !noMove) { 
			move(getOneIntersectingObject(DryTurtle.class).getSpeed(),0); 
			
		}
		else if (getIntersectingObjects(Crocodile.class).size() >= 1) {
			if (getOneIntersectingObject(Crocodile.class).isMouthOpen()) {
				waterDeath = true;
			} else {
				move(getOneIntersectingObject(Crocodile.class).getSpeed(), 0);
			}
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) { 
			if (getOneIntersectingObject(WetTurtle.class).isSunk()) {
				waterDeath = true; 
				
			} else {
				move(getOneIntersectingObject(WetTurtle.class).getSpeed(), 0); 
				
			}
			
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class); // 
			
			if (getOneIntersectingObject(End.class).isActivated()) { 
				numberOfEndsActivated--;
				points-=50;
			}
			
			points+=50;
			changeScore = true;
			distanceLeftTillEnd = 800;
			
			getOneIntersectingObject(End.class).setEnd(); 
			numberOfEndsActivated++; 
			
			setX(300);
			setY(679.8+FROGGER_MOVEMENT_Y); 
		}
		else if (getY()< WATER) { 
			waterDeath = true;

		}
	}
	
	/**
	 * First, death animations are instantiated for use later. Then, if either waterDeath or
	 * carDeath flags are true cycle through death animations. 
	 * 
	 * At the end of each animation, set death flag back to false and respawn the player.
	 * 
	 * The {@code handledDeathFlags(now)} method is used in the Player's act method.
	 * @param now -- time in nanoseconds
	 */
	
	public void handleDeathFlags(long now) {
		Image froggerDeath = new Image(FroggerImages.IMG_FROGGER_UP, FROGGER_IMG_SIZE, FROGGER_IMG_SIZE, true, true);
		
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
			if (carD == 1) {
				setImage(imgCarDeath1);
			}
			if (carD == 2) {
				setImage(imgCarDeath2);
			}
			if (carD == 3) {
				setImage(imgCarDeath3);
			}
			if (carD == 4) { // after three cycles of animation, move frogger back to spawn
				carDeath = false;
				respawnPlayer();
			}
			
		} // now determines how quickly animations are cycled through (higher = slower)
		if (waterDeath) { // cycling through death animation when collide fall into water in second half 		
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD == 1) {
				setImage(imgWaterDeath1);
			}
			if (carD == 2) {
				setImage(imgWaterDeath2);
			}
			if (carD == 3) {
				setImage(imgWaterDeath3);
			}
			if (carD == 4) {
				setImage(imgWaterDeath4);
			}
			if (carD == 5) { // after three cycles of animation, move frogger back to spawn
				waterDeath = false;
				respawnPlayer();
			}
			
		}
	}
	
	/**
	 * Called to respawn (reset) player position to starting point. Also deduct points as well as lives.
	 */
	public void respawnPlayer() {
		setImage(imgW1);
		setX(300);
		setY(679.8+FROGGER_MOVEMENT_Y);
		carD = 0;
		
		noMove = false;
		
		if (points>50) {
			points-=50;
			changeScore = true; 
		}
		
		if (lives > 0) {
			lives--;
		}
	}
	
	/**
	 * Get the only instance of Player. If no instance exists, an instance will be instantiated. 
	 * Abides the Singleton design pattern.
	 * @return instance -- instance of Player
	 */
	
	public static Player getInstance() { // Singleton design pattern
		return instance;
	}
	
	/**
	 * Check if all five ends have been reached.
	 * @return true/false -- if true, all five ends have been reached.
	 */
	
	public boolean getStop() { // game over function, called when all five holes are filled with frogs
		return numberOfEndsActivated == 5;
	}
	
	/**
	 * Returns player's current score for printing
	 * @return points -- player's current score 
	 */
	
	public int getPoints() { // for use in displaying score
		return points;
	}
	
	/**
	 * Returns true if changeScore is true, and set changeScore to false.
	 * @return changeScore -- flag indicating to modify score shown real time
	 */
	
	public boolean changeScore() { // get value of changeScore
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	
	/**
	 * Check if the player died and return a boolean value.
	 * @return boolean
	 */
	
	public boolean didPlayerDie() {
		if (waterDeath || carDeath) {
			return true;
		}
		return false;
	}
	
	/**
	 * Returns the number of lives the player has left
	 * @return lives -- number of chances the player has left to complete the round
	 */
	
	public int getLives() {
		return lives;
	}	

}
