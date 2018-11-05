package com.epam.project1.model;

import com.epam.project1.data.DataKnight;
import com.epam.project1.model.entity.Ammunition;
import com.epam.project1.model.entity.armor.ChestArmor;
import com.epam.project1.model.entity.armor.Helmet;
import com.epam.project1.model.entity.armor.Shield;
import com.epam.project1.model.entity.warrior.Knight;
import com.epam.project1.model.entity.weapon.Dagger;
import com.epam.project1.model.entity.weapon.Spear;
import com.epam.project1.model.entity.weapon.Sword;
import com.epam.project1.model.entity.weapon.Weapon;
import java.io.*;
import java.util.*;

public class KnightModel implements Model {
    private Knight knight;
    private DataKnight dataKnight = new DataKnight();

    @Override
    public Knight getKnight() {
        return knight;
    }

    @Override
    public Knight createKnight() {
        knight = dataKnight.createKnight();
        return knight;
    }

    @Override
    public Knight loadKnight() {
        try (ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream("src\\com\\epam\\project1\\dao\\knight.ser"))) {
            knight = (Knight) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Upss...Something must have gone wrong! =(");
            e.getStackTrace();
        }
        return knight;
    }

    @Override
    public void saveKnight() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream("src\\com\\epam\\project1\\dao\\knight.ser"))) {
            outputStream.writeObject(knight);
        } catch (IOException e) {
            System.out.println("Upss...Something must have gone wrong! =(");
            e.getStackTrace();
        }
    }

    @Override
    public <T>void equipKnight(Class<T> type, Ammunition newAmmunition) {
/*        if(oldAmmunition == null){
        }
        else */if (type == ChestArmor.class) {
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
            result.add(dataKnight.createChestArmor());
        }
        return result;
    }

    private List<Ammunition> createHelmet(List<Ammunition> result, int count){
        for (int i = 0; i < count; i++) {
            result.add(dataKnight.createHelmet());
        }
        return result;
    }

    private List<Ammunition> createShield(List<Ammunition> result, int count){
        for (int i = 0; i < count; i++) {
            result.add(dataKnight.createShield());
        }
        return result;
    }

    private List<Ammunition> createWeapon(List<Ammunition> result, int count){
        for (int i = 0; i < count; i++) {
            result.add(dataKnight.createWeapon());
        }
        return result;
    }

    @Override
    public String calculateTotalCostOfAmmunition() {
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
    public void sortAmmunition(Comparator<Ammunition> comparator) {
        Collections.sort(knight.getInventory(), comparator);
    }

    @Override
    public List<Ammunition> findItemsOfAmmunitionInPriceDiapason(double lowerPrice, double topPrice) {
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
}
