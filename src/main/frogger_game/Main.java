package main.frogger_game;

import java.io.File;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import main.frogger_game.actors.*;
import main.frogger_game.world.*;

public class Main extends Application {
	AnimationTimer timer;
	MyStage background;
	Player player;
	public static void main(String[] args) {
		launch(args);
	}

	@Override 
	public void start(Stage primaryStage) throws Exception { // Stage -> Scene -> Scene Graph. Stage is the window/container for a scene.
	    background = new MyStage();
	    Scene scene  = new Scene(background,600,800);
	    
		BackgroundImage froggerback = new BackgroundImage("file:src/main/resources/misc/background.png");
	    
		background.add(froggerback);
		
		background.add(new Log("log3", 150, 0, 166, 1.5));
		background.add(new Log("log3", 150, 220, 166, 1.5));
		background.add(new Log("log3", 150, 440, 166, 1.5));

		background.add(new Log("log1", 300, 0, 276, -4));
		background.add(new Log("log1", 300, 400, 276, -4));
		
		background.add(new Log("log3", 150, 50, 329, 2));
		background.add(new Log("log3", 150, 270, 329, 2));
		background.add(new Log("log3", 150, 490, 329, 2));
		
		background.add(new Turtle(500, 376, -1, 130, 130));
		background.add(new Turtle(300, 376, -1, 130, 130)); // create two turtles that never submerge (dry turtles)
		
		background.add(new WetTurtle(700, 376, -1, 130, 130));
		background.add(new WetTurtle(600, 217, -1, 130, 130));
		background.add(new WetTurtle(400, 217, -1, 130, 130));
		background.add(new WetTurtle(200, 217, -1, 130, 130)); // create four turtles that submerge (wet turtles)

		background.add(new End(13,96)); // End represent the boxes at the end of the map
		background.add(new End(141,96));
		background.add(new End(141 + 141-13,96));
		background.add(new End(141 + 141-13+141-13+1,96));
		background.add(new End(141 + 141-13+141-13+141-13+3,96));
		player = Player.getInstance();
		background.add(player);
		background.add(new Obstacle("truck1Right", 0, 649, 1, 120, 120));
		background.add(new Obstacle("truck1Right", 300, 649, 1, 120, 120));
		background.add(new Obstacle("truck1Right", 600, 649, 1, 120, 120));
		background.add(new Obstacle("car1Left", 100, 597, -1, 50, 50));
		background.add(new Obstacle("car1Left", 250, 597, -1, 50, 50));
		background.add(new Obstacle("car1Left", 400, 597, -1, 50, 50));
		background.add(new Obstacle("car1Left", 550, 597, -1, 50, 50));
		background.add(new Obstacle("truck2Right", 0, 540, 1, 200, 200));
		background.add(new Obstacle("truck2Right", 500, 540, 1, 200, 200));
		background.add(new Obstacle("car1Left", 500, 490, -5, 50, 50));
		background.add(new Digit(0, 30, 360, 25));

		background.start();
		primaryStage.setScene(scene);
		primaryStage.show();
		start(); // calls playMusic() and createTimer() for music and score
	}
	public void createTimer() { // manages score. need animationtimer to increment score 
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (player.changeScore()) { // calls setNumber function to display score
            		setNumber(player.getPoints());
            	}
            	if (player.getStop()) { // game over
            		System.out.print("STOP:");
            		background.stopMusic();
            		stop();
            		background.stop(); 
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Your High Score: "+player.getPoints()+"!");
            		alert.setContentText("Highest Possible Score: 800");
            		alert.show();
            	}
            }
        };
    }
	public void start() { // start music embedded in stage(mediaplayer), starts AnimationTimer for score
		background.playMusic();
    	createTimer();
        timer.start();
    }

    public void stop() { // GAME END (stop animationtimer)
        timer.stop();
    }
    
    public void setNumber(int n) { // invokes Digit constructor to create a new image corresponding to current score (VISUAL)
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  background.add(new Digit(k, 30, 360 - shift, 25));
    		  shift+=30;
    		}
    }
}
