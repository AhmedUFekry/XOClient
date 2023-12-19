/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProfileScreen;

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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import xoclient.Navigate;

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
    @FXML
    private BorderPane rootPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        BackgroundImage background = ExtraComponent.setBackgroundImg("/Icons/back.jpg");
        rootPane.setBackground(new Background(background));
    }    

    @FXML
    private void goBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/OnlineListScreen/OnlineListScreen.fxml")) ;
          Parent root = loader.load();
          Navigate.navigateTo(root, event);
    }

    @FXML
    private void displayRecordOnline(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader (getClass().getResource("/OnlineListScreen/OnlineListScreen.fxml")) ;
          Parent root = loader.load();
          Navigate.navigateTo(root, event);
    }
}
