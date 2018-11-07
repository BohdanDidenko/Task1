package com.epam.project1.controller;

import com.epam.project1.dao.Dao;
import com.epam.project1.dao.KnightDao;
import com.epam.project1.model.warrior.Knight;
import com.epam.project1.service.KnightService;
import com.epam.project1.service.Service;
import com.epam.project1.view.ConsoleView;
import java.util.List;

public abstract class Controller {
    protected static ConsoleView view = new ConsoleView();
    protected static Knight model;
    protected static Service service = new KnightService();
    protected static Dao dao = new KnightDao();

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