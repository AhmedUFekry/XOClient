/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xoclient.Screens;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.util.Callback;
import static sun.plugin.javascript.navig.JSType.Image;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> items = FXCollections.observableArrayList("Item 1", "Item 2", "Item 3");
        listView.setItems(items);
        listView.setCellFactory(new Callback<ListView<String>, ListCell<String>>(){
            @Override
            public ListCell<String> call(ListView<String> param) {
             return new  CustomListCell();
            }
            
        });       
    }    

    @FXML
    private void logoutMethod(ActionEvent event) {
    }

    @FXML
    private void goToProfileScreen(ActionEvent event) {
    }

    @FXML
    private void gotoSingleMode(ActionEvent event) {
    }
    
}
