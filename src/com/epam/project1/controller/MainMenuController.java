package com.epam.project1.controller;

public class MainMenuController extends Controller{
    private KnightMenuController knightMenuController = new KnightMenuController();

    private enum MainMenu{
        SHOW_KNIGHT,
        CREATE_KNIGHT,
        LOAD_KNIGHT,
        SAVE_KNIGHT,
        EQUIP_KNIGHT,
        CALCULATE_TOTAL_COST_OF_AMMUNITION,
        SORT_AMMUNITION_BY_WEIGHT,
        FIND_ITEMS_OF_AMMUNITION_IN_PRICE_RANGE,
        EXIT
    }

    protected void mainMenu() {
        while (true) {
            try {
                MainMenu choice = getUserChoice(MainMenu.values(), view.MAIN_MENU);
                switch (choice) {
                    case SHOW_KNIGHT: { resultHandler(model.getKnight());break; }
                    case CREATE_KNIGHT: { resultHandler(model.createKnight());break; }
                    case LOAD_KNIGHT: { resultHandler(model.loadKnight());break; }
                    case SAVE_KNIGHT: { model.saveKnight();break; }
                    case EQUIP_KNIGHT: { knightMenuController.equipKnight();break; }
                    case CALCULATE_TOTAL_COST_OF_AMMUNITION: { resultHandler(model.calculateTotalCostOfAmmunition());break; }
                    case SORT_AMMUNITION_BY_WEIGHT: {
                        model.sortAmmunition((o1, o2) -> (int) (o1.getWeight() - o2.getWeight()));
                        resultHandler(model.getKnight().getInventory());
                        break;
                    }
                    case FIND_ITEMS_OF_AMMUNITION_IN_PRICE_RANGE: {
                        view.getRequestFromUser().nextLine();
                        view.showMessage(view.MIN_PRICE); double lowerPrice = view.getRequestFromUser().nextDouble();
                        view.showMessage(view.MAX_PRICE); double topPrice = view.getRequestFromUser().nextDouble();
                        resultHandler(model.findItemsOfAmmunitionInPriceDiapason(lowerPrice, topPrice));
                        break;
                    }
                    case EXIT: { return; }
                }
            }
            catch (Exception e){ view.showMessage(view.WRONG_INPUT); }
        }
    }
}