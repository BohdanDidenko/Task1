package com.epam.task9.controller;

import java.util.Locale;

public class ChangeLanguageController extends Controller {
    private MainMenuController mainMenuController = new MainMenuController();

    private enum ChangeLanguageMenu{
        ENGLISH,
        RUSSIAN,
        UKRAINE
    }

    public void changeLanguage(){
        ChangeLanguageMenu choice = getUserChoice(ChangeLanguageMenu.values(), resourceManager.getString("LANGUAGE_MENU"));
        view.getRequestFromUser().nextLine();
        switch (choice) {
            case ENGLISH: {
                resourceManager.changeResource(Locale.ENGLISH);
                mainMenuController.mainMenu();
            }
            case RUSSIAN:{
                resourceManager.changeResource(new Locale("ru", "RU"));
                mainMenuController.mainMenu();
            }
            case UKRAINE: {
                resourceManager.changeResource(new Locale("uk", "UA"));
                mainMenuController.mainMenu();
            }
            default: mainMenuController.mainMenu();
        }
    }
}
