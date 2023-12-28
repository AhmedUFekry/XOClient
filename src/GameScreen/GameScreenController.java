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
            int result =miniMax.miniMax(boardBtns, 100, false,true);
             pickButton(result);
             checkResult();
            
         });   
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
    private void computerMoveEasy(Button btn) {  // handle computer move 

            while (true) {
                int index = random.nextInt(9);

                if (boardBtns.get(index).getText().isEmpty()) {
                   // boardBtns.get(index).setText("O");
                   // boardBtns.get(index).setDisable(true);
                   pickButton(index);

                    checkResult();
                    turn = 0;
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