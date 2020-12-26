package froggerGame.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * <h1>mainMenuController</h1>
 * <p>
 * The main menu controller serves to handle the three events that can be made in the main menu,
 * which are when the play button is pressed, the info button is pressed, or the quit button is pressed.
 * 
 * When the play button is pressed, the scene will change to the userScreen, which asks for the user to
 * enter their name, which is to be used later on in the high score.
 * 
 * When the info button is pressed, the scene will change to the infoScreen. In infoScreen lies details on 
 * how to play the game, such as its mechanics and the win condition.
 * 
 * When the quit button is pressed, the program is simply closed.
 * </p>
 * @author hfyns3
 */

public class mainMenuController {
    @FXML
    private Button playButton;
    
    @FXML
    private Button infoButton;

    @FXML
    private Button quitButton;

    /**
     * When pressed, load the userScreen. It detects the current stage that holds the scene and 
     * changes the scene to the userScreen after loading the fxml file in.
     * 
     * @param event -- any event that can be listened and handled
     * @throws IOException -- thrown in the case of any I/O exceptions
     */
    @FXML
    void handlePlayButtonPressed(ActionEvent event) throws IOException {
    	Parent userScreenParent = FXMLLoader.load(getClass().getResource("/fxml/userScreen.fxml"));
    	Scene userScreenScene = new Scene(userScreenParent);
    	
    	Stage window = (Stage) (((Node)event.getSource()).getScene().getWindow());
    	
    	window.setScene(userScreenScene);
    	window.show();
    }
    /**
     * When pressed, load the infoScreen. It detects the current stage that holds the scene and 
     * changes the scene to the infoScene after loading the fxml file in.
     * 
     * @param event -- any event that can be listened and handled
     * @throws IOException -- thrown in the case of any I/O exceptions
     */
    @FXML
    void handleInfoButtonPressed(ActionEvent event) throws IOException {
    	Parent infoScreenParent = FXMLLoader.load(getClass().getResource("/fxml/infoScreen.fxml"));
    	Scene infoScreenScene = new Scene(infoScreenParent);
    	
    	Stage window = (Stage) (((Node)event.getSource()).getScene().getWindow());
    	
    	window.setScene(infoScreenScene);
    	window.show();
    	
    }
    /**
     * When pressed, exit the game.
     * 
     * @param event -- any event that can be listened and handled
     */
    @FXML
    void handleQuitButtonPressed(ActionEvent event) {
    	System.exit(0);
    }
}
