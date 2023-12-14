/*package xoclient.Screens;

import java.util.ArrayList;
import java.util.Arrays;
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
   
      // Logic variables
    private ArrayList<Button> boardBtns;                //BoardButtons
    //  private int gameId;                                 // to store game Id 
    private int turn;
    private static int _scoreP1 = 0;
    private static int _scoreP2 = 0;
    private String[] players = {"X", "O"};
    private String p1ayMoves;
 
    protected final HBox hBox;
    protected final VBox vBox;
  //  protected final ImageView imageView;
    protected final  Label txtPlayer1;
    protected final Label player1Symbol;
    protected final VBox vBox0;
    protected final Label label;
    protected final Label label0;
    protected final HBox hBox0;
    protected final Label scoreP1;
    protected final Label label1;
    protected final Label scoreP2;
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
    protected final Button button1;
    protected final Button button2;
    protected final Button button3;
    protected final Button button4;
    protected final Button button5;
    protected final Button button6;
    protected final Button button7;
    protected final Button button8;
    protected final Button button9;
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
        scoreP1 = new Label();
        label1 = new Label();
        scoreP2 = new Label();
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
        button1 = new Button();
        button2 = new Button();
        button3 = new Button();
        button4 = new Button();
        button5 = new Button();
        button6 = new Button();
        button7 = new Button();
        button8 = new Button();
        button9 = new Button();
        pane = new Pane();
        exitBtn = new Button();
        recBtn = new Button();
       // imageView1 = new ImageView();
   /**************** Game Logic Init */
   //  gameId = 0;
/*
        turn = 0;
        p1ayMoves = "";
        scoreP1.setText("0");
        scoreP2.setText("0");
        player1Symbol.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        boardBtns = new ArrayList<>(Arrays.asList(button1, button2, button3, button4, button5, button6, button7, button8, button9));
        exitBtn.addEventHandler(ActionEvent.ACTION, e -> {
            System.out.println("hello");
        });
        boardBtns.forEach(button -> {
            setUpBtn(button);
        });
        /\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\/ 
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

        imageView.setImage(new Image(getClass().getResource("../Icons/icon1.png").toExternalForm()));


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

        scoreP1.setAlignment(javafx.geometry.Pos.CENTER);
        scoreP1.setPrefHeight(36.0);
        scoreP1.setPrefWidth(69.0);
        scoreP1.setText("0");
        scoreP1.setFont(new Font("Baskerville Old Face", 30.0));

        label1.setAlignment(javafx.geometry.Pos.CENTER);
        label1.setPrefHeight(33.0);
        label1.setPrefWidth(106.0);
        label1.setText("-");
        label1.setFont(new Font("Berlin Sans FB", 30.0));

        scoreP2.setAlignment(javafx.geometry.Pos.CENTER);
        scoreP2.setPrefHeight(36.0);
        scoreP2.setPrefWidth(69.0);
        scoreP2.setText("0");
        scoreP2.setFont(new Font("Baskerville Old Face", 30.0));
        vBox0.setPadding(new Insets(20.0, 0.0, 10.0, 0.0));

        vBox1.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        vBox1.setLayoutX(184.0);
        vBox1.setLayoutY(10.0);
        vBox1.setPrefHeight(200.0);
        vBox1.setPrefWidth(100.0);
            ///////////////////////////////////////////

        /*imageView0.setFitHeight(124.0);
        imageView0.setFitWidth(103.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        VBox.setMargin(imageView0, new Insets(0.0));

        imageView0.setImage(new Image(getClass().getResource("../Icons/icon1.png").toExternalForm()));*/

