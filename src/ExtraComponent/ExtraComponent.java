/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExtraComponent;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import xoclient.Navigate;

/**
 *
 * @author DELL
 */
public class ExtraComponent {
    public static Alert showAlertChooseSymbol(Alert.AlertType type, String title , String headerTxt){
        // Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        // alert.setTitle("Symbol");
        //   alert.setHeaderText("You want play with");
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(headerTxt);
           return alert; 
    }
    
    public static String openDialog(String title, String contentText){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle(title);
       // dialog.setHeaderText("Enter Data:");
        dialog.setContentText(contentText);
        
        Optional<String> result = dialog.showAndWait();
       // TextField input = dialog.getEditor();
        
       /* if(input.getText() != null && input.getText().length() != 0){
            return 
        }*/
       return result.orElse(null);
    }

}

