/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import RecordScreen.RecordsScreenController;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import xoclient.Navigate;

/**
 *
 * @author Rwan el matry
 */
public class StartScreenController implements Initializable {
    String dirName = "GameRecords";
    String newFileName = "2023-12-14 03-35-25.408.txt";
    String recordsDirPath = "./GameRecords";
    String dirPath = "D:\\ITI Native 9 month\\Java\\Laps\\JavaProject\\XOClient";
    File dir ;
    File file ;
    File[] recordsList;
    FileInputStream fis;
    DataInputStream dis;
    String game;
    String[] gameee;
    Recordings recordings;
    
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
        recordings = new Recordings(recordsDirPath);
        gameee = recordings.getRecordedGamesList();
        for (int x=0; x<gameee.length; x++)
        System.out.println(gameee[x]);
        
        dir = new File(recordsDirPath);
        recordsList = dir.listFiles();
        /*if (recordsList != null) {
            // Display the list of files in the TextArea
            StringBuilder fileList = new StringBuilder();
            for (File file : recordsList) {
                fileList.append(file.getAbsolutePath()).append("\n");
            }
            System.out.println(fileList.toString());
        } else {
            System.out.println("No files in the specified directory.");
        }*/
        
        
        
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
        singButton.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                Navigate.navigateTo(new ChooseLevelScreenBase(),e);
            }
        });
         dualButton.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                Navigate.navigateTo(new EnterPlayerNamesScreenBase(),e);
            }
        });
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

        // TODO
    }    

    @FXML
    private void showChooseLevelScreen(ActionEvent event) {
    }

    @FXML
    private void gotoRecScreen(ActionEvent event) throws IOException {
        if(file == null)
                {
                    try{
                    file = new File(recordsDirPath, newFileName);    
                    fis = new FileInputStream(file);
                    dis = new DataInputStream(fis);
                    game = dis.readUTF();
                    System.out.println(game);
                    //System.out.println(recordsList.get(0).getName()); 
                    //textAreaId.setText(s);
                    fis.close();
                    //Stage primaryStage = (Stage) showRecBtn.getScene().getWindow();
                     //Stage primaryStage = new Stage();
                    
                    // primaryStage.setScene(new Scene(root, USE_PREF_SIZE, USE_PREF_SIZE));
                    // primaryStage.show();
                    }catch(Exception e) {
                        e.printStackTrace();                        
                    }
                }else{
               System.out.println(game);
                }
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/RecordScreen/RecordsScreen.fxml"));
         Parent root = loader.load();
         RecordsScreenController recScreen = loader.getController();
        // recScreen.files = recordsList;
         Navigate.navigateTo(root, event);
    }
    
}
