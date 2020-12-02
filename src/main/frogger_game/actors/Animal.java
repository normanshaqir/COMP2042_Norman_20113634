package main.frogger_game.actors;

import java.util.ArrayList;

import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import main.frogger_game.world.*;


public class Animal extends Actor { // Animal.class aka Frogger (player) deals with animating the sprite, handling collision, and player score.
	Image imgW1;
	Image imgA1;
	Image imgS1;
	Image imgD1;
	Image imgW2;
	Image imgA2;
	Image imgS2;
	Image imgD2; // images to cycle through for animation
	int points = 0;
	int end = 0;
	private boolean second = false;
	boolean noMove = false;
	double movement = 13.3333333*2;
	double movementX = 10.666666*2;
	int imgSize = 40; // width and height of image - corresponds with hitbox as well
	boolean carDeath = false;
	boolean waterDeath = false;
	boolean stop = false;
	boolean changeScore = false;
	int carD = 0;
	double w = 800;
	ArrayList<End> inter = new ArrayList<End>();
	public Animal(String imageLink) {
		setImage(new Image(imageLink, imgSize, imgSize, true, true));
		setX(300);
		setY(679.8+movement);
		imgW1 = new Image("file:src/p4_group_8_repo/froggerUp.png", imgSize, imgSize, true, true);
		imgA1 = new Image("file:src/p4_group_8_repo/froggerLeft.png", imgSize, imgSize, true, true);
		imgS1 = new Image("file:src/p4_group_8_repo/froggerDown.png", imgSize, imgSize, true, true);
		imgD1 = new Image("file:src/p4_group_8_repo/froggerRight.png", imgSize, imgSize, true, true);
		imgW2 = new Image("file:src/p4_group_8_repo/froggerUpJump.png", imgSize, imgSize, true, true);
		imgA2 = new Image("file:src/p4_group_8_repo/froggerLeftJump.png", imgSize, imgSize, true, true);
		imgS2 = new Image("file:src/p4_group_8_repo/froggerDownJump.png", imgSize, imgSize, true, true);
		imgD2 = new Image("file:src/p4_group_8_repo/froggerRightJump.png", imgSize, imgSize, true, true); 
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
	
	@Override
	public void act(long now) {
		int bounds = 0;
		if (getY()<0 || getY()>734) { // prevents player from going out of bounds - moves player back to spawn point
			setX(300);
			setY(679.8+movement);
		}
		if (getX()<0) { // prevents player from going out of bounds
			move(movement*2, 0);
		}
		if (carDeath) { // cycling through death animation when collide with car/truck
			noMove = true; // now determines how quickly animations are cycled through (higher = slower)
			if ((now)% 2 ==0) { //
				carD++;
			}
			if (carD==1) {
				setImage(new Image("file:src/p4_group_8_repo/cardeath1.png", imgSize, imgSize, true, true));
			}
			if (carD==2) {
				setImage(new Image("file:src/p4_group_8_repo/cardeath2.png", imgSize, imgSize, true, true));
			}
			if (carD==3) {
				setImage(new Image("file:src/p4_group_8_repo/cardeath3.png", imgSize, imgSize, true, true));
			}
			if (carD == 4) { // after three cycles of animation, move frogger back to spawn
				setX(300);
				setY(679.8+movement);
				carDeath = false;
				carD = 0;
				setImage(new Image("file:src/p4_group_8_repo/froggerUp.png", imgSize, imgSize, true, true));
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
				setImage(new Image("file:src/p4_group_8_repo/waterdeath1.png", imgSize,imgSize , true, true));
			}
			if (carD==2) {
				setImage(new Image("file:src/p4_group_8_repo/waterdeath2.png", imgSize,imgSize , true, true));
			}
			if (carD==3) {
				setImage(new Image("file:src/p4_group_8_repo/waterdeath3.png", imgSize,imgSize , true, true));
			}
			if (carD == 4) {
				setImage(new Image("file:src/p4_group_8_repo/waterdeath4.png", imgSize,imgSize , true, true));
			}
			if (carD == 5) { // after three cycles of animation, move frogger back to spawn
				setX(300);
				setY(679.8+movement);
				waterDeath = false;
				carD = 0;
				setImage(new Image("file:src/p4_group_8_repo/froggerUp.png", imgSize, imgSize, true, true));
				noMove = false;
				
				if (points>50) {
					points-=50;
					changeScore = true; // if player dies, deduct score.
				}
			}
			
		}
		
		if (getX()>600) { // prevents player from going out of bounds
			move(-movement*2, 0);
		}
		if (getIntersectingObjects(Obstacle.class).size() >= 1) { // check for collision, if yes trigger carDeath animation and move to spawn
			carDeath = true;
		}
		if (getX() == 240 && getY() == 82) {
			stop = true;
		}
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) { // if player is on Log, move player alongside the Log
			if(getIntersectingObjects(Log.class).get(0).getLeft()) // check if Log is moving left or right
				move(-2,0); // move left
			else
				move (.75,0); // move right
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) { // if player is on Turtle, move player alongside the Turtle
			move(-1,0); // move left (all turtles move to the left)
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) { // similar to Turtle class, except for isSunk
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true; // trigger waterDeath if isSunk returns true
			} else {
				move(-1,0); // move left
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
