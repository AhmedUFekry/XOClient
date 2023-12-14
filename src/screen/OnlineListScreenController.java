/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screen;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author Geforce
 */
public class OnlineListScreenController implements Initializable {

    @FXML
    private Button logoutBtn;
    @FXML
    private Button profileBtn;
    @FXML
    private Button singlrModeBtn;
    @FXML
    private ListView<?> listView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void logoutMethod(ActionEvent event) {
    }

    @FXML
    private void goToProfileScreen(ActionEvent event) {
    }

    @FXML
    private void gotoSingleMode(ActionEvent event) {
    }
    
}
