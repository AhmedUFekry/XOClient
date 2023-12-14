/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChooseLevelScreen;

import static com.sun.javafx.scene.control.skin.Utils.getResource;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import xoclient.Navigate;
import xoclient.Screens.GameScreenController;

/**
 * FXML Controller class
 *
 * @author Rwan el matry
 */
public class ChooseLevelScreenController implements Initializable {

    @FXML
    private AnchorPane midButton;
    @FXML
    private Button easyButton;
    @FXML
    private Button hardButton;
    @FXML
    private Button backBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goToGameEasy(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader (getClass ().getResource ("/GameScreen/GameScreen.fxml")) ;
Parent root = loader.load();
Navigate.navigateTo(root, event);
    }
    
}
