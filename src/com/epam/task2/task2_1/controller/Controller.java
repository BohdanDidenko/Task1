package com.epam.task2.task2_1.controller;

import com.epam.task2.task2_1.data.DataSource;
import com.epam.task2.task2_1.model.Books;
import com.epam.task2.task2_1.model.enity.Book;
import com.epam.task2.task2_1.view.BooksView;
import java.util.Scanner;

/**
 * Класс Controller интерпретирует действия пользователя,
 * оповещая модель о необходимости изменений
 */

public class Controller {

    /**
     * Поле предоставляющие доступ к данным и методам работы с ними
     */
    private Books model = new Books();

    /**
     * Поле предоставляющие доступ к данным отображаемым пользователю
     */
    private BooksView view = new BooksView();
    private Book[] result;
    private String searchQuery;

    /**
     * Главный метод класса Controller инициализирующий поле books[] принадлежащие модели,
     * и исполняющий метод selectAction, который отвечает за взаимодействие с пользователем
     */
    public void run(){
        model.setBooks(DataSource.getBooks());
        selectAction();
    }

    /**
     * Метод отвечает за взаимодействие с пользователем и предлагает ему
     * выполнить 1 из 9 операций, или закончить работу программы
     */
    private void selectAction() {
        int choice;

        while (true) {
            choice = inputNumber(view.getScannerForChoice());
            switch (choice) {
                case 1: {
                    searchByTitle();
                    break;
                }
                case 2: {
                    searchByAuthor();
                    break;
                }
                case 3: {
                    searchByPublisher();
                    break;
                }
                case 4: {
                    searchByPublishedBeforeSelectedYearInclusive();
                    break;
                }
                case 5: {
                    searchByPublishedLaterThanSelectedYear();
                    break;
                }
                case 6: {
                    model.sort(model.getComparatorByTitle());
                    view.printBooks("", model.getBooks());
                    break;
                }
                case 7: {
                    model.sort(model.getComparatorByAuthor());
                    view.printBooks("", model.getBooks());
                    break;
                }
                case 8: {
                    model.sort(model.getComparatorByPublisher());
                    view.printBooks("", model.getBooks());
                    break;
                }
                case 9: {
                    model.sort(model.getComparatorByYear());
                    view.printBooks("", model.getBooks());
                    break;
                }
                case 0: {
                    return;
                }
                default: {
                    view.printMessage(view.WRONG_INPUT);
                    view.getScannerForChoice().next();
                }
            }
        }
    }

    /**
     * Метод запрашивает у пользователя ввод положительного целого числа
     * от 1 до 9 - для исполнения выбранной операции
     * или 0 - для выхода из программы
     *
     * @param scannerForChoice - считывает данные введенные пользователем
     */
    private int inputNumber(Scanner scannerForChoice){
        while (true) {
            view.printMessage(view.SELECT_AN_ACTION);

            if (scannerForChoice.hasNextInt())
                return scannerForChoice.nextInt();
            else {
                view.printMessage(view.WRONG_INPUT);
                scannerForChoice.next();
            }
        }
    }

    private void searchByTitle(){
        view.printMessage(view.VALUE_TO_SEARCH);
        searchQuery = view.getScannerForSearchQuery().nextLine();
        result = model.getByTitle(searchQuery);
        resultHandler(searchQuery, result);
    }

    private void searchByAuthor(){
        view.printMessage(view.VALUE_TO_SEARCH);
        searchQuery = view.getScannerForSearchQuery().nextLine();
        result = model.getByAuthor(searchQuery);
        resultHandler(searchQuery, result);
    }

    private void searchByPublisher(){
        view.printMessage(view.VALUE_TO_SEARCH);
        searchQuery = view.getScannerForSearchQuery().nextLine();
        result = model.getByPublisher(searchQuery);
        resultHandler(searchQuery, result);
    }

    private void searchByPublishedBeforeSelectedYearInclusive(){
        while (true) {
            view.printMessage(view.VALUE_TO_SEARCH);
            searchQuery = view.getScannerForSearchQuery().nextLine();
            try {
                result = model.getPublishedBeforeSelectedYearInclusive
                        (Integer.parseInt(searchQuery));
                break;
            } catch (NumberFormatException e) {
                view.printMessage(view.WRONG_INPUT);
            }
        }
        resultHandler(searchQuery, result);
    }

    private void searchByPublishedLaterThanSelectedYear(){
        while (true){
            view.printMessage(view.VALUE_TO_SEARCH);
            searchQuery = view.getScannerForSearchQuery().nextLine();

            try {
                result = model.getPublishedLaterThanSelectedYear
                        (Integer.parseInt(searchQuery));
                break;
            }
            catch (NumberFormatException e) {
                view.printMessage(view.WRONG_INPUT);
            }
        }
        resultHandler(searchQuery, result);
    }

    /**
     * Метод обрабатывает результаты полученные от модели.
     * Если модель вернула результат по заросу пользователя, то он
     * при момощи отображения будет выведен на консоль.
     * Иначе, если результат отсутствует, то пользователь получает
     * соответствующие уведомление.
     *
     * @param searchQuery - запрос введенный пользователем
     * @param result - результат полученный от модели
     */
    private void resultHandler(String searchQuery, Book[] result) {
        if (result.length > 0)
            view.printBooks(searchQuery, result);
        else
            view.printMessage(view.NO_BOOKS + searchQuery);
    }
}