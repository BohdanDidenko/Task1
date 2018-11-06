package com.epam.project1.service;

import com.epam.project1.model.ammunition.entity.Ammunition;
import com.epam.project1.model.ammunition.armor.ChestArmor;
import com.epam.project1.model.ammunition.armor.Helmet;
import com.epam.project1.model.ammunition.armor.Shield;
import com.epam.project1.model.warrior.Knight;
import com.epam.project1.model.ammunition.weapon.Dagger;
import com.epam.project1.model.ammunition.weapon.Spear;
import com.epam.project1.model.ammunition.weapon.Sword;
import com.epam.project1.model.ammunition.weapon.Weapon;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class KnightService implements Service {
    private String[] names = {"Ulrich von Lichtenstein",
            "Don Quixote",
            "Edward the Black Prince",
            "Jacques de molay",
            "Gottfried of Bouillon",
            "Sir Galahad",
            "Jean Le Mengre Busico",
            "Richard the Lionheart",
            "William Marshall"};

    @Override
    public <T>void equipKnight(Knight knight, Class<T> type, Ammunition newAmmunition) {
        if (type == ChestArmor.class) {
            if (knight.getChestArmor() != null) {
                knight.getInventory().add(knight.getChestArmor());
            }
            knight.setChestArmor((ChestArmor) newAmmunition);
        } else if (type == Helmet.class) {
            if (knight.getHelmet() != null) {
                knight.getInventory().add(knight.getHelmet());
            }
            knight.setHelmet((Helmet) newAmmunition);
        } else if (type == Shield.class) {
            if (knight.getShield() != null) {
                knight.getInventory().add(knight.getShield());
            }
            knight.setShield((Shield) newAmmunition);
        } else if (type == Dagger.class || type == Spear.class || type == Sword.class) {
            if (knight.getWeapon() != null) {
                knight.getInventory().add(knight.getWeapon());
            }
            knight.setWeapon((Weapon) newAmmunition);
        }
        if(knight.getInventory().contains(newAmmunition))
            knight.getInventory().remove(newAmmunition);
    }

    @Override
    public <T>List<Ammunition> goToMarket(Class<T> type, int count){
        List<Ammunition> result = new LinkedList<>();
        if(type == ChestArmor.class){
            return createChestArmor(result, count);
        }
        else if(type == Helmet.class){
            return createHelmet(result, count);
        }
        else if(type == Shield.class){
            return createShield(result, count);
        }
        else if(type == Dagger.class || type == Spear.class || type == Sword.class){
            return createWeapon(result, count);
        }
        return result;
    }

    private List<Ammunition> createChestArmor(List<Ammunition> result, int count){
        for (int i = 0; i < count; i++) {
            result.add(createChestArmor());
        }
        return result;
    }

    private List<Ammunition> createHelmet(List<Ammunition> result, int count){
        for (int i = 0; i < count; i++) {
            result.add(createHelmet());
        }
        return result;
    }

    private List<Ammunition> createShield(List<Ammunition> result, int count){
        for (int i = 0; i < count; i++) {
            result.add(createShield());
        }
        return result;
    }

    private List<Ammunition> createWeapon(List<Ammunition> result, int count){
        for (int i = 0; i < count; i++) {
            result.add(createWeapon());
        }
        return result;
    }

    @Override
    public String calculateTotalCostOfAmmunition(Knight knight) {
        if(knight == null) return null;

        double result = 0;
        if(knight.getChestArmor() != null)result += knight.getChestArmor().getCost();
        if(knight.getHelmet() != null)result += knight.getHelmet().getCost();
        if(knight.getShield() != null)result += knight.getShield().getCost();
        if(knight.getWeapon() != null)result += knight.getWeapon().getCost();

        for (int i = 0; i < knight.getInventory().size(); i++) {
                result += knight.getInventory().get(i).getCost();
        }
        return String.format("%.2f", result);
    }

    @Override
    public void sortAmmunition(Knight knight, Comparator<Ammunition> comparator) {
        Collections.sort(knight.getInventory(), comparator);
    }

    @Override
    public List<Ammunition> findItemsOfAmmunitionInPriceDiapason(Knight knight, double lowerPrice, double topPrice) {
        if(knight == null) return null;

        List<Ammunition> result = new ArrayList<>();
        if(knight.getChestArmor() != null
                && knight.getChestArmor().getCost() >= lowerPrice
                && knight.getChestArmor().getCost() <= topPrice)
            result.add(knight.getChestArmor());
        if(knight.getHelmet() != null
                && knight.getHelmet().getCost() >= lowerPrice
                && knight.getHelmet().getCost() <= topPrice)
            result.add(knight.getHelmet());
        if(knight.getShield() != null
                && knight.getShield().getCost() >= lowerPrice
                && knight.getShield().getCost() <= topPrice)
            result.add(knight.getShield());
        if(knight.getWeapon() != null
                && knight.getWeapon().getCost() >= lowerPrice
                && knight.getWeapon().getCost() <= topPrice)
            result.add(knight.getWeapon());

        for (Ammunition ammunition : knight.getInventory()) {
            if(ammunition.getCost() >= lowerPrice
                    && ammunition.getCost() <= topPrice)
                result.add(ammunition);
        }
        return result;
    }

    @Override
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
        Knight.Order order = getOrder();
        return Knight.getInstance(name, age, height, weight, money,
                chestArmor, helmet, shield, weapon, inventory, order);
    }

    @Override
    public ChestArmor createChestArmor() {
        double weight = getRandomNumberInGivenRange(30, 100) / 10;
        double cost = getRandomNumberInGivenRange(1500, 3000);
        Ammunition.Rarity rarityLevel = calculateRarityLevel(cost, "ChestArmor");
        int protection = calculateProtection(rarityLevel);
        int protectionAgainstFire = calculateProtection(rarityLevel);
        return new ChestArmor(weight, cost, rarityLevel, protection, protectionAgainstFire);
    }

    @Override
    public Helmet createHelmet() {
        double weight = getRandomNumberInGivenRange(5, 20) / 10;
        double cost = getRandomNumberInGivenRange(400, 1000);
        Ammunition.Rarity rarityLevel = calculateRarityLevel(cost, "Helmet");
        int protection = calculateProtection(rarityLevel);
        boolean isHelmetOpen = false;
        return new Helmet(weight, cost, rarityLevel, protection, isHelmetOpen);
    }

    @Override
    public Shield createShield() {
        double weight = getRandomNumberInGivenRange(20, 50) / 10;
        double cost = getRandomNumberInGivenRange(750, 1500);
        Ammunition.Rarity rarityLevel = calculateRarityLevel(cost, "Shield");
        int protection = calculateProtection(rarityLevel);
        int protectionAgainstArrows = calculateProtection(rarityLevel);
        int protectionAgainstSuperHit = calculateProtection(rarityLevel);
        return new Shield(weight, cost, rarityLevel, protection, protectionAgainstArrows, protectionAgainstSuperHit);
    }

    @Override
    public Weapon createWeapon() {
        Weapon weapon;
        double weight = getRandomNumberInGivenRange(15, 50) / 10;
        double cost = getRandomNumberInGivenRange(1000, 1900);
        Ammunition.Rarity rarityLevel = calculateRarityLevel(cost, "Weapon");
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

    private Sword cteateSword(double weight, double cost, Ammunition.Rarity rarityLevel, int damage){
        int size = getRandomNumberInGivenRange(70, 90);
        return new Sword(weight, cost, rarityLevel, damage, size, damage);
    }

    private Dagger cteateDagger(double weight, double cost, Ammunition.Rarity rarityLevel, int damage){
        int size = getRandomNumberInGivenRange(30, 40);
        return new Dagger(weight, cost, rarityLevel, damage, size, Dagger.Poison.DRYAD_POLLEN);
    }

    private Spear cteateSpear(double weight, double cost, Ammunition.Rarity rarityLevel, int damage){
        int size = getRandomNumberInGivenRange(220, 260);
        return new Spear(weight, cost, rarityLevel, damage, size, "Metal");
    }

    private int getRandomNumberInGivenRange(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    private Ammunition.Rarity calculateRarityLevel(double cost, String nameOfThing) {
        if ((nameOfThing.equals("ChestArmor") && cost <= 2000)
                || (nameOfThing.equals("Helmet") && cost <= 600)
                || (nameOfThing.equals("Weapon") && cost <= 1300)
                || (nameOfThing.equals("Shield") && cost <= 1000))
            return Ammunition.Rarity.LOW;
        else if((nameOfThing.equals("ChestArmor") && cost <= 2500)
                || (nameOfThing.equals("Helmet") && cost <= 800)
                || (nameOfThing.equals("Weapon") && cost <= 1600)
                || (nameOfThing.equals("Shield") && cost <= 1250))
            return Ammunition.Rarity.MIDDLE;
        else if((nameOfThing.equals("ChestArmor") && cost <= 3000)
                || (nameOfThing.equals("Helmet") && cost <= 1000)
                || (nameOfThing.equals("Weapon") && cost <= 1900)
                || (nameOfThing.equals("Shield") && cost <= 1500))
            return Ammunition.Rarity.HIGH;

        else return null;
    }

    private int calculateProtection(Ammunition.Rarity rarity){
        switch (rarity){
            case LOW: return getRandomNumberInGivenRange(10, 99);
            case MIDDLE: return getRandomNumberInGivenRange(100, 199);
            case HIGH: return getRandomNumberInGivenRange(200, 299);
            default: return 0;
        }
    }

    private int calculateDamage(Ammunition.Rarity rarity){
        switch (rarity){
            case LOW: return getRandomNumberInGivenRange(50, 74);
            case MIDDLE: return getRandomNumberInGivenRange(75, 84);
            case HIGH: return getRandomNumberInGivenRange(85, 99);
            default: return 0;
        }
    }

    private Knight.Order getOrder(){
        Knight.Order[] orders = Knight.Order.values();
        return orders[getRandomNumberInGivenRange(0, orders.length-1)];
    }
}