package edu.sdccd.cisc191.architectbankaccount;

import edu.sdccd.cisc191.architectbankaccount.screen.ScreenManager;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class BankAccount extends Application {

    public static String password;

    @Override
    public void start(Stage stage) {

        ScreenManager manager = new ScreenManager(stage);
        manager.setStartScene();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        password = args[0];

        launch();
    }
}