/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OnlineListScreen;

import ClientServer.Client;
import DTO.DTOPlayerData;
import DTO.DataOperation;
import ExtraComponent.ExtraComponent;
import GameScreen.GameScreenController;
import NetworkManager.NetworkManager;
import ProfileScreen.ProfileScreenController;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import xoclient.Navigate;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class OnlineListScreenController implements Initializable {

    @FXML
    private Button logoutBtn;
    @FXML
    private Button profileBtn;
    @FXML
    private Button singlrModeBtn;
    @FXML

    /*private ListView<String> listView;

    private ObservableList<String> items;

    private DTOPlayerData currentPlayer;
    public static String playerName;
    public List<DTOPlayerData> playerList;
    public List<String> availablePlayerNames;*/
    

    private ListView<DTOPlayerData> listView;
    
    VBox vb ;
   // private ObservableList<String> items;

   private DTOPlayerData currentPlayer;
   public static String playerName;
   public ObservableList<DTOPlayerData> availabLeList;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currentPlayer = new DTOPlayerData();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        CompletableFuture<String> resultFuture = new CompletableFuture<>();
        // Set the callback for the result
        resultFuture.thenAccept(result -> {
            Platform.runLater(() -> {
                if (result.equals("error")) {
                    Alert alert = ExtraComponent.showAlert(Alert.AlertType.ERROR, "Error", "The Username or Password is Invalid");
                    alert.show();
                    System.out.println("No available players " + result);
                } else {
                    java.lang.reflect.Type listType = new TypeToken<ArrayList<DTOPlayerData>>() {
                    }.getType();
                    List<DTOPlayerData> playerLists = gson.fromJson(result, listType);
                    //add availablePlayer to the list
                    availabLeList = FXCollections.observableArrayList(playerLists);
                    listView.setItems(availabLeList);
                    listView.setCellFactory((ListView<DTOPlayerData> param) -> new  CustomListCell());  
                    listView.setOnMouseClicked(event -> handleListViewClicked());
                }
            });
        });
        Client client = NetworkManager.getClient();
        client.setSendDataToServer("availableUsers");
        client.setCallback(resultFuture);
    }
    @FXML
    private void logoutMethod(ActionEvent event) throws IOException {
        System.out.println("Back");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/StartScreen/StartScreen.fxml"));
        Parent root = loader.load();
        Navigate.navigateTo(root, event);
    }

    @FXML
    private void goToProfileScreen(ActionEvent event) throws IOException {

        List<DTOPlayerData> playerList = new ArrayList<>();
        DTOPlayerData player = new DTOPlayerData();
        player.setUserName(playerName.trim());
        playerList.add(player);
        DataOperation operation = new DataOperation("profile", playerList);
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        System.out.println(gson.toJson(operation));
        CompletableFuture<String> resultFuture = new CompletableFuture<>();
         // Set the callback for the result
         resultFuture.thenAccept(result->{
             Platform.runLater(() ->{   
                 if(result.equals("error")){
                    Alert alert = ExtraComponent.showAlert(Alert.AlertType.ERROR, "Error", "The Username or Password is Invalid");
                     alert.show();
                     System.out.println("cant login " + result);
                }else {
                     try {
                            DTOPlayerData dataReceived = new Gson().fromJson(result, DTOPlayerData.class);
                            System.out.println("OnlineListScreen.OnlineListScreenController.goToProfileScreen()"+dataReceived.getPassword());
                            ProfileScreenController profile = new ProfileScreenController(dataReceived);
                            FXMLLoader loader = new FXMLLoader (getClass().getResource("/ProfileScreen/ProfileScreen.fxml")) ;
                             loader.setController(profile);
                              currentPlayer = dataReceived; 
                            // profile.setPlayerData(dataReceived);

                            Parent root = loader.load();
                            Navigate.navigateTo(root, event);
                        } catch (IOException ex) {
                         Logger.getLogger(OnlineListScreenController.class.getName()).log(Level.SEVERE, null, ex);
                     }

                 }
             });
         }
     );
      Client client = NetworkManager.getClient();
      client.setSendDataToServer(gson.toJson(operation));
      client.setCallback(resultFuture);
    }

    @FXML
    private void gotoSingleMode(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GameScreen/GameScreen.fxml"));
        Parent root = loader.load();
        Navigate.navigateTo(root, event);
    }
    //when playe select player to play with get the player data
    private void handleListViewClicked() {
       int item = listView.getSelectionModel().getSelectedIndex();
       if (item >= 0) {
            System.out.println("Selected user index is "+item);
            System.out.println("Selected user name is "+ availabLeList.get(item).getUserName());
            DTOPlayerData invitedPlayer = availabLeList.get(item); // get the selected user data
            System.out.println("current player "+currentPlayer);
            sendRequest(invitedPlayer);
       }
    }
    //
    private void sendRequest(DTOPlayerData invitedPlayer){
        currentPlayer.setUserName(playerName.trim());
        List<DTOPlayerData> playerList = Arrays.asList(currentPlayer, invitedPlayer);
        DataOperation request = new DataOperation("request",playerList);
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        System.out.println(gson.toJson(request));
        Client client = NetworkManager.getClient();
        CompletableFuture<String> resultFuture = new CompletableFuture<>();
        resultFuture.thenAccept(result->{
                 Platform.runLater(() ->{
                     System.out.println("response from server for request "+result);
                     if(result.equalsIgnoreCase("user invited")){
                         Alert alert = ExtraComponent.showAlert(Alert.AlertType.CONFIRMATION, "Request", "Request");
                         ButtonType acceptButton = new ButtonType("Accept", ButtonBar.ButtonData.OK_DONE);
                         ButtonType rejectButton = new ButtonType("Reject", ButtonBar.ButtonData.CANCEL_CLOSE);
                         alert.getButtonTypes().setAll(acceptButton, rejectButton);
                         Optional<ButtonType> resultButton = alert.showAndWait();
                         if (resultButton.isPresent()) {
                              if (resultButton.get() == acceptButton) {
                                 client.setSendDataToServer("start the game"); //send to the server start the game 
                                 System.out.println("User clicked Accept");
                        } else if (resultButton.get() == rejectButton) {
                            client.setSendDataToServer("rejected the game");
                             System.out.println("User clicked Reject");
                        }
                        }else {
                              System.out.println("User closed the alert without clicking a button");
                        }
                     }else if(result.equalsIgnoreCase("start the game")){ 
                         System.out.println(" start the game ");
                        /* try {
                            //if players accept to play together
                            GameScreenController controller = new GameScreenController(4);
                            FXMLLoader loader = new FXMLLoader (getClass().getResource("/GameScreen/GameScreen.fxml")) ;
                            loader.setController(controller);
                            Parent root = loader.load();
                            Navigate.navigateTo(root, event);
                            System.out.println(" start the game ");
                         } catch (IOException ex) {
                             Logger.getLogger(OnlineListScreenController.class.getName()).log(Level.SEVERE, null, ex);
                         }*/
                     }else if(result.equalsIgnoreCase("rejected the game")){
                         Alert alert = ExtraComponent.showAlert(Alert.AlertType.INFORMATION, "Information ", "Rejected");
                         alert.show();
                     }
                });
          });          
          client.setSendDataToServer(gson.toJson(request));
          System.out.println("Data send to request for a game "+gson.toJson(request));
          client.setCallback(resultFuture);
    }
}
