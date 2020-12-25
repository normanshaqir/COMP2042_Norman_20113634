package froggerGame.models.levels;

import froggerGame.Main;
import froggerGame.actorFactory.AbstractActorFactory;
import froggerGame.actorFactory.FactoryProducer;
import froggerGame.constants.ActorImages;

import froggerGame.highScore.HighScoreManager;
import froggerGame.models.World;
import froggerGame.models.actors.BackgroundImage;
import froggerGame.models.actors.Digit;
import froggerGame.models.actors.End;
import froggerGame.models.actors.Player;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public abstract class Level { // factory design pattern
	AnimationTimer timer;
	World background = new World();
	Scene scene  = new Scene(background, 600, 800);
	
	Player player = Player.getInstance();

	AbstractActorFactory LogFactory = FactoryProducer.getFactory("LOG");
	AbstractActorFactory CarFactory = FactoryProducer.getFactory("CAR");
	AbstractActorFactory TruckFactory = FactoryProducer.getFactory("TRUCK");
	
	public abstract void spawnActors();
	
	public Level nextLevel() {
		if (this instanceof EasyLevel) {
			return new MedLevel();
		}
		return null;
	}
	
	public void start() { // starts AnimationTimer connected to all actors and as well as createLevel().
    	createTimer();
        timer.start();

        
    }
	
	public void stop() { // GAME END (stop animationtimer)
		HighScoreManager hm = new HighScoreManager();
	    hm.addScore("Astaga",player.getPoints());
	    System.out.print(hm.getHighscoreString());
        timer.stop();
        
        
        
    }
	
	public void createTimer() { // manages score. need animationtimer to increment score 
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	
				if (player.changeScore()) { // calls setNumber function to display score
            		setScore(player.getPoints());
            	}
				if (player.didPlayerDie()) {
					setLives(player.getLives()-1);
				}
            	if (player.getStop()) { // game over
            		System.out.print("STOP:");
            		//Music.stopMusic();
            		stop();
            		background.stop(); 
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Your High Score: "+ player.getPoints()+"!");
            		alert.setContentText("Highest Possible Score: 800");
            		alert.show();

            		
            	}
            }
        };
    }
	
	public void setScore(int n) { // invokes Digit constructor to create a new image corresponding to current score (VISUAL)
    	int shift = 0;
    	
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  background.add(new Digit(k, 30, 360 - shift, 25));
    		  shift+=30;
    		}
    }
	
	public void setLives(int n) {
		background.add(new Digit(n, 30, 450, 45));
	}  
	
	public void startGame(Stage primaryStage) {
        createLevel();
		background.start(); // starts timer for world
		primaryStage.setScene(scene);
		primaryStage.show();
		start(); // starts timer for frog
	}
	
	public void createLevel() {
		BackgroundImage gameBackground = new BackgroundImage(ActorImages.IMG_LEVEL_BACKGROUND);
		background.add(gameBackground);
		spawnEnds();
		spawnScoreAndLives();
		spawnActors();
		
	}
	
	public void spawnEnds() {
		background.add(new End(13,96)); // End represent the boxes at the end of the map
		background.add(new End(141,96));
		background.add(new End(141 + 141-13,96));
		background.add(new End(141 + 141-13+141-13+1,96));
		background.add(new End(141 + 141-13+141-13+141-13+3,96));
	}
	
	public void spawnScoreAndLives() {
		background.add(new Digit(0, 30, 360, 25));
        background.add(new Digit(5, 30, 450, 45));
	}
}
