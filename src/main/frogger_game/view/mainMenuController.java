import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class mainMenuController {

    @FXML
    private Button playButton;

    @FXML
    private Button helpButton;

    @FXML
    private Button quitButton;

    @FXML
    private Button muteButton;
    
    @FXML
    void handlePlayGame(ActionEvent event) throws IOException {
    	Parent LevelOneParent = FXMLLoader.load(getClass().getResource("LevelOne.fxml"));
    	Scene LevelOneScene = new Scene(LevelOneParent);
    	
    	// retrieving the Stage information
    	Stage window = (Stage) (((Node)event.getSource()).getScene().getWindow());
    	
    	window.setScene(LevelOneScene);
    	window.show();
    }
    
    @FXML
    void handleHelpButton(ActionEvent event) {
    	
    }

    @FXML
    void handleMuteMusic(ActionEvent event) {

    }


    @FXML
    void handleQuitGame(ActionEvent event) {
    	System.exit(0);
    }
    
    
    @FXML
    void initialize() {
        assert playButton != null : "fx:id=\"playButton\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert helpButton != null : "fx:id=\"helpButton\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert quitButton != null : "fx:id=\"quitButton\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert muteButton != null : "fx:id=\"muteButton\" was not injected: check your FXML file 'mainMenu.fxml'.";
        
        MediaPl
    }

}
