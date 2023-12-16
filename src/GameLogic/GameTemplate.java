/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLogic;

/**
 *
 * @author DELL
 */
public abstract class GameTemplate {
   public void GameTemplate(){
       init();
       start();
       play();
       checkResult();
       playVideo();
       restart();
   }
   public abstract void init();
   public abstract void start();
   public abstract void play();
   public abstract void checkResult();
   public void playVideo(){}
   public abstract void restart();

  
}
