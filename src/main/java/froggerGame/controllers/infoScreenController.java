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
 * <h1>infoScreenController</h1>
 * <p> The infoScreenController serves to control the infoScreen fxml view, which is shown when the 
 * player clicks on the help button ('HOW TO PLAY'). There is only one functionality in this controller,
 * that is to return to the main menu when the player clicks on 'BACK'.
 * </p>
 * 
 * @author hfyns3
 *
 */
public class infoScreenController {
    @FXML
    private Button backButton;
    /**
     * When pressed, load the mainMenu. It detects the current stage that holds the scene and 
     * changes the scene to the infoScene after loading the fxml file in.
     * 
     * @param event -- any event that can be listened and handled
     * @throws IOException -- thrown in the case of any I/O exceptions
     */
    @FXML
    void handleBackButtonPressed(ActionEvent event) throws IOException {
    	Parent mainMenuParent = FXMLLoader.load(getClass().getResource("/fxml/mainMenu.fxml"));
    	Scene mainMenuScene = new Scene(mainMenuParent);
    	
    	// retrieving the Stage information
    	Stage window = (Stage) (((Node)event.getSource()).getScene().getWindow());
    	
    	window.setScene(mainMenuScene);
    	window.show();
    }

}
