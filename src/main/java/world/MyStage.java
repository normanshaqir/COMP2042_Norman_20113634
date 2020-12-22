package world;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class MyStage extends World {
	private MediaPlayer mediaPlayer;
	
	public MyStage() {
		
	}
	
	public void playMusic() {
		String musicFile = "src/main/resources/misc/Frogger Main Song Theme (loop).mp3"; 
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}	
	
	public void stopMusic() {
		mediaPlayer.stop();
	}

}