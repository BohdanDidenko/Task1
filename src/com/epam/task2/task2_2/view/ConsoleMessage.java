package com.epam.task2.task2_2.view;

public interface ConsoleMessage {
    /**
     * Константа с перечнем допустимых действий для выбора пользователем
     */
    String MAIN_MENU = "Select an action: " + "\n" +
            "1 - Calculate the total area of all figures, " + "\n" +
            "2 - Calculate the total area of all circles, " + "\n" +
            "3 - Calculate the total area of all triangles, " + "\n" +
            "4 - Calculate the total area of all rectangles, " + "\n" +
            "5 - Sort by increasing the area of figures, " + "\n" +
            "6 - Sort by color of figures, " + "\n" +
            "7 - exit";

    /**
     * Константа уведомляющая пользователя о том, что результат не найден
     */
    String NO_RESULT = "No results were found for your search";

    /**
     * Константа уведомляющая пользователя о некорректно введенных данных
     */
    String WRONG_INPUT = "Wrong input! Repeat please!";
}
