/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Profile;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Ahmed Fekry
 */
public class ProfileScreenController implements Initializable {

    @FXML
    private ImageView player2Img;
    @FXML
    private Label txtUserName;
    @FXML
    private Button backBtn;
    @FXML
    private Label totalMatchesLabel;
    @FXML
    private Label winLabel;
    @FXML
    private Label drawLabel;
    @FXML
    private Label loseLabel;
    @FXML
    private Button showRecordsBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goBack(ActionEvent event) {
    }

    @FXML
    private void displayRecordOnline(ActionEvent event) {
    }
    
}
