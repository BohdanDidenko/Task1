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
    <T>void equipKnight(Class<T> type, Ammunition newAmmunition);
//    void putAmmunitionInInventory();
    <T>List<Ammunition> goToMarket(Class<T> type, int count);
    String calculateTotalCostOfAmmunition();
    void sortAmmunition(Comparator<Ammunition> comparator);
    List<Ammunition> findItemsOfAmmunitionInPriceDiapason(double lowerPrice, double topPrice);
}
