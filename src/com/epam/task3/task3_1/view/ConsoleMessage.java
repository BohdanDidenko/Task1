package com.epam.task3.task3_1.view;

public interface ConsoleMessage {
    /**
     * Константа с перечнем допустимых действий для выбора пользователем
     */
    String MAIN_MENU = "Select an action: " + "\n" +
            "1 - Print the current list of toys, " + "\n" +
            "2 - Calculate the total value all kids toys, " + "\n" +
            "3 - Get a list of kids toys search by specified criteria, " + "\n" +
            "4 - Sort kids toys by title, " + "\n" +
            "5 - Sort kids toys by manufacturer, " + "\n" +
            "6 - Sort kids toys by material, " + "\n" +
            "7 - Sort kids toys by price, " + "\n" +
            "8 - Sort kids toys by warrantyDays, " + "\n" +
            "9 - Exit";

    String SELECT_SEARCH_CRITERIA = "Select search criteria: " + "\n" +
            "1 - Search by title, " + "\n" +
            "2 - Search by manufacturer, " + "\n" +
            "3 - Search by material, " + "\n" +
            "4 - Search by price, " + "\n" +
            "5 - Search by min count warranty days, " + "\n" +
            "6 - Search by max packing width, " + "\n" +
            "7 - Search by max packing height, " + "\n" +
            "8 - Search by age group, " + "\n" +
            "9 - Print the result and exit";

    /**
     * Константы запрашивающая у пользователя данные для поиска
     */
    String SEARCH_BY_TITLE = "Please enter a title to search";
    String SEARCH_BY_MANUFACTURER = "Please enter a manufacturer to search";
    String SEARCH_BY_MATERIAL = "Please enter a material to search";
    String SEARCH_BY_PRICE = "Please enter a max price to search";
    String SEARCH_BY_WARRANTY_DAYS = "Please enter a min count warranty days to search";
    String SEARCH_BY_PACKING_WIDTH = "Please enter a max packing width to search";
    String SEARCH_BY_PACKING_HEIGHT = "Please enter a max packing height to search";
    String SEARCH_BY_AGE_GROUP = "Please enter a age group to search";


    /**
     * Константа уведомляющая пользователя о том, что результат не найден
     */
    String NO_RESULT = "No results were found for your search";

    /**
     * Константа уведомляющая пользователя о некорректно введенных данных
     */
    String WRONG_INPUT = "Wrong input! Repeat please!";
}
