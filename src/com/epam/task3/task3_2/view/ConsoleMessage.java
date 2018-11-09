package com.epam.task3.task3_2.view;

public interface ConsoleMessage {
    /**
     * Константа с перечнем допустимых действий для выбора пользователем
     */
    String MAIN_MENU = "Select an action: " + "\n" +
            "1 - Get a current name of store, " + "\n" +
            "2 - Get a current list of departments, " + "\n" +
            "3 - Change store name, " + "\n" +
            "4 - Create a departments, " + "\n" +
            "5 - Delete department by name, " + "\n" +
            "6 - Delivery products in department, " + "\n" +
            "7 - Redistribution department by department name, " + "\n" +
            "8 - Redistribution department by type of products, " + "\n" +
            "9 - Redistribution department by suitService, " + "\n" +
            "10 - Exit";

    String ENTER_STORE_NAME = "Please enter a store name";
    String ENTER_DEPARTMENT_NAME = "Please enter a department name";
    String ENTER_TYPE_OF_PRODUCTS = "Please enter a type of products";
    String ENTER_SERVICE = "Please enter a suitService";
    String ENTER_LOCATION = "Please enter a location";
    String ENTER_DELIVERY_PRODUCTS = "Please enter a delivery products split space";
    String DEPARTMENT_NOT_EXISTS = "There is no department with that name.";
    String DEPARTMENT_EXISTS = "Department with that name already exists.";

    /**
     * Константа уведомляющая пользователя о том, что результат не найден
     */
    String NO_RESULT = "No results were found for your search";


    /**
     * Константа уведомляющая пользователя о некорректно введенных данных
     */
    String WRONG_INPUT = "Wrong input! Repeat please!";
}
