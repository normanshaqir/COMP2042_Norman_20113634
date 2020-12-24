package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class userScreenController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField inputBox;

    @FXML
    void handleOKButtonPressed(ActionEvent event) throws IOException {
    	Parent SelectScreenParent = FXMLLoader.load(getClass().getResource("/fxml/selectScreen.fxml"));
    	Scene SelectScreenScene = new Scene(SelectScreenParent);
    	
    	// retrieving the Stage information
    	Stage window = (Stage) (((Node)event.getSource()).getScene().getWindow());
    	
    	window.setScene(SelectScreenScene);
    	window.show();
    }

    @FXML
    void initialize() {
        assert inputBox != null : "fx:id=\"inputBox\" was not injected: check your FXML file 'nameScreen.fxml'.";

    }
}
