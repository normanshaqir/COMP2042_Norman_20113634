import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;


import models.Digit;
import models.Player;
import models.World;




public class Main extends Application {
	AnimationTimer timer;
	World background = new World();
	Scene scene  = new Scene(background, 600, 800);
	Player player = Player.getInstance();
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override 
	public void start(Stage primaryStage) throws Exception { // Stage -> Scene -> Scene Graph. Stage is the window/container for a scene.
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/mainMenu.fxml"));
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Frogger");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		// TODO:
//		EasyLevel1 test = new EasyLevel1();
//		test.spawnActors();
//		test.startGame(primaryStage);
		
		
//	    MusicPlayer Music = new MusicPlayer();
//	    Music.playMusic();
//	    EasyLevel1 test = new EasyLevel1();
//	    test.spawnActors();
//	    test.startGame(primaryStage);
		
	    
//	    HighScoreManager hm = new HighScoreManager();
//        hm.addScore("Astaga",player.getPoints());
//        hm.addScore("Marge",300);
//        hm.addScore("Maggie",220);
//        hm.addScore("Homer",100);
//        hm.addScore("Lisa",270);

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
	
	public void startGame(Stage primaryStage) {
		background.start();
		primaryStage.setScene(scene);
		primaryStage.show();
		start();
	}
	
	public void start() { // start music embedded in stage(mediaplayer), starts AnimationTimer for score
    	createTimer();
        timer.start();
    }
}
