package com.epam.project1.view;

public interface ConsoleMessage {
    String MAIN_MENU = "Select an action: " + "\n" +
            "1 - Show a knight" + "\n" +
            "2 - Create a knight" + "\n" +
            "3 - Load  a knight" + "\n" +
            "4 - Save a knight" + "\n" +
            "5 - Equip knight" + "\n" +
            "6 - Calculate total cost of ammunition" + "\n" +
            "7 - Sort ammunition by weight" + "\n" +
            "8 - Find the items of ammunition corresponding to the specified range of price parameters" + "\n" +
            "9 - Exit";

    String KNIGHT_MENU = "Select the item of ammunition" + "\n" +
            "1 - Chest armor of knight" + "\n" +
            "2 - Helmet of knight" + "\n" +
            "3 - Shield of knight" + "\n" +
            "4 - Weapon of knight" + "\n" +
            "5 - Come back";

    String AMMUNITION_MENU = "Select an action with ammunition" + "\n" +
            "1 - Remove and put into inventory" + "\n" +
            "2 - Take from inventory" + "\n" +
            "3 - Buy on the market" + "\n" +
            "4 - Come back";

    String INVENTORY_MENU = "Select an action" + "\n" +
            "1 - Take first thing" + "\n" +
            "2 - Take second thing" + "\n" +
            "3 - Take third thing" + "\n" +
            "4 - Come back";

    String WRONG_INPUT = "Wrong input! Repeat please!";
    String NO_RESULT = "No results were found for your search";
}
