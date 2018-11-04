package com.epam.project1.model.entity.armor;

import com.epam.project1.model.entity.Ammunition;
import com.epam.project1.model.entity.Rarity;

public abstract class Armor extends Ammunition {
    private int protection;

    public Armor() {
    }

    public Armor(double weight, double cost, Rarity rarityLevel, int protection) {
        super(weight, cost, rarityLevel);
        this.protection = protection;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Armor)) return false;
        if (!super.equals(o)) return false;

        Armor armor = (Armor) o;

        return getProtection() == armor.getProtection();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getProtection();
        return result;
    }

    @Override
    public String toString() {
        return "Armor{" +
                "protection=" + protection +
                '}';
    }
}
