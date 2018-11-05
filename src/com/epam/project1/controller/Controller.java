package com.epam.project1.controller;

import com.epam.project1.model.KnightModel;
import com.epam.project1.view.ConsoleView;
import java.util.List;

public class Controller {
    protected static KnightModel model = new KnightModel();
    protected static ConsoleView view = new ConsoleView();

    public void run(){
        new MainMenuController().mainMenu();
    }

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
