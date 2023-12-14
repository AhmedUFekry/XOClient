/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginScreen;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goBackBtn(ActionEvent event) {
    }

    @FXML
    private void signInMethod(ActionEvent event) {
    }

    @FXML
    private void signoutMethod(ActionEvent event) {
    }
    
}
