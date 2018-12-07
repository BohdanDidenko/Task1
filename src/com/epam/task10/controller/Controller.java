package com.epam.task10.controller;

import com.epam.task10.controller.strategy.ItemMenu;
import com.epam.task10.controller.strategy.Strategy;
import com.epam.task10.exception.UnExistItemMenu;
import com.epam.task10.service.Service;
import com.epam.task10.service.ShapesService;
import com.epam.task10.util.InputUtility;
import com.epam.task10.util.ResourceManager;
import com.epam.task10.view.ConsoleView;
import com.epam.task10.view.View;
import org.apache.log4j.Logger;

import java.io.IOException;

public class Controller {
    protected static View view = new ConsoleView();
    protected static Service service = new ShapesService();
    protected static ResourceManager resourceManager = ResourceManager.INSTANCE;
    final static Logger logger = Logger.getLogger(Controller.class);

    public void run(){
        init();

        while (true){
            try {
                view.showMessage(resourceManager.getMessage("MAIN_MENU"));
                int number = InputUtility.inputInt(view, resourceManager);
                Strategy command = defineCommand(number);
                view.showMessage(command.execute());
            }
            catch (UnExistItemMenu e){
                logger.info("Wrong input from user");
                view.showErrorMessage(e.getMessage());
            }
            catch (IOException e){

            }
        }
    }

    private Strategy defineCommand(int number) throws UnExistItemMenu {
        ItemMenu[] itemMenus = ItemMenu.values();
        if (number < 0 || number >= itemMenus.length) {
            throw new UnExistItemMenu(resourceManager.getMessage("WRONG_INPUT"));
        }
        return itemMenus[number].getCommand();
    }

    private void init(){
        try { service.loadShapes(); }
        catch (IOException | ClassNotFoundException e) {
            logger.error("Error read");
        }
    }
}
