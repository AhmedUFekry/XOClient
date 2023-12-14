/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Rwan el matry
 */
public class StartScreenController implements Initializable {
    String dirName = "GameRecords";
    String newFileName = "GameRecords";
    String recordsDirPath = "D:\\ITI Native 9 month\\Java\\Laps\\JavaProject\\XOClient\\GameRecords";
    String dirPath = "D:\\ITI Native 9 month\\Java\\Laps\\JavaProject\\XOClient";
    File dir ;
    File file ;
    File[] recordsList;
    FileInputStream fis;
    DataInputStream dis;
    String game;
    
    private Label label;
    @FXML
    private Button singButton;
    @FXML
    private Button dualButton;
    @FXML
    private Button onlButton;
    @FXML
    private Button showRecBtn;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dir = new File(dirPath, dirName);
        recordsList = dir.listFiles();
        onlButton.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage primaryStage = (Stage) onlButton.getScene().getWindow();
                //Stage primaryStage = new Stage();
                LoginScreenBase pro = new LoginScreenBase();
                Parent root = pro;
                primaryStage.setScene(new Scene(root, USE_PREF_SIZE, USE_PREF_SIZE));
                primaryStage.show();
            }
        });
        showRecBtn.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(file == null)
                {
                    try{
                    file = new File(recordsDirPath, newFileName);    
                    fis = new FileInputStream(file);
                    dis = new DataInputStream(fis);
                    game = dis.readUTF();
                    System.out.println(game);
                    //textAreaId.setText(s);
                    fis.close();
                    }catch(Exception e) {
                        e.printStackTrace();                        
                    }
                }else{
               System.out.println(game);
                } 
            }
        });
        // TODO
    }    

    @FXML
    private void showChooseLevelScreen(ActionEvent event) {
    }
    
}
