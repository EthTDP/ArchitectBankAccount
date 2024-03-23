package edu.sdccd.cisc191.architectbankaccount;

import edu.sdccd.cisc191.architectbankaccount.screen.ScreenManager;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.io.IOException;

public class BankAccount extends Application {
    @Override
    public void start(Stage stage) {
        ScreenManager manager = new ScreenManager(stage);
        manager.setStartScene();
    }

    public static void main(String[] args) {
        launch();
    }
}