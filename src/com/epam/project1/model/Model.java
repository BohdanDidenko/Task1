package com.epam.project1.model;

import com.epam.project1.model.entity.Ammunition;
import com.epam.project1.model.entity.warrior.Knight;

import java.util.Comparator;
import java.util.List;

public interface Model {
    Knight createKnight();
    Knight loadKnight();
    Knight getKnight();
    void saveKnight();
    void equipKnight(Ammunition knightAmmunition, Ammunition newAmmunition);
//    void putAmmunitionInInventory();
    List<Ammunition> goToMarket(Ammunition ammunition, int count);
    String calculateTotalCostOfAmmunition();
    void sortAmmunition(Comparator<Ammunition> comparator);
    List<Ammunition> findItemsOfAmmunitionInPriceDiapason(double lowerPrice, double topPrice);
}
