package com.epam.project2.controller;

import com.epam.project2.model.Word;
import com.epam.project2.service.FileService;
import com.epam.project2.service.Service;
import com.epam.project2.view.ConsoleView;
import java.util.List;

public abstract class Controller {
    protected static ConsoleView view = new ConsoleView();
    protected static Service service = new FileService();


    protected  <E, T>E getUserChoice(E[] elements, T message){
        while (true) {
            view.showMessage(message);
            if (view.getRequestFromUser().hasNextInt())
                return elements[view.getRequestFromUser().nextInt()-1];
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

    protected <E>void resultHandler(List<E> result) {
        if (result.size() > 0)
            view.showList(result);
        else
            view.showMessage(view.NO_RESULT);
    }
}