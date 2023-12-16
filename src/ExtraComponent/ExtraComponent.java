/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExtraComponent;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

/**
 *
 * @author DELL
 */
public class ExtraComponent {
    public Alert showAlertChooseSymbol(Alert.AlertType type, String title , String headerTxt){
        // Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        // alert.setTitle("Symbol");
        //   alert.setHeaderText("You want play with");
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(headerTxt);
           return alert; 
    }
    
    public void showSymbolChoiceDialog(){
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Choose Symbol");
       // dialog.setHeaderText("Choose X or O");
        ButtonType buttonX = new ButtonType("X");
       ButtonType buttonO = new ButtonType("O");
        
        
        DialogPane dialogPane = new DialogPane();
        dialogPane.setMinSize(250, 50);
        Label contentLabel = new Label("You want play with..");
        contentLabel.setMinSize(250, 40);
        contentLabel.setAlignment(javafx.geometry.Pos.CENTER);
        contentLabel.setFont(new Font("Baskerville Old Face", 25.0));
        dialogPane.setContent(new HBox(contentLabel));
      //  buttonX.setFont(new Font("Baskerville Old Face", 20.0));
        dialogPane.getButtonTypes().addAll(buttonX,buttonO);

        // Set custom dialog pane to the dialog
        dialog.setDialogPane(dialogPane);
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(symbol -> System.out.println("Selected symbol: " + symbol));

    }
}
