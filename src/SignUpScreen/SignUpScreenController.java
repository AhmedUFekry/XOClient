/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SignUpScreen;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import xoclient.Navigate;

/**
 * FXML Controller class
 *
 * @author Ahmed Fekry
 */
public class SignUpScreenController implements Initializable {

    @FXML
    private TextField userNameTxtfield;
    @FXML
    private TextField emailTxtfield;
    @FXML
    private RadioButton maleRadiobtn;
    @FXML
    private RadioButton femaleRadiobtn;
    @FXML
    private Button signInBtn;
    @FXML
    private Button signUpBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void signInMethod(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/LoginScreen/LoginScreen.fxml"));
          Parent root = loader.load();
          Navigate.navigateTo(root, event);
    }

    @FXML
    private void signUpMethod(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/OnlineListScreen/OnlineListScreen.fxml"));
          Parent root = loader.load();
          Navigate.navigateTo(root, event);
    }
}
