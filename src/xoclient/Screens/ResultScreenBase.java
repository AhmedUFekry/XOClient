package xoclient.Screens;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public abstract class ResultScreenBase extends AnchorPane {

    protected final MediaView resVideo;
    protected final Text text;
    protected final Button exiButton;
    protected final Button repButton;

    public ResultScreenBase() {

        resVideo = new MediaView();
        text = new Text();
        exiButton = new Button();
        repButton = new Button();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        resVideo.setFitHeight(200.0);
        resVideo.setFitWidth(200.0);
        resVideo.setLayoutX(200.0);
        resVideo.setLayoutY(77.0);

        text.setLayoutX(215.0);
        text.setLayoutY(43.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Result Screen");
        text.setWrappingWidth(170.13665771484375);
        text.setFont(new Font("System Bold Italic", 23.0));

        exiButton.setLayoutX(70.0);
        exiButton.setLayoutY(319.0);
        exiButton.setMnemonicParsing(false);
        exiButton.setPrefHeight(31.0);
        exiButton.setPrefWidth(96.0);
        exiButton.setText("Exit");
        exiButton.setFont(new Font("System Italic", 14.0));

        repButton.setLayoutX(446.0);
        repButton.setLayoutY(319.0);
        repButton.setMnemonicParsing(false);
        repButton.setPrefHeight(31.0);
        repButton.setPrefWidth(96.0);
        repButton.setText("Replay");
        repButton.setFont(new Font("System Italic", 15.0));

        getChildren().add(resVideo);
        getChildren().add(text);
        getChildren().add(exiButton);
        getChildren().add(repButton);

    }
}
