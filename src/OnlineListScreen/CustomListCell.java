/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OnlineListScreen;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

/**
 *
 * @author DELL
 */
public class CustomListCell extends ListCell<String> {

    protected final HBox cell;
    protected final ImageView playerImage;
    protected final Label playerName;
    protected final Label statusTxt;
    protected final Label inviteLable;
    protected final ImageView imageView;

    public CustomListCell() {

        cell = new HBox();
        playerImage = new ImageView();
        playerName = new Label();
        statusTxt = new Label();
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

        playerImage.setFitHeight(56.0);
        playerImage.setFitWidth(139.0);
        playerImage.setPickOnBounds(true);
        playerImage.setPreserveRatio(true);
        playerImage.setImage(new Image(getClass().getResource("/Icons/boy.png").toExternalForm()));

        playerName.setPrefHeight(56.0);
        playerName.setPrefWidth(128.0);
        playerName.setText("Player Name");
        playerName.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        playerName.setFont(new Font("Baskerville Old Face", 20.0));
        playerName.setPadding(new Insets(0.0, 0.0, 0.0, 10.0));
        HBox.setMargin(playerName, new Insets(0.0, 10.0, 0.0, 0.0));

        statusTxt.setAlignment(javafx.geometry.Pos.CENTER);
        statusTxt.setPrefHeight(64.0);
        statusTxt.setPrefWidth(136.0);
        statusTxt.setText("Status");
        statusTxt.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        statusTxt.setFont(new Font("Baskerville Old Face", 20.0));
        statusTxt.setPadding(new Insets(0.0, 0.0, 0.0, 20.0));

        inviteLable.setContentDisplay(javafx.scene.control.ContentDisplay.RIGHT);
        inviteLable.setPrefHeight(64.0);
        inviteLable.setPrefWidth(98.0);
        inviteLable.setText("Invite");
        inviteLable.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        inviteLable.setFont(new Font("Baskerville Old Face", 20.0));
        inviteLable.setPadding(new Insets(0.0, 0.0, 0.0, 10.0));

        imageView.setFitHeight(25.0);
        imageView.setFitWidth(46.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/Icons/start.png").toExternalForm()));
        inviteLable.setGraphic(imageView);
        HBox.setMargin(inviteLable, new Insets(0.0, 0.0, 0.0, 80.0));
        cell.setPadding(new Insets(10.0, 0.0, 10.0, 20.0));

        cell.getChildren().add(playerImage);
        cell.getChildren().add(playerName);
        cell.getChildren().add(statusTxt);
        cell.getChildren().add(inviteLable);
        getChildren().add(cell);

    }

    
   @Override
   protected void updateItem(String item, boolean empty) {
       super.updateItem(item, empty);

       if (item != null && !empty) {
         //Set icon, label, and button properties
         //icon.setImage(new Image("/girlIcon.png"));
           playerName.setText(item);
        //   inviteBtn.setText("Button");
           setGraphic(cell);
       }else {
           setGraphic(null);
       }
   }
}
