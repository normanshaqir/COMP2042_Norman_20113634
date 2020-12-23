package world;

import actors.Digit;
import actors.Player;
import highScore.HighScoreManager;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public abstract class Level { // factory design pattern
	AnimationTimer timer;
	World background = new World();
	Scene scene  = new Scene(background, 600, 800);
	Player player = Player.getInstance();
	
	public abstract void spawnActors();
	
	public void start() { // start music embedded in stage(mediaplayer), starts AnimationTimer for score
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
            		setNumber(player.getPoints());
            	}
            	if (player.getStop()) { // game over
            		System.out.print("STOP:");
            		//Music.stopMusic();
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
