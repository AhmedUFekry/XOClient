/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameScreen;

import GameLogic.GameTemplate;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import xoclient.Navigate;

/**
 *
 * @author LENOVO
 */
public class GameScreenController extends GameTemplate implements Initializable {
   
     // Logic variables
    private ArrayList<Button> boardBtns;                //BoardButtons
    //  private int gameId;                                 // to store game Id 
    
    private int turn;
    private static int _scoreP1 = 0;
    private static int _scoreP2 = 0;
    private String[] players = {"X","O"};
    private String p1ayMoves;

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

    @Override
    public void initialize(URL location, ResourceBundle resources){

     /**************** Game Logic Init */
        turn = 0;
        p1ayMoves = "";
        // init UI
        scoreP1.setText("0");
        scoreP2.setText("0");
        player1Symbol.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        boardBtns = new ArrayList<>(Arrays.asList(button1, button2, button3, button4, button5, button6, button7, button8, button9));
       
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
            play(button);
        });
    }
    @Override
    public void play(Button btn) {

        btn.addEventHandler(ActionEvent.ACTION, e -> {
            int index;
            setPlayerSymbol(btn);
            index = boardBtns.indexOf(btn);
            p1ayMoves = p1ayMoves + index;
            btn.setDisable(true);
            checkResult();
        });
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
                  
                    
                    //    ResultScreen.ResultScreenController controller = loader.getController();
                    //    controller.setResult(result);
                    
                    // showTheVideo('X');
                    
                    
                    restart();
                    // go to video screen or tab 
             
            } else if (result.matches("OOO")) {
                ++_scoreP2;
                System.out.println("O wins ");
               // showTheVideo('O');
               
                restart();
                // go to video screen or tab 
            } else if (p1ayMoves.length() == 9) {
                System.out.println("draw");
              
                restart();
            }
        
        }
    }
    @Override
    public void restart() {
        // u should add code to store Game Records here 
        /*
        
        
        */
        
        p1ayMoves = "";                               // reset moves 
        scoreP1.setText("" + _scoreP1);                // update scores on the screen 
        scoreP2.setText("" + _scoreP2);                  // update scores on the screen
        if (turn % 2 == 0) {                                // check for whose turn ? 
            //player 1 turn 
            player1Symbol.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
            player2Symbol.setStyle("-fx-border-color: black; -fx-border-width: 0px;");
            player1Symbol.setText("X");
            player2Symbol.setText("O");
            turn = 1;
        } else {
            //player 2 turn
            player2Symbol.setStyle("-fx-border-color: black; -fx-border-width: 2px;");        // set border 
            player1Symbol.setStyle("-fx-border-color: black; -fx-border-width: 0px;");
            player1Symbol.setText("O");
            player2Symbol.setText("X");
            turn = 0;
        }
        for (Button b : boardBtns) {
            resetBtn(b);
        }
    }
    public void resetBtn(Button btn) {
        btn.setDisable(false);
        btn.setText(" ");
    }

    public void setPlayerSymbol(Button btn) {
        if (turn % 2 == 0) {
            btn.setText("X");
            turn = 1;
        } else {
            btn.setText("O");
            turn = 0;
        }
    }

    @FXML
    private void exitTheGame(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader (getClass().getResource("/StartScreen/StartScreen.fxml")) ;
          Parent root = loader.load();
          Navigate.navigateTo(root, event);
    }

    @FXML
    private void startRecord(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader (getClass().getResource("/ResultScreen/ResultScreen.fxml")) ;
          Parent root = loader.load();
          Navigate.navigateTo(root, event);
    }

    public void setPlayerNames(String player1, String player2) {
        txtPlayer1.setText(player1);
        txtPlayer2.setText(player2);
    }
    public void showTheVideo() throws IOException{
              FXMLLoader loader = new FXMLLoader (getClass().getResource("/ResultScreen/ResultScreen.fxml")) ;
            Parent root;

            root = loader.load();
            ActionEvent event = null;
            Navigate.navigateTo(root, event);
    }

    
  

 

  


}