package com.epam.task3.task3_2.view;

import java.util.List;
import java.util.Scanner;

public class StoreView<T> {
    private Scanner scanner = new Scanner(System.in);

    public static final String SELECT_AN_ACTION = "Select an action: " + "\n" +
            "1 - Get a current name of store, " + "\n" +
            "2 - Get a current list of departments, " + "\n" +
            "3 - Change store name, " + "\n" +
            "4 - Create a departments, " + "\n" +
            "5 - Delete department by name, " + "\n" +
            "6 - Delivery products in department, " + "\n" +
            "7 - Redistribution department by department name, " + "\n" +
            "8 - Redistribution department by type of products, " + "\n" +
            "9 - Redistribution department by service, " + "\n" +
            "0 - Exit";

    public static final String WRONG_INPUT = "Wrong input! Repeat please!";

    public static final String NO_RESULT = "No results were found for your search";

    public static final String ENTER_STORE_NAME = "Please enter a store name";
    public static final String ENTER_DEPARTMENT_NAME = "Please enter a department name";
    public static final String ENTER_TYPE_OF_PRODUCTS = "Please enter a type of products";
    public static final String ENTER_SERVICE = "Please enter a service";
    public static final String ENTER_LOCATION = "Please enter a location";
    public static final String ENTER_DELIVERY_PRODUCTS = "Please enter a delivery products split space";
    public static final String DEPARTMENT_NOT_EXISTS = "There is no department with that name.";
    public static final String DEPARTMENT_EXISTS = "Department with that name already exists.";

    public Scanner getScanner() {
        return scanner;
    }

    public <T>void printList(List<T> list) {
        for (T element : list) {
            System.out.println(element);
        }
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}