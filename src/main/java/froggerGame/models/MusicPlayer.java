package froggerGame.models;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicPlayer {
	private MediaPlayer mediaPlayer;

	
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
