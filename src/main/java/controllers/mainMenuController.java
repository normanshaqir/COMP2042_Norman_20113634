package controllers;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class mainMenuController {
	
	private MediaPlayer mp;
    private boolean flag = false; // mute flag. flag == false indicates unmuted.
    
    @FXML
    private Button playButton;
    
    @FXML
    private Button infoButton;

    @FXML
    private Button quitButton;
    
    @FXML
    private Button highScoreButton;
    
    @FXML
    void handlePlayButtonPressed(ActionEvent event) throws IOException {
    	Parent userScreenParent = FXMLLoader.load(getClass().getResource("/fxml/userScreen.fxml"));
    	Scene userScreenScene = new Scene(userScreenParent);
    	
    	// retrieving the Stage information
    	Stage window = (Stage) (((Node)event.getSource()).getScene().getWindow());
    	
    	window.setScene(userScreenScene);
    	window.show();
    }
    
    @FXML
    void handleHighScoreButtonPressed(ActionEvent event) throws IOException {
        
    }
    
    @FXML
    void handleInfoButtonPressed(ActionEvent event) throws IOException {
    	Parent infoScreenParent = FXMLLoader.load(getClass().getResource("/fxml/infoScreen.fxml"));
    	Scene infoScreenScene = new Scene(infoScreenParent);
    	
    	// retrieving the Stage information
    	Stage window = (Stage) (((Node)event.getSource()).getScene().getWindow());
    	
    	window.setScene(infoScreenScene);
    	window.show();
    }

    @FXML
    void handleMuteButtonPressed(ActionEvent event) {
    	if (flag) { // flag == true -> muted.
    		flag = false;
    		mp.play();
    	}
    	else {
    		flag = true;
    		mp.stop();
    	}
    }

    @FXML
    void handleQuitButtonPressed(ActionEvent event) {
    	System.exit(0);
    }
    
    @FXML
    void initialize() {
        assert playButton != null : "fx:id=\"playButton\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert infoButton != null : "fx:id=\"helpButton\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert quitButton != null : "fx:id=\"quitButton\" was not injected: check your FXML file 'mainMenu.fxml'.";
        
        String path = "\\Users\\User\\eclipse-workspace\\Practice\\src\\application\\Frogger Main Song Theme (loop).mp3";  
        
        Media media = new Media(new File(path).toURI().toString());  
        
        mp = new MediaPlayer(media);
		mp.setCycleCount(MediaPlayer.INDEFINITE);
        mp.play();
        
    }
    


}
