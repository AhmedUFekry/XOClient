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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
<<<<<<< HEAD
import javafx.util.Callback;
import javax.print.DocFlavor;
=======
import javafx.stage.Stage;
>>>>>>> a580625f5498b687fcd2b896627ace87d298574b
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
<<<<<<< HEAD
    private ListView<String> listView;

    VBox vb;
    private ObservableList<String> items;

    private DTOPlayerData currentPlayer;
    public static String playerName;
    public List<DTOPlayerData> playerList;
    public List<String> availablePlayerNames;
    
=======
    private ListView<DTOPlayerData> listView;
    
    VBox vb ;
   // private ObservableList<String> items;

   private DTOPlayerData currentPlayer;
   public static String playerName;
   private ObservableList<DTOPlayerData> availabLeList;
>>>>>>> a580625f5498b687fcd2b896627ace87d298574b

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
<<<<<<< HEAD

        ////////////////////////////////
        availablePlayerNames = new ArrayList<>();
        playerList = new ArrayList<>();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        CompletableFuture<String> resultFuture = new CompletableFuture<>();
        // Set the callback for the result
        resultFuture.thenAccept(result -> {
            Platform.runLater(() -> {
                if (result.equals("error")) {
                    Alert alert = ExtraComponent.showAlertChooseSymbol(Alert.AlertType.ERROR, "Error", "The Username or Password is Invalid");
                    alert.show();
                    System.out.println("No available players " + result);
                } else {
                    java.lang.reflect.Type listType = new TypeToken<ArrayList<DTOPlayerData>>() {
                    }.getType();
                    List<DTOPlayerData> playerLists = gson.fromJson(result, listType);

                    for(int i = 0 ; i < 2; i++){
                        availablePlayerNames.add(playerLists.get(i).getUserName()); 
                    }
                    items = FXCollections.observableArrayList(availablePlayerNames);
                    listView.setItems(items);
                    listView.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
                        @Override
                        public ListCell<String> call(ListView<String> param) {
                            return new CustomListCell();
                        }
                    });
                    listView.setOnMouseClicked(event -> handleListViewClicked());

                }
            });

        }
        );
        Client client = NetworkManager.getClient();
        client.setSendDataToServer("availableUsers");
        client.setCallback(resultFuture);

        ///////////////////////////////
        // TODO
    }
=======
        // TODODTO
        DTOPlayerData player = new DTOPlayerData("aya", "aya", "email", "1234", 0, 0, 0, true, true, true);
        DTOPlayerData player2 = new DTOPlayerData("rwan2", "aya", "", "", 1, 0, 2, true, true, true);
        availabLeList = FXCollections.observableArrayList(player, player2);

        listView.setItems(availabLeList);
        listView.setCellFactory((ListView<DTOPlayerData> param) -> new  CustomListCell());  
        listView.setOnMouseClicked(event -> handleListViewClicked());
    }    
