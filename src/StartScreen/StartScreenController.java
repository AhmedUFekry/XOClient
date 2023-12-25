/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StartScreen;

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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import xoclient.Navigate;


/**
=======
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import xoclient.Navigate;

/**
 * FXML Controller class
>>>>>>> rwan
 *
 * @author Rwan el matry
 */
public class StartScreenController implements Initializable {
    
    private Label label;
    private String serverData;

    @FXML
    private Button singleButton;

    @FXML
    private Button dualButton;
    @FXML
    private Button onlButton;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Button displayRecordedGamesbtn;

    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    


    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        BackgroundImage background = ExtraComponent.setBackgroundImg("/Icons/up_1.png");
       // BackgroundImage background = ExtraComponent.setBackgroundImg("/Icons/s.jpg");
        rootPane.setBackground(new Background(background));
    }    

    
    @FXML
    private void goToChooseLevelScreen(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader (getClass().getResource("/ChooseLevelScreen/ChooseLevelScreen.fxml"));
         Parent root = loader.load();
         Navigate.navigateTo(root, event);
    }

    @FXML
    private void goToEntrePlayerName(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader (getClass().getResource("/EnterNameScreen/EnterPlayerNamesScreen.fxml")) ;
        Parent root = loader.load();
        Navigate.navigateTo(root, event);
    }

    @FXML
    private void goToLogIn(ActionEvent event) throws IOException {
        serverData = ExtraComponent.openDialog("Server Connection", "Enter the server Data");
        if (serverData != null && serverData.length() != 0) {
            System.out.println("Entered data: " + serverData);
            FXMLLoader loader = new FXMLLoader (getClass().getResource("/LoginScreen/LoginScreen.fxml")) ;
            Parent root = loader.load();
            Navigate.navigateTo(root, event);
        }
        /*else if(serverData.length() == 0){
            Alert alert = ExtraComponent.showAlertChooseSymbol(Alert.AlertType.ERROR, "Error", "Can't Connect to the server");
            alert.show(); 
        }*/
        
        
      
       
    }
 /*   public void getServerData(String server){
        serverData = server;
    }*/

    @FXML
    private void displayRecordedGamesbtn(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader (getClass().getResource("/RecordScreen/RecordsScreen.fxml")) ;
          Parent root = loader.load();
          Navigate.navigateTo(root, event);
    }
}
