package edu.sdccd.cisc191.architectbankaccount.screen.bank;

import edu.sdccd.cisc191.architectbankaccount.screen.Screen;
import edu.sdccd.cisc191.architectbankaccount.screen.ScreenManager;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        Label amountOfMoney = new Label("$10.00");
        amountOfMoney.setTranslateX(250);
        amountOfMoney.setFont(Font.font("Lucida Console", 25));

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
                    amountOfMoney.setText("$" + String.format("%.2f", amount));
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
        removeMoneyButton.setTranslateY(250);
        addMoneyButton.setTranslateY(250);
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
                    amountOfMoney.setText("$" + String.format("%.2f", amount));
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

        ArrayList<Node> allChildren = new ArrayList<>();
        allChildren.add(addMoneyButton);
        allChildren.add(amountOfMoney);
        allChildren.add(removeMoneyButton);
        pane.getChildren().addAll(allChildren);
        scene = new Scene(pane, 600, 400);

        //Recursion with compound interest
    }

    public Scene getScene() {
        return scene;
    }
}
