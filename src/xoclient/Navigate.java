/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xoclient;

import java.awt.event.MouseEvent;
import java.util.Stack;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 public class Navigate{
     private static Scene scene;
     private static Stage stage;
      private static Stack<Parent> screenHistory = new Stack<>();
      public static Parent homeScreen;

    public static void setHomeScreen(Parent root) {
        homeScreen = root;
    }
      
// navigate by event action parameter
    public static void navigateTo(Parent distinationRoot, ActionEvent event){
        scene  = new Scene(distinationRoot);
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        showScene();
       
    }
    
    // navigate by event parameter
    public static void navigateTo(Parent distinationRoot, Event event){
        scene = new Scene(distinationRoot);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        showScene();
    }
    // navigate by mouse event
     public static void navigateTo(Parent distinationRoot, MouseEvent event){
        scene = new Scene(distinationRoot);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        showScene();
    }
    
    // navigate by stage parameter
    public static void navigateTo(Parent distinationRoot, Stage currentStage){
        scene = new Scene(distinationRoot);
        stage = currentStage;
        showScene();
    }
    
    // navigate by stage parameter
    public static void navigateTo(Parent distinationRoot){
        scene = new Scene(distinationRoot);
      
        showScene();
    }
   
    private static void showScene(){
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

}
