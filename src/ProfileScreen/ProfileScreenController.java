/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProfileScreen;

import DTO.DTOPlayerData;
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
import javafx.scene.image.Image;
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
    private Button showRecordsBtn;
    @FXML
    private BorderPane rootPane;
    private DTOPlayerData player;
    private int Draw;

    /**
     * Initializes the controller class.
     */
    public ProfileScreenController(DTOPlayerData player){
        this.player = player;
        
    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            BackgroundImage background = ExtraComponent.setBackgroundImg("/Icons/back.jpg");
            rootPane.setBackground(new Background(background));
            Draw =player.getTotalMatch()-(player.getLoseMAtch()+player.getWinMatch());
            txtUserName.setText(player.getUserName());
             totalMatchesLabel.setText(""+player.getTotalMatch());
            winLabel.setText(""+player.getWinMatch());
             loseLabel.setText(""+player.getLoseMAtch());
             drawLabel.setText(""+Draw);
             if(player.isIsMale())
                player2Img.setImage(new Image(getClass().getResource("/Icons/boy.png").toExternalForm()));
           else 
               player2Img.setImage(new Image(getClass().getResource("/Icons/girl.png").toExternalForm()));
        
                        
                      

           
    }
        @FXML
        private void goBack(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/OnlineListScreen/OnlineListScreen.fxml")) ;
              Parent root = loader.load();
              Navigate.navigateTo(root, event);
        }
        private void updateUI(DTOPlayerData player) {
    // Update your UI elements with the received player data
    txtUserName.setText(player.getUserName());
    // Update other UI elements as needed
}


        
    }
