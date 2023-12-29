package RecordScreen;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GameScreen.GameScreenController;
import Records.GameRecord;
import RecordScreen.RecordsCell;
import Records.Recordings;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import xoclient.Navigate;

/**
 * FXML Controller class
 *
 * @author Abdullah
 */
public class RecordsScreenController implements Initializable {

    @FXML
    private Button backBtn;
    @FXML
    private ListView<String> recordListView;
    private ObservableList<String> items;
    private Recordings recordings;
    private String[] recs;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            recordings = new Recordings();
            recs = recordings.getRecordedGamesList();
            System.out.println(recs[0]);
        // TODO
             items = FXCollections.observableArrayList(recs);
             recordListView.setItems(items);
             recordListView.setCellFactory(new Callback<ListView<String>, ListCell<String>>(){
            @Override
            public ListCell<String> call(ListView<String> param) {
             //return new  CustomListCell();
             return new RecordsCell();
            }
            
            
        });  
             recordListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    int selectedIndex = recordListView.getSelectionModel().getSelectedIndex();
                    
                    GameRecord gameRecord = recordings.getRecord(items.get(selectedIndex));
                    int[] gameMovments = gameRecord.getGameMoves();
                    String fPlayerName = gameRecord.getFirstPlayerName();
                    String sPlayerName = gameRecord.getSecondPlayerName();
                    String gameResult = gameRecord.getGameResult();
                    
                    System.out.println(fPlayerName);
                    System.out.println(sPlayerName);
                    System.out.println(gameResult);
                    GameScreenController gameController = new GameScreenController(gameMovments , true);
                    FXMLLoader loader = new FXMLLoader (getClass().getResource("/GameScreen/GameScreen.fxml"));
                    loader.setController(gameController);
                    Parent root = loader.load();
                    
                    //GameScreenController gameController =loader.getController();
                    gameController.setPlayerNames(gameRecord.getFirstPlayerName(),gameRecord.getSecondPlayerName());
                    gameController.setRecordedMovments(gameRecord.getGameMoves());
                    gameController.disableGamePad();
                    gameController.playRecordedGame(gameMovments);
                    Navigate.navigateTo(root, event);
                    // backBtn.setText(fPlayerName);
                    
                    
                    // Add your logic for handling the click on the item
                } catch (IOException ex) {
                    Logger.getLogger(RecordsScreenController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
            /*recordings = new Recordings();
            recs = recordings.getRecordedGamesList();
            System.out.println(recs[0]);*/
    }    
    
}