package froggerGame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import froggerGame.models.MusicPlayer;


public class Main extends Application {
	MusicPlayer mp = new MusicPlayer();
	static Stage window;
	public static void main(String[] args) {
		launch(args);
	}

	@Override 
	public void start(Stage primaryStage) throws Exception { // Stage -> Scene -> Scene Graph. Stage is the window/container for a scene.
		this.window = primaryStage;
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/mainMenu.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Frogger");
			primaryStage.setResizable(false);
			primaryStage.getIcons().add(new Image ("file:src/main/resources/misc/frogger_favicon.png"));
			mp.playMusic();
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
	
	public static Stage getStage() {
		return Main.window;
	}
}
