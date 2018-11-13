package com.epam.task6.controller;

public class LoadController extends Controller{
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
                LoadMenu choice = getUserChoice(LoadMenu.values(), view.LOAD_MENU);
                view.getRequestFromUser().nextLine();
                switch (choice) {
                    case LOAD_TO_USER_FILE: {
                        view.showMessage(view.LOAD_FILE);
                        dao.setPath(view.getRequestFromUser().nextLine());
                        service.setShapes(dao.loadShapes());
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
                view.showMessage(view.WRONG_INPUT);
            }
        }
    }
}
