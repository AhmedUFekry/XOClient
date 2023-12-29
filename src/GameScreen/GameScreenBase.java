package GameScreen;

import ClientServer.Client;
import DTO.MoveDTO;
import DTO.MoveOperation;
import static GameLogic.MarkSymbol.OIMG;
import static GameLogic.MarkSymbol.XIMG;
import Records.RecordGame;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public  class GameScreenBase extends BorderPane {

    protected final HBox hBox;
    protected final HBox hBox0;
    protected final VBox vBox;
    protected final ImageView player1Img;
    protected final Label txtPlayer1;
    protected final Label player1Symbol;
    protected final VBox vBox0;
    protected final Label label;
    protected final Label label0;
    protected final HBox hBox1;
    protected final Label scoreP1;
    protected final Label label1;
    protected final Label scoreP2;
    protected final VBox vBox1;
    protected final ImageView player2Img;
    protected final Label txtPlayer2;
    protected final Label player2Symbol;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final ImageView imgSymbol1;
    protected final Button button1;
    protected final ImageView imgSymbol2;
    protected final Button button2;
    protected final ImageView imgSymbol3;
    protected final Button button3;
    protected final ImageView imgSymbol4;
    protected final Button button4;
    protected final ImageView imgSymbol5;
    protected final Button button5;
    protected final ImageView imgSymbol6;
    protected final Button button6;
    protected final ImageView imgSymbol7;
    protected final Button button7;
    protected final ImageView imgSymbol8;
    protected final Button button8;
    protected final ImageView imgSymbol9;
    protected final Button button9;
    protected final Pane pane;
    protected final Button exitBtn;
    protected final ImageView exitImg;
    protected final Button recBtn;
    protected final ImageView recImg;
         // Logic variables
    private ArrayList<Button> boardBtns;                //BoardButtons
    //  private int gameId;                                 // to store game Id 
    private ArrayList<ImageView> symbolsImgs;
    private int turn;
    private static int _scoreP1 = 0;
    private static int _scoreP2 = 0;
    private String[] players = {"X","O"};
    private String p1ayMoves;
    private RecordGame recordGame;
    private boolean isRecord;
    private ArrayList<Integer> moves;
    private Client client ;
    private MoveDTO mvDto;
    
    public GameScreenBase(Client client) {
        this.client = client ;
        hBox = new HBox();
        hBox0 = new HBox();
        vBox = new VBox();
        player1Img = new ImageView();
        txtPlayer1 = new Label();
        player1Symbol = new Label();
        vBox0 = new VBox();
        label = new Label();
        label0 = new Label();
        hBox1 = new HBox();
        scoreP1 = new Label();
        label1 = new Label();
        scoreP2 = new Label();
        vBox1 = new VBox();
        player2Img = new ImageView();
        txtPlayer2 = new Label();
        player2Symbol = new Label();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        imgSymbol1 = new ImageView();
        button1 = new Button();
        imgSymbol2 = new ImageView();
        button2 = new Button();
        imgSymbol3 = new ImageView();
        button3 = new Button();
        imgSymbol4 = new ImageView();
        button4 = new Button();
        imgSymbol5 = new ImageView();
        button5 = new Button();
        imgSymbol6 = new ImageView();
        button6 = new Button();
        imgSymbol7 = new ImageView();
        button7 = new Button();
        imgSymbol8 = new ImageView();
        button8 = new Button();
        imgSymbol9 = new ImageView();
        button9 = new Button();
        pane = new Pane();
        exitBtn = new Button();
        exitImg = new ImageView();
        recBtn = new Button();
        recImg = new ImageView();
        turn = 0;
        p1ayMoves = "";
        // init UI
        scoreP1.setText("0");
        scoreP2.setText("0");
        player1Symbol.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        boardBtns = new ArrayList<>(Arrays.asList(button1, button2, button3, button4, button5, button6, button7, button8, button9));
        symbolsImgs = new ArrayList<>(Arrays.asList(imgSymbol1,imgSymbol2,imgSymbol3,imgSymbol4,imgSymbol5,imgSymbol6,imgSymbol7,imgSymbol8,imgSymbol9));
        moves = new ArrayList<Integer>();
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);

        hBox0.setAlignment(javafx.geometry.Pos.CENTER);
        hBox0.setPrefHeight(115.0);
        hBox0.setPrefWidth(600.0);

        vBox.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        vBox.setPrefHeight(200.0);
        vBox.setPrefWidth(100.0);

        player1Img.setFitHeight(124.0);
        player1Img.setFitWidth(104.0);
        player1Img.setPickOnBounds(true);
        player1Img.setPreserveRatio(true);
        VBox.setMargin(player1Img, new Insets(0.0));
        player1Img.setImage(new Image(getClass().getResource("/Icons/boy.png").toExternalForm()));

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
        label0.setFont(new Font("Baskerville Old Face", 25.0));

        hBox1.setPrefHeight(38.0);
        hBox1.setPrefWidth(100.0);

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

        player2Img.setFitHeight(124.0);
        player2Img.setFitWidth(103.0);
        player2Img.setPickOnBounds(true);
        player2Img.setPreserveRatio(true);
        VBox.setMargin(player2Img, new Insets(0.0));
        player2Img.setImage(new Image(getClass().getResource("/Icons/girl.png").toExternalForm()));

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
        hBox0.setOpaqueInsets(new Insets(0.0));
        hBox0.setPadding(new Insets(10.0, 0.0, 0.0, 0.0));
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

        GridPane.setHalignment(imgSymbol1, javafx.geometry.HPos.CENTER);
        imgSymbol1.setFitHeight(45.0);
        imgSymbol1.setFitWidth(100.0);
        imgSymbol1.setPickOnBounds(true);
        imgSymbol1.setPreserveRatio(true);
        GridPane.setMargin(imgSymbol1, new Insets(0.0));

        button1.setAlignment(javafx.geometry.Pos.CENTER);
        button1.setMnemonicParsing(false);
        button1.setOpacity(0.0);
        button1.setPrefHeight(49.0);
        button1.setPrefWidth(102.0);

        GridPane.setColumnIndex(imgSymbol2, 1);
        GridPane.setHalignment(imgSymbol2, javafx.geometry.HPos.CENTER);
        imgSymbol2.setFitHeight(45.0);
        imgSymbol2.setFitWidth(100.0);
        imgSymbol2.setPickOnBounds(true);
        imgSymbol2.setPreserveRatio(true);
        GridPane.setMargin(imgSymbol2, new Insets(0.0));

        GridPane.setColumnIndex(button2, 1);
        button2.setMnemonicParsing(false);
        button2.setOpacity(0.0);
        button2.setPrefHeight(48.0);
        button2.setPrefWidth(102.0);

        GridPane.setColumnIndex(imgSymbol3, 2);
        GridPane.setHalignment(imgSymbol3, javafx.geometry.HPos.CENTER);
        imgSymbol3.setFitHeight(45.0);
        imgSymbol3.setFitWidth(100.0);
        imgSymbol3.setPickOnBounds(true);
        imgSymbol3.setPreserveRatio(true);
        GridPane.setMargin(imgSymbol3, new Insets(0.0));

        GridPane.setColumnIndex(button3, 2);
        button3.setMnemonicParsing(false);
        button3.setOpacity(0.0);
        button3.setPrefHeight(60.0);
        button3.setPrefWidth(107.0);

        GridPane.setHalignment(imgSymbol4, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(imgSymbol4, 1);
        imgSymbol4.setFitHeight(45.0);
        imgSymbol4.setFitWidth(100.0);
        imgSymbol4.setPickOnBounds(true);
        imgSymbol4.setPreserveRatio(true);

        GridPane.setRowIndex(button4, 1);
        button4.setMnemonicParsing(false);
        button4.setOpacity(0.0);
        button4.setPrefHeight(48.0);
        button4.setPrefWidth(105.0);

        GridPane.setColumnIndex(imgSymbol5, 1);
        GridPane.setHalignment(imgSymbol5, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(imgSymbol5, 1);
        imgSymbol5.setFitHeight(45.0);
        imgSymbol5.setFitWidth(100.0);
        imgSymbol5.setPickOnBounds(true);
        imgSymbol5.setPreserveRatio(true);

        GridPane.setColumnIndex(button5, 1);
        GridPane.setRowIndex(button5, 1);
        button5.setMnemonicParsing(false);
        button5.setOpacity(0.0);
        button5.setPrefHeight(53.0);
        button5.setPrefWidth(108.0);

        GridPane.setColumnIndex(imgSymbol6, 2);
        GridPane.setHalignment(imgSymbol6, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(imgSymbol6, 1);
        imgSymbol6.setFitHeight(45.0);
        imgSymbol6.setFitWidth(100.0);
        imgSymbol6.setPickOnBounds(true);
        imgSymbol6.setPreserveRatio(true);

        GridPane.setColumnIndex(button6, 2);
        GridPane.setRowIndex(button6, 1);
        button6.setMnemonicParsing(false);
        button6.setOpacity(0.0);
        button6.setPrefHeight(56.0);
        button6.setPrefWidth(119.0);

        GridPane.setHalignment(imgSymbol7, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(imgSymbol7, 2);
        imgSymbol7.setFitHeight(45.0);
        imgSymbol7.setFitWidth(100.0);
        imgSymbol7.setPickOnBounds(true);
        imgSymbol7.setPreserveRatio(true);

        GridPane.setRowIndex(button7, 2);
        button7.setMnemonicParsing(false);
        button7.setOpacity(0.0);
        button7.setPrefHeight(55.0);
        button7.setPrefWidth(103.0);

        GridPane.setColumnIndex(imgSymbol8, 1);
        GridPane.setHalignment(imgSymbol8, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(imgSymbol8, 2);
        imgSymbol8.setFitHeight(45.0);
        imgSymbol8.setFitWidth(100.0);
        imgSymbol8.setPickOnBounds(true);
        imgSymbol8.setPreserveRatio(true);

        GridPane.setColumnIndex(button8, 1);
        GridPane.setRowIndex(button8, 2);
        button8.setMnemonicParsing(false);
        button8.setOpacity(0.0);
        button8.setPrefHeight(59.0);
        button8.setPrefWidth(136.0);

        GridPane.setColumnIndex(imgSymbol9, 2);
        GridPane.setHalignment(imgSymbol9, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(imgSymbol9, 2);
        imgSymbol9.setFitHeight(45.0);
        imgSymbol9.setFitWidth(100.0);
        imgSymbol9.setPickOnBounds(true);
        imgSymbol9.setPreserveRatio(true);

        GridPane.setColumnIndex(button9, 2);
        GridPane.setRowIndex(button9, 2);
        button9.setMnemonicParsing(false);
        button9.setOpacity(0.0);
        button9.setPrefHeight(48.0);
        button9.setPrefWidth(120.0);
        setCenter(gridPane);

        BorderPane.setAlignment(pane, javafx.geometry.Pos.CENTER);
        pane.setPrefHeight(71.0);
        pane.setPrefWidth(600.0);

        exitBtn.setAlignment(javafx.geometry.Pos.CENTER);
        exitBtn.setLayoutX(510.0);
        exitBtn.setLayoutY(5.0);
        exitBtn.setMnemonicParsing(false);
       
        exitBtn.setPrefHeight(44.0);
        exitBtn.setPrefWidth(48.0);
        exitBtn.setFont(new Font("Baskerville Old Face", 20.0));
          exitBtn.addEventHandler(ActionEvent.ACTION, e -> {
            // 1  send close game to server  
            
            });
          boardBtns.forEach(button -> {
              button.addEventHandler(ActionEvent.ACTION, e->{
                  //************************ SEND MOVE TO SERVER
                  int index = boardBtns.indexOf(button);
                 String sym =  client.getCurrSym();
                  
                  String msg = "play"+index+sym;
                  client.SendMoveToServer(msg);
                  makeMove(index,sym);
                  disableBtn(false);
                  if(button.getText().isEmpty()){
                   button.setText(sym);
                   if(sym.equals("X")){
                    symbolsImgs.get(index).setImage(new Image(XIMG.getMark()));
                   }else{
                    symbolsImgs.get(index).setImage(new Image(OIMG.getMark()));
                   }
                  }
                  
              });
          });
        exitImg.setFitHeight(48.0);
        exitImg.setFitWidth(107.0);
        exitImg.setPickOnBounds(true);
        exitImg.setPreserveRatio(true);
        exitImg.setImage(new Image(getClass().getResource("/Icons/Exit.png").toExternalForm()));
        exitBtn.setGraphic(exitImg);

        recBtn.setAlignment(javafx.geometry.Pos.CENTER);
        recBtn.setContentDisplay(javafx.scene.control.ContentDisplay.RIGHT);
        recBtn.setLayoutX(14.0);
        recBtn.setLayoutY(10.0);
        recBtn.setMnemonicParsing(false);
        
        recBtn.setPrefHeight(54.0);
        recBtn.setPrefWidth(122.0);
        recBtn.setText("Record");
        recBtn.setFont(new Font("Baskerville Old Face", 20.0));

        recImg.setFitHeight(20.0);
        recImg.setFitWidth(19.0);
        recImg.setPickOnBounds(true);
        recImg.setPreserveRatio(true);
        recImg.setImage(new Image(getClass().getResource("/Icons/rec.png").toExternalForm()));
        recBtn.setGraphic(recImg);
        setBottom(pane);

        vBox.getChildren().add(player1Img);
        vBox.getChildren().add(txtPlayer1);
        vBox.getChildren().add(player1Symbol);
        hBox0.getChildren().add(vBox);
        vBox0.getChildren().add(label);
        vBox0.getChildren().add(label0);
        hBox1.getChildren().add(scoreP1);
        hBox1.getChildren().add(label1);
        hBox1.getChildren().add(scoreP2);
        vBox0.getChildren().add(hBox1);
        hBox0.getChildren().add(vBox0);
        vBox1.getChildren().add(player2Img);
        vBox1.getChildren().add(txtPlayer2);
        vBox1.getChildren().add(player2Symbol);
        hBox0.getChildren().add(vBox1);
        hBox.getChildren().add(hBox0);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(imgSymbol1);
        gridPane.getChildren().add(button1);
        gridPane.getChildren().add(imgSymbol2);
        gridPane.getChildren().add(button2);
        gridPane.getChildren().add(imgSymbol3);
        gridPane.getChildren().add(button3);
        gridPane.getChildren().add(imgSymbol4);
        gridPane.getChildren().add(button4);
        gridPane.getChildren().add(imgSymbol5);
        gridPane.getChildren().add(button5);
        gridPane.getChildren().add(imgSymbol6);
        gridPane.getChildren().add(button6);
        gridPane.getChildren().add(imgSymbol7);
        gridPane.getChildren().add(button7);
        gridPane.getChildren().add(imgSymbol8);
        gridPane.getChildren().add(button8);
        gridPane.getChildren().add(imgSymbol9);
        gridPane.getChildren().add(button9);
        pane.getChildren().add(exitBtn);
        pane.getChildren().add(recBtn);

    }

 public void makeMove(int index,String sym){
      
       System.out.println("Suppose to paint on Screen");
            //boardBtns.get(index).setText(sym);
            System.out.println("index is "+index);
            moves.add(index);
       // updateBoard(index,sym);
       
        
     //   client.sendMsgToServer(jsonMv);
      
    }
  public void disableBtn(boolean flag){
        boardBtns.forEach(button -> {
        button.setDisable(flag);
        });
  }
 public void UpdateBoard(){
     Platform.runLater(new Runnable(){
      

         @Override
         public void run() {
                  
            if(client.getCurrMoveDto()!= null  ){
                int index =  client.getCurrMoveDto().getIndex();
                String sym = client.getCurrMoveDto().getSym();
                if(boardBtns.get(index).getText().isEmpty()){
                    boardBtns.get(index).setText(sym);
                    if(sym.equals("X")){
                    symbolsImgs.get(index).setImage(new Image(XIMG.getMark()));
                    }else{
                    symbolsImgs.get(index).setImage(new Image(OIMG.getMark()));
                    }
                }
            }

         }
     
     
     });
 
 }
}
