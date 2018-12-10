package com.epam.task11.task11_2.controller;

import com.epam.task11.task11_2.controller.strategy.ItemMenu;
import com.epam.task11.task11_2.controller.strategy.Strategy;
import com.epam.task11.task11_2.exception.UnExistItemMenu;
import com.epam.task11.task11_2.util.InputUtility;
import com.epam.task11.task11_2.util.ResourceManager;
import com.epam.task11.task11_2.view.ConsoleView;
import com.epam.task11.task11_2.view.View;
import org.apache.log4j.Logger;

import java.io.IOException;

public class Controller {
    protected static View view = new ConsoleView();
    protected static ResourceManager resourceManager = ResourceManager.INSTANCE;
    final static Logger logger = Logger.getLogger(Controller.class);

    public void run(){
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
                logger.info("Something went wrong ... =(");
                view.showErrorMessage(e.getMessage());
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
}
