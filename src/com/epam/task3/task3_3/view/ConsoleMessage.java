package com.epam.task3.task3_3.view;

public interface ConsoleMessage {
    /**
     * Константа с перечнем допустимых действий для выбора пользователем
     */
    String MAIN_MENU = "Select an action: " + "\n" +
            "1 - Get current list of enum Suit" + "\n" +
            "2 - Get enum by name" + "\n" +
            "3 - Get enum ordinal by name" + "\n" +
            "4 - Get enum name by ordinal" + "\n" +
            "5 - Compare enum by name" + "\n" +
            "6 - Exit";

    String ENTER_MYENUM_NAME = "Please enter a enum name";
    String ENTER_MYENUM_ORDINAL = "Please enter a ordinal";

    /**
     * Константа уведомляющая пользователя о том, что результат не найден
     */
    String NO_RESULT = "No results were found for your search";


    /**
     * Константа уведомляющая пользователя о некорректно введенных данных
     */
    String WRONG_INPUT = "Wrong input! Repeat please!";
}
