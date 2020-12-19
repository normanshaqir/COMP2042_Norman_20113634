package main.frogger_game.actors;

import java.util.ArrayList;

import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import main.frogger_game.world.*;
import main.frogger_game.actors.*;


public class Player extends Actor { // Animal.class aka Frogger (player) deals with animating the sprite, handling collision, and player score.
	private Image imgW1;
	private Image imgA1;
	private Image imgS1;
	private Image imgD1;
	private Image imgW2;
	private Image imgA2;
	private Image imgS2;
	private Image imgD2; // images to cycle through for animation
	
	private int points = 0;
	private int end = 0;
	private boolean second = false;
	private boolean noMove = false;
	private double movement = 13.3333333*2;
	private double movementX = 10.666666*2;
	private int imgSize = 40; // width and height of image - corresponds with hitbox as well
	private boolean carDeath = false;
	private boolean waterDeath = false;
	private boolean changeScore = false;
	private int carD = 0;
	private double w = 800;
	
	private ArrayList<End> inter = new ArrayList<End>();
	
	private static Player instance = new Player("file:src/main/resources/frogger/froggerUp.png");
	
	private Player (String imageLink) {
		setImage(new Image(imageLink, imgSize, imgSize, true, true));
		setX(300);
		setY(679.8+movement);
		imgW1 = new Image("file:src/main/resources/frogger/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:src/main/resources/frogger/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:src/main/resources/frogger/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:src/main/resources/frogger/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:src/main/resources/frogger/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:src/main/resources/frogger/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:src/main/resources/frogger/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:src/main/resources/frogger/froggerRightJump.png", imgSize, imgSize, true, true);
		
		// images to cycle through for animation
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){ // cycling through animations and handling movement and handling score
				if (noMove) {
					
				}
				else {
				if (second) {
					if (event.getCode() == KeyCode.W) {	  
		                move(0, -movement);
		                changeScore = false;
		                setImage(imgW1);
		                second = false;
		            }
		            else if (event.getCode() == KeyCode.A) {	            	
		            	 move(-movementX, 0);
		            	 setImage(imgA1);
		            	 second = false;
		            }
		            else if (event.getCode() == KeyCode.S) {	            	
		            	 move(0, movement);
		            	 setImage(imgS1);
		            	 second = false;
		            }
		            else if (event.getCode() == KeyCode.D) {	            	
		            	 move(movementX, 0);
		            	 setImage(imgD1);
		            	 second = false;
		            }
				}
				else if (event.getCode() == KeyCode.W) {	            	
	                move(0, -movement);
	                setImage(imgW2);
	                second = true;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	 move(-movementX, 0);
	            	 setImage(imgA2);
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	 move(0, movement);
	            	 setImage(imgS2);
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	 move(movementX, 0);
	            	 setImage(imgD2);
	            	 second = true;
	            }
	        }
			}
		});	
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (noMove) {}
				else {
				if (event.getCode() == KeyCode.W) {	  
					if (getY() < w) {
						changeScore = true;
						w = getY();
						points+=10;
					}
	                move(0, -movement);
	                setImage(imgW1);
	                second = false;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	 move(-movementX, 0);
	            	 setImage(imgA1);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	 move(0, movement);
	            	 setImage(imgS1);
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	 move(movementX, 0);
	            	 setImage(imgD1);
	            	 second = false;
	            }
	        }
			}
			
		});
	}
	
	public static Player getInstance() { // Singleton design pattern
		return instance;
		
	}
	
	@Override
	public void act(long now) {
		
		Image froggerDeath = new Image("file:src/main/resources/frogger/froggerUp.png", imgSize, imgSize, true, true);
		
		Image imgWaterDeath1 = new Image("file:src/main/resources/frogger/deathAnimations/waterdeath1.png", imgSize,imgSize, true, true);
		Image imgWaterDeath2 = new Image("file:src/main/resources/frogger/deathAnimations/waterdeath2.png", imgSize,imgSize, true, true);
		Image imgWaterDeath3 = new Image("file:src/main/resources/frogger/deathAnimations/waterdeath3.png", imgSize,imgSize, true, true);
		Image imgWaterDeath4 = new Image("file:src/main/resources/frogger/deathAnimations/waterdeath4.png", imgSize,imgSize, true, true);
		
		Image imgCarDeath1 = new Image("file:src/main/resources/obstacles/deathAnimations/cardeath1.png", imgSize, imgSize, true, true);
		Image imgCarDeath2 = new Image("file:src/main/resources/obstacles/deathAnimations/cardeath2.png", imgSize, imgSize, true, true);
		Image imgCarDeath3 = new Image("file:src/main/resources/obstacles/deathAnimations/cardeath3.png", imgSize, imgSize, true, true);
		
		if (getY()>734) { // prevents player from going out of y bounds
			//setX(300);
			//setY(679.8+movement);
			move(0, -movement);
		}
		if (getX()<0) { // prevents player from going out of bounds
			move(movement, 0);
		}
		if (carDeath) { // cycling through death animation when collide with car/truck
			noMove = true; // now determines how quickly animations are cycled through (higher = slower)
			if ((now)% 2 ==0) { //
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
				setX(300);
				setY(679.8+movement);
				carDeath = false;
				carD = 0;
				setImage(froggerDeath);
				noMove = false;
				
				if (points>50) {
					points-=50;
					changeScore = true; // if player dies, deduct score.
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
				setY(679.8+movement);
				waterDeath = false;
				carD = 0;
				setImage(froggerDeath);
				noMove = false;
				
				if (points>50) {
					points-=50;
					changeScore = true; // if player dies, deduct score.
				}
			}
			
		}
		
		if (getX()>600) { // prevents player from going out of X bounds
			move(-movement, 0);
		}
		if (getIntersectingObjects(Obstacle.class).size() >= 1) { // check for collision, if yes trigger carDeath animation and move to spawn
			carDeath = true;
		}
		if (getX() == 240 && getY() == 82) {
			stop = true;
		}
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) { // if player is on Log, move player alongside the Log
			if(getIntersectingObjects(Log.class).get(0).getLeft()) // check if Log is moving left or right
				move(getOneIntersectingObject(Log.class).getSpeed(),0); // move left
			else
				move(getOneIntersectingObject(Log.class).getSpeed(),0); // move right
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) { // if player is on Turtle, move player alongside the Turtle
			move(getOneIntersectingObject(Turtle.class).getSpeed(),0); // move left (all turtles move to the left)
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) { // similar to Turtle class, except for isSunk
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true; // trigger waterDeath if isSunk returns true
			} else {
				move(getOneIntersectingObject(WetTurtle.class).getSpeed(),0); // move left
			}
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			
			if (getIntersectingObjects(End.class).get(0).isActivated()) { // if player collides with frog in hole, deduct points
				end--;
				points-=50;
			}
			
			points+=50;
			changeScore = true;
			w=800;
			getIntersectingObjects(End.class).get(0).setEnd(); // put frog in hole
			end++; // increment end, end == 5 triggers game over screen
			setX(300);
			setY(679.8+movement); // move player back to spawn
		}
		else if (getY()<413){ // if player collides/falls into water
			waterDeath = true;
			//setX(300);
			//setY(679.8+movement);
		}
	}
	public boolean getStop() { // game over function, called when all five holes are filled with frogs
		return end==5;
	}
	
	public int getPoints() { // for use in displaying score
		return points;
	}
	
	public boolean changeScore() { // ?
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	

}
