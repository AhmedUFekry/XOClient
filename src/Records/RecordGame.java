/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Records;

import GameScreen.GameScreenController;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author Ahmed Fekry
 */
public class RecordGame {
    
    private String timeStamp;
    private String timeStampAfterReplace;
    private String newFileName;
    private String recordsDirPath = "./GameRecords";
    private File file;
    private FileOutputStream fos;
    private DataOutputStream dos;
    private String intofile;
    private Button recBtn;

    RecordGame(Button recordButton) {
        recBtn = recordButton;
    }

    public void startRecord() {

        timeStamp = new Timestamp(System.currentTimeMillis()).toString();
        timeStampAfterReplace = timeStamp.replace(":", "-");
        newFileName = timeStampAfterReplace + ".txt";
        file = new File(recordsDirPath, newFileName);
        try {
            fos = new FileOutputStream(file);
            dos = new DataOutputStream(fos);
            recBtn.setDisable(true);
            // Your code for recording goes here
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
//intofile = p1ayMoves + "." + Player1.getText() + "." + Player2.getText() + "." + winnerLabel +"Wins";

    public void saveRecord(Label Player1, Label Player2, String p1ayMoves, String winnerLabel) {

        try {
            if (file != null) {
                try {
                    intofile = p1ayMoves + " . " + Player1.getText() + " . " + Player2.getText() + " . " + winnerLabel + " Wins";
                    dos.writeUTF(intofile);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            fos.close();
            recBtn.setDisable(false);
            recBtn.setDisable(false);
        } catch (IOException ex) {
            Logger.getLogger(GameScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
