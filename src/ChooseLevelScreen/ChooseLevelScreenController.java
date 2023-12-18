/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChooseLevelScreen;

import GameScreen.GameScreenController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import xoclient.Navigate;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class ChooseLevelScreenController implements Initializable {

    @FXML
    private Button easyBtn;
    @FXML
    private Button mediamBtn;
    @FXML
    private Button hardBtn;
    @FXML
    private Button btnBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void goToEasy(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader (getClass().getResource("/GameScreen/GameScreen.fxml")) ;
          Parent root = loader.load();
          GameScreenController gameController =loader.getController();
          gameController.setMode(1);
          Navigate.navigateTo(root, event);
    }

    @FXML
    private void startMediumMode(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader (getClass().getResource("/GameScreen/GameScreen.fxml")) ;
          Parent root = loader.load();
          GameScreenController gameController =loader.getController();
          gameController.setMode(2);
          Navigate.navigateTo(root, event);
          
    }

    @FXML
    private void startHardMode(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader (getClass().getResource("/GameScreen/GameScreen.fxml")) ;
          Parent root = loader.load();
          GameScreenController gameController =loader.getController();
          gameController.setMode(3);
          Navigate.navigateTo(root, event);
          
    }

    @FXML
    private void goToHomeScreen(ActionEvent event) throws IOException {
        System.out.println("Back");
        FXMLLoader loader = new FXMLLoader (getClass().getResource("/StartScreen/StartScreen.fxml")) ;
         Parent root = loader.load();
         Navigate.navigateTo(root, event);
    }
}
