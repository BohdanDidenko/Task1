package com.epam.task3.task3_2.service;

import com.epam.task3.task3_2.model.Store;
import com.epam.task3.task3_2.view.StoreView;

import java.util.List;
import java.util.Scanner;

public class Service {
    private Store model = new Store();
    private StoreView view = new StoreView();

    public Service(Store model, StoreView view) {
        this.model = model;
        this.view = view;
    }

    public int inputNumber(String message, Scanner scanner){
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

    public void changeStoreName(){
        view.printMessage(view.ENTER_STORE_NAME);
        view.getScanner().nextLine();
        model.setStoreName(view.getScanner().nextLine());
    }

    public void createDepartments(){
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

    public void deleteDepartmentByName(){
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

    public void deliveryProductsInDepartment(){
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

    public boolean isExistDepartment(String departmentName){
        for (Store.Department department : model.getListDepartments()) {
            if(department.getDepartmentName().equals(departmentName)) return true;
        }
        return false;
    }

    public <E>void sortByDepartmentName(List<E> list) {
        model.redistributionDepartment((o1, o2) ->
                o1.getDepartmentName().compareTo(o2.getDepartmentName()));
    }

    public <E>void sortByTypeOfProducts(List<E> list){
        model.redistributionDepartment((o1,o2)
                -> o1.getTypeOfProducts().compareTo(o2.getTypeOfProducts()));
    }

    public <E>void sortByService(List<E> list){
        model.redistributionDepartment((o1, o2)
                -> o1.getService().compareTo(o2.getService()));
    }

    public void resultHandler(String result) {
        if (result != null && result.equals("") == false)
            view.printMessage(result);
        else
            view.printMessage(view.NO_RESULT);
    }

    public <E>void resultHandler(List<E> result) {
        if (result.size() > 0)
            view.printList(result);
        else
            view.printMessage(view.NO_RESULT);
    }
}
