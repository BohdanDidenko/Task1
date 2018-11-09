package com.epam.task3.task3_3.controller;

import com.epam.task3.task3_3.model.Suit;

public class MainMenuController extends Controller {

    public void run(){
        mainMenu();
    }

    private enum MainMenu {
        CURRENT_LIST_OF_ENUM,
        ENUM_BY_NAME,
        ENUM_ORDINAL_BY_NAME,
        ENUM_NAME_BY_ORDINAL,
        COMPARE_ENUM_BY_NAME,
        EXIT
    }

    protected void mainMenu() {
        while (true) {
            try {
                MainMenu choice = getUserChoice(MainMenu.values(), view.MAIN_MENU);
                view.getRequestFromUser().nextLine();
                switch (choice) {
                case CURRENT_LIST_OF_ENUM: {
                    resultHandler(Suit.values());
                    break;
                }
                case ENUM_BY_NAME: {
                    view.showMessage(view.ENTER_MYENUM_NAME);
                    resultHandler(Suit.valueOf(view.getRequestFromUser().nextLine()));
                    break;
                }
                case ENUM_ORDINAL_BY_NAME: {
                    view.showMessage(view.ENTER_MYENUM_NAME);
                    resultHandler(service.getEnumOrdinalByName(String.valueOf(view.getRequestFromUser().nextLine())));
                    break;
                }
                case ENUM_NAME_BY_ORDINAL: {
                    view.showMessage(view.ENTER_MYENUM_ORDINAL);
                    resultHandler(service.getEnumNameByOrdinal(view.getRequestFromUser().nextInt()));
                    break;
                }
                case COMPARE_ENUM_BY_NAME: {
                    view.showMessage(view.ENTER_MYENUM_NAME);
                    String firstName = view.getRequestFromUser().nextLine();
                    view.showMessage(view.ENTER_MYENUM_NAME);
                    String secondName = view.getRequestFromUser().nextLine();
                    resultHandler(service.compareEnum(firstName, secondName));
                    break;
                }
                    case EXIT: { return; }
                }
            }
            catch (Exception e){ view.showMessage(view.WRONG_INPUT); }
        }
    }
}