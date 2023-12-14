/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xoclient.Screens;

import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/**
 *
 * @author DELL
 */
public class CustomListCell extends ListCell<String> {

   private HBox hbox;
   private ImageView icon;
   private Label playerName;
   private Button button;

   public CustomListCell() {
       hbox = new HBox();
     //  icon = new ImageView();
       playerName = new Label();
       button = new Button();

       // Add components to HBox
     //  hbox.getChildren().addAll(icon, label, button);
     hbox.getChildren().addAll(playerName, button);
       // Align icon and label to the left, and button to the right
       HBox.setHgrow(playerName, Priority.ALWAYS);
       //HBox.setHalignment(button, HPos.RIGHT);
       
   }

   @Override
   protected void updateItem(String item, boolean empty) {
       super.updateItem(item, empty);

       if (item != null && !empty) {
           // Set icon, label, and button properties
         //  icon.setImage(new Image("/girlIcon.png"));
           playerName.setText(item);
           button.setText("Button");

           setGraphic(hbox);
       } else {
           setGraphic(null);
       }
   }
}
