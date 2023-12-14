/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Ahmed Fekry
 */
public class SignUpScreenController implements Initializable {

    @FXML
    private TextField lNameTxtfield;
    @FXML
    private TextField fNameTxtfield;
    @FXML
    private TextField emailTxtfield;
    @FXML
    private PasswordField passwordTxtfield;
    @FXML
    private RadioButton maleRadiobtn;
    @FXML
    private RadioButton femaleRadiobtn;
    @FXML
    private Button createBtn;
    @FXML
    private Button loginBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
