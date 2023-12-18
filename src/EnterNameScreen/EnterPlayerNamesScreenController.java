/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnterNameScreen;

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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import xoclient.Navigate;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class EnterPlayerNamesScreenController implements Initializable {

    @FXML
    private Button backBtn;
    @FXML
    private Button btnStart;
    @FXML
    private TextField txtFieldPlayer1;
    @FXML
    private TextField txtFieldPlayer2;
    @FXML
    private ImageView backImg;
    @FXML
    private ImageView playImg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void startTwoPlayergame(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader (getClass().getResource("/GameScreen/GameScreen.fxml")) ;
          Parent root = loader.load();
          GameScreenController gameController =loader.getController();
          gameController.setPlayerNames(txtFieldPlayer1.getText(),txtFieldPlayer2.getText());
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
