package edu.sdccd.cisc191.architectbankaccount.screen;

import edu.sdccd.cisc191.architectbankaccount.screen.bank.BankScreen;
import edu.sdccd.cisc191.architectbankaccount.screen.start.StartScreen;
import javafx.stage.Stage;

import java.awt.*;

public class ScreenManager {
    StartScreen screen;
    BankScreen bank;
    Stage primaryStage;

    public ScreenManager(Stage primaryStage) {
        screen = new StartScreen(this);
        bank = new BankScreen(this);
        this.primaryStage = primaryStage;
    }

    public void setStartScene() {
        primaryStage.setTitle("BankAccount Login Screen");
        primaryStage.setScene(screen.getScreen());

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        primaryStage.setX((screenSize.getWidth() / 2) - 200);
        primaryStage.setY((screenSize.getHeight() / 2) - 200);
        primaryStage.show();
    }

    public void setBankScene() {
        primaryStage.setTitle("BankAccount");
        primaryStage.setScene(bank.getScene());

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        primaryStage.setX((screenSize.getWidth() / 2) - 200);
        primaryStage.setY((screenSize.getHeight() / 2) - 200);
        primaryStage.show();
    }
}
