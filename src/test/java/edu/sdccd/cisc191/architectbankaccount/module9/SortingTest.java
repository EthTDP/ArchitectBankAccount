package edu.sdccd.cisc191.architectbankaccount.module9;

import edu.sdccd.cisc191.architectbankaccount.savingandsorting.SinglyLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class SortingTest {

    @Test
    void sortingTest() {
        Date firstDate = new Date();
        Date secondDate = new Date();
        Date thirdDate = new Date();
        Date[] equalList = new Date[] {firstDate, secondDate, thirdDate};
        Date[] list = new Date[] {secondDate, firstDate, thirdDate};

        SinglyLinkedList.mergeSort(list);

        for (int i = 0; i < 3; i++) {
            Assertions.assertEquals(equalList[i].getTime(), list[i].getTime());
        }

    }
}
