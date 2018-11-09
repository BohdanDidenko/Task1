package com.epam.task3.task3_3.controller;

import com.epam.task3.task3_3.view.ConsoleView;
import com.epam.task3.task3_3.service.SuitService;

import java.util.Arrays;
import java.util.List;

public abstract class Controller {
    protected static ConsoleView view = new ConsoleView();
    protected static SuitService service = new SuitService();

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

    protected <T>void resultHandler(T[] result) {
        if (result != null && result.length > 0)
            view.showMessage(Arrays.toString(result));
        else
            view.showMessage(view.NO_RESULT);
    }

    protected <E>void resultHandler(List<E> result) {
        if (result.size() > 0)
            view.showList(result);
        else
            view.showMessage(view.NO_RESULT);
    }
}
