/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xoclient;

//import xoclient.Screens.StartScreenBase;

import ClientServer.Client;
import OnlineListScreen.OnlineListScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;




/**
 *
 * @author Ahmed Fekry
 */
public class XOClient extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Parent root = new StartScreenBase();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/StartScreen/StartScreen.fxml"));
        Parent root = loader.load();
        //OnlineListScreenController controller = loader.getController();
       
        Scene scene = new Scene(root);
        
        
        
        stage.setScene(scene);
        stage.show();
        Navigate.setHomeScreen(root);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

