/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StartScreen;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
=======
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import xoclient.Navigate;

/**
 * FXML Controller class
>>>>>>> rwan
 *
 * @author Rwan el matry
 */
public class StartScreenController implements Initializable {
    
    private Label label;
    @FXML
    private Button singButton;


    @FXML
    private Button singleButton;

    @FXML
    private Button dualButton;
    @FXML
    private Button onlButton;

    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    


    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML

    private void showChooseLevelScreen(ActionEvent event) {

    private void goToChooseLevelScreen(ActionEvent event) throws IOException {
           FXMLLoader loader = new FXMLLoader (getClass ().getResource ("/ChooseLevelScreen/ChooseLevelScreen.fxml")) ;
			Parent root = loader.load();
			Navigate.navigateTo(root, event);
    }

    @FXML
    private void goToEntrePlayerName(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader (getClass ().getResource ("/EntrePlayerNamesScreen/EntrePlayerNamesScreen.fxml")) ;
Parent root = loader.load();
Navigate.navigateTo(root, event);
    }

    @FXML
    private void goToLogIn(ActionEvent event) {

    }
    
}
