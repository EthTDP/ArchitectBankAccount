package edu.sdccd.cisc191.architectbankaccount.screen.start;

import edu.sdccd.cisc191.architectbankaccount.BankAccount;
import edu.sdccd.cisc191.architectbankaccount.screen.Screen;
import edu.sdccd.cisc191.architectbankaccount.screen.ScreenManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class LoginScreen implements Screen {
    Scene scene;
    String username;
    String password;
    ScreenManager manager;

    public LoginScreen(ScreenManager manager) {
        startScreen();
        username = "Cisc191";
        password = "BestClass!";
        this.manager = manager;
    }

    @Override
    public void startScreen() {
        HBox hBox = new HBox();
        hBox.setPrefHeight(400);
        hBox.setPrefWidth(600);
        AnchorPane pane = new AnchorPane();
        pane.setPrefHeight(400);
        pane.setPrefWidth(458);
        AnchorPane greenPane = new AnchorPane();
        greenPane.setPrefHeight(400);
        greenPane.setPrefWidth(142);
        BackgroundFill green = new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY);
        greenPane.setBackground(new Background(green));
        Label signInLabel = new Label("Sign In");
        TextField usernameLabel = new TextField();
        PasswordField passwordLabel = new PasswordField();
        Button loginButton = new Button("Login");

        try {
            setAnchorPane(pane, usernameLabel, passwordLabel, loginButton, signInLabel);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Text passwordCorrect = new Text();
        passwordCorrect.setLayoutX(95);
        passwordCorrect.setLayoutY(310);
        passwordCorrect.setFont(Font.font("Lucida Console", 15));

        usernameLabel.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER) {
                if(passwordLabel.getText() == null) {
                    passwordLabel.requestFocus();
                } else {
                    loginToAccount(usernameLabel, passwordLabel, passwordCorrect);
                }
            }
        });

        loginButton.setOnMouseClicked(clickedMouse -> {
            loginToAccount(usernameLabel, passwordLabel, passwordCorrect);
        });

        passwordLabel.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER) {
                loginToAccount(usernameLabel, passwordLabel, passwordCorrect);
            }
        });

        pane.getChildren().add(passwordCorrect);
        hBox.getChildren().add(pane);
        hBox.getChildren().add(greenPane);
        scene = new Scene(hBox, 600, 400);

        signInLabel.requestFocus();
    }

    private void setAnchorPane(AnchorPane pane, TextField usernameLabel, PasswordField passwordLabel, Button loginButton, Label signInLabel) throws IOException {
        //Signin Text
        signInLabel.setAlignment(Pos.CENTER);
        signInLabel.setLayoutX(126);
        signInLabel.setLayoutY(55);
        signInLabel.setPrefHeight(99);
        signInLabel.setPrefWidth(230);
        signInLabel.setFont(Font.font("Lucida Console", 45));
        signInLabel.setTextFill(Color.DARKGREEN);

        //Username Field
        usernameLabel.setPromptText("Username or Email");
        usernameLabel.setLayoutX(163);
        usernameLabel.setLayoutY(163);
        usernameLabel.setPrefHeight(25);
        usernameLabel.setPrefWidth(154);

        //Password Field
        passwordLabel.setPromptText("Password");
        passwordLabel.setLayoutX(163);
        passwordLabel.setLayoutY(192);
        passwordLabel.setPrefHeight(25);
        passwordLabel.setPrefWidth(154);

        //Login Button
        loginButton.setAlignment(Pos.CENTER);
        loginButton.setLayoutX(178);
        loginButton.setLayoutY(231);
        loginButton.setPrefHeight(44);
        loginButton.setPrefWidth(109);
        loginButton.setTextFill(Color.DARKGREEN);
        loginButton.setFont(Font.font("SansSerif Regular, 24"));

        URL usernameFile = BankAccount.class.getClassLoader().getResource("username.png");
        ImageView usernameImageView = new ImageView(String.valueOf(usernameFile));
        usernameImageView.setFitHeight(25);
        usernameImageView.setPreserveRatio(true);
        usernameImageView.setLayoutX(135);
        usernameImageView.setLayoutY(163);

        URL passwordFile = BankAccount.class.getClassLoader().getResource("password.png");
        ImageView passwordImageView = new ImageView(String.valueOf(passwordFile));
        passwordImageView.setFitHeight(25);
        passwordImageView.setPreserveRatio(true);
        passwordImageView.setLayoutX(135);
        passwordImageView.setLayoutY(192);

        //Add to an ArrayList(Generics) to add to the AnchorPane
        ArrayList<Node> children = new ArrayList<>();
        children.add(signInLabel);
        children.add(usernameLabel);
        children.add(passwordLabel);
        children.add(loginButton);
        children.add(usernameImageView);
        children.add(passwordImageView);

        pane.getChildren().addAll(children);
    }

    private void loginToAccount(TextField usernameField, PasswordField passwordField, Text passwordCorrect) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        // Implementation of Loging In

        if(!username.equalsIgnoreCase(this.username) && !password.equalsIgnoreCase(this.password)){
            passwordCorrect.setText("Incorrect Password and Username!! Please try again!");
        } else if(!password.equalsIgnoreCase(this.password)) {
            passwordCorrect.setText("Incorrect Password!! Please try again!");
        } else if(!username.equalsIgnoreCase(this.username)){
            passwordCorrect.setText("Incorrect Username!! Please try again!");
        } else {
            manager.setBankScene();
        }
    }



    public Scene getScreen() {
        return scene;
    }
}
