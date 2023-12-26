/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SignUpScreen;

import ClientServer.Client;
import DTO.DTOPlayerData;
import DTO.DataOperation;
import ExtraComponent.ExtraComponent;
import LoginScreen.LoginScreenController;
import NetworkManager.NetworkManager;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
    private TextField userNameTxtfield;
    @FXML
    private TextField emailTxtfield;
    @FXML
    private RadioButton maleRadiobtn;
    @FXML
    private RadioButton femaleRadiobtn;
    @FXML
    private ToggleGroup genderToggleGroup;
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
    @FXML
    private TextField fullNameTxtfield;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        BackgroundImage background = ExtraComponent.setBackgroundImg("/Icons/hi.jpeg");
        rootPane.setBackground(new Background(background));
          // Create a ToggleGroup
        genderToggleGroup = new ToggleGroup();

        // Associate ToggleGroup with radio buttons
        maleRadiobtn.setToggleGroup(genderToggleGroup);
        femaleRadiobtn.setToggleGroup(genderToggleGroup);
        
    }    

    @FXML
    private void signInMethod(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/LoginScreen/LoginScreen.fxml"));
          Parent root = loader.load();
          Navigate.navigateTo(root, event);
    }

    @FXML
    private void signUpMethod(ActionEvent event) throws IOException {
        if(NetworkManager.isClientAlive()){
            if(isValidate()&&isPasswordMatched()){
               List<DTOPlayerData>playerList = new ArrayList<>();
                DTOPlayerData player =new DTOPlayerData();

            player.setFullName(fullNameTxtfield.getText());
            player.setUserName(userNameTxtfield.getText());

           player.setEmail(emailTxtfield.getText());
           player.setPassword(pass.getText());



        //player.setIsMale(false);
         player.setIsMale(maleRadiobtn.isSelected()); // Set true for male, false for female
        playerList.add(player);

        DataOperation operation = new DataOperation("sign up",playerList);
          GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        //Client client = new Client();
        System.out.println(gson.toJson(operation));
        //client.out(gson.toJson(operation));
         CompletableFuture<String> resultFuture = new CompletableFuture<>();
        System.out .println("connection to server done");
        //client.start();
       resultFuture.thenAccept(result->{
                     Platform.runLater(() ->{
                          if ("error".equals(result)){

                            userNameTxtfield.setStyle("-fx-border-color: red ; -fx-border-width:2px");
                            userNameTxtfield.setPromptText("Please Enter valid Password");
                            emailTxtfield.setStyle("-fx-border-color: red ; -fx-border-width:2px");
                            emailTxtfield.setPromptText("Please Enter valid UserName");
                            Alert alert = ExtraComponent.showAlertChooseSymbol(Alert.AlertType.ERROR, "Error", "This user is already exist");
                             alert.show();
                             System.out.println("cant sign up " + result);
                         }
                         else{
                              try {
                                  String playerName = result;
                                  System.out.println("Player name "+playerName);
                                  FXMLLoader loader = new FXMLLoader(getClass().getResource("/OnlineListScreen/OnlineListScreen.fxml"));
                                  Parent root = loader.load();
                                  //sendToServer(player);
                                  Navigate.navigateTo(root, event);
                              } catch (IOException ex) {
                                  Logger.getLogger(SignUpScreenController.class.getName()).log(Level.SEVERE, null, ex);
                              }
                          }
                     });
                });
              Client client = NetworkManager.getClient();
              client.setSendDataToServer(gson.toJson(operation));
              client.setCallback(resultFuture);
            }
            else{
                System.out.println("not vaildate");
            }
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
                 
  
    private Boolean isValidate(){
        
        
          if( fullNameTxtfield.getText().length()==0|| userNameTxtfield.getText().length()==0||emailTxtfield.getText().length()==0|| pass.getText().length()==0||conPass.getText().length()==0){
             
       
            if( fullNameTxtfield.getText().length()==0){
             fullNameTxtfield.setStyle("-fx-border-color:red ;-fx-border-width:1px");
              fullNameTxtfield.setPromptText("you should entre valid full name");
            }
            
              else {
              fullNameTxtfield.setStyle("-fx-border-color: ; -fx-border-width: ");
                      }
        
      
         
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
    private boolean isPasswordMatched(){
          if(!conPass.getText().equals(pass.getText()) ){
                   pass.setStyle("-fx-border-color:red ; -fx-border-width:1px");
                    conPass.setStyle("-fx-border-color:red ; -fx-border-width:1px");
             
              return false;
             }
           else{
                   pass.setStyle("-fx-border-color: ; -fx-border-width:");
                    conPass.setStyle("-fx-border-color: ; -fx-border-width:");
              return true;
           }
            
    
    }
    

       

}
