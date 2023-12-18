package LoginScreen;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;

public abstract class LoginScreenBase extends GridPane {

    protected final Button backBtn1;
    protected final ImageView imageView;
    protected final Label label;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final Label label0;
    protected final ImageView imageView0;
    protected final TextField txtFieldPlayerName;
    protected final PasswordField txtFieldPassword;
    protected final Label label1;
    protected final ImageView imageView1;
    protected final Button signInBtn;
    protected final ImageView imageView2;
    protected final Label label2;
    protected final Button signOutBtn;

    public LoginScreenBase() {

        backBtn1 = new Button();
        imageView = new ImageView();
        label = new Label();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        label0 = new Label();
        imageView0 = new ImageView();
        txtFieldPlayerName = new TextField();
        txtFieldPassword = new PasswordField();
        label1 = new Label();
        imageView1 = new ImageView();
        signInBtn = new Button();
        imageView2 = new ImageView();
        label2 = new Label();
        signOutBtn = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        backBtn1.setLayoutX(14.0);
        backBtn1.setLayoutY(18.0);
        backBtn1.setMnemonicParsing(false);
        backBtn1.setOnAction(this::goBackBtn);
        backBtn1.setPrefHeight(24.0);
        backBtn1.setPrefWidth(92.0);
        backBtn1.setText("Back");
        backBtn1.setFont(new Font("Baskerville Old Face", 18.0));

        imageView.setFitHeight(23.0);
        imageView.setFitWidth(18.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("../Icons/backBtn.png").toExternalForm()));
        backBtn1.setGraphic(imageView);

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setLayoutX(98.0);
        label.setLayoutY(5.0);
        label.setPrefHeight(59.0);
        label.setPrefWidth(405.0);
        label.setText("Sign In");
        label.setFont(new Font("Baskerville Old Face", 36.0));

        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        gridPane.setLayoutX(27.0);
        gridPane.setLayoutY(115.0);
        gridPane.setPrefHeight(135.0);
        gridPane.setPrefWidth(546.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(214.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(134.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(421.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(412.0);

        rowConstraints.setMaxHeight(114.0);
        rowConstraints.setMinHeight(0.0);
        rowConstraints.setPrefHeight(77.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMaxHeight(159.0);
        rowConstraints0.setMinHeight(0.0);
        rowConstraints0.setPrefHeight(80.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        label0.setContentDisplay(javafx.scene.control.ContentDisplay.RIGHT);
        label0.setPrefHeight(31.0);
        label0.setPrefWidth(123.0);
        label0.setText("User Name");
        label0.setFont(new Font("Baskerville Old Face", 20.0));

        imageView0.setFitHeight(25.0);
        imageView0.setFitWidth(22.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("../Icons/R%20(2).png").toExternalForm()));
        label0.setGraphic(imageView0);

        GridPane.setColumnIndex(txtFieldPlayerName, 1);
        txtFieldPlayerName.setPrefHeight(31.0);
        txtFieldPlayerName.setPrefWidth(420.0);
        txtFieldPlayerName.setPromptText("enter your name ");
        txtFieldPlayerName.setFont(new Font("Baskerville Old Face", 16.0));

        GridPane.setColumnIndex(txtFieldPassword, 1);
        GridPane.setRowIndex(txtFieldPassword, 1);
        txtFieldPassword.setPromptText("enter you password");
        txtFieldPassword.setFont(new Font("Baskerville Old Face", 15.0));

        GridPane.setRowIndex(label1, 1);
        label1.setContentDisplay(javafx.scene.control.ContentDisplay.RIGHT);
        label1.setPrefHeight(31.0);
        label1.setPrefWidth(130.0);
        label1.setText("Password");
        label1.setFont(new Font("Baskerville Old Face", 20.0));

        imageView1.setFitHeight(24.0);
        imageView1.setFitWidth(39.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("../Icons/lock.png").toExternalForm()));
        label1.setGraphic(imageView1);

        signInBtn.setContentDisplay(javafx.scene.control.ContentDisplay.RIGHT);
        signInBtn.setLayoutX(239.0);
        signInBtn.setLayoutY(273.0);
        signInBtn.setMnemonicParsing(false);
        signInBtn.setOnAction(this::signIn);
        signInBtn.setPrefHeight(43.0);
        signInBtn.setPrefWidth(123.0);
        signInBtn.setText("Sign In");
        signInBtn.setFont(new Font("Baskerville Old Face", 20.0));

        imageView2.setFitHeight(29.0);
        imageView2.setFitWidth(49.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        imageView2.setImage(new Image(getClass().getResource("../Icons/forward.png").toExternalForm()));
        signInBtn.setGraphic(imageView2);

        label2.setLayoutX(171.0);
        label2.setLayoutY(343.0);
        label2.setPrefHeight(43.0);
        label2.setPrefWidth(196.0);
        label2.setText("Don't have an account? ");
        label2.setFont(new Font("Baskerville Old Face", 20.0));

        signOutBtn.setLayoutX(362.0);
        signOutBtn.setLayoutY(346.0);
        signOutBtn.setMnemonicParsing(false);
        signOutBtn.setOnAction(this::signUptMethod);
        signOutBtn.setPrefHeight(31.0);
        signOutBtn.setPrefWidth(100.0);
        signOutBtn.setText("Sign Up");
        signOutBtn.setFont(new Font("Baskerville Old Face", 20.0));

        getChildren().add(backBtn1);
        getChildren().add(label);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getChildren().add(label0);
        gridPane.getChildren().add(txtFieldPlayerName);
        gridPane.getChildren().add(txtFieldPassword);
        gridPane.getChildren().add(label1);
        getChildren().add(gridPane);
        getChildren().add(signInBtn);
        getChildren().add(label2);
        getChildren().add(signOutBtn);

    }

    protected abstract void goBackBtn(javafx.event.ActionEvent actionEvent);

    protected abstract void signIn(javafx.event.ActionEvent actionEvent);

    protected abstract void signUptMethod(javafx.event.ActionEvent actionEvent);

}
