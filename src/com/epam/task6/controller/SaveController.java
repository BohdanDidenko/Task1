package com.epam.task6.controller;

import java.io.IOException;

public class SaveController extends Controller{

    private enum SaveMenu {
        SAVE_TO_USER_FILE,
        DEFAULT_SAVE
    }

    protected void saveMenu() throws IOException {
        while (true) {
            SaveMenu choice = getUserChoice(SaveMenu.values(), view.SAVE_MENU);
            view.getRequestFromUser().nextLine();
            switch (choice) {
                case SAVE_TO_USER_FILE: {
                    view.showMessage(view.SAVE_FILE);
                    dao.setPath(view.getRequestFromUser().nextLine());
                    dao.saveShapes(service.getShapes());
                    break;
                }
                case DEFAULT_SAVE: {
                    dao.saveShapes(service.getShapes());
                    System.exit(0);
                }
            }
        }
    }
}