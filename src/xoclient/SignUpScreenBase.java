package xoclient;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;

public class SignUpScreenBase extends BorderPane {

    protected final Label label;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final RowConstraints rowConstraints2;
    protected final RowConstraints rowConstraints3;
    protected final RowConstraints rowConstraints4;
    protected final TextField lNameTxtfield;
    protected final Label label0;
    protected final TextField fNameTxtfield;
    protected final Label label1;
    protected final TextField emailTxtfield;
    protected final Label label2;
    protected final Label label3;
    protected final PasswordField passwordTxtfield;
    protected final Label label4;
    protected final RadioButton maleRadiobtn;
    protected final RadioButton femaleRadiobtn;
    protected final Button createBtn;
    protected final Button loginBtn;
    protected final Label label5;

    public SignUpScreenBase() {

        label = new Label();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        rowConstraints4 = new RowConstraints();
        lNameTxtfield = new TextField();
        label0 = new Label();
        fNameTxtfield = new TextField();
        label1 = new Label();
        emailTxtfield = new TextField();
        label2 = new Label();
        label3 = new Label();
        passwordTxtfield = new PasswordField();
        label4 = new Label();
        maleRadiobtn = new RadioButton();
        femaleRadiobtn = new RadioButton();
        createBtn = new Button();
        loginBtn = new Button();
        label5 = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(label, javafx.geometry.Pos.CENTER);
        label.setText("Create new Account");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setFont(new Font("Bodoni MT Black Italic", 44.0));
        setTop(label);

        BorderPane.setAlignment(gridPane, javafx.geometry.Pos.CENTER);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        rowConstraints.setMaxHeight(53.0);
        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(45.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMaxHeight(71.0);
        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(45.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMaxHeight(81.0);
        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(44.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMaxHeight(81.0);
        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(50.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMaxHeight(83.0);
        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPrefHeight(45.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints4.setMaxHeight(110.0);
        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPrefHeight(110.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setRowIndex(lNameTxtfield, 1);
        GridPane.setMargin(lNameTxtfield, new Insets(0.0, 200.0, 0.0, 200.0));

        GridPane.setRowIndex(label0, 1);
        label0.setText("Last Name");
        GridPane.setMargin(label0, new Insets(0.0, 0.0, 0.0, 100.0));
        label0.setFont(new Font("Bodoni MT Black Italic", 15.0));

        GridPane.setMargin(fNameTxtfield, new Insets(0.0, 200.0, 0.0, 200.0));

        label1.setText("First Name");
        label1.setFont(new Font("Bodoni MT Black Italic", 15.0));
        GridPane.setMargin(label1, new Insets(0.0, 0.0, 0.0, 100.0));

        GridPane.setRowIndex(emailTxtfield, 2);
        GridPane.setMargin(emailTxtfield, new Insets(0.0, 200.0, 0.0, 200.0));

        GridPane.setRowIndex(label2, 2);
        label2.setText("Email");
        label2.setFont(new Font("Bodoni MT Black Italic", 15.0));
        GridPane.setMargin(label2, new Insets(0.0, 0.0, 0.0, 100.0));

        GridPane.setRowIndex(label3, 3);
        label3.setText("Password");
        label3.setFont(new Font("Bodoni MT Black Italic", 15.0));
        GridPane.setMargin(label3, new Insets(0.0, 0.0, 0.0, 100.0));

        GridPane.setRowIndex(passwordTxtfield, 3);
        GridPane.setMargin(passwordTxtfield, new Insets(0.0, 200.0, 0.0, 200.0));

        GridPane.setRowIndex(label4, 4);
        label4.setLayoutX(110.0);
        label4.setLayoutY(204.0);
        label4.setText("Gender");
        label4.setFont(new Font("Bodoni MT Black Italic", 15.0));
        GridPane.setMargin(label4, new Insets(0.0, 0.0, 0.0, 100.0));

        GridPane.setRowIndex(maleRadiobtn, 4);
        maleRadiobtn.setMnemonicParsing(false);
        maleRadiobtn.setText("male");
        GridPane.setMargin(maleRadiobtn, new Insets(0.0, 0.0, 0.0, 200.0));
        maleRadiobtn.setFont(new Font("Bodoni MT Black Italic", 16.0));

        GridPane.setRowIndex(femaleRadiobtn, 4);
        femaleRadiobtn.setLayoutX(210.0);
        femaleRadiobtn.setLayoutY(260.0);
        femaleRadiobtn.setMnemonicParsing(false);
        femaleRadiobtn.setText("Female");
        femaleRadiobtn.setFont(new Font("Bodoni MT Black Italic", 16.0));
        GridPane.setMargin(femaleRadiobtn, new Insets(0.0, 0.0, 0.0, 300.0));

        GridPane.setRowIndex(createBtn, 5);
        createBtn.setMnemonicParsing(false);
        createBtn.setText("Create");
        createBtn.setFont(new Font("Bodoni MT Black", 14.0));
        GridPane.setMargin(createBtn, new Insets(-70.0, 0.0, 0.0, 340.0));

        GridPane.setRowIndex(loginBtn, 5);
        loginBtn.setLayoutX(350.0);
        loginBtn.setLayoutY(254.0);
        loginBtn.setMnemonicParsing(false);
        loginBtn.setText("Login");
        loginBtn.setFont(new Font("Bodoni MT Black", 14.0));
        GridPane.setMargin(loginBtn, new Insets(50.0, 0.0, 0.0, 325.0));

        GridPane.setRowIndex(label5, 5);
        label5.setLayoutX(110.0);
        label5.setLayoutY(215.0);
        label5.setText("Already have an account?");
        label5.setFont(new Font("Bodoni MT Black Italic", 15.0));
        GridPane.setMargin(label5, new Insets(50.0, 0.0, 0.0, 100.0));
        setCenter(gridPane);

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getRowConstraints().add(rowConstraints2);
        gridPane.getRowConstraints().add(rowConstraints3);
        gridPane.getRowConstraints().add(rowConstraints4);
        gridPane.getChildren().add(lNameTxtfield);
        gridPane.getChildren().add(label0);
        gridPane.getChildren().add(fNameTxtfield);
        gridPane.getChildren().add(label1);
        gridPane.getChildren().add(emailTxtfield);
        gridPane.getChildren().add(label2);
        gridPane.getChildren().add(label3);
        gridPane.getChildren().add(passwordTxtfield);
        gridPane.getChildren().add(label4);
        gridPane.getChildren().add(maleRadiobtn);
        gridPane.getChildren().add(femaleRadiobtn);
        gridPane.getChildren().add(createBtn);
        gridPane.getChildren().add(loginBtn);
        gridPane.getChildren().add(label5);

    }
}
