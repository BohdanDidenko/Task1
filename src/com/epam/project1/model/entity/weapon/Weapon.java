package com.epam.project1.model.entity.weapon;

import com.epam.project1.model.entity.Ammunition;
import com.epam.project1.model.entity.Rarity;

public class Weapon extends Ammunition {
    private int damage;
    private int size;

    public Weapon() {
    }

    public Weapon(double weight, double cost, Rarity rarityLevel, int damage, int size) {
        super(weight, cost, rarityLevel);
        this.damage = damage;
        this.size = size;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Weapon)) return false;
        if (!super.equals(o)) return false;

        Weapon weapon = (Weapon) o;

        if (getDamage() != weapon.getDamage()) return false;
        return getSize() == weapon.getSize();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getDamage();
        result = 31 * result + getSize();
        return result;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "damage=" + damage +
                ", size=" + size +
                '}';
    }
}
