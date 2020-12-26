package froggerGame.controllers;

import java.io.IOException;

import froggerGame.models.actors.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
/**
 * <h1>gameOverScreenController</h1>
 * <p>
 * The {@code gameOverScreenController} serves as the controller for the userScreen fxml view. It uses the data
 * stored by the {@code HighScoreManager} and updates the text label on the screen to reflect the score the player
 * got.
 * </p>
 * 
 * @see froggerGame.controllers
 * @see froggerGame.highScore
 * @author hfyns3
 *
 */

public class gameOverScreenController {

    @FXML
    private Button backButton;

    @FXML
    private Button quitButton;

    @FXML
    private Label scoreLabel;
    
    @FXML
    void initialize() {
        scoreLabel.setText(Integer.toString(Player.getPoints()));
    }
    /**
     * When quit button is pressed, the game will exit.
    * @param event -- any event that can be listened and handled
     * @throws IOException -- thrown in the case of any I/O exceptions
	 */
    
    public void handleQuitButtonPressed(ActionEvent event) throws IOException {
    	System.exit(0);
    }
}
