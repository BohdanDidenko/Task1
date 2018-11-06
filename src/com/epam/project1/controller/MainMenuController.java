package com.epam.project1.controller;

public class MainMenuController extends Controller{
    private KnightMenuController knightMenuController = new KnightMenuController();

    public void run(){ mainMenu(); }

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
                    case SHOW_KNIGHT: { resultHandler(model);break; }
                    case CREATE_KNIGHT: { resultHandler(model = service.createKnight());break; }
                    case LOAD_KNIGHT: { resultHandler(model = dao.loadKnight());break; }
                    case SAVE_KNIGHT: { dao.saveKnight(model);break; }
                    case EQUIP_KNIGHT: { knightMenuController.equipKnight();break; }
                    case CALCULATE_TOTAL_COST_OF_AMMUNITION: { resultHandler(service.calculateTotalCostOfAmmunition(model));break; }
                    case SORT_AMMUNITION_BY_WEIGHT: {
                        service.sortAmmunition(model, (o1, o2) -> (int) (o1.getWeight() - o2.getWeight()));
                        resultHandler(model.getInventory());
                        break;
                    }
                    case FIND_ITEMS_OF_AMMUNITION_IN_PRICE_RANGE: {
                        view.getRequestFromUser().nextLine();
                        view.showMessage(view.MIN_PRICE); double lowerPrice = view.getRequestFromUser().nextDouble();
                        view.showMessage(view.MAX_PRICE); double topPrice = view.getRequestFromUser().nextDouble();
                        resultHandler(service.findItemsOfAmmunitionInPriceDiapason(model, lowerPrice, topPrice));
                        break;
                    }
                    case EXIT: { return; }
                }
            }
            catch (Exception e){ view.showMessage(view.WRONG_INPUT); }
        }
    }
}