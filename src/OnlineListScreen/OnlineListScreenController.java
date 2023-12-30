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
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
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

    /*private ListView<String> listView;

    private ObservableList<String> items;

    private DTOPlayerData currentPlayer;
    public static String playerName;
    public List<DTOPlayerData> playerList;
    public List<String> availablePlayerNames;*/
    private ListView<DTOPlayerData> listView;

    VBox vb;
    // private ObservableList<String> items;

    private DTOPlayerData currentPlayer;
    public static String playerName;
    public ObservableList<DTOPlayerData> availabLeList;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        CompletableFuture<String> resultFuture = new CompletableFuture<>();
        // Set the callback for the result
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

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


                    availabLeList = FXCollections.observableArrayList(playerLists);
                    //System.out.println("انا بطبع الليست تاني");
                    listView.setItems(availabLeList);
                    listView.setCellFactory((ListView<DTOPlayerData> param) -> new CustomListCell());
                    listView.setOnMouseClicked(event -> handleListViewClicked());
                }
            });

        }
        );

        /*Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> {
                    Client client = NetworkManager.getClient();
                    client.setSendDataToServer("availableUsers");
                    client.setCallback(resultFuture);
                    System.out.println("calling available from database");
                })
                
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();*/
       Client client = NetworkManager.getClient();
    client.setSendDataToServer("availableUsers");
    client.setCallback(resultFuture); 

        //timeline.play();
        
        

    };
    
    @FXML
    private void logoutMethod(ActionEvent event) throws IOException {
        if(NetworkManager.isClientAlive()){
            Alert alert = ExtraComponent.showAlert(Alert.AlertType.INFORMATION, "Information", "Do you want to log out?");
            ButtonType yesButton = new ButtonType("YES",ButtonBar.ButtonData.YES);
            ButtonType cancelButton = new ButtonType("Cancel",ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(yesButton,cancelButton);
            Optional<ButtonType> resultButton = alert.showAndWait();
            
            if(resultButton.isPresent() && resultButton.get().equals(yesButton)){
                 List<DTOPlayerData> playerList = new ArrayList<>();
                DTOPlayerData player = new DTOPlayerData();
                player.setUserName(playerName);
                playerList.add(player);
                DataOperation operation = new DataOperation("logout", playerList);
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                Client client = NetworkManager.getClient();
                CompletableFuture<String> resultFuture = new CompletableFuture<>();
                resultFuture.thenAccept(result->{
                    Platform.runLater(()->{
                        if(result.equalsIgnoreCase("logout")){
                            try {
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("/StartScreen/StartScreen.fxml"));
                                Parent root = loader.load();
                                Navigate.navigateTo(root, event);
                                client.stopClient();
                            } catch (IOException ex) {
                                Logger.getLogger(OnlineListScreenController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }else{
                            Alert alertError = ExtraComponent.showAlert(Alert.AlertType.ERROR, "error", "Faild to log out");
                            alertError.show();
                        }
                    });
                });
                client.setSendDataToServer(gson.toJson(operation));
                client.setCallback(resultFuture);
            }
        }else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/StartScreen/StartScreen.fxml"));
            Parent root = loader.load();
            Navigate.navigateTo(root, event);
        }
    }

    @FXML
    private void goToProfileScreen(ActionEvent event) throws IOException {
        if(NetworkManager.isClientAlive()){
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
            resultFuture.thenAccept(result -> {
                Platform.runLater(() -> {
                    if (result.equals("error")) {
                        Alert alert = ExtraComponent.showAlert(Alert.AlertType.ERROR, "Error", "The Username or Password is Invalid");
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
                            Navigate.navigateTo(root);
                        } catch (IOException ex) {
                            Logger.getLogger(OnlineListScreenController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            });
            Client client = NetworkManager.getClient();
            client.setSendDataToServer(gson.toJson(operation));
            client.setCallback(resultFuture);
        }else{
            try {
                FXMLLoader loader = new FXMLLoader (getClass().getResource("/StartScreen/StartScreen.fxml")) ;
                Parent root = loader.load();
                Navigate.navigateTo(root);
                } catch (IOException ex) {
                    Logger.getLogger(OnlineListScreenController.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }

    private void gotoSingleMode(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GameScreen/GameScreen.fxml"));
        Parent root = loader.load();
        Navigate.navigateTo(root, event);
    }

    private void handleListViewClicked() {
        
        int item = listView.getSelectionModel().getSelectedIndex();
        if (item >= 0) {
            System.out.println("OnlineListScreen.OnlineListScreenController.handleListViewClicked()" + item);
            System.out.println("name " + availabLeList.get(item).getUserName());
            DTOPlayerData invitedPlayer = availabLeList.get(item);
            System.out.println("current player " + currentPlayer);
            sendRequest(currentPlayer, invitedPlayer);
        }
    }

    private void sendRequest(DTOPlayerData currentPlayer, DTOPlayerData invitedPlayer) {
        if(NetworkManager.isClientAlive()){
            DTOPlayerData cp = new DTOPlayerData();
            cp.setUserName(playerName.trim());
            List<DTOPlayerData> playerList = Arrays.asList(cp, invitedPlayer);
            DataOperation request = new DataOperation("request", playerList);
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            System.out.println(gson.toJson(request));
            Client client = NetworkManager.getClient();
            CompletableFuture<String> resultFuture = new CompletableFuture<>();
            resultFuture.thenAccept(result -> {
                Platform.runLater(() -> {
                    System.out.println("response from server for request " + result);
                    if (result.equalsIgnoreCase("user invited")) {
                        Alert alert = ExtraComponent.showAlert(Alert.AlertType.CONFIRMATION, "Request", "Request");
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
                        } else {
                            System.out.println("User closed the alert without clicking a button");
                        }
                    } else if (result.equalsIgnoreCase("start the game")) {
                        /* GameScreenController controller = new GameScreenController(4);
                              FXMLLoader loader = new FXMLLoader (getClass().getResource("/GameScreen/GameScreen.fxml")) ;
                              loader.setController(controller);
                              Parent root = loader.load();
                              Navigate.navigateTo(root, event);*/
                        System.out.println(" start the game");
                    } else if (result.equalsIgnoreCase("rejected the game")) {
                        Alert alert = ExtraComponent.showAlert(Alert.AlertType.INFORMATION, "Information ", "Rejected");
                        alert.show();
                    }
                });
            });
            client.setSendDataToServer(gson.toJson(request));
            System.out.println("Data send to request for a game " + gson.toJson(request));
            client.setCallback(resultFuture);
        }else{
            try {
                FXMLLoader loader = new FXMLLoader (getClass().getResource("/StartScreen/StartScreen.fxml")) ;
                Parent root = loader.load();
                Navigate.navigateTo(root);
            } catch (IOException ex) {
                Logger.getLogger(OnlineListScreenController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
