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
                    model.equipKnight(model.getKnight().getChestArmor().getClass(),
                            inventoryMenuController.inventoryOfKnight(model.getKnight().getChestArmor().getClass()));
                    break;
                }
                case HELMET_OF_KNIGHT: {
                    model.equipKnight(model.getKnight().getHelmet().getClass(),
                            inventoryMenuController.inventoryOfKnight(model.getKnight().getHelmet().getClass()));
                    break;
                }
                case SHIELD_OF_KNIGHT: {
                    model.equipKnight(model.getKnight().getShield().getClass(),
                            inventoryMenuController.inventoryOfKnight(model.getKnight().getShield().getClass()));
                    break;
                }
                case WEAPON_OF_KNIGH: {
                    model.equipKnight(model.getKnight().getWeapon().getClass(),
                            inventoryMenuController.inventoryOfKnight(model.getKnight().getWeapon().getClass()));
                    break;
                }
                case COME_BACK: { return; }
                default: { view.showMessage(view.WRONG_INPUT); view.getRequestFromUser().next(); }
            }
        }
    }
}