package com.epam.task3.task3_1.controller;

import com.epam.task3.task3_1.data.DataSource;
import com.epam.task3.task3_1.model.GameRoom;
import com.epam.task3.task3_1.model.entity.KidsToy;
import com.epam.task3.task3_1.service.GameRoomService;
import com.epam.task3.task3_1.service.Service;
import com.epam.task3.task3_1.view.ConsoleView;

import java.util.List;

public abstract class Controller {
    protected static ConsoleView view = new ConsoleView();
    protected static GameRoom<KidsToy> model = new GameRoom<KidsToy>(DataSource.getKidsToys());
    protected static Service service = new GameRoomService();

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

    protected <E>void resultHandler(List<E> result) {
        if (result.size() > 0)
            view.showList(result);
        else
            view.showMessage(view.NO_RESULT);
    }
}
