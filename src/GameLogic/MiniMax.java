/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLogic;

import static GameLogic.MarkSymbol.*;
import java.util.ArrayList;
import javafx.scene.control.Button;

/**
 *
 * @author DELL
 */
public class MiniMax {
    private ArrayList<Button> boardStatus;
    public int miniMax(ArrayList<Button> board, int depth, boolean isMaximizing, boolean firstTime ){
        
        int result = checkWinner(board);
        if(depth == 0 || result != 1) {
            return result;
        }
        if(isMaximizing) {
            int finalScore = -10;
            int finalIndex = 0;
            for(int i = 0 ; i<board.size();i++){
                if(board.get(i).getText() == BLANK.getMark()) {
                    board.get(i).setText(X.getMark());
                    int score = miniMax(board, depth - 1, false, false);
                    board.get(i).setText(BLANK.getMark());
                    if(score > finalScore) {
                        finalScore = score;
                        finalIndex = i;
                    }
                }
            }
        if(firstTime) {
            board.get(finalIndex).setText(O.getMark());
        }
            return finalIndex;
        }else{
            int finalScore = 10;
            int finalIndex = 0;
            for(int i = 0 ; i<board.size();i++){
                if(board.get(i).getText() == BLANK.getMark()) {
                    board.get(finalIndex).setText(O.getMark());
                    int score = miniMax(board, depth - 1, true, false);
                    board.get(i).setText(BLANK.getMark());
                    if(score < finalScore) {
                        finalScore = score;
                        finalIndex = i;
                    }
                }
            }
            if(firstTime) {
                 board.get(finalIndex).setText(O.getMark());
            }
            return finalIndex;
        }
    }
    private int checkWinner(ArrayList<Button> board) {
        String result = null ;
        for(int i =0; i<board.size(); i++){
            switch (i) {
               case 0:
                   result = board.get(0).getText() + board.get(1).getText() + board.get(3).getText(); // 0 1 2 
                   break;
               case 1 :
                   result = board.get(3).getText() + board.get(4).getText() + board.get(5).getText(); // 3 4 5 
                   break;
               case 2 :
                   result =  board.get(6).getText() + board.get(7).getText() + board.get(8).getText();  // 6 7  8 
                   break;
               case 3 : 
                   result = board.get(0).getText() + board.get(4).getText() + board.get(6).getText(); //0 4 6
                   break;
               case 4 :
                   result = board.get(1).getText() + board.get(4).getText() + board.get(7).getText(); // 1 4 7
                   break;
               case 5 :
                   result = board.get(2).getText() + board.get(5).getText() + board.get(8).getText(); // 2 5 8
                   break;
               case 6 :
                   result =  board.get(0).getText() + board.get(4).getText() + board.get(8).getText(); // 0 4 8
                   break;
               case 7 : 
                   result = board.get(2).getText() + board.get(4).getText() + board.get(6).getText(); // 2 4 6
                   break;
               default : 
                   result = BLANK.getMark();
           }
        }
        boolean tie = true;
            if (result.equals("XXX")) {
                return 2; //X winner
            } else if (result.equals("OOO")) {
                return -2; //O Winner re
            }else if(result == BLANK.getMark())
                tie = false; 
            if(tie)
                return 0;
            return 1;
    }
    
}
