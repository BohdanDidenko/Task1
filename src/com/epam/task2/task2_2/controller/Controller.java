package com.epam.task2.task2_2.controller;

import com.epam.task2.task2_2.model.Circle;
import com.epam.task2.task2_2.model.Rectangle;
import com.epam.task2.task2_2.model.Triangle;
import com.epam.task2.task2_2.service.Service;
import com.epam.task2.task2_2.service.ShapesService;
import com.epam.task2.task2_2.view.ConsoleView;

public abstract class Controller {
    protected static ConsoleView view = new ConsoleView();
    protected static Service service = new ShapesService();
    protected static Circle modelCircle = new Circle();
    protected static Triangle modelTriangle = new Triangle();
    protected static Rectangle modelRectangle= new Rectangle();

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
