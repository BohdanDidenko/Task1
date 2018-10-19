package com.epam.task3.task3_1.controller;

import com.epam.task3.task3_1.data.DataSource;
import com.epam.task3.task3_1.model.GameRoom;
import com.epam.task3.task3_1.model.entity.KidsToy;
import com.epam.task3.task3_1.view.ToysView;
import com.epam.task3.task3_1.service.Service;

public class Controller {
    private GameRoom<KidsToy> model = new GameRoom<>();
    private ToysView view = new ToysView();
    private Service service = new Service(model, view);

    public void run(){
        model.setKidsToys(DataSource.getKidsToys());
        selectAction();
    }

    private void selectAction() {
        while (true) {
            int choice = service.inputNumber(view.SELECT_AN_ACTION , view.getScanner());
            switch (choice) {
                case 1: {
                    service.resultHandler(model.getKidsToys());
                    break;
                }
                case 2: {
                   service.resultHandler(model.calculateTotalValueAllKidsToy());
                    break;
                }
                case 3: {
                    service.resultHandler(service.searchBySpecifiedCriteria(model.getKidsToys()));
                    break;
                }
                case 4: {
                    service.sortByTitle(model.getKidsToys());
                    service.resultHandler(model.getKidsToys());
                    break;
                }
                case 5: {
                    service.sortByManufacturer(model.getKidsToys());
                    service.resultHandler(model.getKidsToys());
                    break;
                }
                case 6: {
                    service.sortByMaterial(model.getKidsToys());
                    service.resultHandler(model.getKidsToys());
                    break;
                }
                case 7: {
                    service.sortByPrice(model.getKidsToys());
                    service.resultHandler(model.getKidsToys());
                    break;
                }
                case 8: {
                    service.sortByWarrantyDays(model.getKidsToys());
                    service.resultHandler(model.getKidsToys());
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