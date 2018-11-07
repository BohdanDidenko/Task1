package com.epam.task3.task3_1.controller;

import com.epam.task3.task3_1.model.entity.KidsToy;
import java.util.InputMismatchException;
import java.util.List;

public class SearchCriteriaController extends Controller {
    private enum SearchCriteriaMenu {
        SEARCH_BY_TITLE,
        SEARCH_BY_MANUFACTURER,
        SEARCH_BY_MATERIAL,
        SEARCH_BY_PRICE,
        SEARCH_BY_MIN_COUNT_WARRANTY_DAYS,
        SEARCH_BY_MAX_PACKING_WIDTH,
        SEARCH_BY_MAX_PACKING_HEIGHT,
        SEARCH_BY_AGE_GROUP,
        PRINT_THE_RESULT_AND_EXIT
    }

    protected List<KidsToy> searchBySpecifiedCriteria() {
        String title = "";
        String manufacturer = "";
        String material = "";
        double price = -1.0;
        int warrantyDays = -1;
        int packingWidth = -1;
        int packingHeight = -1;
        String ageGroup = "";

        while (true) {
            try {
                SearchCriteriaMenu choice = getUserChoice(SearchCriteriaMenu.values(), view.SELECT_SEARCH_CRITERIA);
                switch (choice) {
                    case SEARCH_BY_TITLE: {
                        view.showMessage(view.SEARCH_BY_TITLE);
                        view.getRequestFromUser().nextLine();
                        title = view.getRequestFromUser().nextLine();
                        break;
                    }
                    case SEARCH_BY_MANUFACTURER: {
                        view.showMessage(view.SEARCH_BY_MANUFACTURER);
                        view.getRequestFromUser().nextLine();
                        manufacturer = view.getRequestFromUser().nextLine();
                        break;
                    }
                    case SEARCH_BY_MATERIAL: {
                        view.showMessage(view.SEARCH_BY_MATERIAL);
                        view.getRequestFromUser().nextLine();
                        material = view.getRequestFromUser().nextLine();
                        break;
                    }
                    case SEARCH_BY_PRICE: {
                        view.showMessage(view.SEARCH_BY_PRICE);
                        view.getRequestFromUser().nextLine();
                        price = view.getRequestFromUser().nextDouble();
                        break;
                    }
                    case SEARCH_BY_MIN_COUNT_WARRANTY_DAYS: {
                        view.showMessage(view.SEARCH_BY_WARRANTY_DAYS);
                        view.getRequestFromUser().nextLine();
                        warrantyDays = view.getRequestFromUser().nextInt();
                        break;
                    }
                    case SEARCH_BY_MAX_PACKING_WIDTH: {
                        view.showMessage(view.SEARCH_BY_PACKING_WIDTH);
                        view.getRequestFromUser().nextLine();
                        packingWidth = view.getRequestFromUser().nextInt();
                        break;
                    }
                    case SEARCH_BY_MAX_PACKING_HEIGHT: {
                        view.showMessage(view.SEARCH_BY_PACKING_HEIGHT);
                        view.getRequestFromUser().nextLine();
                        packingHeight = view.getRequestFromUser().nextInt();
                        break;
                    }
                    case SEARCH_BY_AGE_GROUP: {
                        view.showMessage(view.SEARCH_BY_AGE_GROUP);
                        view.getRequestFromUser().nextLine();
                        ageGroup = view.getRequestFromUser().nextLine();
                        break;
                    }
                    case PRINT_THE_RESULT_AND_EXIT: {
                        return service.searchForKidsToysAtTheUserRequest(model.getKidsToys(), title, manufacturer, material,
                                price, warrantyDays, packingWidth, packingHeight, ageGroup);
                    }
                }
            } catch (NumberFormatException | InputMismatchException e) {
                view.showMessage(view.WRONG_INPUT);
            }
        }
    }
}