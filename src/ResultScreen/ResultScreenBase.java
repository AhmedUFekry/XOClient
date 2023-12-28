package ResultScreen;

import ClientServer.Client;
import ExtraComponent.ExtraComponent;
import GameScreen.GameScreenController;
import NetworkManager.NetworkManager;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import xoclient.Navigate;

public class ResultScreenBase {

    protected  Text text;
    protected  ImageView imageView;
    protected  Button acceptButton;
    protected  ImageView imageView0;
    protected  Button rejectButton;
    public AnchorPane paneRoot;

    public ResultScreenBase() {

        text = new Text();
        imageView = new ImageView();
        acceptButton = new Button();
        imageView0 = new ImageView();
        rejectButton = new Button();
        paneRoot = new AnchorPane();

        paneRoot.setMaxHeight(USE_PREF_SIZE);
        paneRoot.setMaxWidth(USE_PREF_SIZE);
       paneRoot. setMinHeight(USE_PREF_SIZE);
       paneRoot. setMinWidth(USE_PREF_SIZE);
        paneRoot.setPrefHeight(200.0);
        paneRoot.setPrefWidth(500.0);

        AnchorPane.setLeftAnchor(text, 5.0);
        AnchorPane.setRightAnchor(text, 5.3291015625);
        text.setLayoutX(5.0);
        text.setLayoutY(77.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("PlayerName Invite you to play?");
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text.setWrappingWidth(469.6708984375);
        text.setFont(new Font("Baskerville Old Face", 30.0));

        AnchorPane.setBottomAnchor(imageView, 10.0);
        AnchorPane.setLeftAnchor(imageView, 38.0);
        AnchorPane.setRightAnchor(imageView, 292.0);
        AnchorPane.setTopAnchor(imageView, 143.0);
        imageView.setFitHeight(50.0);
        imageView.setFitWidth(201.0);
        imageView.setLayoutX(38.0);
        imageView.setLayoutY(143.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/Icons/accept.png").toExternalForm()));

        AnchorPane.setBottomAnchor(acceptButton, 10.0);
        AnchorPane.setLeftAnchor(acceptButton, 38.0);
        AnchorPane.setRightAnchor(acceptButton, 292.0);
        AnchorPane.setTopAnchor(acceptButton, 143.0);
        acceptButton.setLayoutX(38.0);
        acceptButton.setLayoutY(143.0);
        acceptButton.setMnemonicParsing(false);
        acceptButton.setOpacity(0.0);
        acceptButton.setPrefHeight(50.0);
        acceptButton.setPrefWidth(150.0);

        AnchorPane.setBottomAnchor(imageView0, 10.0);
        AnchorPane.setLeftAnchor(imageView0, 292.0);
        AnchorPane.setRightAnchor(imageView0, 38.0);
        AnchorPane.setTopAnchor(imageView0, 142.0);
        imageView0.setFitHeight(50.0);
        imageView0.setFitWidth(201.0);
        imageView0.setLayoutX(306.0);
        imageView0.setLayoutY(143.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("/Icons/reject.png").toExternalForm()));

        AnchorPane.setBottomAnchor(rejectButton, 10.0);
        AnchorPane.setLeftAnchor(rejectButton, 292.0);
        AnchorPane.setRightAnchor(rejectButton, 38.0);
        AnchorPane.setTopAnchor(rejectButton, 143.0);
        rejectButton.setLayoutX(179.0);
        rejectButton.setLayoutY(81.0);
        rejectButton.setMnemonicParsing(false);
        rejectButton.setOpacity(0.0);
        rejectButton.setPrefHeight(41.0);
        rejectButton.setPrefWidth(156.0);
        rejectButton.setText("Button");

       paneRoot. getChildren().add(text);
       paneRoot. getChildren().add(imageView);
       paneRoot. getChildren().add(acceptButton);
       paneRoot. getChildren().add(imageView0);
       paneRoot. getChildren().add(rejectButton);
       
       acceptButton.setOnAction(event ->{
           sendInvitePlayerResponse("accepted",event);
       });
       rejectButton.setOnAction(event ->{
           sendInvitePlayerResponse("rejected",event);
       });
       
    }
    public void sendInvitePlayerResponse(String msgToServer, ActionEvent event){
         CompletableFuture<String> resultFuture = new CompletableFuture<>();
          resultFuture.thenAccept(result->{
                 Platform.runLater(() ->{
                     System.out.println("response from server for request "+result);
                     if(result.equalsIgnoreCase("start the game")){
                         try {
                             System.out.println("player accepted"+result);
                             //navigate to Game Screen if player accept
                             GameScreenController controller = new GameScreenController(4);
                             FXMLLoader loader = new FXMLLoader (getClass().getResource("/GameScreen/GameScreen.fxml")) ;
                             loader.setController(controller);
                             Parent root = loader.load();
                             Navigate.navigateTo(root, event);
                         } catch (IOException ex) {
                             Logger.getLogger(ResultScreenBase.class.getName()).log(Level.SEVERE, null, ex);
                         }
                     }else if(result.equalsIgnoreCase("player reject the game")){
                         try {
                             System.out.println("player reject "+result);
                             GameScreenController controller = new GameScreenController(4);
                             FXMLLoader loader = new FXMLLoader (getClass().getResource("/OnlineListScreen/OnlineListScreen.fxml")) ;
                             loader.setController(controller);
                             Parent root = loader.load();
                             Navigate.navigateTo(root, event);
                         } catch (IOException ex) {
                             Logger.getLogger(ResultScreenBase.class.getName()).log(Level.SEVERE, null, ex);
                         }
                     }else{
                         System.out.println("none");
                     }
                 });
          });
          Client client = NetworkManager.getClient();
          client.setSendDataToServer(msgToServer);
          System.out.println("send data from profile "+msgToServer);
          client.setCallback(resultFuture);
    }
}
