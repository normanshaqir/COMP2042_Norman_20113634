package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Node;

import models.EasyLevel1;


public class selectScreenController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void handleEasyButtonPressed(ActionEvent event) {
    	Stage window = (Stage) (((Node)event.getSource()).getScene().getWindow());
		EasyLevel1 test = new EasyLevel1();
		test.spawnActors();
		test.startGame(window);
		
    }

    @FXML
    void handleHardButtonPressed(ActionEvent event) {

    }

    @FXML
    void handleInsaneButtonPressed(ActionEvent event) {

    }

    @FXML
    void handleMediumButtonPressed(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }
}
