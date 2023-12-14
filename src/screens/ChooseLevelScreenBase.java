package screens;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import xoclient.Navigate;
import screens.StartScreenBase;

public  class ChooseLevelScreenBase extends AnchorPane {

    protected final Text text;
    protected final Text text0;
    protected final Button easyButton;
    protected final Button midButton;
    protected final Button hardButton;
    protected final Button backBtn;

    public ChooseLevelScreenBase() {

        text = new Text();
        text0 = new Text();
        easyButton = new Button();
        midButton = new Button();
        hardButton = new Button();
        backBtn = new Button();

        setId("AnchorPane");
        setPrefHeight(337.0);
        setPrefWidth(500.0);

        text.setLayoutX(189.0);
        text.setLayoutY(60.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Tic Tac Toe");
        text.setWrappingWidth(160.13668823242188);
        text.setFont(new Font("System Bold Italic", 26.0));

        text0.setLayoutX(25.0);
        text0.setLayoutY(102.0);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("Choose Level ");
        text0.setWrappingWidth(144.13668823242188);
        text0.setFont(new Font("System Italic", 20.0));

        easyButton.setLayoutX(207.0);
        easyButton.setLayoutY(107.0);
        easyButton.setMnemonicParsing(false);
        easyButton.setPrefHeight(25.0);
        easyButton.setPrefWidth(87.0);
        easyButton.setText("Easy");
        easyButton.setFont(new Font("System Italic", 13.0));
         easyButton.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                Navigate.navigateTo(new GameScreenBase(),e);
            }
        });

        midButton.setLayoutX(207.0);
        midButton.setLayoutY(169.0);
        midButton.setMnemonicParsing(false);
        midButton.setPrefHeight(29.0);
        midButton.setPrefWidth(87.0);
        midButton.setText("Mid");
        midButton.setFont(new Font("System Italic", 14.0));

        hardButton.setLayoutX(207.0);
        hardButton.setLayoutY(235.0);
        hardButton.setMnemonicParsing(false);
        hardButton.setPrefHeight(30.0);
        hardButton.setPrefWidth(87.0);
        hardButton.setText("Hard");
        hardButton.setFont(new Font("System Italic", 13.0));

        backBtn.setLayoutX(14.0);
        backBtn.setLayoutY(14.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setText("Back");
         backBtn.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                Navigate.navigateTo(new StartScreenBase(),e);
            }
        });

        getChildren().add(text);
        getChildren().add(text0);
        getChildren().add(easyButton);
        getChildren().add(midButton);
        getChildren().add(hardButton);
        getChildren().add(backBtn);

    }
}
