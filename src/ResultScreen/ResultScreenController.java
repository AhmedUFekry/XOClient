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
    @FXML
    private MediaView resVideo;
    @FXML
    private Label resultTxt;
    @FXML
    private Button exitBtn;
    @FXML
    private Button playAgainBtn;
    @FXML
    private Label txtCounter;
    
    private  String video;
    
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        video = "/videos/winner.mp4";
        Media media = new Media(getClass().getResource(video).toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        resVideo.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
    }    

    @FXML
    private void exitTheGame(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader (getClass().getResource("/StartScreen/StartScreen.fxml")) ;
          Parent root = loader.load();
          Navigate.navigateTo(root, event);
    }

    @FXML
    private void playAgain(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader (getClass().getResource("/ResultScreen/ResultScreen.fxml")) ;
         Parent root = loader.load();
         Navigate.navigateTo(root, event);
    }
    public void setResult(char result){
         switch(result){
             case 'X':
                 video = "/videos/winner.mp4";
                break;
             case 'O':
                 video = "/videos/loser.mp4";
                 break;
             default:
                 video = "/videos/draw.mp4";
         }
        resultTxt.setText("Teh Winner is "+result);
    }
}

