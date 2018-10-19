package com.epam.task3.task3_2.controller;

import com.epam.task3.task3_2.model.Store;
import com.epam.task3.task3_2.view.StoreView;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private Store model = new Store();
    private StoreView view = new StoreView();

    public void run(){
        view.printMessage(view.ENTER_STORE_NAME);
        model.setStoreName(view.getScanner().nextLine());
        selectAction();
    }

    public void selectAction() {
        while (true) {
            int choice = inputNumber(view.SELECT_AN_ACTION , view.getScanner());
            switch (choice) {
                case 1: {
                    resultHandler(model.getStoreName());
                    break;
                }
                case 2: {
                    resultHandler(model.getListDepartments());
                    break;
                }
                case 3: {
                    changeStoreName();
                    break;
                }
                case 4: {
                    createDepartments();
                    break;
                }
                case 5: {
                    deleteDepartmentByName();
                    break;
                }
                case 6: {
                    deliveryProductsInDepartment();
                    break;
                }
                case 7: {
                    sortByDepartmentName(model.getListDepartments());
                    view.printList(model.getListDepartments());
                    break;
                }
                case 8: {
                    sortByTypeOfProducts(model.getListDepartments());
                    view.printList(model.getListDepartments());
                    break;
                }
                case 9: {
                    sortByService(model.getListDepartments());
                    view.printList(model.getListDepartments());
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

    private int inputNumber(String message, Scanner scanner){
        while (true) {
            view.printMessage(message);

            if (scanner.hasNextInt())
                return scanner.nextInt();
            else {
                view.printMessage(view.WRONG_INPUT);
                scanner.next();
            }
        }
    }

    private void changeStoreName(){
        view.printMessage(view.ENTER_STORE_NAME);
        view.getScanner().nextLine();
        model.setStoreName(view.getScanner().nextLine());
    }

    private void createDepartments(){
        String departmentName;
        String typeOfProducts;
        String service;
        String location;

        view.printMessage(view.ENTER_DEPARTMENT_NAME);
        view.getScanner().nextLine();
        departmentName = view.getScanner().nextLine();

        if(!isExistDepartment(departmentName)){
            view.printMessage(view.ENTER_TYPE_OF_PRODUCTS);
            typeOfProducts = view.getScanner().nextLine();

            view.printMessage(view.ENTER_SERVICE);
            service = view.getScanner().nextLine();

            view.printMessage(view.ENTER_LOCATION);
            location = view.getScanner().nextLine();

            model.getListDepartments().
                    add(model.creatDepartment(departmentName, typeOfProducts, service, location));
        }
        else{
            view.printMessage(view.DEPARTMENT_EXISTS);
        }
    }

    private void deleteDepartmentByName(){
        String departmentNameForDelete;

        view.printMessage(view.ENTER_DEPARTMENT_NAME);
        view.getScanner().nextLine();
        departmentNameForDelete = view.getScanner().nextLine();

        if(isExistDepartment(departmentNameForDelete)){
        model.deleteDepartmentByName(departmentNameForDelete);
        }
        else{
            view.printMessage(view.DEPARTMENT_NOT_EXISTS);
        }
    }

    private void deliveryProductsInDepartment(){
        String departmentName;
        String products;

        view.printMessage(view.ENTER_DEPARTMENT_NAME);
        view.getScanner().nextLine();
        departmentName = view.getScanner().nextLine();

        if(isExistDepartment(departmentName)) {
            view.printMessage(view.ENTER_DELIVERY_PRODUCTS);
            products = view.getScanner().nextLine();

            model.deliveryProducts(departmentName, products.split(" "));
        }
        else {
            view.printMessage(view.DEPARTMENT_NOT_EXISTS);
        }
    }

    private boolean isExistDepartment(String departmentName){
        for (Store.Department department : model.getListDepartments()) {
            if(department.getDepartmentName().equals(departmentName)) return true;
        }
        return false;
    }

    private <E>void sortByDepartmentName(List<E> list) {
        model.redistributionDepartment((o1, o2) ->
                o1.getDepartmentName().compareTo(o2.getDepartmentName()));
    }

    private <E>void sortByTypeOfProducts(List<E> list){
        model.redistributionDepartment((o1,o2)
                -> o1.getTypeOfProducts().compareTo(o2.getTypeOfProducts()));
    }

    private <E>void sortByService(List<E> list){
        model.redistributionDepartment((o1, o2)
                -> o1.getService().compareTo(o2.getService()));
    }

    private void resultHandler(String result) {
        if (result != null && result.equals("") == false)
            view.printMessage(result);
        else
            view.printMessage(view.NO_RESULT);
    }

    private <E>void resultHandler(List<E> result) {
        if (result.size() > 0)
            view.printList(result);
        else
            view.printMessage(view.NO_RESULT);
    }
}
