package xoclient.Screens;

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

public  class LoginScreenBase extends BorderPane {

    protected final Label label;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final RowConstraints rowConstraints;
    protected final Label label0;
    protected final Label label1;
    protected final TextField userNameTxtField;
    protected final Button signUpbtn;
    protected final Button loginBtn;
    protected final Label label2;
    protected final PasswordField passTxtField;

    public LoginScreenBase() {

        label = new Label();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        label0 = new Label();
        label1 = new Label();
        userNameTxtField = new TextField();
        signUpbtn = new Button();
        loginBtn = new Button();
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

        BorderPane.setAlignment(gridPane, javafx.geometry.Pos.CENTER);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        rowConstraints.setMaxHeight(173.0);
        rowConstraints.setMinHeight(0.0);
        rowConstraints.setPrefHeight(173.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        label0.setText("User name");
        GridPane.setMargin(label0, new Insets(-80.0, 0.0, 0.0, 50.0));
        label0.setFont(new Font("Bodoni MT Black", 18.0));

        label1.setText("Password");
        label1.setFont(new Font("Bodoni MT Black", 18.0));
        GridPane.setMargin(label1, new Insets(0.0, 0.0, 0.0, 50.0));

        userNameTxtField.setPromptText("user name ");
        GridPane.setMargin(userNameTxtField, new Insets(-80.0, 10.0, 0.0, 150.0));

        signUpbtn.setMnemonicParsing(false);
        signUpbtn.setText("Sign Up");
        GridPane.setMargin(signUpbtn, new Insets(150.0, 70.0, 0.0, 325.0));

        loginBtn.setContentDisplay(javafx.scene.control.ContentDisplay.RIGHT);
        loginBtn.setMnemonicParsing(false);
        loginBtn.setNodeOrientation(javafx.geometry.NodeOrientation.RIGHT_TO_LEFT);
        loginBtn.setPrefHeight(31.0);
        loginBtn.setPrefWidth(143.0);
        loginBtn.setText("LogIn");
        loginBtn.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        GridPane.setMargin(loginBtn, new Insets(80.0, 50.0, 0.0, 450.0));

        label2.setText("Don't have an account ?");
        GridPane.setMargin(label2, new Insets(150.0, 100.0, 0.0, 155.0));

        passTxtField.setPromptText("Password ");
        GridPane.setMargin(passTxtField, new Insets(0.0, 10.0, 0.0, 150.0));
        setCenter(gridPane);

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getChildren().add(label0);
        gridPane.getChildren().add(label1);
        gridPane.getChildren().add(userNameTxtField);
        gridPane.getChildren().add(signUpbtn);
        gridPane.getChildren().add(loginBtn);
        gridPane.getChildren().add(label2);
        gridPane.getChildren().add(passTxtField);

    }
}
