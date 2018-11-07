package com.epam.task2.task2_1.controller;

import com.epam.task2.task2_1.model.Book;
import com.epam.task2.task2_1.service.BooksService;
import com.epam.task2.task2_1.service.Service;
import com.epam.task2.task2_1.view.ConsoleView;

public abstract class Controller {
    protected static ConsoleView view = new ConsoleView();
    protected static Book model = new Book();
    protected static Service service = new BooksService();

    protected  <E, T>E getUserChoice(E[] elements, T message){
        while (true) {
            view.showMessage(message);
            if (view.getRequestFromUser().hasNextInt()) {
                return elements[view.getRequestFromUser().nextInt() - 1];
            }
            else {
                view.showMessage(view.WRONG_INPUT);
                view.getRequestFromUser().next();
            }
        }
    }

    protected <T>void resultHandler(T result) {
        if (result != null && !result.equals(""))
            view.showMessage(result);
        else
            view.showMessage(view.NO_RESULT);
    }

    protected <E>void resultHandler(E[] result) {
        if (result.length > 0)
            view.showArray(result);
        else
            view.showMessage(view.NO_RESULT);
    }
}
