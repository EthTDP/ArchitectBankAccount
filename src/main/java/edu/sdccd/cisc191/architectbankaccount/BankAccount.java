package edu.sdccd.cisc191.architectbankaccount;

import edu.sdccd.cisc191.architectbankaccount.screen.ScreenManager;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class BankAccount extends Application {
    @Override
    public void start(Stage stage) {
        ScreenManager manager = new ScreenManager(stage);
        manager.setStartScene();
        stage.setResizable(false);
    }

    private static double compoundInterest(double initial, double rates, int years, double annualRate) {
        if(years == 0) {
            return initial;
        } else {
            double amount = initial * Math.pow(1 + rates / annualRate, annualRate);
            return compoundInterest(amount, rates, years - 1, annualRate);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}