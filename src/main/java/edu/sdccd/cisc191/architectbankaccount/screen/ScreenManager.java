package edu.sdccd.cisc191.architectbankaccount.screen;

import edu.sdccd.cisc191.architectbankaccount.screen.bank.BankScreen;
import edu.sdccd.cisc191.architectbankaccount.screen.start.LoginScreen;
import javafx.stage.Stage;

import java.awt.*;

public class ScreenManager {
    int height = 400, width = 600;
    LoginScreen screen;
    BankScreen bank;
    Stage primaryStage;

    public ScreenManager(Stage primaryStage) {
        screen = new LoginScreen(this);
        bank = new BankScreen(this);
        this.primaryStage = primaryStage;
        primaryStage.setHeight(height);
        primaryStage.setWidth(width);
    }

    public void setStartScene() {
        primaryStage.setTitle("BankAccount Login Screen");
        primaryStage.setScene(screen.getScreen());

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        primaryStage.setX((screenSize.getWidth() / 2) - ((double) width / 2));
        primaryStage.setY((screenSize.getHeight() / 2 ) - ((double) height / 2));
        primaryStage.show();
    }

    public void setBankScene() {
        primaryStage.setTitle("BankAccount");
        primaryStage.setScene(bank.getScene());

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        primaryStage.setX((screenSize.getWidth() / 2) - ((double) width / 2));
        primaryStage.setY((screenSize.getHeight() / 2) - ((double) height / 2));
        primaryStage.show();
    }
}
