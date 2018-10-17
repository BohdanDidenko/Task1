package com.epam.task3.task3_1.view;

import java.util.List;
import java.util.Scanner;

public class ToysView {
    private Scanner scanner = new Scanner(System.in);

    public static final String SELECT_AN_ACTION = "Select an action: " + "\n" +
            "1 - Print the current list of toys, " + "\n" +
            "2 - Calculate the total value all kids toys, " + "\n" +
            "3 - Get a list of kids toys search by specified criteria, " + "\n" +
            "4 - Sort kids toys by title, " + "\n" +
            "5 - Sort kids toys by manufacturer, " + "\n" +
            "6 - Sort kids toys by material, " + "\n" +
            "7 - Sort kids toys by price, " + "\n" +
            "8 - Sort kids toys by warrantyDays, " + "\n" +
            "0 - Exit";

    public static final String WRONG_INPUT = "Wrong input! Repeat please!";

    public static final String NO_RESULT = "No results were found for your search";

    public static final String SELECT_SEARCH_CRITERIA = "Select search criteria: " + "\n" +
            "1 - Search by title, " + "\n" +
            "2 - Search by manufacturer, " + "\n" +
            "3 - Search by material, " + "\n" +
            "4 - Search by price, " + "\n" +
            "5 - Search by min count warranty days, " + "\n" +
            "6 - Search by max packing width, " + "\n" +
            "7 - Search by max packing height, " + "\n" +
            "8 - Search by age group, " + "\n" +
            "0 - Print the result and exit";

    /**
     * Константы запрашивающая у пользователя данные для поиска
     */
    public static final String SEARCH_BY_TITLE = "Please enter a title to search";
    public static final String SEARCH_BY_MANUFACTURER = "Please enter a manufacturer to search";
    public static final String SEARCH_BY_MATERIAL = "Please enter a material to search";
    public static final String SEARCH_BY_PRICE = "Please enter a max price to search";
    public static final String SEARCH_BY_WARRANTY_DAYS = "Please enter a min count warranty days to search";
    public static final String SEARCH_BY_PACKING_WIDTH = "Please enter a max packing width to search";
    public static final String SEARCH_BY_PACKING_HEIGHT = "Please enter a max packing height to search";
    public static final String SEARCH_BY_AGE_GROUP = "Please enter a age group to search";

    public Scanner getScanner() {
        return scanner;
    }

    public <E>void printList(List<E> list) {
        for (E element : list) {
            System.out.println(element);
        }
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}