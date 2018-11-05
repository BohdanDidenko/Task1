package com.epam.project1.controller;

import com.epam.project1.model.entity.Ammunition;
import java.util.List;

public class InventoryMenuController extends Controller {
    private enum InventoryMenu{
        TAKE_FROM_INVENTORY,
        BUY_ON_MARKET,
    }

    protected  <T>Ammunition inventoryOfKnight(Class<T> type) {
        while (true) {
            InventoryMenu choice = getUserChoice(InventoryMenu.values(), view.AMMUNITION_MENU);
            switch (choice) {
                case TAKE_FROM_INVENTORY: {
                    List<Ammunition> thingsInInventory = model.getKnight().getInventory(type);
                    resultHandler(thingsInInventory);
                    view.showList(view.INVENTORY_MENU, thingsInInventory.size());
                    return thingsInInventory.get(view.getRequestFromUser().nextInt() - 1);
                }
                case BUY_ON_MARKET: {
                    List<Ammunition> thingsOnMarket = model.goToMarket(type, 3);
                    resultHandler(thingsOnMarket);
                    view.showList(view.INVENTORY_MENU, thingsOnMarket.size());
                    return thingsOnMarket.get(view.getRequestFromUser().nextInt() - 1);
                }
                default: { view.showMessage(view.WRONG_INPUT); view.getRequestFromUser().next(); }
            }
        }
    }
}
