package com.epam.task9.controller;

import com.epam.task9.data.DataSource;

public class LoadController extends Controller {
    private MainMenuController mainMenuController = new MainMenuController();

    public void run(){
        loadMenu();
    }
    private enum LoadMenu {
        LOAD_TO_USER_FILE,
        DEFAULT_LOAD
    }

    protected void loadMenu() {
        while (true) {
            try {
                LoadMenu choice = getUserChoice(LoadMenu.values(), resourceManager.getString("LOAD_MENU"));
                view.getRequestFromUser().nextLine();
                switch (choice) {
                    case LOAD_TO_USER_FILE: {
                        view.showMessage(resourceManager.getString("LOAD_FILE"));
                        dao.setPath(view.getRequestFromUser().nextLine());
                        service.setShapes(dao.loadShapes());
//                        service.setShapes(DataSource.getShapes());
                        mainMenuController.mainMenu();
                        break;
                    }
                    case DEFAULT_LOAD: {
                        service.setShapes(dao.loadShapes());
                        mainMenuController.mainMenu();
                        break;
                    }
                }
            } catch (Exception e) {
                logger.info("Wrong input from user to load file");
                view.showMessage(resourceManager.getString("WRONG_INPUT"));
            }
        }
    }
}
