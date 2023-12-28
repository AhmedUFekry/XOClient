/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameScreen;

import GameLogic.BoardState;
import GameLogic.GameTemplate;
import Records.RecordGame;
import static GameLogic.MarkSymbol.*;
import GameLogic.MiniMax;
import GameLogic.MiniMaxAI;
import ResultScreen.ResultScreenController;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
 * @author LENOVO
 */
public class GameScreenController extends GameTemplate implements Initializable {
   
     // Logic variables
    private ArrayList<Button> boardBtns;                //BoardButtons
    //  private int gameId;                                 // to store game Id 
    private ArrayList<ImageView> symbolsImgs;
    private int turn;
    private static int _scoreP1 = 0;
    private static int _scoreP2 = 0;
    private String[] players = {"X","O"};
    private String p1ayMoves;
    private RecordGame recordGame;
    private boolean isRecord;
            
    MiniMaxAI ticTacToeAI = new MiniMaxAI();
     Random random ;
    public int mode;
    private MiniMax miniMax = new MiniMax();

    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;

    @FXML
    private Label txtPlayer1;
    @FXML
    private Label scoreP1;
    @FXML
    private Label scoreP2;
    @FXML
    private Label player1Symbol;
    @FXML
    private Label txtPlayer2;
    @FXML
    private Label player2Symbol;
    @FXML
    private Button exitBtn;
    @FXML
    private Button recBtn;
    @FXML
    private ImageView player2Img;
    @FXML
    private ImageView player1Img;
    @FXML
    private ImageView exitImg;
    @FXML
    private ImageView recImg;
    @FXML
    private ImageView imgSymbol1;
    @FXML
    private ImageView imgSymbol2;
    @FXML
    private ImageView imgSymbol3;
    @FXML
    private ImageView imgSymbol4;
    @FXML
    private ImageView imgSymbol5;
    @FXML
    private ImageView imgSymbol6;
    @FXML
    private ImageView imgSymbol7;
    @FXML
    private ImageView imgSymbol8;
    @FXML
    private ImageView imgSymbol9;
  
