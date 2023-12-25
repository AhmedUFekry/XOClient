/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChooseLevelScreen;

import ExtraComponent.ExtraComponent;
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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
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
    private BorderPane rootPane;
    @FXML
    private Button btnBack1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        BackgroundImage background = ExtraComponent.setBackgroundImg("/Icons/choose.jpg");
        rootPane.setBackground(new Background(background));
    }    
    
    @FXML
    private void goToEasy(ActionEvent event) throws IOException {
        GameScreenController controller = new GameScreenController(1);
        FXMLLoader loader = new FXMLLoader (getClass().getResource("/GameScreen/GameScreen.fxml")) ;
        loader.setController(controller);
        Parent root = loader.load();
        // gameController.setMode(1);
        // GameScreenController.mode = 1;
        Navigate.navigateTo(root, event);
    }

    @FXML
    private void startMediumMode(ActionEvent event) throws IOException {
        GameScreenController controller = new GameScreenController(2);
        FXMLLoader loader = new FXMLLoader (getClass().getResource("/GameScreen/GameScreen.fxml")) ;
        loader.setController(controller);
        Parent root = loader.load();
        //  GameScreenController gameController =loader.getController();
        //    gameController.setMode(2);
        //GameScreenController.mode = 2;
        Navigate.navigateTo(root, event);  
    }

    @FXML
    private void startHardMode(ActionEvent event) throws IOException {
        GameScreenController controller = new GameScreenController(3);
        FXMLLoader loader = new FXMLLoader (getClass().getResource("/GameScreen/GameScreen.fxml")) ;
        loader.setController(controller);
          Parent root = loader.load();
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
