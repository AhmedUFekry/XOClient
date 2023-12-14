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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class RecordsScreenController implements Initializable {

    @FXML
    private Button backBtn;
    @FXML
    private ListView<String> recordListView;
    private ObservableList<String> items;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
             items = FXCollections.observableArrayList("Item 1", "Item 2", "Item 3");
             recordListView.setItems(items);
             recordListView.setCellFactory(new Callback<ListView<String>, ListCell<String>>(){
            @Override
            public ListCell<String> call(ListView<String> param) {
             return new  CustomListCell();
            }
            
        });  
    }    
    
}
