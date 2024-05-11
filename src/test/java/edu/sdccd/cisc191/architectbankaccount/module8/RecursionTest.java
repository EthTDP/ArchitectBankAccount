package edu.sdccd.cisc191.architectbankaccount.module8;

import edu.sdccd.cisc191.architectbankaccount.screen.bank.BankScreen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Formatter;

public class RecursionTest {

    @Test
    void recursionTest() {
        double amount = BankScreen.compoundInterest(10, .05, 10, 1);
        Assertions.assertEquals("16.29", String.format("%.2f", amount));
    }
}
