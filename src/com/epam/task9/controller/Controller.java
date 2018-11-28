package com.epam.task9.controller;

import com.epam.task9.dao.Dao;
import com.epam.task9.dao.ShapesDao;
import com.epam.task9.model.Circle;
import com.epam.task9.model.Rectangle;
import com.epam.task9.model.Triangle;
import com.epam.task9.service.Service;
import com.epam.task9.service.ShapesService;
import com.epam.task9.util.ResourceManager;
import com.epam.task9.view.ConsoleView;
import org.apache.log4j.Logger;

public abstract class Controller {
    protected static ConsoleView view = new ConsoleView();
    protected static Service service = new ShapesService();
    protected static Circle modelCircle = new Circle();
    protected static Triangle modelTriangle = new Triangle();
    protected static Rectangle modelRectangle= new Rectangle();
    protected static Dao dao = new ShapesDao();
    protected static ResourceManager resourceManager = ResourceManager.INSTANCE;
    final static Logger logger = org.apache.log4j.Logger.getLogger(Controller.class);

    protected  <E, T>E getUserChoice(E[] elements, T message){
        while (true) {
            view.showMessage(message);
            if (view.getRequestFromUser().hasNextInt()) {
                return elements[view.getRequestFromUser().nextInt() - 1];
            }
            else {
                logger.info("Wrong input from user in select menu");
                view.showMessage(resourceManager.getString("WRONG_INPUT"));
                view.getRequestFromUser().next();
            }
        }
    }

    protected <T>void resultHandler(T result) {
        if (result != null && !result.equals(""))
            view.showMessage(result);
        else
            view.showMessage(resourceManager.getString("NO_RESULT"));
    }

    protected <E>void resultHandler(E[] result) {
        if (result.length > 0)
            view.showArray(result);
        else
            view.showMessage(resourceManager.getString("NO_RESULT"));
    }
}
