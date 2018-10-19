package com.epam.task3.task3_3.view;

import com.epam.task3.task3_3.model.entity.MyEnum;
import java.util.Scanner;

public class SuitView {
    private Scanner scanner = new Scanner(System.in);

    public static final String SELECT_AN_ACTION = "Select an action: " + "\n" +
            "1 - Get current list of enum Suit" + "\n" +
            "2 - Get enum by name" + "\n" +
            "3 - Get enum ordinal by name" + "\n" +
            "4 - Get enum name by ordinal" + "\n" +
            "5 - Compare enum by name" + "\n" +
            "0 - Exit";
    public static final String ENTER_MYENUM_NAME = "Please enter a enum name";
    public static final String ENTER_MYENUM_ORDINAL = "Please enter a ordinal";

    public static final String WRONG_INPUT = "Wrong input! Repeat please!";
    public static final String NO_RESULT = "No results were found for your search";



    public Scanner getScanner() {
        return scanner;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public <E>void printArray(E[] array) {
        for (E element : array) {
            System.out.println(element);
        }
    }

    public <E extends MyEnum<E>>void printMyEnum(E message) {
        System.out.println(message);
    }
}
