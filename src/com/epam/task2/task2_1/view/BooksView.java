package com.epam.task2.task2_1.view;

import com.epam.task2.task2_1.model.enity.Book;

/**
 * Класс BooksView отвечает за отображение данных модели пользователю,
 * реагируя на изменения модели
 */

public class BooksView {

    /**
     * Константа с перечнем допустимых действий для выбора пользователем
     */
    public static final String SELECT_AN_ACTION = "Select an action: " + "\n" +
            "1 - Get a list of books by title, " + "\n" +
            "2 - Get a list of books by author, " + "\n" +
            "3 - Get a list of books by publisher, " + "\n" +
            "4 - Get a list of books published before the selected year inclusive, " + "\n" +
            "5 - Get a list of books published later than the selected year, " + "\n" +
            "6 - Sort books by title, " + "\n" +
            "7 - Sort books by author, " + "\n" +
            "8 - Sort books by publishers, " + "\n" +
            "9 - Sort books by year, " + "\n" +
            "0 - exit";

    /**
     * Константа уведомляющая пользователя о некорректно введенных данных
     */
    public static final String WRONG_INPUT = "Wrong input! Repeat please!";

    /**
     * Константа запрашивающая у пользователя данные для поиска
     */
    public static final String VALUE_TO_SEARCH = "Please enter a value to search";

    /**
     * Константа уведомляющая пользователя о том, что результат не найден
     */
    public static final String NO_BOOKS = "No result found for - ";

    /**
     * Метод отображает в консоль пользователю сообщение и
     * массив полученных книг
     *
     * @param message - текст сообщения
     * @param books - массив книг
     */
    public void printBooks(String message, Book[] books) {
        System.out.println(message);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    /**
     * Метод отображает в консоль пользователю полученное сообщение
     *
     * @param message - полученное сообщение
     */
    public void printMessage(String message) {
        System.out.println(message);
    }
}
