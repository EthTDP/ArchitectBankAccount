package edu.sdccd.cisc191.architectbankaccount.screen.start;

import edu.sdccd.cisc191.architectbankaccount.screen.Screen;
import edu.sdccd.cisc191.architectbankaccount.screen.ScreenManager;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class StartScreen implements Screen {
    Scene scene;
    String username;
    String password;
    ScreenManager manager;

    public StartScreen(ScreenManager manager) {
        startScreen();
        username = "Cisc191";
        password = "BestClass!";
        this.manager = manager;
    }

    @Override
    public void startScreen() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        //Set username
        Label userNameLabel = new Label("Username:");
        GridPane.setConstraints(userNameLabel, 0, 0);
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username or Email here");
        GridPane.setConstraints(usernameField, 1, 0);

        //Set password
        Label passwordLabel = new Label("Password:");
        GridPane.setConstraints(passwordLabel, 0, 1);
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");
        GridPane.setConstraints(passwordField, 1, 1);

        usernameField.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER) {
                passwordField.requestFocus();
            }
        });

        //Set the button
        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 1, 2);

        Text passwordCorrect = new Text();
        GridPane.setConstraints(passwordCorrect, 0, 3);
        GridPane.setColumnSpan(passwordCorrect, 2);

        loginButton.setOnMouseClicked(clickedMouse -> {
            loginToAccount(usernameField, passwordField, passwordCorrect);
        });

        passwordField.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER) {
                loginToAccount(usernameField, passwordField, passwordCorrect);
            }
        });

        grid.getChildren().addAll(userNameLabel, usernameField, passwordLabel, passwordField, loginButton, passwordCorrect);

        scene = new Scene(grid, 300, 200);
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
