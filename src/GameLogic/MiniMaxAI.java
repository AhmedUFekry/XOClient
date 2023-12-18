/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLogic;

import static GameLogic.MarkSymbol.*;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class MiniMaxAI {
 /*  public int miniMax(BoardState state, int depth, boolean isMaximizing){
        int result = checkWinner(state);
        //return result if its leaf or the game ended  
        if(depth == 0 || result != 1) {
             return result;
        }
        if(isMaximizing){
            int finalScore = 
            for(String s : state.getState()){
                if(s == BLANK.getMark())
                {
                    s = X.getMark();
                }
            }
        }
    }*/
    public int minMaxDecision(BoardState state){
        ArrayList<BoardState> possibleMoves = possibleStatesForPlayers(state); 
        ArrayList<Integer> movesList = new ArrayList<>();
        
        for (BoardState states: possibleMoves) {
            movesList.add(minValue(states));
        }

        int min = movesList.get(0);
        int bestIndex = 0;

        for (int i =0; i < movesList.size(); i++) {
            if( movesList.get(i)< min){
                min = movesList.get(i);
                bestIndex = i;
            }
        }
        int action = possibleMoves.get(bestIndex).getPosition();
        return action;
    }
    
    //Find any win state if it exists
    private String checkState(BoardState state, int a) {
         switch (a) {
            case 0: return state.getStateIndex(0) + state.getStateIndex(1) + state.getStateIndex(2);
            case 1 : return state.getStateIndex(3) + state.getStateIndex(4) + state.getStateIndex(5);
            case 2 : return state.getStateIndex(6) + state.getStateIndex(7) + state.getStateIndex(8);
            case 3 : return state.getStateIndex(0) + state.getStateIndex(3) + state.getStateIndex(6);
            case 4 : return state.getStateIndex(1) + state.getStateIndex(4) + state.getStateIndex(7);
            case 5 : return state.getStateIndex(2) + state.getStateIndex(5) + state.getStateIndex(8);
            case 6 : return state.getStateIndex(0) + state.getStateIndex(4) + state.getStateIndex(8);
            case 7 : return state.getStateIndex(2) + state.getStateIndex(4) + state.getStateIndex(6);
            default : return "";
        }
    }
    
    //Returns true if the game is over
    public boolean isGameOver(BoardState state) {
        int btnPlayed = 0;
        for (int a = 0; a < 8; a++) {
            if(state.getStateIndex(a).equals(X.getMark()) || state.getStateIndex(a).equals(O.getMark()) ){
                btnPlayed++; //increase it if the btn hase a data
            }

            String result = checkState(state, a);
            
            //Check for Winners 
            if (result.equals("XXX")) {
                return true; //X winner
            } else if (result.equals("OOO")) {
                return true; //O Winner re
            }
            //if all btn has value
            if(btnPlayed == 9){
                return true; //if its draw
            }
        }
        return false; // the game hasent end
    }

    //Picks best option for the O-player
    private int minValue(BoardState state){
        if (isGameOver(state)){
            return gameResult(state);
        }
        int bestPlaceForO = (int) Double.POSITIVE_INFINITY;
        for (BoardState possibleMove: possibleStatesForPlayers(state)) {
            bestPlaceForO = Math.min(bestPlaceForO, maxValue(possibleMove));
        }
        return bestPlaceForO;
    }
    //Picks best option for the X-player
    private int maxValue(BoardState state){
        if (isGameOver(state)){
            return gameResult(state);
        }
        //return The Max number for X
        int bestPlaceForX = (int) -Double.POSITIVE_INFINITY;
        for (BoardState possibleMove: possibleStatesForPlayers(state)) {
            bestPlaceForX = Math.max(bestPlaceForX, minValue(possibleMove));
        }
        return bestPlaceForX;
    }
    //Returns +1 if X is winner
    //Return -1 if O is winner
    //Returns 0 if no one won
    private int gameResult(BoardState state){
        for (int i = 0; i< 9; i++) {
            String line = checkState(state, i);
            //Check for Winners
            if (line.equals("XXX")) {
                return 1;
            } else if (line.equals("OOO")) {
                return -1;
            }
        }
        return 0;
    }

    //Returns all possible states form a given state
    private ArrayList<BoardState> possibleStatesForPlayers(BoardState state){
        ArrayList<BoardState> possibleMoves = new ArrayList<>();
        int xMoves = 0;
        int yMoves = 0;
        String player;

        //Calculate player turn
        for (String s: state.getState()) {
            if (s.equals("X")) {
                xMoves++;
            }else if(s.equals("O")){
                yMoves++;
            }
        }
        if(xMoves <= yMoves){
            player = X.getMark();
        } else {
            player = O.getMark();
        }
        //Create all possible states
        for (int i = 0; i < 9; i++) {
            String[] newState = state.getState();

            if(newState[i] == BLANK.getMark()){
                newState[i] = player;
                possibleMoves.add(new BoardState(i, newState)); ////
            }
        }
        return possibleMoves;
    }
}
