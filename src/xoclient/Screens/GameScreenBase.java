package xoclient.Screens;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import xoclient.Navigate;
import xoclient.Screens.StartScreenBase;

public  class GameScreenBase extends BorderPane {

    protected final HBox hBox;
    protected final VBox vBox;
  //  protected final ImageView imageView;
    protected final  Label txtPlayer1;
    protected final Label player1Symbol;
    protected final VBox vBox0;
    protected final Label label;
    protected final Label label0;
    protected final HBox hBox0;
    protected final Label label1;
    protected final Label label2;
    protected final Label label3;
    protected final VBox vBox1;
    //protected final ImageView imageView0;
    protected final  Label txtPlayer2;
    protected final Label player2Symbol;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Label cell;
    protected final Label cell0;
    protected final Label cell1;
    protected final Label cell2;
    protected final Label cell3;
    protected final Label cell4;
    protected final Label cell5;
    protected final Label cell6;
    protected final Label cell7;
    protected final Pane pane;
    protected final Button exitBtn;
    protected final Button recBtn;
    
    //protected final ImageView imageView1;

    public GameScreenBase() {

        hBox = new HBox();
        vBox = new VBox();
      //  imageView = new ImageView();
        txtPlayer1 = new Label();
        player1Symbol = new Label();
        vBox0 = new VBox();
        label = new Label();
        label0 = new Label();
        hBox0 = new HBox();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        vBox1 = new VBox();
        //imageView0 = new ImageView();
        txtPlayer2 = new Label();
        player2Symbol = new Label();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        cell = new Label();
        cell0 = new Label();
        cell1 = new Label();
        cell2 = new Label();
        cell3 = new Label();
        cell4 = new Label();
        cell5 = new Label();
        cell6 = new Label();
        cell7 = new Label();
        pane = new Pane();
        exitBtn = new Button();
        recBtn = new Button();
       // imageView1 = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(115.0);
        hBox.setPrefWidth(600.0);

        vBox.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        vBox.setPrefHeight(200.0);
        vBox.setPrefWidth(100.0);

        /*imageView.setFitHeight(124.0);
        imageView.setFitWidth(103.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        VBox.setMargin(imageView, new Insets(0.0));
        imageView.setImage(new Image(getClass().getResource("../Icons/icon1.png").toExternalForm()));*/

        txtPlayer1.setAlignment(javafx.geometry.Pos.CENTER);
        txtPlayer1.setPrefHeight(21.0);
        txtPlayer1.setPrefWidth(192.0);
        txtPlayer1.setText("Player 1");
        txtPlayer1.setFont(new Font("Baskerville Old Face", 20.0));

        player1Symbol.setAlignment(javafx.geometry.Pos.CENTER);
        player1Symbol.setPrefHeight(21.0);
        player1Symbol.setPrefWidth(208.0);
        player1Symbol.setText("X");
        player1Symbol.setFont(new Font("Baskerville Old Face", 20.0));
        HBox.setMargin(vBox, new Insets(0.0, 60.0, 0.0, 10.0));

        vBox0.setAlignment(javafx.geometry.Pos.CENTER);
        vBox0.setPrefHeight(147.0);
        vBox0.setPrefWidth(161.0);

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setPrefHeight(50.0);
        label.setPrefWidth(166.0);
        label.setText("VS");
        label.setFont(new Font("Baskerville Old Face", 35.0));

        label0.setAlignment(javafx.geometry.Pos.CENTER);
        label0.setPrefHeight(46.0);
        label0.setPrefWidth(165.0);
        label0.setText("Score");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#2b00ff"));
        label0.setFont(new Font("Baskerville Old Face", 25.0));

        hBox0.setPrefHeight(38.0);
        hBox0.setPrefWidth(100.0);

        label1.setAlignment(javafx.geometry.Pos.CENTER);
        label1.setPrefHeight(36.0);
        label1.setPrefWidth(69.0);
        label1.setText("1");
        label1.setFont(new Font("Baskerville Old Face", 30.0));

        label2.setAlignment(javafx.geometry.Pos.CENTER);
        label2.setPrefHeight(33.0);
        label2.setPrefWidth(106.0);
        label2.setText("-");
        label2.setFont(new Font("Berlin Sans FB", 30.0));

        label3.setAlignment(javafx.geometry.Pos.CENTER);
        label3.setPrefHeight(36.0);
        label3.setPrefWidth(69.0);
        label3.setText("0");
        label3.setFont(new Font("Baskerville Old Face", 30.0));
        vBox0.setPadding(new Insets(20.0, 0.0, 10.0, 0.0));

        vBox1.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        vBox1.setLayoutX(184.0);
        vBox1.setLayoutY(10.0);
        vBox1.setPrefHeight(200.0);
        vBox1.setPrefWidth(100.0);

        /*imageView0.setFitHeight(124.0);
        imageView0.setFitWidth(103.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        VBox.setMargin(imageView0, new Insets(0.0));
        imageView0.setImage(new Image(getClass().getResource("../Icons/icon1.png").toExternalForm()));*/

        txtPlayer2.setAlignment(javafx.geometry.Pos.CENTER);
        txtPlayer2.setPrefHeight(21.0);
        txtPlayer2.setPrefWidth(192.0);
        txtPlayer2.setText("Player 2");
        txtPlayer2.setFont(new Font("Baskerville Old Face", 20.0));

        player2Symbol.setAlignment(javafx.geometry.Pos.CENTER);
        player2Symbol.setPrefHeight(21.0);
        player2Symbol.setPrefWidth(208.0);
        player2Symbol.setText("0");
        player2Symbol.setFont(new Font("Baskerville Old Face", 20.0));
        HBox.setMargin(vBox1, new Insets(0.0, 10.0, 0.0, 60.0));
        hBox.setOpaqueInsets(new Insets(0.0));
        BorderPane.setMargin(hBox, new Insets(0.0));
        hBox.setPadding(new Insets(10.0, 0.0, 0.0, 0.0));
        setTop(hBox);

        BorderPane.setAlignment(gridPane, javafx.geometry.Pos.CENTER);
        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        gridPane.setGridLinesVisible(true);
        gridPane.setMaxHeight(USE_PREF_SIZE);
        gridPane.setMaxWidth(USE_PREF_SIZE);
        gridPane.setMinWidth(USE_PREF_SIZE);
        gridPane.setPrefHeight(150.0);
        gridPane.setPrefWidth(300.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        cell.setAlignment(javafx.geometry.Pos.CENTER);
        cell.setPrefHeight(51.0);
        cell.setPrefWidth(127.0);
        cell.setText("X");
        cell.setFont(new Font("Berlin Sans FB", 30.0));

        GridPane.setColumnIndex(cell0, 1);
        cell0.setAlignment(javafx.geometry.Pos.CENTER);
        cell0.setPrefHeight(51.0);
        cell0.setPrefWidth(127.0);
        cell0.setFont(new Font("Berlin Sans FB", 30.0));

        GridPane.setColumnIndex(cell1, 2);
        cell1.setAlignment(javafx.geometry.Pos.CENTER);
        cell1.setPrefHeight(51.0);
        cell1.setPrefWidth(127.0);
        cell1.setFont(new Font("Berlin Sans FB", 30.0));

        GridPane.setRowIndex(cell2, 1);
        cell2.setAlignment(javafx.geometry.Pos.CENTER);
        cell2.setPrefHeight(51.0);
        cell2.setPrefWidth(127.0);
        cell2.setFont(new Font("Berlin Sans FB", 30.0));

        GridPane.setRowIndex(cell3, 2);
        cell3.setAlignment(javafx.geometry.Pos.CENTER);
        cell3.setPrefHeight(51.0);
        cell3.setPrefWidth(127.0);
        cell3.setFont(new Font("Berlin Sans FB", 30.0));

        GridPane.setColumnIndex(cell4, 1);
        GridPane.setRowIndex(cell4, 1);
        cell4.setAlignment(javafx.geometry.Pos.CENTER);
        cell4.setPrefHeight(51.0);
        cell4.setPrefWidth(127.0);
        cell4.setText("O");
        cell4.setFont(new Font("Berlin Sans FB", 30.0));

        GridPane.setColumnIndex(cell5, 2);
        GridPane.setRowIndex(cell5, 1);
        cell5.setAlignment(javafx.geometry.Pos.CENTER);
        cell5.setPrefHeight(51.0);
        cell5.setPrefWidth(127.0);
        cell5.setFont(new Font("Berlin Sans FB", 30.0));

        GridPane.setColumnIndex(cell6, 2);
        GridPane.setRowIndex(cell6, 2);
        cell6.setAlignment(javafx.geometry.Pos.CENTER);
        cell6.setPrefHeight(51.0);
        cell6.setPrefWidth(127.0);
        cell6.setFont(new Font("Berlin Sans FB", 30.0));

        GridPane.setColumnIndex(cell7, 1);
        GridPane.setRowIndex(cell7, 2);
        cell7.setAlignment(javafx.geometry.Pos.CENTER);
        cell7.setPrefHeight(51.0);
        cell7.setPrefWidth(127.0);
        cell7.setFont(new Font("Berlin Sans FB", 30.0));
        setCenter(gridPane);

        BorderPane.setAlignment(pane, javafx.geometry.Pos.CENTER);
        pane.setPrefHeight(74.0);
        pane.setPrefWidth(600.0);

        exitBtn.setLayoutX(14.0);
        exitBtn.setLayoutY(10.0);
        exitBtn.setMnemonicParsing(false);
        exitBtn.setPrefHeight(54.0);
        exitBtn.setPrefWidth(122.0);
        exitBtn.setText("Exit");
        exitBtn.setFont(new Font("Baskerville Old Face", 20.0));
         exitBtn.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                Navigate.navigateTo(new StartScreenBase(),e);
            }
        });

        recBtn.setLayoutX(464.0);
        recBtn.setLayoutY(10.0);
        recBtn.setMnemonicParsing(false);
        recBtn.setPrefHeight(54.0);
        recBtn.setPrefWidth(122.0);
        recBtn.setText("Record");
        recBtn.setFont(new Font("Baskerville Old Face", 20.0));

        /*imageView1.setFitHeight(20.0);
        imageView1.setFitWidth(19.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("../Icons/rec.png").toExternalForm()));
        recBtn.setGraphic(imageView1);*/
        setBottom(pane);

        //vBox.getChildren().add(imageView);
        vBox.getChildren().add(txtPlayer1);
        vBox.getChildren().add(player1Symbol);
        hBox.getChildren().add(vBox);
        vBox0.getChildren().add(label);
        vBox0.getChildren().add(label0);
        hBox0.getChildren().add(label1);
        hBox0.getChildren().add(label2);
        hBox0.getChildren().add(label3);
        vBox0.getChildren().add(hBox0);
        hBox.getChildren().add(vBox0);
        //vBox1.getChildren().add(imageView0);
        vBox1.getChildren().add(txtPlayer2);
        vBox1.getChildren().add(player2Symbol);
        hBox.getChildren().add(vBox1);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(cell);
        gridPane.getChildren().add(cell0);
        gridPane.getChildren().add(cell1);
        gridPane.getChildren().add(cell2);
        gridPane.getChildren().add(cell3);
        gridPane.getChildren().add(cell4);
        gridPane.getChildren().add(cell5);
        gridPane.getChildren().add(cell6);
        gridPane.getChildren().add(cell7);
        pane.getChildren().add(exitBtn);
        pane.getChildren().add(recBtn);

    }
}
