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
		
		background.add(new Log(ActorImages.IMG_LOG_3, 150, 0, 166,  0.75)); 
		background.add(new Log(ActorImages.IMG_LOG_3, 150, 220, 166,  0.75));
		background.add(new Log(ActorImages.IMG_LOG_3, 150, 440, 166,  0.75));

		background.add(new Log(ActorImages.IMG_LOG_1, 300, 0, 276, -2));
		background.add(new Log(ActorImages.IMG_LOG_1, 300, 400, 276, -2));
		
		background.add(new Log(ActorImages.IMG_LOG_3, 150, 50, 329, 0.75));
		background.add(new Log(ActorImages.IMG_LOG_3, 150, 270, 329, 0.75));
		background.add(new Log(ActorImages.IMG_LOG_3, 150, 490, 329, 0.75));
		
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
		background.add(new Truck(ActorImages.IMG_TRUCK_RIGHT_1, 120, 120,  0, 649, 1));
		background.add(new Truck(ActorImages.IMG_TRUCK_RIGHT_1, 120, 120, 300, 649, 1));
		background.add(new Truck(ActorImages.IMG_TRUCK_RIGHT_1, 120, 120, 600, 649, 1));
		background.add(new Car(ActorImages.IMG_CAR_LEFT_1, 50, 50,  100, 597, -1));
		background.add(new Car(ActorImages.IMG_CAR_LEFT_1, 50, 50, 250, 597, -1));
		background.add(new Car(ActorImages.IMG_CAR_LEFT_1, 50, 50, 400, 597, -1));
		background.add(new Car(ActorImages.IMG_CAR_LEFT_1, 50, 50,550, 597, -1));
		background.add(new Truck(ActorImages.IMG_TRUCK_RIGHT_2, 200, 200, 0, 540, 1));
		background.add(new Truck(ActorImages.IMG_TRUCK_RIGHT_2, 200, 200, 500, 540, 1));
		background.add(new Car(ActorImages.IMG_CAR_LEFT_1, 50, 50, 500, 490, -5));
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
