package froggerGame.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Node;

import froggerGame.models.levels.*;


public class selectScreenController { // TODO: implement different levels for different difficulties
	private Level difficultyLevel;
    @FXML
    void handleEasyButtonPressed(ActionEvent event) {
    	Stage window = (Stage) (((Node)event.getSource()).getScene().getWindow());
    	difficultyLevel = new EasyLevel();
    	difficultyLevel.startGame(window);

    }
    
    @FXML
    void handleMediumButtonPressed(ActionEvent event) {
    	Stage window = (Stage) (((Node)event.getSource()).getScene().getWindow());
    	difficultyLevel = new MedLevel();
    	difficultyLevel.startGame(window);
    }
    
    @FXML
    void handleHardButtonPressed(ActionEvent event) {
    	Stage window = (Stage) (((Node)event.getSource()).getScene().getWindow());
    	difficultyLevel = new HardLevel();
    	difficultyLevel.startGame(window);
    }

    @FXML
    void handleInsaneButtonPressed(ActionEvent event) {
    	Stage window = (Stage) (((Node)event.getSource()).getScene().getWindow());
    	difficultyLevel = new InsaneLevel();
    	difficultyLevel.startGame(window);
    }

    

    @FXML
    void initialize() {

    }
}
