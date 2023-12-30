/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResultScreen;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import xoclient.Navigate;

/**
 *
 * @author DELL
 */
public class ResultUI {
    public ResultUI(char gameResult){
         String video;
         String result;
        switch(gameResult){
             case 'x':
                 video = "/videos/winner.mp4";
                 result = "You’re a hero… of zero!";
                break;
             case 'o':
                 video = "/videos/loser.mp4";
                 result = "Better luck next time… or maybe not! hehe";
                 break;
             default:
                 video = "/videos/draw.mp4";
                 result = "There is no winner in this game, only losers and quitters";
         }
        Label resultTxt = new Label();
       Button closeTheGame = new Button();
       ImageView imageView = new ImageView();
       Button playAgainBtn = new Button();
       ImageView imageView0 = new ImageView();
       Label txtCounter = new Label("7");
       Pane pane = new Pane();
       BorderPane paneRoot = new BorderPane();
       
       Media media = new Media(getClass().getResource(video).toExternalForm());
       MediaPlayer mediaPlayer = new MediaPlayer(media);
       MediaView mediaView = new MediaView(mediaPlayer);
       BorderPane.setAlignment(resultTxt, javafx.geometry.Pos.CENTER);
        resultTxt.setAlignment(javafx.geometry.Pos.CENTER);
        resultTxt.setPrefHeight(10.0);
        resultTxt.setPrefWidth(600.0);
        resultTxt.setText(result);
        resultTxt.setFont(new Font("Baskerville Old Face", 25.0));
        paneRoot.setTop(resultTxt);
        
        BorderPane.setAlignment(mediaView, javafx.geometry.Pos.CENTER);
        mediaView.setFitHeight(280.0);
        mediaView.setFitWidth(600.0);
        BorderPane.setMargin(mediaView, new Insets(10.0, 0.0, 10.0, 0.0));
        BorderPane.setAlignment(mediaView, javafx.geometry.Pos.CENTER);
        mediaView.setFitHeight(USE_COMPUTED_SIZE);
        mediaView.setFitWidth(USE_COMPUTED_SIZE);
        paneRoot.setCenter(mediaView);

        BorderPane.setAlignment(pane, Pos.CENTER);
        pane.setPrefHeight(71.0);
        pane.setPrefWidth(600.0);
        BorderPane.setMargin(pane, new Insets(0.0, 0.0, 10.0, 0.0));
        paneRoot.setBottom(pane);
       
        closeTheGame.setAlignment(javafx.geometry.Pos.CENTER);
        closeTheGame.setContentDisplay(javafx.scene.control.ContentDisplay.RIGHT);
        closeTheGame.setLayoutX(464.0);
        closeTheGame.setLayoutY(5.0);
        closeTheGame.setMnemonicParsing(false);
        closeTheGame.setPrefHeight(55.0);
        closeTheGame.setPrefWidth(122.0);
        closeTheGame.setText("Exit");
        closeTheGame.setFont(new Font("Baskerville Old Face", 20.0));

        imageView.setFitHeight(27.0);
        imageView.setFitWidth(30.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/Icons/forward.png").toExternalForm()));
        closeTheGame.setGraphic(imageView);
        
        playAgainBtn.setAlignment(javafx.geometry.Pos.CENTER);
        playAgainBtn.setContentDisplay(javafx.scene.control.ContentDisplay.RIGHT);
        playAgainBtn.setLayoutX(14.0);
        playAgainBtn.setLayoutY(9.0);
        playAgainBtn.setMnemonicParsing(false);
        playAgainBtn.setPrefHeight(55.0);
        playAgainBtn.setPrefWidth(122.0);
        playAgainBtn.setText("Replay");
        playAgainBtn.setFont(new Font("Baskerville Old Face", 20.0));

        imageView0.setFitHeight(27.0);
        imageView0.setFitWidth(30.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("/Icons/replay.png").toExternalForm()));
        playAgainBtn.setGraphic(imageView0);
        
        txtCounter.setAlignment(javafx.geometry.Pos.CENTER);
        txtCounter.setLayoutX(213.0);
        txtCounter.setLayoutY(16.0);
        txtCounter.setPrefHeight(34.0);
        txtCounter.setPrefWidth(175.0);
        txtCounter.setText("Counter");
        txtCounter.setFont(new Font("Baskerville Old Face", 20.0));
        BorderPane.setMargin(pane, new Insets(0.0));
        paneRoot.setBottom(pane);
        
        //button Implementation
        
        
        pane.getChildren().add(closeTheGame);
        pane.getChildren().add(playAgainBtn);
        pane.getChildren().add(txtCounter);
        Stage videoStage = new Stage();
        videoStage.setResizable(false);  // Set resizable to false
        videoStage.setMaximized(false);  // Set maximized to false
        videoStage.initModality(Modality.APPLICATION_MODAL);
        videoStage.setScene(new Scene(paneRoot, 600, 500));
        videoStage.show();
        
        
         mediaPlayer.setOnEndOfMedia(() -> {
                // Stop the video and close the stage
                mediaPlayer.stop();
                videoStage.close();
        });
        videoStage.show();
        mediaView.setFitWidth(videoStage.getWidth());
        mediaView.setFitHeight(videoStage.getHeight());
        // Play the video
        mediaPlayer.play();
        // the Duration to show the result Screen
        Duration countdownDuration = Duration.seconds(6); 
        
        // Create a pause transition to close the stage after the specified duration
        PauseTransition pauseTransition = new PauseTransition(countdownDuration);

         pauseTransition.setOnFinished(event -> {
            // Update the countTextField and close the stage
            txtCounter.setText("0");
            videoStage.close();
            });
        pauseTransition.play();
        pauseTransition.currentTimeProperty().addListener((obs, oldTime, newTime) -> {
            long secondsRemaining = Math.round(countdownDuration.toSeconds() - pauseTransition.getCurrentTime().toSeconds());
            txtCounter.setText(String.valueOf(secondsRemaining));
        }); 
        playAgainBtn.setOnAction(event -> {
            mediaPlayer.stop();
            videoStage.close();
            pauseTransition.stop();
        });
        
        closeTheGame.setOnAction(event -> {
             try {
                 mediaPlayer.stop();
                 videoStage.close();
                 pauseTransition.stop();
                 
                 FXMLLoader loader = new FXMLLoader (getClass().getResource("/StartScreen/StartScreen.fxml")) ;
                 Parent root = loader.load();
                 Navigate.navigateTo(root);
             } catch (IOException ex) {
                 Logger.getLogger(ResultUI.class.getName()).log(Level.SEVERE, null, ex);
             }
        });
    }
}
