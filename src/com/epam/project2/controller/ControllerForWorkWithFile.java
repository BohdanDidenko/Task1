package com.epam.project2.controller;

public class ControllerForWorkWithFile extends Controller {

    public void run(){
        view.showMessage(view.START);
        while (true) {
            try {
                view.showMessage(view.FILE_NAME);
                service.readAllWordInFile(view.getRequestFromUser().nextLine());
//                service.readAllWordInFile("src\\com\\epam\\project2\\resources\\Read.txt");
//                service.readAllWordInFile("src\\com\\epam\\project2\\resources\\Read.pdf");
                view.showMessage(view.READING);
                mainMenu();
            } catch (Exception e) {
                view.showMessage(view.EXCEPTION);
            }
        }
    }

    private enum MainMenu{
        SELECT_ANOTHER_FILE,
        SORT_WORDS_BY_COUNT_VOWEL,
        EXIT
    }

    protected void mainMenu() {
        while (true) {
            try {
                MainMenu choice = getUserChoice(MainMenu.values(), view.MAIN_MENU);
                switch (choice) {
                    case SELECT_ANOTHER_FILE: {
                        view.showMessage(view.FILE_NAME);
                        service.readAllWordInFile(view.getRequestFromUser().nextLine());
                        break;
                    }
                    case SORT_WORDS_BY_COUNT_VOWEL: {
                        service.sortTextWordsByAscendingVowelCount();
                        view.showArray(service.getWordsFromFile());
                        break;
                    }
                    case EXIT: { System.exit(0); }
                }
            }
            catch (Exception e){ view.showMessage(view.WRONG_INPUT); }
        }
    }
}