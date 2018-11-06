package com.epam.project1.controller;

public class KnightMenuController extends Controller{
    private InventoryMenuController inventoryMenuController = new InventoryMenuController();

    private enum KnightMenu{
        CHEST_ARMOR_OF_KNIGHT,
        HELMET_OF_KNIGHT,
        SHIELD_OF_KNIGHT,
        WEAPON_OF_KNIGH,
        COME_BACK
    }

    protected void equipKnight() {
        while (true) {
            KnightMenu choice = getUserChoice(KnightMenu.values(), view.KNIGHT_MENU);
            switch (choice) {
                case CHEST_ARMOR_OF_KNIGHT: {
                    service.equipKnight(model, model.getChestArmor().getClass(),
                            inventoryMenuController.inventoryOfKnight(model.getChestArmor().getClass()));
                    break;
                }
                case HELMET_OF_KNIGHT: {
                    service.equipKnight(model, model.getHelmet().getClass(),
                            inventoryMenuController.inventoryOfKnight(model.getHelmet().getClass()));
                    break;
                }
                case SHIELD_OF_KNIGHT: {
                    service.equipKnight(model, model.getShield().getClass(),
                            inventoryMenuController.inventoryOfKnight(model.getShield().getClass()));
                    break;
                }
                case WEAPON_OF_KNIGH: {
                    service.equipKnight(model, model.getWeapon().getClass(),
                            inventoryMenuController.inventoryOfKnight(model.getWeapon().getClass()));
                    break;
                }
                case COME_BACK: { return; }
                default: { view.showMessage(view.WRONG_INPUT); view.getRequestFromUser().next(); }
            }
        }
    }
}