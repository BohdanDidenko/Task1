package com.epam.task3.task3_3.controller;

import com.epam.task3.task3_3.model.Suit;
import com.epam.task3.task3_3.service.Service;
import com.epam.task3.task3_3.view.SuitView;

public class Controller {
    private SuitView view = new SuitView();
    private Service service = new Service(view);

    public void run(){
        selectAction();
    }

    private void selectAction() {
        while (true) {
            int choice = service.inputNumber(view.SELECT_AN_ACTION , view.getScanner());
            switch (choice) {
                case 1: {
                    service.resultHandler(Suit.values());
                    break;
                }
                case 2: {
                    service.resultHandler(Suit.valueOf(service.getEnumNameFromUser()));
                    break;
                }
                case 3: {
                    service.resultHandler(Suit.getEnumOrdinalByName(service.getEnumNameFromUser()));
                    break;
                }
                case 4: {
                    service.resultHandler(Suit.getEnumNameByOrdinal(service.getEnumOrdinalFromUser()));
                    break;
                }
                case 5: {
                    service.compareEnum();
                    break;
                }
                case 0: {
                    return;
                }
                default: {
                    view.printMessage(view.WRONG_INPUT);
                    view.getScanner().next();
                }
            }
        }
    }
}