    // Declare index1, index2, index3 as class members
    private int index1;
    private int index2;
    private int index3;
    private static final int[][] WINNING_COMBINATIONS = {
    {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
    {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
    {0, 4, 8}, {2, 4, 6}             // Diagonals
};
    

    
   public GameScreenController(int mode){
        this.mode = mode;
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources){
    // mode=2;
        turn = 0;
        p1ayMoves = "";
        // init UI
        scoreP1.setText("0");
        scoreP2.setText("0");
        player1Symbol.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        boardBtns = new ArrayList<>(Arrays.asList(button1, button2, button3, button4, button5, button6, button7, button8, button9));
        symbolsImgs = new ArrayList<>(Arrays.asList(imgSymbol1,imgSymbol2,imgSymbol3,imgSymbol4,imgSymbol5,imgSymbol6,imgSymbol7,imgSymbol8,imgSymbol9));
       random=new Random();
        System.out.println("GameScreen.GameScreenController.initialize()"+mode);
        // START GAME 
        start();
        /*********************************/ 
    }
    @Override
    public void start() {
        exitBtn.addEventHandler(ActionEvent.ACTION, e -> {
            System.out.println("hello");
            });
        boardBtns.forEach(button -> {
            // mode 1 for easy mode
            // mode 2 for mid mode
            // mode 3 for hard
            // mode 4 for dual mode 
            if(mode == 1)
               playEasy(button);
            else if(mode == 2)
                playMid(button); 
            else if (mode == 3)//add hard mode play here
                playHardMode(button); 
            else if(mode == 4){
                play(button);    
            }
                
        });
    }
   



    @Override
    public void play(Button btn) {

        btn.addEventHandler(ActionEvent.ACTION, e -> {
            int index;
            index = boardBtns.indexOf(btn);
            if(turn == 0 )
                 symbolsImgs.get(index).setImage(new Image(XIMG.getMark()));
            else
                symbolsImgs.get(index).setImage(new Image(OIMG.getMark()));
            setPlayerSymbol(btn);
           p1ayMoves += index;
            btn.setDisable(true);
            checkResult();
        });
    }
    public void playMid(Button button) {
        
        button.setOnMouseClicked(mouseEvent -> {
        button.setText(X.getMark());
        int index = boardBtns.indexOf(button);
        symbolsImgs.get(index).setImage(new Image(XIMG.getMark()));
        p1ayMoves += index;
        button.setDisable(true);
        makeComputerMove();
        checkResult();  
        });
    }
    private void playHardMode(Button button){
      button.setOnMouseClicked(mouseEvent -> {
        button.setText(X.getMark());
        int index = boardBtns.indexOf(button);
        symbolsImgs.get(index).setImage(new Image(XIMG.getMark()));
        p1ayMoves += index;
        button.setDisable(true);

        // Check if the computer can win in the next move
        int computerWinningMove = findWinningMove(true);
        if (computerWinningMove != -1) {
            pickButton(computerWinningMove);
        } else {
            // If no winning move, check if the player can win in the next move and block them
            int playerBlockingMove = findWinningMove(false);
            if (playerBlockingMove != -1) {
                pickButton(playerBlockingMove);
            } else {
                // If no winning or blocking move, make a random move
                makeRandomMove();
            }
        }

        checkResult();
    });
}
// checking player and computer moves
private int findWinningMove(boolean isComputer) {
    char symbol = isComputer ? 'O' : 'X';
     //Iterates through all the winning combinations in the game.
    for (int i = 0; i < WINNING_COMBINATIONS.length; i++) {
        int count = 0;
        int emptyIndex = -1;
        //Iterates through each position in a winning combination.
        for (int j = 0; j < WINNING_COMBINATIONS[i].length; j++) {
            int position = WINNING_COMBINATIONS[i][j];
            if (boardBtns.get(position).getText().equals(String.valueOf(symbol))) {
                count++;
            } else if (boardBtns.get(position).getText().isEmpty()) {
                emptyIndex = position;
            }
        }
        //Checks if there are two matching symbols and one empty spot in the winning combination.
        if (count == 2 && emptyIndex != -1) {
            return emptyIndex;
        }
    }
    return -1;  // no winning moves
}

private void makeRandomMove() {
    ArrayList<Integer> emptyIndices = new ArrayList<>();
    for (int i = 0; i < boardBtns.size(); i++) {
        if (boardBtns.get(i).getText().isEmpty()) {
            emptyIndices.add(i);
        }
    }

    if (!emptyIndices.isEmpty()) {
        int randomIndex = emptyIndices.get(random.nextInt(emptyIndices.size()));
        pickButton(randomIndex);
    }
}

    
    private void playEasy(Button btn) {

       btn.addEventHandler(ActionEvent.ACTION, e ->{
           btn.setText("X");
           int index = boardBtns.indexOf(btn);
           symbolsImgs.get(index).setImage(new Image(XIMG.getMark()));
           p1ayMoves += index;
           btn.setDisable(true);
          computerMoveEasy(btn);
           checkResult();
       
       });
        
       }
    private void computerMoveEasy(Button btn) {
    int attempts = 0; //used to count number of valid moves
    while (true) {
        int index = random.nextInt(9);

        if (boardBtns.get(index).getText().isEmpty()) {
            pickButton(index);
            checkResult();
            turn = 0;
            break;
        }

        attempts++;
        if (attempts > 10) { // Adjust the threshold as needed
            System.out.println("Exceeded maximum attempts. Exiting loop.");
            break;
        }
    }
}
    

     @Override
    public void checkResult() {
        String result = null;
        System.out.println("playMoves :"+p1ayMoves);
        for (int i = 0; i < 8; i++) {
            
            switch (i) {
                case 0:                    // 1 2 3 
                    result = button1.getText() + button2.getText() + button3.getText();
                               

                    break;
                case 1:                      // 4 5 6 
                    result = button4.getText() + button5.getText() + button6.getText();
                                
                    break;
                case 2:                    // 7 8 9  
                    result = button7.getText() + button8.getText() + button9.getText();
                              
                    break;
                case 3:                    // 3 5 7 
                    result = button3.getText() + button5.getText() + button7.getText();
                                

                    break;
                case 4:                      // 1 5 9  
                    result = button1.getText() + button5.getText() + button9.getText();
                               

                    break;
                case 5:                    // 1 4 7 
                    result = button1.getText() + button4.getText() + button7.getText();
                               

                    break;
                case 6:                      // 2 5 8
                    result = button2.getText() + button5.getText() + button8.getText();
                                
                    break;
                case 7:                    // 3 6 9  
                    result = button3.getText() + button6.getText() + button9.getText();
                               

                    break;
                default:
                    result = null;

            };
            
            System.out.println("result : "+result);
            
            if (result.matches("XXX")) {
                highlightWinningMoves(index1, index2, index3);
                
                                       


              
                    ++_scoreP1;
                    System.out.println("X wins ");
                    if(isRecord){
                        recordGame.saveRecord(txtPlayer1, txtPlayer2, p1ayMoves, "X");
                        isRecord = false;
                    }
                    
                    //    ResultScreen.ResultScreenController controller = loader.getController();
                    //    controller.setResult(result);
                    
                    // showTheVideo('X');
                    
                    
                    restart();
                    // go to video screen or tab 
                    showTheVideo('x');
             
            } else if (result.matches("OOO")) {
                highlightWinningMoves(index1, index2, index3);
                            

                ++_scoreP2;
                System.out.println("O wins ");
               // showTheVideo('O');
               if(isRecord){
                        recordGame.saveRecord(txtPlayer1, txtPlayer2, p1ayMoves, "O");
                        isRecord = false;
                    }
               
                restart();
                // go to video screen or tab 
                showTheVideo('o');
            } else if (p1ayMoves.length() == 9) {
                System.out.println("draw");
                if(isRecord){
                        recordGame.saveRecord(txtPlayer1, txtPlayer2, p1ayMoves, "draw");
                        isRecord = false;
                    }
              
                restart();
                showTheVideo('d');
            }
        
        }
    }
     // Modify the highlightWinningMoves method to receive indices as parameters
    private void highlightWinningMoves(int index1, int index2, int index3) {
        // Your existing logic for highlighting winning moves...
        // Use the provided indices instead of class members
        for (int index : Arrays.asList(index1, index2, index3)) {
            boardBtns.get(index).setStyle("-fx-background-color: lightgreen; -fx-border-color: black; -fx-border-width: 2px;");
        }
    }

    @Override
    public void restart() {
        
        p1ayMoves = BLANK.getMark();                               // reset moves 
        scoreP1.setText("" + _scoreP1);                // update scores on the screen 
        scoreP2.setText("" + _scoreP2);                  // update scores on the screen
        if (turn % 2 == 0) {                                // check for whose turn ? 
            //player 1 turn 
            player1Symbol.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
            player2Symbol.setStyle("-fx-border-color: black; -fx-border-width: 0px;");
            turn = 1;
        } else {
            //player 2 turn
            player2Symbol.setStyle("-fx-border-color: black; -fx-border-width: 2px;");        // set border 
            player1Symbol.setStyle("-fx-border-color: black; -fx-border-width: 0px;");
            turn = 0;
        }
        for (Button b : boardBtns) {
            resetBtn(b);
        }
        for(ImageView img : symbolsImgs)
            removeSymbol(img);
    }
    public void resetBtn(Button btn) {
        btn.setDisable(false);
        btn.setText(BLANK.getMark());
    }

    public void setPlayerSymbol(Button btn) {
        if (turn == 0) {
            btn.setText(X.getMark());
            turn = 1;
        } else {
            btn.setText(O.getMark());
            turn = 0;
        }
    }

    @FXML
    private void exitTheGame(ActionEvent event) throws IOException {
        if(isRecord)
        {
            recordGame.saveRecord(txtPlayer1, txtPlayer2, p1ayMoves, "draw");
            isRecord = false;
        }
        
        FXMLLoader loader = new FXMLLoader (getClass().getResource("/StartScreen/StartScreen.fxml")) ;
          Parent root = loader.load();
          Navigate.navigateTo(root, event);
    }

    @FXML
    private void startRecord(ActionEvent event) throws IOException {
        isRecord = true;
        recordGame = new RecordGame(recBtn);
        recordGame.startRecord();
    }

    public void setPlayerNames(String player1, String player2) {
        txtPlayer1.setText(player1);
        txtPlayer2.setText(player2);
    }
  /*  public void showTheVideo(char gameResult){
        
        try {
            ResultScreenController controller = new ResultScreenController(gameResult);
            FXMLLoader loader = new FXMLLoader (getClass().getResource("/ResultScreen/ResultScreen.fxml"));
            loader.setController(controller);
            Parent root = loader.load();
            System.out.println("Before Navigate.navigateTo");
            Navigate.navigateTo(root);
            Duration delayDuration = Duration.seconds(5); // Adjust the delay time as needed
            Timeline timeline = new Timeline(new KeyFrame(delayDuration, this::goBackToHomeScreen));
            timeline.play();
        } catch (IOException ex) {
            Logger.getLogger(GameScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
   /* public void showTheVideo(char gameResult){
        String video;
        switch(gameResult){
             case 'x':
                 video = "/videos/winner.mp4";
                break;
             case 'o':
                 video = "/videos/loser.mp4";
                 break;
             default:
                 video = "/videos/draw.mp4";
         }
            Media media = new Media(getClass().getResource(video).toExternalForm());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            MediaView mediaView = new MediaView(mediaPlayer);
             // Create a StackPane to hold the mediaView
           
            // Set the size of the stage (adjust as needed)
            
            // Create buttons
            Button playButton = new Button("Play");
            Button stopButton = new Button("Stop");
            TextField countTextField = new TextField("6");
            
            VBox vbox = new VBox(mediaView, playButton, stopButton, countTextField);

            // Create a Scene with the VBox
            Scene videoScene = new Scene(vbox);

            // Create a new Stage for the video
            Stage videoStage = new Stage();
            videoStage.setScene(videoScene);
            videoStage.setWidth(600);
            videoStage.setHeight(500);
            // Set an action to be performed after the video playback
            mediaPlayer.setOnEndOfMedia(() -> {
                // Stop the video and close the stage
                mediaPlayer.stop();
                videoStage.close();
            });
            mediaView.setFitWidth(videoStage.getWidth());
            mediaView.setFitHeight(videoStage.getHeight());

            // Show the video stage
            videoStage.show();

            // Play the video
            mediaPlayer.play();
            Duration countdownDuration = Duration.seconds(10); // Set the countdown duration

            // Create a pause transition to close the stage after the specified duration
            PauseTransition pauseTransition = new PauseTransition(countdownDuration);
          
             pauseTransition.setOnFinished(event -> {
                // Update the countTextField and close the stage
                countTextField.setText("0");
                videoStage.close();
            });
            pauseTransition.play();
            pauseTransition.currentTimeProperty().addListener((obs, oldTime, newTime) -> {
                long secondsRemaining = Math.round(countdownDuration.toSeconds() - pauseTransition.getCurrentTime().toSeconds());
                countTextField.setText(String.valueOf(secondsRemaining));
            });

    }*/
    
    private void goBackToHomeScreen(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/StartScreen/StartScreen.fxml"));
            Parent root = loader.load();
            Navigate.navigateTo(root, event);
        } catch (IOException ex) {
            Logger.getLogger(GameScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void makeComputerMove(){
        int move = ticTacToeAI.minMaxDecision(getBoardState());    
        pickButton(move);
    }

    private void pickButton(int index){
          boardBtns.get(index).setText(O.getMark());
          symbolsImgs.get(index).setImage(new Image(OIMG.getMark()));
          boardBtns.get(index).setDisable(true);
           p1ayMoves += index;
      }
       
    
    
    public BoardState getBoardState(){
        String[] board = new String[9];

        for (int i = 0; i < boardBtns.size(); i++) {
            board[i] = boardBtns.get(i).getText();
        }
        return new BoardState(0,board);
    }
  

    //remove the image from the button
    private void removeSymbol(ImageView img) {
        img.setImage(null);
    }

  
public void showTheVideo(char gameResult){
       new ResultScreen.ResultUI(gameResult);
       
        
       
}

}