package com.epam.task9.controller;

/**
 * Класс MainMenuController интерпретирует действия пользователя,
 * оповещая модель о необходимости изменений
 */

public class MainMenuController extends Controller {
    private SaveController saveController = new SaveController();
    private ChangeLanguageController changeLanguageController = new ChangeLanguageController();

    /**
     * Главный метод класса MainMenuController инициализирующий поле shapes[] принадлежащие модели,
     * и исполняющий метод selectAction, который отвечает за взаимодействие с пользователем
     */
    private enum MainMenu{
        CALCULATE_TOTAL_AREA_OF_ALL_FIGURES,
        CALCULATE_TOTAL_AREA_OF_ALL_CIRCLES,
        CALCULATE_TOTAL_AREA_OF_ALL_TRIANGLES,
        CALCULATE_THE_TOTAL_AREA_OF_ALL_RECTANGLES,
        SORT_BY_INCREASING_AREA_OF_FIGURES,
        SORT_BY_COLOR_OF_FIGURES,
        CHANGE_LANGUAGE,
        SAVE_AND_EXIT,
    }

    protected void mainMenu() {
        while (true) {
            try {
                MainMenu choice = getUserChoice(MainMenu.values(), view.MAIN_MENU);
                view.getRequestFromUser().nextLine();
                switch (choice) {
                    case CALCULATE_TOTAL_AREA_OF_ALL_FIGURES: {
                        view.showMessage(String.valueOf(service.calculateTotalArea()));
                        break;
                    }
                    case CALCULATE_TOTAL_AREA_OF_ALL_CIRCLES: {
                        view.showMessage(service.calculateTotalArea(modelCircle.getClass()));
                        break;
                    }
                    case CALCULATE_TOTAL_AREA_OF_ALL_TRIANGLES: {
                        view.showMessage(service.calculateTotalArea(modelTriangle.getClass()));
                        break;
                    }
                    case CALCULATE_THE_TOTAL_AREA_OF_ALL_RECTANGLES: {
                        view.showMessage(service.calculateTotalArea(modelRectangle.getClass()));
                        break;
                    }
                    case SORT_BY_INCREASING_AREA_OF_FIGURES: {
                        service.sortByIncreasingAreaOfFigures();
                        view.showArray(service.getShapes());
                        break;
                    }
                    case SORT_BY_COLOR_OF_FIGURES: {
                        service.sortByColorOfFigures();
                        view.showArray(service.getShapes());
                        break;
                    }
                    case CHANGE_LANGUAGE: {
                        changeLanguageController.changeLanguage();
                        break;
                    }
                    case SAVE_AND_EXIT: {
                        saveController.saveMenu();
                        break;
                    }
                }
            } catch (Exception e) {
                logger.info("Wrong input from user");
                view.showMessage(resourceManager.getString("WRONG_INPUT"));
            }
        }
    }
}
