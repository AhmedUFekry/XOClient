/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecordScreen;

 

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

/**
 *
 * @author Ahmed Fekry
 */
public class RecordsCell extends ListCell<String>{
    
    protected final HBox cell;
    
    protected final Label playerName;
    protected final Label inviteLable;
    protected final ImageView imageView;

    public RecordsCell() {

        cell = new HBox();
        playerName = new Label();
        inviteLable = new Label();
        imageView = new ImageView();

        setId("AnchorPane");
        setPrefHeight(60.0);
        setPrefWidth(600.0);

        cell.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        cell.setFillHeight(false);
        cell.setLayoutX(-2.0);
        cell.setLayoutY(174.0);
        cell.setPrefHeight(41.0);
        cell.setPrefWidth(600.0);
        cell.setSpacing(10.0);

     

        playerName.setPrefHeight(56.0);
        playerName.setPrefWidth(300.0);
        playerName.setText("Player Name");
        playerName.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        playerName.setFont(new Font("Baskerville Old Face", 20.0));
        playerName.setPadding(new Insets(0.0, 0.0, 0.0, 0.0));
        HBox.setMargin(playerName, new Insets(0.0, 0.0, 0.0, 0.0));

      

        inviteLable.setContentDisplay(javafx.scene.control.ContentDisplay.RIGHT);
        inviteLable.setPrefHeight(64.0);
        inviteLable.setPrefWidth(98.0);
        inviteLable.setText("Play");
        inviteLable.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        inviteLable.setFont(new Font("Baskerville Old Face", 20.0));
        inviteLable.setPadding(new Insets(0.0, 0.0, 0.0, 0.0));

        imageView.setFitHeight(25.0);
        imageView.setFitWidth(46.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/Icons/start.png").toExternalForm()));
        inviteLable.setGraphic(imageView);
        HBox.setMargin(inviteLable, new Insets(0.0, 0.0, 0.0, 200.0));
        cell.setPadding(new Insets(0.0, 0.0, 0.0, 0.0));

        
        cell.getChildren().add(playerName);
        cell.getChildren().add(inviteLable);
        getChildren().add(cell);

    }

    
   @Override
   protected void updateItem(String item, boolean empty) {
       super.updateItem(item, empty);

       if (item != null && !empty) {
         
           playerName.setText(item);
           setGraphic(cell);
       }else {
           setGraphic(null);
       }
   }
    
}
