package edu.sdccd.cisc191.architectbankaccount.screen;

import edu.sdccd.cisc191.architectbankaccount.screen.bank.BankScreen;
import edu.sdccd.cisc191.architectbankaccount.screen.start.LoginScreen;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.awt.*;
import java.sql.Array;
import java.sql.Connection;
import java.util.ArrayList;

public class ScreenManager {
    int height = 400, width = 600;
    LoginScreen screen;
    BankScreen bank;
    Stage primaryStage;

    public ScreenManager(Stage primaryStage) {
        screen = new LoginScreen(this);
        this.primaryStage = primaryStage;
        primaryStage.setHeight(height);
        primaryStage.setWidth(width);
    }

    public void setStartScene() {
        primaryStage.setTitle("BankAccount Login Screen");
        primaryStage.setScene(screen.getScreen());

        setScreen();
    }

    public void setBankScene(double money) {
        bank = new BankScreen( this, money);
        primaryStage.setTitle("BankAccount");
        primaryStage.setScene(bank.getScene());

        setScreen();
    }

    private void setScreen() {
        Screen screen = Screen.getPrimary();

        Rectangle2D screenSize = screen.getVisualBounds();

        primaryStage.setX((screenSize.getWidth() / 2) - ((double) width / 2));
        primaryStage.setY((screenSize.getHeight() / 2 ) - ((double) height / 2));
        primaryStage.show();
    }
}
