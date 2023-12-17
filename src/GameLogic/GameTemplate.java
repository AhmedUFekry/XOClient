/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLogic;

import javafx.scene.control.Button;

/**
 *
 * @author DELL
 */
public abstract class GameTemplate {
 
   
   public abstract void start();
   public abstract void play(Button btn);
   public abstract void checkResult();
   public abstract void restart();

  
}
