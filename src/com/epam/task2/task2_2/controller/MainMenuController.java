package com.epam.task2.task2_2.controller;

import com.epam.task2.task2_2.data.DataSource;

/**
 * Класс MainMenuController интерпретирует действия пользователя,
 * оповещая модель о необходимости изменений
 */

public class MainMenuController extends Controller {
    /**
     * Главный метод класса MainMenuController инициализирующий поле shapes[] принадлежащие модели,
     * и исполняющий метод selectAction, который отвечает за взаимодействие с пользователем
     */
    public void run(){
        mainMenu();
    }

    private enum MainMenu{
        CALCULATE_TOTAL_AREA_OF_ALL_FIGURES,
        CALCULATE_TOTAL_AREA_OF_ALL_CIRCLES,
        CALCULATE_TOTAL_AREA_OF_ALL_TRIANGLES,
        CALCULATE_THE_TOTAL_AREA_OF_ALL_RECTANGLES,
        SORT_BY_INCREASING_AREA_OF_FIGURES,
        SORT_BY_COLOR_OF_FIGURES,
        EXIT,
    }

    protected void mainMenu() {
        while (true) {
            try {
                service.setShapes(dao.loadShapes());
                MainMenu choice = getUserChoice(MainMenu.values(), view.MAIN_MENU);
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
                    case EXIT: {
                        dao.saveShapes(service.getShapes());
                        return;
                    }
                }
            } catch (Exception e) {
                view.showMessage(view.WRONG_INPUT);
            }
        }
    }
}
