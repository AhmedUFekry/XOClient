/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExtraComponent;

import ResultScreen.ResultScreenBase;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

/**
 *
 * @author DELL
 */
public class ExtraComponent {
    public static Alert showAlert(Alert.AlertType type, String title , String headerTxt){
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
        dialog.setContentText(contentText); 
        Optional<String> result = dialog.showAndWait();
       return result.orElse(null);
    }
    public static BackgroundImage setBackgroundImg(String imgPath){
       Image backgroundImage = new Image(imgPath);

        // Create a BackgroundImage
        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        );
        return background;
    }
    public static Alert requestAlert(String playerName){
        Alert alert = new Alert(Alert.AlertType.NONE);
       ResultScreenBase testAlert = new ResultScreenBase();
       DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setContent(testAlert.paneRoot);
        dialogPane.getButtonTypes().clear(); 
        return alert;
    }
}

