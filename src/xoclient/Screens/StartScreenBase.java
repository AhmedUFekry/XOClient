package xoclient.Screens;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public  class StartScreenBase extends AnchorPane {

    protected final Text text;
    protected final Text text0;
    protected final Button singButton;
    protected final Button dualButton;
    protected final Button onlButton;

    public StartScreenBase() {

        text = new Text();
        text0 = new Text();
        singButton = new Button();
        dualButton = new Button();
        onlButton = new Button();

        setId("AnchorPane");
        setPrefHeight(322.0);
        setPrefWidth(492.0);

        text.setLayoutX(167.0);
        text.setLayoutY(49.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Tic Tac Toe");
        text.setWrappingWidth(158.13671875);
        text.setFont(new Font("System Bold Italic", 23.0));

        text0.setLayoutX(178.0);
        text0.setLayoutY(109.0);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("Game Mood");
        text0.setWrappingWidth(108.13671875);
        text0.setFont(new Font("System Italic", 18.0));

        singButton.setLayoutX(42.0);
        singButton.setLayoutY(164.0);
        singButton.setMnemonicParsing(false);
        singButton.setPrefHeight(59.0);
        singButton.setPrefWidth(77.0);
        singButton.setText("Single");
        singButton.setFont(new Font("System Italic", 15.0));
        
        dualButton.setLayoutX(194.0);
        dualButton.setLayoutY(164.0);
        dualButton.setMnemonicParsing(false);
        dualButton.setPrefHeight(59.0);
        dualButton.setPrefWidth(77.0);
        dualButton.setText("Dual");
        dualButton.setFont(new Font("System Italic", 15.0));
        dualButton.addEventHandler(ActionEvent.ACTION,e->{
        Stage st = (Stage) singButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GameScreen.fxml"));
        
            try {
                VBox root;
                root = loader.load();
                  GameScreenController controller = loader.getController();
                   st.setScene(new Scene(root,USE_PREF_SIZE,USE_PREF_SIZE));
                   st.show();
            } catch (IOException ex) {
                Logger.getLogger(StartScreenBase.class.getName()).log(Level.SEVERE, null, ex);
            }
      
        });
        onlButton.setLayoutX(352.0);
        onlButton.setLayoutY(164.0);
        onlButton.setMnemonicParsing(false);
        onlButton.setPrefHeight(59.0);
        onlButton.setPrefWidth(77.0);
        onlButton.setText("Online");
        onlButton.setFont(new Font("System Italic", 15.0));

        getChildren().add(text);
        getChildren().add(text0);
        getChildren().add(singButton);
        getChildren().add(dualButton);
        getChildren().add(onlButton);

    }
}
