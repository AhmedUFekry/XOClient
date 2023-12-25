/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginScreen;

import ExtraComponent.ExtraComponent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import xoclient.Navigate;

/**
 * FXML Controller class
 *
 * @author Ahmed Fekry
 */
public class LoginScreenController implements Initializable {

    @FXML
    private Button backBtn1;
    @FXML
    private TextField txtFieldPlayerName;
    @FXML
    private PasswordField txtFieldPassword;
    @FXML
    private Button signInBtn;
    @FXML
    private Button signOutBtn;
    @FXML
    private Pane rootPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        BackgroundImage background = ExtraComponent.setBackgroundImg("/Icons/up.png");
        rootPane.setBackground(new Background(background));
    }    

    @FXML
    private void goBackBtn(ActionEvent event) throws IOException {
         System.out.println("Back");
        FXMLLoader loader = new FXMLLoader (getClass().getResource("/StartScreen/StartScreen.fxml")) ;
         Parent root = loader.load();
         Navigate.navigateTo(root, event);
    }

    @FXML
    private void signIn(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader (getClass().getResource("/OnlineListScreen/OnlineListScreen.fxml")) ;
          Parent root = loader.load();
          Navigate.navigateTo(root, event);
        
    }

    @FXML
    private void signUptMethod(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader (getClass().getResource("/SignUpScreen/SignUpScreen.fxml")) ;
          Parent root = loader.load();
          Navigate.navigateTo(root, event);
    }
    
}
