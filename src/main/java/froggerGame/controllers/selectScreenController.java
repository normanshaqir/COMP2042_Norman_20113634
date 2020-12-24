package froggerGame.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Node;


import froggerGame.models.EasyLevel1;
import froggerGame.models.HardLevel1;
import froggerGame.models.InsaneLevel;
import froggerGame.models.Level;
import froggerGame.models.MedLevel1;

public class selectScreenController { // TODO: implement different levels for different difficulties
	private Level difficultyLevel;
    @FXML
    void handleEasyButtonPressed(ActionEvent event) {
    	Stage window = (Stage) (((Node)event.getSource()).getScene().getWindow());
    	difficultyLevel = new EasyLevel1();
    	difficultyLevel.spawnActors();
    	difficultyLevel.startGame(window);
		
    }
    
    @FXML
    void handleMediumButtonPressed(ActionEvent event) {
    	Stage window = (Stage) (((Node)event.getSource()).getScene().getWindow());
    	difficultyLevel = new MedLevel1();
    	difficultyLevel.spawnActors();
    	difficultyLevel.startGame(window);
    }
    
    @FXML
    void handleHardButtonPressed(ActionEvent event) {
    	Stage window = (Stage) (((Node)event.getSource()).getScene().getWindow());
    	difficultyLevel = new HardLevel1();
    	difficultyLevel.spawnActors();
    	difficultyLevel.startGame(window);
    }

    @FXML
    void handleInsaneButtonPressed(ActionEvent event) {
    	Stage window = (Stage) (((Node)event.getSource()).getScene().getWindow());
    	difficultyLevel = new InsaneLevel();
    	difficultyLevel.spawnActors();
    	difficultyLevel.startGame(window);
    }

    

    @FXML
    void initialize() {

    }
}
