package com.epam.project1.data;

import com.epam.project1.model.entity.Ammunition;
import com.epam.project1.model.entity.Rarity;
import com.epam.project1.model.entity.armor.ChestArmor;
import com.epam.project1.model.entity.armor.Helmet;
import com.epam.project1.model.entity.armor.Shield;
import com.epam.project1.model.entity.warrior.Knight;
import com.epam.project1.model.entity.warrior.Order;
import com.epam.project1.model.entity.weapon.*;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DataKnight {
    private String[] names = {"Ulrich von Lichtenstein",
            "Don Quixote",
            "Edward the Black Prince",
            "Jacques de molay",
            "Gottfried of Bouillon",
            "Sir Galahad",
            "Jean Le Mengre Busico",
            "Richard the Lionheart",
            "William Marshall"};

    public DataKnight() {
    }

    public Knight createKnight() {
        String name = names[getRandomNumberInGivenRange(0, names.length-1)];
        int age = getRandomNumberInGivenRange(18, 60);
        int height = getRandomNumberInGivenRange(150, 220);
        int weight = getRandomNumberInGivenRange(60, 120);
        double money = getRandomNumberInGivenRange(5000, 10000);
        ChestArmor chestArmor = createChestArmor();
        Helmet helmet = createHelmet();
        Weapon weapon = createWeapon();
        Shield shield = createShield();
        List<Ammunition> inventory = new LinkedList<>();
        Order order = getOrder();
        return new Knight(name, age, height, weight, money,
                chestArmor, helmet, shield, weapon, inventory, order);
    }

    public ChestArmor createChestArmor() {
        double weight = getRandomNumberInGivenRange(30, 100) / 10;
        double cost = getRandomNumberInGivenRange(1500, 3000);
        Rarity rarityLevel = calculateRarityLevel(cost, "ChestArmor");
        int protection = calculateProtection(rarityLevel);
        int protectionAgainstFire = calculateProtection(rarityLevel);
        return new ChestArmor(weight, cost, rarityLevel, protection, protectionAgainstFire);
    }

    public Helmet createHelmet() {
        double weight = getRandomNumberInGivenRange(5, 20) / 10;
        double cost = getRandomNumberInGivenRange(400, 1000);
        Rarity rarityLevel = calculateRarityLevel(cost, "Helmet");
        int protection = calculateProtection(rarityLevel);
        boolean isHelmetOpen = false;
        return new Helmet(weight, cost, rarityLevel, protection, isHelmetOpen);
    }

    public Shield createShield() {
        double weight = getRandomNumberInGivenRange(20, 50) / 10;
        double cost = getRandomNumberInGivenRange(750, 1500);
        Rarity rarityLevel = calculateRarityLevel(cost, "Shield");
        int protection = calculateProtection(rarityLevel);
        int protectionAgainstArrows = calculateProtection(rarityLevel);
        int protectionAgainstSuperHit = calculateProtection(rarityLevel);
        return new Shield(weight, cost, rarityLevel, protection, protectionAgainstArrows, protectionAgainstSuperHit);
    }

    public Weapon createWeapon() {
        Weapon weapon;
        double weight = getRandomNumberInGivenRange(15, 50) / 10;
        double cost = getRandomNumberInGivenRange(1000, 1900);
        Rarity rarityLevel = calculateRarityLevel(cost, "Weapon");
        int damage = calculateDamage(rarityLevel);
        int typeOfWeapon = getRandomNumberInGivenRange(0,1);
        switch (typeOfWeapon){
            case 0: weapon = cteateSword(weight, cost, rarityLevel, damage);
            break;
            case 1: weapon = cteateDagger(weight, cost, rarityLevel, damage);
            break;
            case 2: weapon = cteateSpear(weight, cost, rarityLevel, damage);
            break;
            default: weapon = cteateSword(weight, cost, rarityLevel, damage);
        }
        return weapon;
    }

    private Sword cteateSword(double weight, double cost, Rarity rarityLevel, int damage){
        int size = getRandomNumberInGivenRange(70, 90);
        return new Sword(weight, cost, rarityLevel, damage, size, damage);
    }

    private Dagger cteateDagger(double weight, double cost, Rarity rarityLevel, int damage){
        int size = getRandomNumberInGivenRange(30, 40);
        return new Dagger(weight, cost, rarityLevel, damage, size, Poison.DRYAD_POLLEN);
    }

    private Spear cteateSpear(double weight, double cost, Rarity rarityLevel, int damage){
        int size = getRandomNumberInGivenRange(220, 260);
        return new Spear(weight, cost, rarityLevel, damage, size, "Metal");
    }

    private int getRandomNumberInGivenRange(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    private Rarity calculateRarityLevel(double cost, String nameOfThing) {
        if ((nameOfThing.equals("ChestArmor") && cost <= 2000)
                || (nameOfThing.equals("Helmet") && cost <= 600)
                || (nameOfThing.equals("Weapon") && cost <= 1300)
                || (nameOfThing.equals("Shield") && cost <= 1000))
            return Rarity.LOW;
        else if((nameOfThing.equals("ChestArmor") && cost <= 2500)
                || (nameOfThing.equals("Helmet") && cost <= 800)
                || (nameOfThing.equals("Weapon") && cost <= 1600)
                || (nameOfThing.equals("Shield") && cost <= 1250))
            return Rarity.MIDDLE;
        else if((nameOfThing.equals("ChestArmor") && cost <= 3000)
                || (nameOfThing.equals("Helmet") && cost <= 1000)
                || (nameOfThing.equals("Weapon") && cost <= 1900)
                || (nameOfThing.equals("Shield") && cost <= 1500))
        return Rarity.HIGH;

        else return null;
    }

    private int calculateProtection(Rarity rarity){
        switch (rarity){
            case LOW: return getRandomNumberInGivenRange(10, 99);
            case MIDDLE: return getRandomNumberInGivenRange(100, 199);
            case HIGH: return getRandomNumberInGivenRange(200, 299);
            default: return 0;
        }
    }

    private int calculateDamage(Rarity rarity){
        switch (rarity){
            case LOW: return getRandomNumberInGivenRange(50, 74);
            case MIDDLE: return getRandomNumberInGivenRange(75, 84);
            case HIGH: return getRandomNumberInGivenRange(85, 99);
            default: return 0;
        }
    }

    private Order getOrder(){
        Order[] orders = Order.values();
        return orders[getRandomNumberInGivenRange(0, orders.length-1)];
    }
}
