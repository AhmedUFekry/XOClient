package screens;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;

public class ProfileScreenBase extends BorderPane {

    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final RowConstraints rowConstraints;
    protected final Label label;
    protected final Label totalMatchesLabel;
    protected final Label label0;
    protected final Label winLabel;
    protected final Label label1;
    protected final Label drawLabel;
    protected final Label label2;
    protected final Label loseLabel;
    protected final Button showRecordsBtn;
    protected final GridPane gridPane0;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final ColumnConstraints columnConstraints2;
    protected final RowConstraints rowConstraints0;
    protected final Button backBtn;
    protected final Label label3;
    protected final ImageView profileImage;
    protected final Label usernameLabel;
    public String username;

    public ProfileScreenBase() {

        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        label = new Label();
        totalMatchesLabel = new Label();
        label0 = new Label();
        winLabel = new Label();
        label1 = new Label();
        drawLabel = new Label();
        label2 = new Label();
        loseLabel = new Label();
        showRecordsBtn = new Button();
        gridPane0 = new GridPane();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        columnConstraints2 = new ColumnConstraints();
        rowConstraints0 = new RowConstraints();
        backBtn = new Button();
        label3 = new Label();
        profileImage = new ImageView();
        usernameLabel = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(gridPane, javafx.geometry.Pos.CENTER);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label.setText("Matches Played : ");
        label.setFont(new Font("Bodoni MT Black", 27.0));
        label.setOpaqueInsets(new Insets(0.0));
        GridPane.setMargin(label, new Insets(-200.0, 0.0, 0.0, 170.0));

        totalMatchesLabel.setAlignment(javafx.geometry.Pos.CENTER);
        totalMatchesLabel.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        totalMatchesLabel.setText("0");
        totalMatchesLabel.setFont(new Font("Bodoni MT Black", 27.0));
        totalMatchesLabel.setOpaqueInsets(new Insets(0.0));
        GridPane.setMargin(totalMatchesLabel, new Insets(-200.0, 0.0, 0.0, 410.0));

        label0.setAlignment(javafx.geometry.Pos.CENTER);
        label0.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label0.setText("Win : ");
        label0.setFont(new Font("Bodoni MT Black", 27.0));
        label0.setOpaqueInsets(new Insets(0.0));
        GridPane.setMargin(label0, new Insets(0.0, 0.0, 0.0, 80.0));

        winLabel.setAlignment(javafx.geometry.Pos.CENTER);
        winLabel.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        winLabel.setText("0");
        winLabel.setFont(new Font("Bodoni MT Black", 27.0));
        winLabel.setOpaqueInsets(new Insets(0.0));
        GridPane.setMargin(winLabel, new Insets(0.0, 0.0, 0.0, 170.0));

        label1.setAlignment(javafx.geometry.Pos.CENTER);
        label1.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label1.setText("Draw : ");
        label1.setFont(new Font("Bodoni MT Black", 27.0));
        label1.setOpaqueInsets(new Insets(0.0));
        GridPane.setMargin(label1, new Insets(0.0, 0.0, 0.0, 240.0));

        drawLabel.setAlignment(javafx.geometry.Pos.CENTER);
        drawLabel.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        drawLabel.setText("0");
        drawLabel.setFont(new Font("Bodoni MT Black", 27.0));
        drawLabel.setOpaqueInsets(new Insets(0.0));
        GridPane.setMargin(drawLabel, new Insets(0.0, 0.0, 0.0, 350.0));

        label2.setAlignment(javafx.geometry.Pos.CENTER);
        label2.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label2.setText("Lose : ");
        label2.setFont(new Font("Bodoni MT Black", 27.0));
        label2.setOpaqueInsets(new Insets(0.0));
        GridPane.setMargin(label2, new Insets(0.0, 0.0, 0.0, 430.0));

        loseLabel.setAlignment(javafx.geometry.Pos.CENTER);
        loseLabel.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        loseLabel.setText("0");
        loseLabel.setFont(new Font("Bodoni MT Black", 27.0));
        loseLabel.setOpaqueInsets(new Insets(0.0));
        GridPane.setMargin(loseLabel, new Insets(0.0, 0.0, 0.0, 520.0));

        showRecordsBtn.setMnemonicParsing(false);
        showRecordsBtn.setText("Play Records");
        showRecordsBtn.setFont(new Font(22.0));
        GridPane.setMargin(showRecordsBtn, new Insets(0.0, 0.0, -200.0, 220.0));
        setCenter(gridPane);

        BorderPane.setAlignment(gridPane0, javafx.geometry.Pos.CENTER);
        gridPane0.setPrefHeight(103.0);
        gridPane0.setPrefWidth(600.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(212.0);
        columnConstraints0.setMinWidth(USE_PREF_SIZE);
        columnConstraints0.setPrefWidth(130.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(Double.MAX_VALUE);
        columnConstraints1.setMinWidth(300.0);
        columnConstraints1.setPrefWidth(356.0);

        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMaxWidth(162.0);
        columnConstraints2.setMinWidth(USE_PREF_SIZE);
        columnConstraints2.setPrefWidth(114.0);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        backBtn.setMnemonicParsing(false);
        backBtn.setText("Back");
        GridPane.setMargin(backBtn, new Insets(0.0, 0.0, 0.0, 30.0));

        GridPane.setColumnIndex(label3, 1);
        label3.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        label3.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label3.setFocusTraversable(false);
        label3.setText("Profile");
        label3.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label3.setFont(new Font("Bodoni MT Black", 49.0));
        label3.setOpaqueInsets(new Insets(0.0));
        GridPane.setMargin(label3, new Insets(0.0, 0.0, 0.0, 100.0));

        GridPane.setColumnIndex(profileImage, 2);
        profileImage.setFitHeight(60.0);
        profileImage.setFitWidth(83.0);
        profileImage.setPickOnBounds(true);
        profileImage.setPreserveRatio(true);
        GridPane.setMargin(profileImage, new Insets(0.0, 0.0, 0.0, 20.0));

        GridPane.setColumnIndex(usernameLabel, 2);
        usernameLabel.setText("User Name");
        GridPane.setMargin(usernameLabel, new Insets(80.0, 0.0, 0.0, 20.0));
        usernameLabel.setFont(new Font("Bodoni MT Black", 15.0));
        setTop(gridPane0);

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getChildren().add(label);
        gridPane.getChildren().add(totalMatchesLabel);
        gridPane.getChildren().add(label0);
        gridPane.getChildren().add(winLabel);
        gridPane.getChildren().add(label1);
        gridPane.getChildren().add(drawLabel);
        gridPane.getChildren().add(label2);
        gridPane.getChildren().add(loseLabel);
        gridPane.getChildren().add(showRecordsBtn);
        gridPane0.getColumnConstraints().add(columnConstraints0);
        gridPane0.getColumnConstraints().add(columnConstraints1);
        gridPane0.getColumnConstraints().add(columnConstraints2);
        gridPane0.getRowConstraints().add(rowConstraints0);
        gridPane0.getChildren().add(backBtn);
        gridPane0.getChildren().add(label3);
        gridPane0.getChildren().add(profileImage);
        gridPane0.getChildren().add(usernameLabel);

    }
}
