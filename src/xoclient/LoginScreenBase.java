package xoclient;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;

public class LoginScreenBase extends BorderPane {

    protected final Label label;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final RowConstraints rowConstraints2;
    protected final Label label0;
    protected final Button loginBtn;
    protected final Label label1;
    protected final TextField userNameTxtField;
    protected final Button signUpbtn;
    protected final Label label2;
    protected final PasswordField passTxtField;

    public LoginScreenBase() {

        label = new Label();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        label0 = new Label();
        loginBtn = new Button();
        label1 = new Label();
        userNameTxtField = new TextField();
        signUpbtn = new Button();
        label2 = new Label();
        passTxtField = new PasswordField();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(label, javafx.geometry.Pos.CENTER);
        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setPrefHeight(54.0);
        label.setPrefWidth(175.0);
        label.setText("LogIn");
        label.setFont(new Font("Bodoni MT Black Italic", 48.0));
        label.setPadding(new Insets(10.0, 0.0, 0.0, 0.0));
        setTop(label);

        BorderPane.setAlignment(gridPane, javafx.geometry.Pos.TOP_CENTER);
        gridPane.setPrefHeight(296.0);
        gridPane.setPrefWidth(600.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(600.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(101.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(468.0);
        columnConstraints0.setMinWidth(0.0);
        columnConstraints0.setPrefWidth(421.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(434.0);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(74.0);

        rowConstraints.setMaxHeight(104.0);
        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(104.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMaxHeight(106.0);
        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(83.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMaxHeight(156.0);
        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(36.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMaxHeight(177.0);
        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(113.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(label0, 1);
        label0.setPrefHeight(23.0);
        label0.setPrefWidth(98.0);
        label0.setText("User name");
        GridPane.setMargin(label0, new Insets(100.0, 0.0, 0.0, 0.0));
        label0.setFont(new Font("Bodoni MT Black", 18.0));

        GridPane.setColumnIndex(loginBtn, 1);
        GridPane.setRowIndex(loginBtn, 2);
        loginBtn.setMnemonicParsing(false);
        loginBtn.setPrefHeight(31.0);
        loginBtn.setPrefWidth(151.0);
        loginBtn.setText("LogIn");
        GridPane.setMargin(loginBtn, new Insets(0.0, 0.0, 0.0, 225.0));

        GridPane.setColumnIndex(label1, 1);
        GridPane.setRowIndex(label1, 1);
        label1.setText("Password");
        label1.setFont(new Font("Bodoni MT Black", 18.0));

        GridPane.setColumnIndex(userNameTxtField, 1);
        userNameTxtField.setPrefHeight(31.0);
        userNameTxtField.setPrefWidth(326.0);
        userNameTxtField.setPromptText("user name ");
        GridPane.setMargin(userNameTxtField, new Insets(100.0, 0.0, 0.0, 100.0));

        GridPane.setColumnIndex(signUpbtn, 1);
        GridPane.setRowIndex(signUpbtn, 3);
        signUpbtn.setMnemonicParsing(false);
        signUpbtn.setText("Sign Up");
        GridPane.setMargin(signUpbtn, new Insets(0.0, 0.0, 0.0, 300.0));

        GridPane.setColumnIndex(label2, 1);
        GridPane.setRowIndex(label2, 3);
        label2.setText("Don't have an account ?");
        GridPane.setMargin(label2, new Insets(0.0, 0.0, 0.0, 130.0));

        GridPane.setColumnIndex(passTxtField, 1);
        GridPane.setRowIndex(passTxtField, 1);
        passTxtField.setPromptText("Password ");
        GridPane.setMargin(passTxtField, new Insets(0.0, 0.0, 0.0, 100.0));
        setCenter(gridPane);

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getRowConstraints().add(rowConstraints2);
        gridPane.getChildren().add(label0);
        gridPane.getChildren().add(loginBtn);
        gridPane.getChildren().add(label1);
        gridPane.getChildren().add(userNameTxtField);
        gridPane.getChildren().add(signUpbtn);
        gridPane.getChildren().add(label2);
        gridPane.getChildren().add(passTxtField);

    }
}
