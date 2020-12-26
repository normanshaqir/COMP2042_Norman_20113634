package froggerGame.models;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * <h1>MusicPlayer</h1>
 * <p>Previously before refactoring, the {@code MusicPlayer} class had 
 * been coupled with the now deprecated {@code MyStage} class which managed both
 * music and setting the stage for the game. 
 * 
 * The MyStage class has now been renamed to MusicPlayer and after some refactorings, serves to only play music.
 * </p>
 * 
 * 
 * @author hfyns3
 *
 */


public class MusicPlayer {
	private MediaPlayer mediaPlayer;
	/**
	 * Set file path to audio file
	 */
	private static final String MUSIC_FILE_PATH = "src/main/resources/misc/froggerMainThemeLoop.mp3";
	
	/**
	 * Initialise a MediaPlayer with the audio file path as an argument.
	 * The music will play until the game is closed.
	 */
	public void playMusic() {
		String musicFile = MUSIC_FILE_PATH;
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}	
	
	/**
	 * Stop playing the music
	 */
	
	public void stopMusic() {
		mediaPlayer.stop();
	}

}
