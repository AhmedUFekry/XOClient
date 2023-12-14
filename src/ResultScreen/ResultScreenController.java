/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResultScreen;



import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.MediaView;

/**
 *
 * @author Rwan el matry
 */
public class ResultScreenController implements Initializable {
    
    private Label label;
    @FXML
    private MediaView resVideo;
    @FXML
    private Label resultTxt;
    @FXML
    private Button exitBtn;
    @FXML
    private Button playAgainBtn;
    @FXML
    private Label txtCounter;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void exitTheGame(ActionEvent event) {
    }

    @FXML
    private void playAgain(ActionEvent event) {
    }
    
}

