/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StartScreen;

import ClientServer.Client;
import ExtraComponent.ExtraComponent;
import NetworkManager.NetworkManager;
import java.io.IOException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
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
    private String serverData = null;

    @FXML
    private Button singleButton;

    @FXML
    private Button dualButton;
    @FXML
    private Button onlButton;
    @FXML
    private AnchorPane rootPane;

    
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
    private void goToLogIn(ActionEvent event){
        serverData = ExtraComponent.openDialog("Server Connection", "Enter the server Data");
        if (serverData != null && !serverData.isEmpty()) {
            try {
                System.out.println("Entered data: " + serverData);
                // Client client = new Client();
                NetworkManager.setIpServer(serverData);
                // Use CompletableFuture for handling the asynchronous result
                CompletableFuture<String> resultFuture = new CompletableFuture<>();
                // Set the callback for the result
                resultFuture.whenComplete((result, exception)-> {
                    Platform.runLater(() -> {
                        if(exception != null){
                            Alert alert = ExtraComponent.showAlertChooseSymbol(Alert.AlertType.ERROR, "Error", exception.getMessage());
                            alert.show();
                        }else{
                            if ("connected successfully".equals(result)) {
                                try {
                                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/LoginScreen/LoginScreen.fxml"));
                                    Parent root = loader.load();
                                    Navigate.navigateTo(root, event);
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            } else {
                                // Handle start connect to the server failure
                                System.out.println("cant connect tot the server" + result);
                                Alert alert = ExtraComponent.showAlertChooseSymbol(Alert.AlertType.ERROR, "Error", "Can not connect to the server");
                                alert.show();
                            }
                        }});
                });
                // Use the client from the NetworkManager
                Client client = NetworkManager.getClient();
                client.setSendDataToServer("start");
                client.setCallback(resultFuture);
            } catch (UnknownHostException ex) {
               // ex.printStackTrace();
                Alert alert = ExtraComponent.showAlertChooseSymbol(Alert.AlertType.ERROR, "Error", "Unknown Host Exception: Enter the correct IP.");
                alert.show();
            }
        }else if (serverData == null) {
            System.out.println("dialog is closed");
        }else if(serverData.isEmpty() ){
            Alert alert = ExtraComponent.showAlertChooseSymbol(Alert.AlertType.ERROR, "Error", "please enter the server ip");
            alert.show(); 
        }
    }
}
