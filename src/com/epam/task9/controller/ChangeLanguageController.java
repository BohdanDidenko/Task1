package com.epam.task9.controller;

import java.util.Locale;

public class ChangeLanguageController extends Controller {
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
                resourceManager.changeResource(new Locale("en", "GB"));
                return;
            }
            case RUSSIAN:{
                resourceManager.changeResource(new Locale("ru", "RU"));
                return;
            }
            case UKRAINE: {
                resourceManager.changeResource(new Locale("uk", "UA"));
                return;
            }
            default: return;
        }
    }
}