>>>>>>> a580625f5498b687fcd2b896627ace87d298574b

    @FXML
    private void logoutMethod(ActionEvent event) throws IOException {
        System.out.println("Back");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/StartScreen/StartScreen.fxml"));
        Parent root = loader.load();
        Navigate.navigateTo(root, event);
    }

    @FXML
    private void goToProfileScreen(ActionEvent event) throws IOException {
<<<<<<< HEAD

        List<DTOPlayerData> playerList = new ArrayList<>();
        DTOPlayerData player = new DTOPlayerData();
        player.setUserName(playerName);

        playerList.add(player);
        DataOperation operation = new DataOperation("profile", playerList);
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        System.out.println(gson.toJson(operation));
        CompletableFuture<String> resultFuture = new CompletableFuture<>();
        // Set the callback for the result
        resultFuture.thenAccept(result -> {
            Platform.runLater(() -> {
                if (result.equals("error")) {
                    Alert alert = ExtraComponent.showAlertChooseSymbol(Alert.AlertType.ERROR, "Error", "The Username or Password is Invalid");
                    alert.show();
                    System.out.println("cant login " + result);
                } else {
                    try {
                        DTOPlayerData dataReceived = new Gson().fromJson(result, DTOPlayerData.class);
                        System.out.println("OnlineListScreen.OnlineListScreenController.goToProfileScreen()" + dataReceived.getPassword());
                        ProfileScreenController profile = new ProfileScreenController(dataReceived);
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProfileScreen/ProfileScreen.fxml"));
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
=======
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
                        Alert alert = ExtraComponent.showAlertChooseSymbol(Alert.AlertType.ERROR, "Error", "The Username or Password is Invalid");
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
>>>>>>> a580625f5498b687fcd2b896627ace87d298574b
    }

    @FXML
    private void gotoSingleMode(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GameScreen/GameScreen.fxml"));
        Parent root = loader.load();
        Navigate.navigateTo(root, event);
    }

    private void handleListViewClicked() {
<<<<<<< HEAD
        int item = listView.getSelectionModel().getSelectedIndex();

        System.out.println("OnlineListScreen.OnlineListScreenController.handleListViewClicked()" + items.get(item));

        String currentPlayer = "Curent Player";
        String invitedPlayer = items.get(item);

    }

    private void sendRequest(String invitedPlayer) {
        DTOPlayerData invitedPlayerData = new DTOPlayerData();

=======
       int item = listView.getSelectionModel().getSelectedIndex();
       if (item >= 0) {
            System.out.println("OnlineListScreen.OnlineListScreenController.handleListViewClicked()"+item);
            System.out.println("name "+ availabLeList.get(item).getUserName());
            DTOPlayerData invitedPlayer = availabLeList.get(item);
            System.out.println("current player "+currentPlayer);
            sendRequest(currentPlayer, invitedPlayer);
       }
    }
    private void sendRequest(DTOPlayerData currentPlayer, DTOPlayerData invitedPlayer){
       DTOPlayerData cp = new DTOPlayerData();
       cp.setUserName(playerName.trim());
        List<DTOPlayerData> playerList = Arrays.asList(cp, invitedPlayer);
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
                         Alert alert = ExtraComponent.showAlertChooseSymbol(Alert.AlertType.CONFIRMATION, "Request", "Request");
                         ButtonType acceptButton = new ButtonType("Accept", ButtonBar.ButtonData.OK_DONE);
                         ButtonType rejectButton = new ButtonType("Reject", ButtonBar.ButtonData.CANCEL_CLOSE);
                         alert.getButtonTypes().setAll(acceptButton, rejectButton);
                         Optional<ButtonType> resultButton = alert.showAndWait();
                         if (resultButton.isPresent()) {
                              if (resultButton.get() == acceptButton) {
                                 client.setSendDataToServer("start the game");
                                 System.out.println("User clicked Accept");
                        } else if (resultButton.get() == rejectButton) {
                            client.setSendDataToServer("rejected the game");
                             System.out.println("User clicked Reject");
                        }
                        }else {
                              System.out.println("User closed the alert without clicking a button");
                        }
                     }else if(result.equalsIgnoreCase("start the game")){
                        /* GameScreenController controller = new GameScreenController(4);
                          FXMLLoader loader = new FXMLLoader (getClass().getResource("/GameScreen/GameScreen.fxml")) ;
                          loader.setController(controller);
                          Parent root = loader.load();
                          Navigate.navigateTo(root, event);*/
                          System.out.println(" start the game");
                     }else if(result.equalsIgnoreCase("rejected the game")){
                         Alert alert = ExtraComponent.showAlertChooseSymbol(Alert.AlertType.INFORMATION, "Information ", "Rejected");
                         alert.show();
                     }
                });
          });          
          client.setSendDataToServer(gson.toJson(request));
          System.out.println("Data send to request for a game "+gson.toJson(request));
          client.setCallback(resultFuture);

          
>>>>>>> a580625f5498b687fcd2b896627ace87d298574b
    }

    private static class Type {

        public Type() {
        }
    }
}
