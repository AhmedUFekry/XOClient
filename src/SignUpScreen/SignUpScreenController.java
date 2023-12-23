/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SignUpScreen;

import ClientServer.Client;
import ExtraComponent.ExtraComponent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import xoclient.Navigate;

/**
 * FXML Controller class
 *
 * @author Ahmed Fekry
 */
public class SignUpScreenController implements Initializable {

    @FXML
    public TextField userNameTxtfield;
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
    @FXML
    private BorderPane rootPane;
    @FXML
    private PasswordField pass;
    @FXML
    private PasswordField conPass;
    Socket server;
     DataInputStream dis;
    DataOutputStream dos;
    PrintStream ps;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        BackgroundImage background = ExtraComponent.setBackgroundImg("/Icons/hi.jpeg");
        rootPane.setBackground(new Background(background));
    }    

    @FXML
    private void signInMethod(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/LoginScreen/LoginScreen.fxml"));
          Parent root = loader.load();
          Navigate.navigateTo(root, event);
    }

    @FXML
    public void signUpMethod(ActionEvent event) throws IOException {
       if(isValidate()){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/OnlineListScreen/OnlineListScreen.fxml"));
          Parent root = loader.load();
         
               //sendToServer(player);
               Navigate.navigateTo(root, event);
              
          
          }
       
          DTOPlayerData player =new DTOPlayerData();
    player.setUserName(userNameTxtfield.getText());
   
   // player.setEmaiL(controller.emailTxtfield.getText());
    player.setPassword(pass.getText());
  
    player.setIsMale(false);
  
    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.create();
    // sendToServer();
    System.out.println(gson.toJson(player));
    System.out .println("connection to server done");

       
    
    }
       private void sendToServer(String data) {
        // Create an instance of the Client class
        Client client = new Client();

        // Set the output data to be sent to the server
        client.setOut(data);

        // Start the thread to establish connection and send data
        client.start();
       }
    private Boolean isValidate(){
         if( userNameTxtfield.getText().length()==0||emailTxtfield.getText().length()==0|| pass.getText().length()==0||conPass.getText().length()==0){
         
            if( userNameTxtfield.getText().length()==0){
             userNameTxtfield.setStyle("-fx-border-color:red ;-fx-border-width:1px");
              userNameTxtfield.setPromptText("you should entre valid username");
            }
            
              else {
              userNameTxtfield.setStyle("-fx-border-color: ; -fx-border-width: ");
                      }
            
            
            if( emailTxtfield.getText().length()==0){
             emailTxtfield.setStyle("-fx-border-color:red ;-fx-border-width:1px");
              emailTxtfield.setPromptText("you should entre valid email");
            }
             else{
              emailTxtfield.setStyle("-fx-border-color: ; -fx-border-width: ");
                      }
            if(  pass.getText().length()==0){
              pass.setStyle("-fx-border-color:red ; -fx-border-width:1px");
               pass.setPromptText("you should entre valid password");
            }
            else{
              pass.setStyle("-fx-border-color: ; -fx-border-width: ");
                      }
             if( conPass.getText().length()==0){
              conPass.setStyle("-fx-border-color:red ; -fx-border-width:1px");
               conPass.setPromptText("you should entre match password");
            }
              else{
              conPass.setStyle("-fx-border-color:; -fx-border-width: ");
                      }
         
          return false;
                 }
         return true;
       
    }
       

}
    
    
    

    


