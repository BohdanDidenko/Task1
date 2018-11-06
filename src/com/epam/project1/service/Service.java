package com.epam.project1.service;

import com.epam.project1.model.ammunition.entity.Ammunition;
import com.epam.project1.model.ammunition.armor.ChestArmor;
import com.epam.project1.model.ammunition.armor.Helmet;
import com.epam.project1.model.ammunition.armor.Shield;
import com.epam.project1.model.warrior.Knight;
import com.epam.project1.model.ammunition.weapon.Weapon;
import java.util.Comparator;
import java.util.List;

public interface Service {
    Knight createKnight();
    ChestArmor createChestArmor();
    Helmet createHelmet();
    Shield createShield();
    Weapon createWeapon();
    <T>void equipKnight(Knight knight, Class<T> type, Ammunition newAmmunition);
    <T>List<Ammunition> goToMarket(Class<T> type, int count);
    String calculateTotalCostOfAmmunition(Knight knight);
    void sortAmmunition(Knight knight, Comparator<Ammunition> comparator);
    List<Ammunition> findItemsOfAmmunitionInPriceDiapason(Knight knight, double lowerPrice, double topPrice);
}
