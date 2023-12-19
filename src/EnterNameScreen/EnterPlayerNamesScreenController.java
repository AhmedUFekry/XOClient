/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnterNameScreen;

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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
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
    @FXML
    private Pane rootPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        BackgroundImage background = ExtraComponent.setBackgroundImg("/Icons/hi.jpeg");
        rootPane.setBackground(new Background(background));
    }    

    @FXML
    private void startTwoPlayergame(ActionEvent event) throws IOException {
        GameScreenController controller = new GameScreenController(4);
        FXMLLoader loader = new FXMLLoader (getClass().getResource("/GameScreen/GameScreen.fxml")) ;
        loader.setController(controller);
          Parent root = loader.load();
          controller.setPlayerNames(txtFieldPlayer1.getText(),txtFieldPlayer2.getText());
          //gameController.setMode(4);
        //GameScreenController.mode = 4;
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
