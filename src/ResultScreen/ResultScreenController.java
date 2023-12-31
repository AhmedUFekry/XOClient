/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResultScreen;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import xoclient.Navigate;

/**
 *
 * @author Rwan el matry
 */
public class ResultScreenController implements Initializable {
    
    private Label label;
    private MediaView resVideo;
    private Label resultTxt;
    
    private  String video;
    private char result;
    
    public ResultScreenController(char result){
        this.result = result;
    }
            
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       switch(result){
             case 'x':
                 video = "/videos/winner.mp4";
                break;
             case 'o':
                 video = "/videos/loser.mp4";
                 break;
             default:
                 video = "/videos/draw.mp4";
         }
        resultTxt.setText("The Winner is "+result);
        Media media = new Media(getClass().getResource(video).toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        resVideo.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
    }    

    private void exitTheGame(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader (getClass().getResource("/StartScreen/StartScreen.fxml")) ;
          Parent root = loader.load();
          Navigate.navigateTo(root, event);
    }

    private void playAgain(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader (getClass().getResource("/ResultScreen/ResultScreen.fxml")) ;
         Parent root = loader.load();
         Navigate.navigateTo(root, event);
    }
}

