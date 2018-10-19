package com.epam.task3.task3_2.controller;

import com.epam.task3.task3_2.model.Store;
import com.epam.task3.task3_2.service.Service;
import com.epam.task3.task3_2.view.StoreView;

public class Controller {
    private Store model = new Store();
    private StoreView view = new StoreView();
    private Service service = new Service(model, view);

    public void run(){
        view.printMessage(view.ENTER_STORE_NAME);
        model.setStoreName(view.getScanner().nextLine());
        selectAction();
    }

    private void selectAction() {
        while (true) {
            int choice = service.inputNumber(view.SELECT_AN_ACTION , view.getScanner());
            switch (choice) {
                case 1: {
                    service.resultHandler(model.getStoreName());
                    break;
                }
                case 2: {
                    service.resultHandler(model.getListDepartments());
                    break;
                }
                case 3: {
                    service.changeStoreName();
                    break;
                }
                case 4: {
                    service.createDepartments();
                    break;
                }
                case 5: {
                    service.deleteDepartmentByName();
                    break;
                }
                case 6: {
                    service.deliveryProductsInDepartment();
                    break;
                }
                case 7: {
                    service.sortByDepartmentName(model.getListDepartments());
                    service.resultHandler(model.getListDepartments());
                    break;
                }
                case 8: {
                    service.sortByTypeOfProducts(model.getListDepartments());
                    service.resultHandler(model.getListDepartments());
                    break;
                }
                case 9: {
                    service.sortByService(model.getListDepartments());
                    service.resultHandler(model.getListDepartments());
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
