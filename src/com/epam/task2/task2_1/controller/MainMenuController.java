package com.epam.task2.task2_1.controller;

import com.epam.task2.task2_1.data.DataSource;

/**
 * Класс MainMenuController интерпретирует действия пользователя,
 * оповещая модель о необходимости изменений
 */
public class MainMenuController extends Controller{
    public void run(){
        service.setBooks(DataSource.getBooks());
        mainMenu();
    }

    private enum MainMenu{
        LIST_BOOKS_BY_TITLE,
        LIST_BOOKS_BY_AUTHOR,
        LIST_BOOKS_BY_PUBLISHER,
        LIST_BOOKS_PUBLISHED_BEFORE_SELECTED_YEAR_INCLUSIVE,
        LIST_BOOKS_PUBLISHED_LATER_THAN_SELECTED_YEAR,
        SORT_BOOKS_BY_TITLE,
        SORT_BOOKS_BY_AUTHOR,
        SORT_BOOKS_BY_PUBLISHERS,
        SORT_BOOKS_BY_YEAR,
        EXIT
    }

    protected void mainMenu() {
        while (true) {
            try {
                MainMenu choice = getUserChoice(MainMenu.values(), view.MAIN_MENU);
                view.getRequestFromUser().nextLine();
                switch (choice) {
                    case LIST_BOOKS_BY_TITLE: {
                        view.showMessage(view.VALUE_TO_SEARCH);
                        resultHandler(service.getBooksByTitle(view.getRequestFromUser().nextLine()));
                        break;
                    }
                    case LIST_BOOKS_BY_AUTHOR: {
                        view.showMessage(view.VALUE_TO_SEARCH);
                        resultHandler(service.getBooksByAuthor(view.getRequestFromUser().nextLine()));
                        break;
                    }
                    case LIST_BOOKS_BY_PUBLISHER: {
                        view.showMessage(view.VALUE_TO_SEARCH);
                        resultHandler(service.getBooksByPublisher(view.getRequestFromUser().nextLine()));
                        break;
                    }
                    case LIST_BOOKS_PUBLISHED_BEFORE_SELECTED_YEAR_INCLUSIVE: {
                        view.showMessage(view.VALUE_TO_SEARCH);
                        resultHandler(service.getBooksPublishedBeforeSelectedYearInclusive(
                                Integer.parseInt(view.getRequestFromUser().nextLine())));
                        break;
                    }
                    case LIST_BOOKS_PUBLISHED_LATER_THAN_SELECTED_YEAR: {
                        view.showMessage(view.VALUE_TO_SEARCH);
                        resultHandler(service.getBooksPublishedLaterThanSelectedYear(
                                Integer.parseInt(view.getRequestFromUser().nextLine())));
                        break;
                    }
                    case SORT_BOOKS_BY_TITLE: {
                        service.sortByTitle();
                        view.showArray(service.getBooks());
                        break;
                    }
                    case SORT_BOOKS_BY_AUTHOR: {
                        service.sortByAuthor();
                        view.showArray(service.getBooks());
                        break;
                    }
                    case SORT_BOOKS_BY_PUBLISHERS: {
                        service.sortByPublisher();
                        view.showArray(service.getBooks());
                        break;
                    }
                    case SORT_BOOKS_BY_YEAR: {
                        service.sortByYear();
                        view.showArray(service.getBooks());
                        break;
                    }
                    case EXIT: {
                        return;
                    }
                }
            } catch (Exception e) {
                view.showMessage(view.WRONG_INPUT);
            }
        }
    }
}