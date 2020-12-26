package froggerGame.controllers;

import java.io.IOException;

import froggerGame.highScore.HighScoreManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * <h1>userScreenController</h1>
 * <p>
 * The {@code userScreenController} serves as the controller for the userScreen fxml view. It manages the
 * input of the player's username, as well as transfers the data inputted to the {@code HighScoreManager}, which then 
 * stores it for use later.
 * </p>
 * @see froggerGame.controllers
 * @author hfyns3
 *
 */
public class userScreenController {

    @FXML
    private TextField inputBox;
    /**
     * Returns the string value inputted by the player. If the player does not input a value, return "Unknown player".
     * @return username -- value to be stored in {@code HighScoreManager} name field
     */
	public String getInputText() {	
		if (inputBox.getText().equals("")) {
			return "Unknown player";
		} else {
			return inputBox.getText();
		}	
	}
    
	/**
	 * When the 'OK' button is pressed, call the static method {@code settName()} in the class {@code HighScoreManager}
	 * with the argument {@code getInputText()}; leading to the high score manager taking in either the player inputted
	 * string value or the string value "Unknown player"
	 * 
	 * Then, change the scene to the select screen, where the player can select their difficulty/level of play.
	 * 
	 * 
     * @param event -- any event that can be listened and handled
     * @throws IOException -- thrown in the case of any I/O exceptions
	 */
	
    @FXML
    void handleOKButtonPressed(ActionEvent event) throws IOException {
    	HighScoreManager.setName(getInputText());
    	Parent SelectScreenParent = FXMLLoader.load(getClass().getResource("/fxml/selectScreen.fxml"));
    	Scene SelectScreenScene = new Scene(SelectScreenParent);
    	
    	Stage window = (Stage) (((Node)event.getSource()).getScene().getWindow());
    	
    	window.setScene(SelectScreenScene);
    	window.show(); 
    }

}
