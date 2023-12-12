package xoclient.Screens;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import xoclient.Navigate;
import xoclient.Screens.StartScreenBase;

public  class EnterPlayerNamesScreenBase extends BorderPane {

    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final Label label;
    protected final Label label0;
    protected final TextField txtFieldPlayer1;
    protected final TextField txtFieldPlayer2;
    protected final Button btnStart;
    protected final FlowPane flowPane;
    protected final Button backBtn;
    protected final Label label1;

    public EnterPlayerNamesScreenBase() {

        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        label = new Label();
        label0 = new Label();
        txtFieldPlayer1 = new TextField();
        txtFieldPlayer2 = new TextField();
        btnStart = new Button();
        flowPane = new FlowPane();
        backBtn = new Button();
        label1 = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(gridPane, javafx.geometry.Pos.CENTER);
        gridPane.setPrefHeight(110.0);
        gridPane.setPrefWidth(600.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(214.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(81.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(403.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(359.0);

        rowConstraints.setMaxHeight(114.0);
        rowConstraints.setMinHeight(0.0);
        rowConstraints.setPrefHeight(12.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMaxHeight(159.0);
        rowConstraints0.setMinHeight(0.0);
        rowConstraints0.setPrefHeight(16.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setPrefHeight(31.0);
        label.setPrefWidth(110.0);
        label.setText("Player 1");
        label.setFont(new Font(20.0));

        GridPane.setRowIndex(label0, 1);
        label0.setAlignment(javafx.geometry.Pos.CENTER);
        label0.setPrefHeight(31.0);
        label0.setPrefWidth(110.0);
        label0.setText("Player 2");
        label0.setFont(new Font(20.0));

        GridPane.setColumnIndex(txtFieldPlayer1, 1);
        txtFieldPlayer1.setPrefHeight(31.0);
        txtFieldPlayer1.setPrefWidth(277.0);
        txtFieldPlayer1.setPromptText("enter your name ");

        GridPane.setColumnIndex(txtFieldPlayer2, 1);
        GridPane.setRowIndex(txtFieldPlayer2, 1);
        txtFieldPlayer2.setPromptText("enter your name");
        BorderPane.setMargin(gridPane, new Insets(30.0, 80.0, 30.0, 80.0));
        setCenter(gridPane);

        BorderPane.setAlignment(btnStart, javafx.geometry.Pos.CENTER);
        btnStart.setMnemonicParsing(false);
        btnStart.setPrefHeight(55.0);
        btnStart.setPrefWidth(162.0);
        btnStart.setText("Start");
        BorderPane.setMargin(btnStart, new Insets(0.0, 0.0, 30.0, 0.0));
        btnStart.setFont(new Font(20.0));
        setBottom(btnStart);
         btnStart.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                GameScreenBase gs=new  GameScreenBase();
                gs.txtPlayer1.setText(txtFieldPlayer1.getText());
                gs.txtPlayer2.setText(txtFieldPlayer2.getText());
                
                        
               Navigate.navigateTo(gs,e);
                
            }
        });

        BorderPane.setAlignment(flowPane, javafx.geometry.Pos.CENTER);
        flowPane.setHgap(15.0);
        flowPane.setPrefHeight(51.0);
        flowPane.setPrefWidth(600.0);

        backBtn.setMnemonicParsing(false);
        backBtn.setPrefHeight(25.0);
        backBtn.setPrefWidth(65.0);
        backBtn.setText("Back");
        FlowPane.setMargin(backBtn, new Insets(0.0, 0.0, 0.0, 20.0));
         backBtn.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
              
                
                        
                Navigate.navigateTo(new StartScreenBase(),e);
            }
        });

        label1.setAlignment(javafx.geometry.Pos.CENTER);
        label1.setPrefHeight(59.0);
        label1.setPrefWidth(405.0);
        label1.setText("Enter Your Name");
        label1.setFont(new Font("Baskerville Old Face", 36.0));
        setTop(flowPane);

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getChildren().add(label);
        gridPane.getChildren().add(label0);
        gridPane.getChildren().add(txtFieldPlayer1);
        gridPane.getChildren().add(txtFieldPlayer2);
        flowPane.getChildren().add(backBtn);
        flowPane.getChildren().add(label1);

    }
}
