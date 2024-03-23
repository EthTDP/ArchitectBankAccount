package edu.sdccd.cisc191.architectbankaccount.screen.bank;

import edu.sdccd.cisc191.architectbankaccount.screen.Screen;
import edu.sdccd.cisc191.architectbankaccount.screen.ScreenManager;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class BankScreen implements Screen {

    Scene scene;
    ScreenManager manager;

    public BankScreen(ScreenManager manager) {
        startScreen();
        this.manager = manager;
    }

    @Override
    public void startScreen() {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(20));
        pane.setVgap(10);
        pane.setHgap(10);

        Label userNameLabel = new Label("Yessir");
        GridPane.setConstraints(userNameLabel, 0, 0);

        //Set password
        Label passwordLabel = new Label("Yessuh");
        GridPane.setConstraints(passwordLabel, 0, 1);

        pane.getChildren().addAll(userNameLabel, passwordLabel);
        scene = new Scene(pane, 300, 200);
    }

    public Scene getScene() {
        return scene;
    }
}
