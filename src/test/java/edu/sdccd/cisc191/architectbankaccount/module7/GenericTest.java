package edu.sdccd.cisc191.architectbankaccount.module7;

import edu.sdccd.cisc191.architectbankaccount.BankAccount;
import edu.sdccd.cisc191.architectbankaccount.database.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GenericTest {

    @Test
    void genericTest() {
        Account account = new Account(1, "Ethan", "Nguyen", 10.00);
        try {
            BankAccount.initAccount();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        Assertions.assertEquals(account, BankAccount.accounts.get(0));
    }
}
