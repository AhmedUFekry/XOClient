/*[]
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLogic;

/**
 *
 * @author DELL
 */
public class BoardState {
    private String[] state;
    private int position;
    public BoardState(int position,String[] state){
        this.position = position; //0
        this.state = state;  // all text in btn
    }
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String[] getState() {
        return state;
    }

    public String getStateIndex(int i){
        return state[i];
    }

    public void setState(String[] state) {
        this.state = state;
    }


}
