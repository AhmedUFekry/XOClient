/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OnlineListScreen;

import DTO.DTOPlayerData;
import ClientServer.Client;
import DTO.DTOPlayerData;
import DTO.DataOperation;
import ExtraComponent.ExtraComponent;
import LoginScreen.LoginScreenController;
import NetworkManager.NetworkManager;
import ProfileScreen.ProfileScreenController;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javax.print.DocFlavor;
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
    private ListView<String> listView;

    VBox vb;
    private ObservableList<String> items;

    private DTOPlayerData currentPlayer;
    public static String playerName;
    public List<DTOPlayerData> playerList;
    public List<String> availablePlayerNames;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
    }

    @FXML
    private void gotoSingleMode(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GameScreen/GameScreen.fxml"));
        Parent root = loader.load();
        Navigate.navigateTo(root, event);
    }

    private void handleListViewClicked() {
        int item = listView.getSelectionModel().getSelectedIndex();

        System.out.println("OnlineListScreen.OnlineListScreenController.handleListViewClicked()" + items.get(item));

        String currentPlayer = "Curent Player";
        String invitedPlayer = items.get(item);

    }

    private void sendRequest(String invitedPlayer) {
        DTOPlayerData invitedPlayerData = new DTOPlayerData();

    }

    private static class Type {

        public Type() {
        }
    }
}
