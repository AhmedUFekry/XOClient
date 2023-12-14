package xoclient.Screens;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import xoclient.Navigate;

public class StartScreenBase extends AnchorPane {

    protected final Text text;
    protected final Text text0;
    protected final Button singButton;
    protected final Button dualButton;
    protected final Button onlButton;
    protected final Button showRecBtn;
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
    

    public StartScreenBase() {
        dir = new File(dirPath, dirName);
        recordsList = dir.listFiles();
        text = new Text();
        text0 = new Text();
        singButton = new Button();
        dualButton = new Button();
        onlButton = new Button();
        showRecBtn = new Button();

        setId("AnchorPane");
        setPrefHeight(322.0);
        setPrefWidth(492.0);

        text.setLayoutX(168.0);
        text.setLayoutY(49.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Tic Tac Toe");
        text.setWrappingWidth(158.13671875);
        text.setFont(new Font("System Bold Italic", 23.0));

        text0.setLayoutX(179.0);
        text0.setLayoutY(78.0);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("Game Mood");
        text0.setWrappingWidth(108.13671875);
        text0.setFont(new Font("System Italic", 18.0));

        singButton.setLayoutX(50.0);
        singButton.setLayoutY(202.0);
        singButton.setMnemonicParsing(false);
        singButton.setPrefHeight(59.0);
        singButton.setPrefWidth(77.0);
        singButton.setText("Single");
        singButton.setFont(new Font("System Italic", 15.0));
        singButton.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                Navigate.navigateTo(new ChooseLevelScreenBase(),e);
            }
        });

        dualButton.setLayoutX(202.0);
        dualButton.setLayoutY(202.0);
        dualButton.setMnemonicParsing(false);
        dualButton.setPrefHeight(59.0);
        dualButton.setPrefWidth(77.0);
        dualButton.setText("Dual");
        dualButton.setFont(new Font("System Italic", 15.0));
        dualButton.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                Navigate.navigateTo(new EnterPlayerNamesScreenBase(),e);
            }
        });

        onlButton.setLayoutX(360.0);
        onlButton.setLayoutY(202.0);
        onlButton.setMnemonicParsing(false);
        onlButton.setPrefHeight(59.0);
        onlButton.setPrefWidth(77.0);
        onlButton.setText("Online");
        onlButton.setFont(new Font("System Italic", 15.0));
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

        showRecBtn.setLayoutX(176.0);
        showRecBtn.setLayoutY(114.0);
        showRecBtn.setMnemonicParsing(false);
        showRecBtn.setText("Show Records");
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

        getChildren().add(text);
        getChildren().add(text0);
        getChildren().add(singButton);
        getChildren().add(dualButton);
        getChildren().add(onlButton);
        getChildren().add(showRecBtn);

    }

    

}
