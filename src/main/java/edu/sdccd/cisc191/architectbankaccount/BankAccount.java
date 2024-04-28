package edu.sdccd.cisc191.architectbankaccount;

import edu.sdccd.cisc191.architectbankaccount.database.Account;
import edu.sdccd.cisc191.architectbankaccount.database.AccountRepository;
import edu.sdccd.cisc191.architectbankaccount.screen.ScreenManager;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

@SpringBootApplication
public class BankAccount extends Application {

    public ConfigurableApplicationContext springContext;
    public static String password;

    public static List<Account> accounts;

    @Override
    public void start(Stage stage) {

        try {
            Account account = springContext.getBean(Account.class);
            ScreenManager manager = new ScreenManager(stage);
            manager.setStartScene();
            stage.setResizable(false);
        }  catch (Exception e) {
            // Handle the exception gracefully
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        password = "5ukYq7TifOXU";

        launch(args);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        if (springContext != null) {
            springContext.close();
        }
    }

    @Override
    public void init() throws Exception {
        springContext  = SpringApplication.run(BankAccount.class);

    }

    @Bean
    CommandLineRunner commandLineRunner(AccountRepository account) {
        return args -> {
            Account account1 = new Account(1, "Ethan", "Nguyen", 10.00);
            Account account2 = new Account(2, "Cisc191", "BestClass!", 10.00);
            account.save(account1);
            account.save(account2);

            accounts = account.findAll();
        };
    }
}