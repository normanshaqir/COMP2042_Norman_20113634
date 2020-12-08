package main.frogger_game.actors;

import javafx.scene.image.Image;

public class Turtle extends Actor{
	Image turtle1;
	Image turtle2;
	Image turtle3;
	private int speed;
	int i = 1;
	boolean bool = true;
	@Override
	public void act(long now) {

				if (now/900000000  % 3 ==0) {
					setImage(turtle2);
					
				}
				else if (now/900000000 % 3 == 1) {
					setImage(turtle1);
					
				}
				else if (now/900000000 %3 == 2) {
					setImage(turtle3);
					
				}
			
		move(speed , 0); // moves horizontally
		
		if (getX() > 600 && speed>0)
			setX(-200); // for turtles moving from left to right
		if (getX() < -75 && speed<0)
			setX(600); // for turtles moving from right to left
	}
	
	public Turtle(int xpos, int ypos, int s, int w, int h) { // on constructor call, create one instance of Turtle object
															// with images to cycle through for animation
		turtle1 = new Image("file:src/main/resources/turtles/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("file:src/main/resources/turtles/TurtleAnimation2.png", w, h, true, true);
		turtle3 = new Image("file:src/main/resources/turtles/TurtleAnimation3.png", w, h, true, true); 
		
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}
}
