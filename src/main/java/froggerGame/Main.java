package froggerGame;

import java.io.IOException;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import froggerGame.models.World;
import froggerGame.models.Digit;
import froggerGame.models.Player;




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
}
