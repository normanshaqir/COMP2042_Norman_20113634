package froggerGame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

import froggerGame.models.MusicPlayer;


public class Main extends Application {
	MusicPlayer mp = new MusicPlayer();
	private static Stage stage;
	public static void main(String[] args) {
		launch(args);
	}

	@Override 
	public void start(Stage primaryStage) throws Exception { // Stage -> Scene -> Scene Graph. Stage is the window/container for a scene.
		Main.stage = primaryStage;
			
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/mainMenu.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Frogger");
			primaryStage.setResizable(false);
			primaryStage.getIcons().add(new Image ("file:src/main/resources/misc/icons/frogger_favicon.png"));
			primaryStage.show();
			mp.playMusic();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public static Stage getStage() {
		return Main.stage;
	}

}
