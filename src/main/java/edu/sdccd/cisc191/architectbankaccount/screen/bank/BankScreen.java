package edu.sdccd.cisc191.architectbankaccount.screen.bank;

import edu.sdccd.cisc191.architectbankaccount.screen.Screen;
import edu.sdccd.cisc191.architectbankaccount.screen.ScreenManager;
import edu.sdccd.cisc191.architectbankaccount.savingandsorting.SinglyLinkedList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class BankScreen {

    Scene scene;
    ScreenManager manager;
    SinglyLinkedList dateList;

    public static String sortingType;

    public BankScreen(ScreenManager manager, double money) {
        startScreen(money);
        this.manager = manager;
        this.dateList = new SinglyLinkedList();
    }

    public void startScreen(double money) {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(20));
        pane.setVgap(10);
        pane.setHgap(10);

        TextArea transactions = new TextArea();
        transactions.setEditable(false);
        Label amountOfMoney = new Label("$" + money + "0");
        amountOfMoney.setTranslateX(230);
        amountOfMoney.setTranslateY(-60);
        amountOfMoney.setFont(Font.font("Lucida Console", 25));

        AtomicInteger amountOfTransactions = new AtomicInteger();

        Button addMoneyButton = new Button("Add Money");
        addMoneyButton.setOnMouseClicked(e -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Bank Amount");
            dialog.setHeaderText("Enter The Amount you would Like to add: ");

            // Show the dialog and wait for user input
            Optional<String> result = dialog.showAndWait();

            // Process the user input
            result.ifPresent(input -> {
                try {
                    // Try to parse the input as a number
                    double number = Double.parseDouble(input);
                    // Handle the number (e.g., display it)

                    String originalAmount = amountOfMoney.getText();
                    double amount = Double.parseDouble(originalAmount.replace("$", ""));
                    amount += number;
                    Date date = new Date();
                    SinglyLinkedList.insert(dateList, date);
                    amountOfMoney.setText("$" + String.format("%.2f", amount));
                    SinglyLinkedList.printSortedList(dateList, transactions, number, amountOfTransactions.get(), "adding");
                    amountOfTransactions.getAndIncrement();
                } catch (NumberFormatException exception) {
                    // Show an alert if the input is not a valid number
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid Input");
                    alert.setContentText("Please enter a valid number.");
                    alert.showAndWait();
                }
            });
        });

        Button removeMoneyButton = new Button("Remove Money");
        removeMoneyButton.setTranslateY(200);
        addMoneyButton.setTranslateY(200);
        removeMoneyButton.setTranslateX(400);
        addMoneyButton.setTranslateX(50);

        removeMoneyButton.setOnMouseClicked(e -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Bank Amount");
            dialog.setHeaderText("Enter The Amount you would Like to remove: ");

            // Show the dialog and wait for user input
            Optional<String> result = dialog.showAndWait();

            // Process the user input
            result.ifPresent(input -> {
                try {
                    // Try to parse the input as a number
                    double number = Double.parseDouble(input);
                    // Handle the number (e.g., display it)

                    String originalAmount = amountOfMoney.getText();
                    double amount = Double.parseDouble(originalAmount.replace("$", ""));
                    amount -= number;
                    Date date = new Date();
                    SinglyLinkedList.insert(dateList, date);
                    amountOfMoney.setText("$" + String.format("%.2f", amount));
                    SinglyLinkedList.printSortedList(dateList, transactions, number, amountOfTransactions.get(), "removing");
                    amountOfTransactions.getAndIncrement();
                } catch (NumberFormatException exception) {
                    // Show an alert if the input is not a valid number
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid Input");
                    alert.setContentText("Please enter a valid number.");
                    alert.showAndWait();
                }
            });
        });

        Button interestButton = new Button("Calculate Interest");

        transactions.setTranslateX(50);
        transactions.setTranslateY(50);
        interestButton.setTranslateY(200);
        interestButton.setTranslateX(200);

        interestButton.setOnMouseClicked(e -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Interest Calculator");
            dialog.setHeaderText("Enter the amount of years you would like to compute. ");

            // Show the dialog and wait for user input
            Optional<String> result = dialog.showAndWait();

            // Process the user input
            result.ifPresent(input -> {
                try {
                    // Try to parse the input as a number
                    int years = Integer.parseInt(input);
                    // Handle the number (e.g., display it)
                    double amount = Double.parseDouble(amountOfMoney.getText().replace("$", ""));

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Interest");
                    alert.setHeaderText(null);
                    alert.setContentText("$" + String.format("%.2f", compoundInterest(amount, .05, years, 1)));
                    alert.showAndWait();
                } catch (NumberFormatException exception) {
                    // Show an alert if the input is not a valid number
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid Input");
                    alert.setContentText("Please enter a valid number of years!");
                    alert.showAndWait();
                }
            });
        });


        final ComboBox<String> sorting = new ComboBox<>();
        sorting.getItems().addAll("date", "amount");
        sorting.setValue("date");

        sorting.setOnAction(action -> {
            sortingType = sorting.getValue();
            System.out.println(sortingType);
        });

        sorting.setTranslateX(425);
        sorting.setTranslateY(-60);


        ArrayList<Node> allChildren = new ArrayList<>();
        allChildren.add(addMoneyButton);
        allChildren.add(removeMoneyButton);
        allChildren.add(transactions);
        allChildren.add(interestButton);
        allChildren.add(amountOfMoney);
        allChildren.add(sorting);
        pane.getChildren().addAll(allChildren);
        scene = new Scene(pane, 600, 400);

        //Recursion with compound interest
    }

    public static double compoundInterest(double initial, double rates, int years, double annualRate) {
        if(years == 0) {
            return initial;
        } else {
            double amount = initial * Math.pow(1 + rates / annualRate, annualRate);
            return compoundInterest(amount, rates, years - 1, annualRate);
        }
    }

    public Scene getScene() {
        return scene;
    }
}
