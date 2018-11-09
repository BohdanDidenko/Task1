package com.epam.task3.task3_1.controller;

public class MainMenuController extends Controller {
    private SearchCriteriaController searchCriteriaController = new SearchCriteriaController();

    public void run(){
        mainMenu();
    }

    private enum MainMenu {
        CURRENT_LIS_OF_TOYS,
        CALCULATE_TOTAL_VALUE_ALL_KIDS_TOYS,
        LIST_OF_KIDS_TOYS_BY_SPECIFIED_CRITERIA,
        SORT_KIDS_TOYS_BY_TITLE,
        SORT_KIDS_TOYS_BY_MANUFACTURER,
        SORT_KIDS_TOYS_BY_MATERIAL,
        SORT_KIDS_TOYS_BY_PRICE,
        SORT_KIDS_TOYS_BY_WARRANTYDAYS,
        EXIT
    }

    protected void mainMenu() {
        while (true) {
            try {
                MainMenu choice = getUserChoice(MainMenu.values(), view.MAIN_MENU);
                switch (choice) {
                    case CURRENT_LIS_OF_TOYS: {
                        resultHandler(model.getKidsToys());
                        break;
                    }
                    case CALCULATE_TOTAL_VALUE_ALL_KIDS_TOYS: {
                        resultHandler(service.calculateTotalValueAllKidsToy(model.getKidsToys()));
                        break;
                    }
                    case LIST_OF_KIDS_TOYS_BY_SPECIFIED_CRITERIA: {
                        resultHandler(searchCriteriaController.searchBySpecifiedCriteria());
                        break;
                    }
                    case SORT_KIDS_TOYS_BY_TITLE: {
                        service.sortByTitle(model.getKidsToys());
                        resultHandler(model.getKidsToys());
                        break;
                    }
                    case SORT_KIDS_TOYS_BY_MANUFACTURER: {
                        service.sortByManufacturer(model.getKidsToys());
                        resultHandler(model.getKidsToys());
                        break;
                    }
                    case SORT_KIDS_TOYS_BY_MATERIAL: {
                        service.sortByMaterial(model.getKidsToys());
                        resultHandler(model.getKidsToys());
                        break;
                    }
                    case SORT_KIDS_TOYS_BY_PRICE: {
                        service.sortByPrice(model.getKidsToys());
                        resultHandler(model.getKidsToys());
                        break;
                    }
                    case SORT_KIDS_TOYS_BY_WARRANTYDAYS: {
                        service.sortByWarrantyDays(model.getKidsToys());
                        resultHandler(model.getKidsToys());
                        break;
                    }
                    case EXIT: { return; }
                }
            }
            catch (Exception e){ view.showMessage(view.WRONG_INPUT); }
        }
    }
}