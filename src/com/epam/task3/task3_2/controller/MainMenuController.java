package com.epam.task3.task3_2.controller;

public class MainMenuController extends Controller {
    public void run(){
        view.showMessage(view.ENTER_STORE_NAME);
        model.setStoreName(view.getRequestFromUser().nextLine());
        mainMenu();
    }

    private enum MainMenu {
        CURRENT_NAME_OF_STORE,
        CURRENT_LIST_OF_DEPARTMENTS,
        CHANGE_STORE_NAME,
        CREATE_DEPARTMENTS,
        DELETE_DEPARTMENT_BY_NAME,
        DELIVERY_PRODUCTS_IN_DEPARTMENT,
        REDISTRIBUTION_DEPARTMENT_BY_DEPARTMENT_NAME,
        REDISTRIBUTION_DEPARTMENT_BY_TYPE_OF_PRODUCTS,
        REDISTRIBUTION_DEPARTMENT_BY_SUITSERVICE,
        EXIT
    }

    protected void mainMenu() {
        while (true) {
            try {
                MainMenu choice = getUserChoice(MainMenu.values(), view.MAIN_MENU);
                view.getRequestFromUser().nextLine();
                switch (choice) {
                case CURRENT_NAME_OF_STORE: {
                    resultHandler(model.getStoreName());
                    break;
                }
                case CURRENT_LIST_OF_DEPARTMENTS: {
                    resultHandler(model.getListDepartments());
                    break;
                }
                case CHANGE_STORE_NAME: {
                    view.showMessage(view.ENTER_STORE_NAME);
                    model.setStoreName(view.getRequestFromUser().nextLine());
                    break;
                }
                case CREATE_DEPARTMENTS: {
                    createDepartments();
                    break;
                }
                case DELETE_DEPARTMENT_BY_NAME: {
                    deleteDepartmentByName();
                    break;
                }
                case DELIVERY_PRODUCTS_IN_DEPARTMENT: {
                    deliveryProductsInDepartment();
                    break;
                }
                case REDISTRIBUTION_DEPARTMENT_BY_DEPARTMENT_NAME: {
                    service.sortByDepartmentName(model, model.getListDepartments());
                    resultHandler(model.getListDepartments());
                    break;
                }
                case REDISTRIBUTION_DEPARTMENT_BY_TYPE_OF_PRODUCTS: {
                    service.sortByTypeOfProducts(model, model.getListDepartments());
                    resultHandler(model.getListDepartments());
                    break;
                }
                case REDISTRIBUTION_DEPARTMENT_BY_SUITSERVICE: {
                    service.sortByService(model, model.getListDepartments());
                    resultHandler(model.getListDepartments());
                    break;
                }
                    case EXIT: { return; }
                }
            }
            catch (Exception e){ view.showMessage(view.WRONG_INPUT); }
        }
    }

    private void createDepartments(){
        String departmentName;
        String typeOfProducts;
        String serviceName;
        String location;

        view.showMessage(view.ENTER_DEPARTMENT_NAME);
        departmentName = view.getRequestFromUser().nextLine();

        if(!service.isExistDepartment(model, departmentName)){
            view.showMessage(view.ENTER_TYPE_OF_PRODUCTS);
            typeOfProducts = view.getRequestFromUser().nextLine();

            view.showMessage(view.ENTER_SERVICE);
            serviceName = view.getRequestFromUser().nextLine();

            view.showMessage(view.ENTER_LOCATION);
            location = view.getRequestFromUser().nextLine();

            model.getListDepartments().
                    add(service.creatDepartment(model, departmentName, typeOfProducts, serviceName, location));
        }
        else{
            view.showMessage(view.DEPARTMENT_EXISTS);
        }
    }

    private void deleteDepartmentByName(){
        String departmentNameForDelete;

        view.showMessage(view.ENTER_DEPARTMENT_NAME);
        departmentNameForDelete = view.getRequestFromUser().nextLine();

        if(service.isExistDepartment(model, departmentNameForDelete)){
            service.deleteDepartmentByName(model, departmentNameForDelete);
        }
        else{
            view.showMessage(view.DEPARTMENT_NOT_EXISTS);
        }
    }

    private void deliveryProductsInDepartment(){
        String departmentName;
        String products;

        view.showMessage(view.ENTER_DEPARTMENT_NAME);
        departmentName = view.getRequestFromUser().nextLine();

        if(service.isExistDepartment(model, departmentName)) {
            view.showMessage(view.ENTER_DELIVERY_PRODUCTS);
            products = view.getRequestFromUser().nextLine();

            service.deliveryProducts(model, departmentName, products.split(" "));
        }
        else {
            view.showMessage(view.DEPARTMENT_NOT_EXISTS);
        }
    }
}