/*
        txtPlayer2.setAlignment(javafx.geometry.Pos.CENTER);
        txtPlayer2.setPrefHeight(21.0);
        txtPlayer2.setPrefWidth(192.0);
        txtPlayer2.setText("Player 2");
        txtPlayer2.setFont(new Font("Baskerville Old Face", 20.0));

        player2Symbol.setAlignment(javafx.geometry.Pos.CENTER);
        player2Symbol.setPrefHeight(21.0);
        player2Symbol.setPrefWidth(208.0);
        player2Symbol.setText("O");
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

        button1.setMnemonicParsing(false);
        button1.setPrefHeight(49.0);
        button1.setPrefWidth(102.0);

        GridPane.setColumnIndex(button2, 1);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(48.0);
        button2.setPrefWidth(102.0);

        GridPane.setColumnIndex(button3, 2);
        button3.setMnemonicParsing(false);
        button3.setPrefHeight(60.0);
        button3.setPrefWidth(107.0);

        GridPane.setRowIndex(button4, 1);
        button4.setMnemonicParsing(false);
        button4.setPrefHeight(48.0);
        button4.setPrefWidth(105.0);

        GridPane.setColumnIndex(button5, 1);
        GridPane.setRowIndex(button5, 1);
        button5.setMnemonicParsing(false);
        button5.setPrefHeight(53.0);
        button5.setPrefWidth(108.0);

        GridPane.setColumnIndex(button6, 2);
        GridPane.setRowIndex(button6, 1);
        button6.setMnemonicParsing(false);
        button6.setPrefHeight(56.0);
        button6.setPrefWidth(119.0);

        GridPane.setRowIndex(button7, 2);
        button7.setMnemonicParsing(false);
        button7.setPrefHeight(55.0);
        button7.setPrefWidth(103.0);

        GridPane.setColumnIndex(button8, 1);
        GridPane.setRowIndex(button8, 2);
        button8.setMnemonicParsing(false);
        button8.setPrefHeight(59.0);
        button8.setPrefWidth(136.0);

        GridPane.setColumnIndex(button9, 2);
        GridPane.setRowIndex(button9, 2);
        button9.setMnemonicParsing(false);
        button9.setPrefHeight(58.0);
        button9.setPrefWidth(127.0);
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

      //  imageView1.setImage(new Image(getClass().getResource("../Icons/rec.png").toExternalForm()));
       // recBtn.setGraphic(imageView1);
/*
        setBottom(pane);

        //vBox.getChildren().add(imageView);
        vBox.getChildren().add(txtPlayer1);
        vBox.getChildren().add(player1Symbol);
        hBox.getChildren().add(vBox);
        vBox0.getChildren().add(label);
        vBox0.getChildren().add(label0);
        hBox0.getChildren().add(scoreP1);
        hBox0.getChildren().add(label1);
        hBox0.getChildren().add(scoreP2);
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
        gridPane.getChildren().add(button1);
        gridPane.getChildren().add(button2);
        gridPane.getChildren().add(button3);
        gridPane.getChildren().add(button4);
        gridPane.getChildren().add(button5);
        gridPane.getChildren().add(button6);
        gridPane.getChildren().add(button7);
        gridPane.getChildren().add(button8);
        gridPane.getChildren().add(button9);
        pane.getChildren().add(exitBtn);
        pane.getChildren().add(recBtn);

    }
    private void setUpBtn(Button btn) {

        btn.addEventHandler(ActionEvent.ACTION, e -> {
            int index;
            setPlayerSymbol(btn);
            index = boardBtns.indexOf(btn);
            p1ayMoves = p1ayMoves + index;
            btn.setDisable(true);
            checkResult();
        });

    }

    public void resetBtn(Button btn) {
        btn.setDisable(false);
        btn.setText(" ");
    }

    public void setPlayerSymbol(Button btn) {
        if (turn % 2 == 0) {
            btn.setText("X");
            turn = 1;
        } else {
            btn.setText("O");
            turn = 0;
        }
    }

    public void checkResult() {
        String result = null;
        System.out.println("playMoves :"+p1ayMoves);
        for (int i = 0; i < 8; i++) {
            switch (i) {
                case 0:                    // 1 2 3 
                    result = button1.getText() + button2.getText() + button3.getText();
                    break;
                case 1:                      // 4 5 6 
                    result = button4.getText() + button5.getText() + button6.getText();
                    break;
                case 2:                    // 7 8 9  
                    result = button7.getText() + button8.getText() + button9.getText();
                    break;
                case 3:                    // 3 5 7 
                    result = button3.getText() + button5.getText() + button7.getText();
                    break;
                case 4:                      // 1 5 9  
                    result = button1.getText() + button5.getText() + button9.getText();
                    break;
                case 5:                    // 1 4 7 
                    result = button1.getText() + button4.getText() + button7.getText();
                    break;
                case 6:                      // 2 5 8
                    result = button2.getText() + button5.getText() + button8.getText();
                    break;
                case 7:                    // 3 6 9  
                    result = button3.getText() + button6.getText() + button9.getText();
                    break;
                default:
                    result = null;

            };
            
            if (result.matches("XXX")) {
                ++_scoreP1;                    
                System.out.println("X wins ");
                restartGame();
                // go to video screen or tab 
            } else if (result.matches("OOO")) {
                ++_scoreP2;
                System.out.println("O wins ");
                restartGame();
                // go to video screen or tab 
            } else if (p1ayMoves.length() == 9) {
                System.out.println("draw");
                restartGame();
            }
        }
    }

    public void restartGame() {
        // u should add code to store Game Records here 
        /*
        
        
        */
        
/*
        p1ayMoves = "";                               // reset moves 
        scoreP1.setText("" + _scoreP1);                // update scores on the screen 
        scoreP2.setText("" + _scoreP2);                  // update scores on the screen
        if (turn % 2 == 0) {                                // check for whose turn ? 
            //player 1 turn 
            player1Symbol.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
            player2Symbol.setStyle("-fx-border-color: black; -fx-border-width: 0px;");
            player1Symbol.setText("X");
            player2Symbol.setText("O");
            turn = 1;
        } else {
            //player 2 turn
            player2Symbol.setStyle("-fx-border-color: black; -fx-border-width: 2px;");        // set border 
            player1Symbol.setStyle("-fx-border-color: black; -fx-border-width: 0px;");
            player1Symbol.setText("O");
            player2Symbol.setText("X");
            turn = 0;
        }
        for (Button b : boardBtns) {
            resetBtn(b);
        }
    }
}
*/