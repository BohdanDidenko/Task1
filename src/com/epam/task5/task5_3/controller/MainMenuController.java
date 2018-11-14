package com.epam.task5.task5_3.controller;

import java.io.IOException;

public class MainMenuController extends Controller{
    public void run(){
        try {
            model = dao.loadVocabulary();
            mainMenu();
        } catch (IOException | ClassNotFoundException e) {
            view.showMessage(view.EXCEPTION);
        }
    }

    private enum MainMenu{
        TRANSLATE_SENTENCE,
        ADD_NEW_WORD_TO_THE_VOCABULARY,
        EXIT
    }

    protected void mainMenu() {
        while (true) {
            try {
                MainMenu choice = getUserChoice(MainMenu.values(), view.MAIN_MENU);
                view.getRequestFromUser().nextLine();
                switch (choice) {
                    case TRANSLATE_SENTENCE: {
                        view.showMessage(view.SENTENCE_IN_ENGLISH);
                        String line = view.getRequestFromUser().nextLine();
                        resultHandler(service.translateSentence(model, line));
                        break;
                    }
                    case ADD_NEW_WORD_TO_THE_VOCABULARY: {
                        view.showMessage(view.WORD_IN_ENGLISH);
                        String wordInEnglish = view.getRequestFromUser().nextLine();
                        view.showMessage(view.WORD_IN_RUSSIAN);
                        String wordInRussian = view.getRequestFromUser().nextLine();
                        service.addNewWordToVocabulary(model, wordInEnglish, wordInRussian);
                        resultHandler(model.getVocabulary());
                        break;
                    }
                    case EXIT: {
                        dao.saveVocabulary(model);
                        return;
                    }
                }
            }
            catch (Exception e){ view.showMessage(view.WRONG_INPUT); }
        }
    }
}