package com.epam.project1.model.entity.weapon;

import com.epam.project1.model.entity.Rarity;

public class Sword extends Weapon{
    private int superHit;

    public Sword() {
    }

    public Sword(double weight, double cost, Rarity rarityLevel, int damage, int size, int superHit) {
        super(weight, cost, rarityLevel, damage, size);
        this.superHit = superHit;
    }

    public int getSuperHit() {
        return superHit;
    }

    public void setSuperHit(int superHit) {
        this.superHit = superHit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sword)) return false;
        if (!super.equals(o)) return false;

        Sword sword = (Sword) o;

        return getSuperHit() == sword.getSuperHit();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getSuperHit();
        return result;
    }

    @Override
    public String toString() {
        return "Sword{" +
                "superHit=" + superHit +
                '}';
    }
}
