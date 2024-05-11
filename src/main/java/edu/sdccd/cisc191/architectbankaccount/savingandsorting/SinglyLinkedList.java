package edu.sdccd.cisc191.architectbankaccount.savingandsorting;


import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class SinglyLinkedList {

    Node<Date> head = null; // head of list

    /* Linked list Node*/
    static class Node<T> {
        T date;
        Node<T> next;

        Node(T d) {
            date = d;
            next = null;
        }
    }

    public static void insert(SinglyLinkedList list, Date data) {
        Node<Date> new_node = new Node<>(data);

        if(list.head == null) {
            list.head = new_node;
        } else {
            Node<Date> last = list.head;
            while(last.next != null) {
                last = last.next;
            }

            last.next = new_node;
        }
    }

    private ArrayList<Date> linkedListToArrayList(SinglyLinkedList list) {
        ArrayList<Date> arrayList = new ArrayList<>();

        Node<Date> currNode = list.head;

        while (currNode != null) {
            // Print the data at current node
            arrayList.add(currNode.date);

            // Go to next node
            currNode = currNode.next;
        }

        return arrayList;
    }

    private Date[] arrayListToArray(ArrayList<Date> list) {
        Date[] dates = new Date[list.size()];
        dates = list.toArray(dates);

        return dates;
    }

    public static void mergeSort(Date[] list) {
        if (list.length > 1) {
            // Merge sort the first half
            Date[] firstHalf = new Date[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);

            // Merge sort the second half
            int secondHalfLength = list.length - list.length / 2;
            Date[] secondHalf = new Date[secondHalfLength];
            System.arraycopy(list, list.length / 2,
                    secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);

            // Merge firstHalf with secondHalf into list
            merge(firstHalf, secondHalf, list);
        }
    }

    private static void merge(Date[] list1, Date[] list2, Date[] temp) {
        int current1 = 0;
        int current2 = 0;
        int current3 = 0;

        while(current1 < list1.length && current2 < list2.length) {
            if(list1[current1].compareTo(list2[current2]) >= 0) {
                temp[current3++] = list1[current1++];
            } else {
                temp[current3++] = list2[current2++];
            }
        }

        while(current1 < list1.length)
            temp[current3++] = list1[current1++];
        while(current2 < list2.length)
            temp[current3++] = list2[current2++];
    }

    public static void printList(SinglyLinkedList list) {
        Node<Date> currNode = list.head;

        System.out.print("Unsorted LinkedList: \n");

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.date + "\n");

            // Go to next node
            currNode = currNode.next;
        }
    }

    public static void printSortedList(SinglyLinkedList list, TextArea text, double number, int offset, String type) {
        ArrayList<Date> dates = list.linkedListToArrayList(list);
        Date[] dateArray = list.arrayListToArray(dates);
        list.mergeSort(dateArray);

        System.out.println("Sorted List");

        // HashSet to store dates already printed
        HashSet<String> printedDates = new HashSet<>();

        // Print the transactions, starting from the last date
        for (int i = dateArray.length - 1; i >= 0; i--) {
            String currentDate = dateArray[i].toString();
            if (!printedDates.contains(currentDate) && i != offset) {
                // If the date is not already printed and not the offset date, append it
                text.appendText(currentDate + ": Transaction for " + type + " $" + String.format("%.2f", number) + " from your account.\n");
                printedDates.add(currentDate); // Add the printed date to HashSet
            }
        }
    }
}
