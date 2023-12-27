/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginScreen;

import ClientServer.Client;
import DTO.DTOPlayerData;
import DTO.DataOperation;
import ExtraComponent.ExtraComponent;
import NetworkManager.NetworkManager;
import OnlineListScreen.OnlineListScreenController;
import ProfileScreen.ProfileScreenController;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
         System.out.println("client" +NetworkManager.isClientAlive());
         if(NetworkManager.isClientAlive()){
         CompletableFuture<String> resultFuture = new CompletableFuture<>();
         resultFuture.thenAccept(result-> {
             Platform.runLater(()->{
                 if("client exit".equalsIgnoreCase(result)){
                     System.out.println(result);
                    try {
                        FXMLLoader loader = new FXMLLoader (getClass().getResource("/StartScreen/StartScreen.fxml")) ;
                        Parent root = loader.load();
                        Navigate.navigateTo(root, event);

                    } catch (IOException ex) {
                        Logger.getLogger(LoginScreenController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 }
             });
         });
        Client client = NetworkManager.getClient();
        client.setSendDataToServer("exit");
        client.setCallback(resultFuture);
        System.out.println("client after" +NetworkManager.isClientAlive());
         }else{
            try {
                FXMLLoader loader = new FXMLLoader (getClass().getResource("/StartScreen/StartScreen.fxml")) ;
                Parent root = loader.load();
                Navigate.navigateTo(root, event);
                } catch (IOException ex) {
                    Logger.getLogger(LoginScreenController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        System.out.println("client after" +NetworkManager.isClientAlive());

    }

    @FXML
    private void signIn(ActionEvent event){
        if(NetworkManager.isClientAlive()){
            if(isValidate()){
                List<DTOPlayerData> playerList = new ArrayList<>();
                DTOPlayerData player = new DTOPlayerData();
                player.setUserName(txtFieldPlayerName.getText());
                player.setPassword(txtFieldPassword.getText());
                playerList.add(player);
                DataOperation operation = new DataOperation("login", playerList);
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                System.out.println(gson.toJson(operation));
                 // Use CompletableFuture for handling the asynchronous result
                CompletableFuture<String> resultFuture = new CompletableFuture<>();
                 // Set the callback for the result
                 resultFuture.thenAccept(result->{
                     Platform.runLater(() ->{
                          if ("error".equals(result)){
                             txtFieldPassword.setStyle("-fx-border-color: red ; -fx-border-width:2px");
                             txtFieldPassword.setPromptText("Please Enter valid Password");
                             txtFieldPlayerName.setStyle("-fx-border-color: red ; -fx-border-width:2px");
                             txtFieldPlayerName.setPromptText("Please Enter valid UserName");
                            Alert alert = ExtraComponent.showAlertChooseSymbol(Alert.AlertType.ERROR, "Error", "The Username or Password is Invalid");
                             alert.show();
                             System.out.println("cant login " + result);
                         }else if ("user not found".equals(result)){
                             System.out.println("cant login " + result);
                             Alert alert = ExtraComponent.showAlertChooseSymbol(Alert.AlertType.ERROR, "Error", "User Name not found ");
                             alert.show();
                         }else{
                             String playerName = result;
                              System.out.println("Player name "+playerName);
                             try{
                                FXMLLoader loader = new FXMLLoader (getClass().getResource("/OnlineListScreen/OnlineListScreen.fxml")) ;
                                Parent root = loader.load();
                                Navigate.navigateTo(root, event);
                             }catch (IOException ex) {
                                ex.printStackTrace();
                            }
                         }
                     });
                });
              Client client = NetworkManager.getClient();
              client.setSendDataToServer(gson.toJson(operation));
              client.setCallback(resultFuture);
              System.out.println("client after " +NetworkManager.isClientAlive());
         }else{
            try {
                FXMLLoader loader = new FXMLLoader (getClass().getResource("/StartScreen/StartScreen.fxml")) ;
                Parent root = loader.load();
                Navigate.navigateTo(root, event);
                } catch (IOException ex) {
                    Logger.getLogger(LoginScreenController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    @FXML
    private void signUptMethod(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader (getClass().getResource("/SignUpScreen/SignUpScreen.fxml")) ;
          Parent root = loader.load();
          Navigate.navigateTo(root, event);
    }
    private Boolean isValidate(){
        if(txtFieldPassword.getText().isEmpty() || txtFieldPlayerName.getText().isEmpty()){
            if(txtFieldPlayerName.getText().isEmpty()){
                txtFieldPlayerName.setStyle("-fx-border-color: red ; -fx-border-width:2px");
                txtFieldPlayerName.setPromptText("Please Enter valid UserName");
            }else {
                // Reset the style and prompt text for txtFieldPlayerName
                txtFieldPlayerName.setStyle("-fx-border-color: ; -fx-border-width: ;");
                txtFieldPlayerName.setPromptText("");
        }
            if(txtFieldPassword.getText().isEmpty()){
                txtFieldPassword.setStyle("-fx-border-color: red ; -fx-border-width:2px");
                txtFieldPassword.setPromptText("Please Enter valid Password");
            }else {
                // Reset the style and prompt text for txtFieldPassword
                txtFieldPassword.setStyle("-fx-border-color: ; -fx-border-width: ;");
                txtFieldPassword.setPromptText("");
            }
            return false;
        }
        return true;
    }

}
