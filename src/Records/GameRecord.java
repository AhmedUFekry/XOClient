/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Records;

/**
 *
 * @author Ahmed Fekry
 */
public class GameRecord {

    private int[] gameMoves;
    private String firstPlayerName;
    private String secondPlayerName;
    private String gameResult;

    /**
     * @return the gameMoves
     */
    public int[] getGameMoves() {
        return gameMoves;
    }

    /**
     * @param gameMoves the gameMoves to set
     */
    public void setGameMoves(int[] gameMoves) {
        this.gameMoves = gameMoves;
    }

    /**
     * @return the firstPlayerName
     */
    public String getFirstPlayerName() {
        return firstPlayerName;
    }

    /**
     * @param firstPlayerName the firstPlayerName to set
     */
    public void setFirstPlayerName(String firstPlayerName) {
        this.firstPlayerName = firstPlayerName;
    }

    /**
     * @return the secondPlayerName
     */
    public String getSecondPlayerName() {
        return secondPlayerName;
    }

    /**
     * @param secondPlayerName the secondPlayerName to set
     */
    public void setSecondPlayerName(String secondPlayerName) {
        this.secondPlayerName = secondPlayerName;
    }

    /**
     * @return the gameResult
     */
    public String getGameResult() {
        return gameResult;
    }

    /**
     * @param gameResult the gameResult to set
     */
    public void setGameResult(String gameResult) {
        this.gameResult = gameResult;
    }

}
