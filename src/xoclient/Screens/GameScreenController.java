/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xoclient.Screens;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import xoclient.Navigate;

/**
 *
 * @author LENOVO
 */
public class GameScreenController implements Initializable {

 

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
    public Boolean isRecorded;
    String timeStamp ;
    String timeStampAfterReplace ;
    String newFileName ;
    String recordsDirPath = "D:\\ITI Native 9 month\\Java\\Laps\\JavaProject\\XOClient\\GameRecords";
    File file ;
    FileOutputStream fos;
    DataOutputStream dos;
    String intofile;
    private ArrayList<Button> boardBtns;                //BoardButtons
    //  private int gameId;                                 // to store game Id 
    private int turn;
    private static int _scoreP1 = 0;
    private static int _scoreP2 = 0;
    private String[] players = {"X", "O"};
    private String p1ayMoves;

    public void initialize(URL location, ResourceBundle resources) {
        /**************** Game Logic Init */
   //  gameId = 0;
        isRecorded = false;
        turn = 0;
        p1ayMoves = "";
        scoreP1.setText("0");
        scoreP2.setText("0");
        player1Symbol.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        boardBtns = new ArrayList<>(Arrays.asList(button1, button2, button3, button4, button5, button6, button7, button8, button9));
        exitBtn.addEventHandler(ActionEvent.ACTION, e -> {
            System.out.println("hello");
        });
        boardBtns.forEach(button -> {
            setUpBtn(button);
        });
        /*********************************/ 
        
        exitBtn.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                if(isRecorded){
                    try {
                        fos.close();
                    } catch (IOException ex) {
                        Logger.getLogger(GameScreenBase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    isRecorded = false;
                }
                Navigate.navigateTo(new StartScreenBase(),e);
            }
        });
        recBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                isRecorded = true;
                timeStamp = new Timestamp(System.currentTimeMillis()).toString();
                timeStampAfterReplace = timeStamp.replace(":", "-");
                newFileName = timeStampAfterReplace + ".txt";
                file = new File(recordsDirPath, newFileName);
                try{
                    fos = new FileOutputStream(file);
                    dos = new DataOutputStream(fos);
                    recBtn.setDisable(true);
                    }catch(Exception ex) {
                        ex.printStackTrace();                        
                    }
                    
            }
        });
    }
    
      private void setUpBtn(Button btn) {

        btn.addEventHandler(ActionEvent.ACTION, e -> {
            Integer index;
            setPlayerSymbol(btn);
            index = boardBtns.indexOf(btn);
            p1ayMoves = p1ayMoves + index;
            //recorded game****************************
            if (isRecorded) {
               /* if (file != null) {
                    try {
                        dos.writeInt(index);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }*/
            }
            //*******************************************************************************************************************************
            btn.setDisable(true);
            try {
                checkResult();
            } catch (IOException ex) {
                Logger.getLogger(GameScreenBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

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

    public void checkResult() throws IOException {
        
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
            
            if (result.matches("XXX")) {
                ++_scoreP1;                    
                System.out.println("X wins ");
                if(isRecorded){
                     if (file != null) {
                    try {
                        intofile = p1ayMoves + "." + txtPlayer1.getText() + "." + txtPlayer2.getText() + ".X wins ";
                        System.err.println(intofile);
                        
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                    fos.close();
                    recBtn.setDisable(false);
                    isRecorded = false;
                }
                restartGame();
                
                // go to video screen or tab 
            } else if (result.matches("OOO")) {
                ++_scoreP2;
                System.out.println("O wins ");
                
                if(isRecorded){
                     if (file != null) {
                    try {
                        intofile = p1ayMoves + "." + txtPlayer1.getText() + "." + txtPlayer2.getText() + ".O wins ";
                        System.err.println(intofile);
                        
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                    fos.close();
                    recBtn.setDisable(false);
                    isRecorded = false;
                }
                restartGame();
                // go to video screen or tab 
            } else if (p1ayMoves.length() == 9) {
                System.out.println("draw");
                if(isRecorded){
                     if (file != null) {
                    try {
                         intofile = p1ayMoves + "." + txtPlayer1.getText() + "." + txtPlayer2.getText() + ".draw";
                         dos.writeUTF(intofile);
                         
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                    fos.close();
                    recBtn.setDisable(false);
                    isRecorded = false;
                }
                restartGame();
            }
        }
    }

    public void restartGame() {
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
            player1Symbol.setText("X");
            player2Symbol.setText("O");
            turn = 0;
        }
        for (Button b : boardBtns) {
            resetBtn(b);
        }
    }
    
    

   
}
