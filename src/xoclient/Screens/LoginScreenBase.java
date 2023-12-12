package xoclient.Screens;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginScreenBase extends BorderPane {

    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final RowConstraints rowConstraints;
    protected final Label label;
    protected final Label label0;
    protected final TextField userNameTxtField;
    protected final Button signUpbtn;
    protected final Button loginBtn;
    protected final Label label1;
    protected final PasswordField passTxtField;
    protected final FlowPane flowPane;
    protected final Button backBtn;
    protected final Label label2;

    public LoginScreenBase() {

        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        label = new Label();
        label0 = new Label();
        userNameTxtField = new TextField();
        signUpbtn = new Button();
        loginBtn = new Button();
        label1 = new Label();
        passTxtField = new PasswordField();
        flowPane = new FlowPane();
        backBtn = new Button();
        label2 = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(gridPane, javafx.geometry.Pos.CENTER);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        rowConstraints.setMaxHeight(173.0);
        rowConstraints.setMinHeight(0.0);
        rowConstraints.setPrefHeight(173.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        label.setText("User name");
        GridPane.setMargin(label, new Insets(-80.0, 0.0, 0.0, 50.0));
        label.setFont(new Font("Bodoni MT Black", 18.0));

        label0.setText("Password");
        label0.setFont(new Font("Bodoni MT Black", 18.0));
        GridPane.setMargin(label0, new Insets(0.0, 0.0, 0.0, 50.0));

        userNameTxtField.setPromptText("user name ");
        GridPane.setMargin(userNameTxtField, new Insets(-80.0, 10.0, 0.0, 150.0));

        signUpbtn.setMnemonicParsing(false);
        signUpbtn.setText("Sign Up");
        GridPane.setMargin(signUpbtn, new Insets(150.0, 70.0, 0.0, 325.0));
        signUpbtn.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage primaryStage = (Stage) signUpbtn.getScene().getWindow();
                //Stage primaryStage = new Stage();
                SignUpScreenBase pro = new SignUpScreenBase();
                //pro.usernameLabel.setText(userNameTxtField.getText());
                Parent root = pro;
                primaryStage.setScene(new Scene(root, USE_PREF_SIZE, USE_PREF_SIZE));
                primaryStage.show();
            }
        });

        loginBtn.setContentDisplay(javafx.scene.control.ContentDisplay.RIGHT);
        loginBtn.setMnemonicParsing(false);
        loginBtn.setNodeOrientation(javafx.geometry.NodeOrientation.RIGHT_TO_LEFT);
        loginBtn.setPrefHeight(31.0);
        loginBtn.setPrefWidth(143.0);
        loginBtn.setText("LogIn");
        loginBtn.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        GridPane.setMargin(loginBtn, new Insets(80.0, 50.0, 0.0, 450.0));

        label1.setText("Don't have an account ?");
        GridPane.setMargin(label1, new Insets(150.0, 100.0, 0.0, 155.0));

        passTxtField.setPromptText("Password ");
        GridPane.setMargin(passTxtField, new Insets(0.0, 10.0, 0.0, 150.0));
        setCenter(gridPane);

        flowPane.setHgap(155.0);
        flowPane.setPrefHeight(78.0);
        flowPane.setPrefWidth(600.0);

        backBtn.setMnemonicParsing(false);
        backBtn.setText("Back");
        FlowPane.setMargin(backBtn, new Insets(0.0, 0.0, 0.0, 20.0));
        backBtn.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage primaryStage = (Stage) backBtn.getScene().getWindow();
                //Stage primaryStage = new Stage();
                StartScreenBase pro = new StartScreenBase();
                Parent root = pro;
                primaryStage.setScene(new Scene(root, USE_PREF_SIZE, USE_PREF_SIZE));
                primaryStage.show();
            }
        });

        label2.setAlignment(javafx.geometry.Pos.CENTER);
        label2.setPrefHeight(54.0);
        label2.setPrefWidth(175.0);
        label2.setText("LogIn");
        label2.setFont(new Font("Bodoni MT Black Italic", 48.0));
        label2.setPadding(new Insets(10.0, 0.0, 0.0, 0.0));
        FlowPane.setMargin(label2, new Insets(0.0, 150.0, 0.0, 0.0));
        setTop(flowPane);

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getChildren().add(label);
        gridPane.getChildren().add(label0);
        gridPane.getChildren().add(userNameTxtField);
        gridPane.getChildren().add(signUpbtn);
        gridPane.getChildren().add(loginBtn);
        gridPane.getChildren().add(label1);
        gridPane.getChildren().add(passTxtField);
        flowPane.getChildren().add(backBtn);
        flowPane.getChildren().add(label2);

    }
}
