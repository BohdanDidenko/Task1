package com.epam.task2.task2_1.view;

public interface ConsoleMessage {
    /**
     * Константа с перечнем допустимых действий для выбора пользователем
     */
    String MAIN_MENU = "Select an action: " + "\n" +
            "1 - Get a list of books by title, " + "\n" +
            "2 - Get a list of books by author, " + "\n" +
            "3 - Get a list of books by publisher, " + "\n" +
            "4 - Get a list of books published before the selected year inclusive, " + "\n" +
            "5 - Get a list of books published later than the selected year, " + "\n" +
            "6 - Sort books by title, " + "\n" +
            "7 - Sort books by author, " + "\n" +
            "8 - Sort books by publishers, " + "\n" +
            "9 - Sort books by year, " + "\n" +
            "10 - exit";

    /**
     * Константа запрашивающая у пользователя данные для поиска
     */
    String VALUE_TO_SEARCH = "Please enter a value to search";

    /**
     * Константа уведомляющая пользователя о том, что результат не найден
     */
    String NO_RESULT = "No results were found for your search";

    /**
     * Константа уведомляющая пользователя о некорректно введенных данных
     */
    String WRONG_INPUT = "Wrong input! Repeat please!";
}
