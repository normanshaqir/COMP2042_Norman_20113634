package froggerGame.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Node;

import froggerGame.models.levels.*;
/**
 * <h1>selectScreenController</h1>
 * <p>
 * This class serves to control the {@code selectScreen} fxml view which is shown to the player
 * when selecting levels/difficulties ranging from Easy to Insane.
 * 
 * Within each handle function, lies the same functionality -- that is to load the corresponding level in.
 * The abstract class {@code Level} holds the assigned level value, which are its subclasses.
 * </p>
 * @see froggerGame.models.levels
 * 
 * @author hfyns3
 *
 */

public class selectScreenController { 
	private Level difficultyLevel;
    @FXML
    /**
     * Assign {@code EasyLevel} to {@code Level}, demonstrating the OOP principle of inheritance.
     * @param event -- any event that can be handled
     */
    void handleEasyButtonPressed(ActionEvent event) {
    	Stage window = (Stage) (((Node)event.getSource()).getScene().getWindow());
    	difficultyLevel = new EasyLevel();
    	difficultyLevel.startGame(window);
    	
    }
    /**
     * Assign {@code Med} to {@code Level}, demonstrating the OOP principle of inheritance.
     * @param event -- any event that can be handled
     */
    @FXML
    void handleMediumButtonPressed(ActionEvent event) {
    	Stage window = (Stage) (((Node)event.getSource()).getScene().getWindow());
    	difficultyLevel = new MedLevel();
    	difficultyLevel.startGame(window);
    }
    /**
     * Assign {@code HardLevel} to {@code Level}, demonstrating the OOP principle of inheritance.
     * @param event -- any event that can be handled
     */
    @FXML
    void handleHardButtonPressed(ActionEvent event) {
    	Stage window = (Stage) (((Node)event.getSource()).getScene().getWindow());
    	difficultyLevel = new HardLevel();
    	difficultyLevel.startGame(window);
    }
    /**
     * Assign {@code InsaneLevel} to {@code Level}, demonstrating the OOP principle of inheritance.
     * @param event -- any event that can be listened and handled
     */
    @FXML
    void handleInsaneButtonPressed(ActionEvent event) {
    	Stage window = (Stage) (((Node)event.getSource()).getScene().getWindow());
    	difficultyLevel = new InsaneLevel();
    	difficultyLevel.startGame(window);
    }
}
