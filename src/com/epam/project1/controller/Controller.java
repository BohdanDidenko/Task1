package com.epam.project1.controller;

import com.epam.project1.data.DataKnight;
import com.epam.project1.model.KnightModel;
import com.epam.project1.model.entity.Ammunition;
import com.epam.project1.view.ConsoleView;
import java.util.List;

public class Controller {
    private KnightModel model = new KnightModel();
    private ConsoleView view = new ConsoleView();
    private DataKnight dataKnight = new DataKnight();

    public void run(){
        mainMenu();
    }

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

    private void mainMenu() {
        while (true) {
            MainMenu choice = getUserChoice(MainMenu.values(), view.MAIN_MENU);
            switch (choice) {
                case SHOW_KNIGHT: { resultHandler(model.getKnight());break; }
                case CREATE_KNIGHT: { resultHandler(model.createKnight());break; }
                case LOAD_KNIGHT: { resultHandler(model.loadKnight());break; }
                case SAVE_KNIGHT: { model.saveKnight();break; }
                case EQUIP_KNIGHT: { equipKnight(); }
                case CALCULATE_TOTAL_COST_OF_AMMUNITION: { resultHandler(model.calculateTotalCostOfAmmunition());break; }
                case SORT_AMMUNITION_BY_WEIGHT: { model.sortAmmunition((o1, o2)-> (int) (o1.getWeight() - o2.getWeight()));resultHandler(model.getKnight().getInventory());break; }
                case FIND_ITEMS_OF_AMMUNITION_IN_PRICE_RANGE: {
                    view.getRequestFromUser().nextLine();
                    double lowerPrice = view.getRequestFromUser().nextDouble();
                    double topPrice = view.getRequestFromUser().nextDouble();
                    resultHandler(model.findItemsOfAmmunitionInPriceDiapason(lowerPrice, topPrice));
                    break;
                }
                case EXIT: { return; }
                default: { view.showMessage(view.WRONG_INPUT); view.getRequestFromUser().next(); }
            }
        }
    }

    private enum KnightMenu{
        CHEST_ARMOR_OF_KNIGHT,
        HELMET_OF_KNIGHT,
        SHIELD_OF_KNIGHT,
        WEAPON_OF_KNIGH,
        COME_BACK
    }

    private void equipKnight() {
        while (true) {
            KnightMenu choice = getUserChoice(KnightMenu.values(), view.KNIGHT_MENU);
            switch (choice) {
                case CHEST_ARMOR_OF_KNIGHT: {
                    model.equipKnight(model.getKnight().getChestArmor(), inventoryOfKnight(model.getKnight().getChestArmor()));
                    break;
                }
                case HELMET_OF_KNIGHT: {
                    model.equipKnight(model.getKnight().getHelmet(), inventoryOfKnight(model.getKnight().getHelmet()));
                    break;
                }
                case SHIELD_OF_KNIGHT: {
                    model.equipKnight(model.getKnight().getShield(), inventoryOfKnight(model.getKnight().getShield()));
                    break;
                }
                case WEAPON_OF_KNIGH: {
                    model.equipKnight(model.getKnight().getWeapon(), inventoryOfKnight(model.getKnight().getWeapon()));
                    break;
                }
                case COME_BACK: { return; }
                default: { view.showMessage(view.WRONG_INPUT); view.getRequestFromUser().next(); }
            }
        }
    }

    private enum InventoryMenu{
        PUT_INTO_INVENTORY,
        TAKE_FROM_INVENTORY,
        BUY_ON_MARKET,
    }

    private Ammunition inventoryOfKnight(Ammunition ammunition) {
        while (true) {
            InventoryMenu choice = getUserChoice(InventoryMenu.values(), view.AMMUNITION_MENU);
            switch (choice) {
                case PUT_INTO_INVENTORY: { return null; }
                case TAKE_FROM_INVENTORY: {
                    List<Ammunition> thingsInInventory = model.getKnight().getInventory(ammunition);
                    view.showList(thingsInInventory);
                    view.showMessage(view.INVENTORY_MENU);
                    return thingsInInventory.get(view.getRequestFromUser().nextInt() - 1);
                }
                case BUY_ON_MARKET: {
                    List<Ammunition> thingsOnMarket = model.goToMarket(ammunition, 3);
                    view.showList(thingsOnMarket);
                    view.showMessage(view.INVENTORY_MENU);
                    return thingsOnMarket.get(view.getRequestFromUser().nextInt() - 1);
                }
                default: { view.showMessage(view.WRONG_INPUT); view.getRequestFromUser().next(); }
            }
        }
    }

//    private enum MarketMenu{
//        BUY_FIRST_THING,
//        BUY_SECOND_THING,
//        BUY_THIRD_THING,
//        COME_BACK
//    }
//
//    private void goToMarket() {
//        while (true) {
//
//            MarketMenu choice = getUserChoice(MarketMenu.values(), view.KNIGHT_MENU);
//            switch (choice) {
//                case BUY_FIRST_THING: { resultHandler(model.getKnight());break; }
//                case BUY_SECOND_THING: { resultHandler(model.createKnight());break; }
//                case BUY_THIRD_THING: { resultHandler(model.loadKnight());break; }
//                case COME_BACK: { return; }
//                default: { view.showMessage(view.WRONG_INPUT); view.getRequestFromUser().next(); }
//            }
//        }
//    }

    private <T, E>E getUserChoice(E[] element, T message){
        while (true) {
            view.showMessage(message);
            if (view.getRequestFromUser().hasNextInt())
                return element[view.getRequestFromUser().nextInt()-1];
            else {
                view.showMessage(view.WRONG_INPUT);
                view.getRequestFromUser().next();
            }
        }
    }

    private <E>void resultHandler(E result) {
        if (result != null && !result.equals(""))
            view.showMessage(result);
        else
            view.showMessage(view.NO_RESULT);
    }

    private <E>void resultHandler(List<E> result) {
        if (result.size() > 0)
            view.showList(result);
        else
            view.showMessage(view.NO_RESULT);
    }
}
