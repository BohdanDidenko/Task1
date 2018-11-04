package com.epam.project1.model.entity.armor;

import com.epam.project1.model.entity.Rarity;

public class Shield extends Armor {
    private int ProtectionAgainstArrows;
    private int ProtectionAgainstSuperHit;

    public Shield() {
    }

    public Shield(double weight, double cost, Rarity rarityLevel, int protection, int protectionAgainstArrows, int protectionAgainstSuperHit) {
        super(weight, cost, rarityLevel, protection);
        ProtectionAgainstArrows = protectionAgainstArrows;
        ProtectionAgainstSuperHit = protectionAgainstSuperHit;
    }

    public int getProtectionAgainstArrows() {
        return ProtectionAgainstArrows;
    }

    public void setProtectionAgainstArrows(int protectionAgainstArrows) {
        ProtectionAgainstArrows = protectionAgainstArrows;
    }

    public int getProtectionAgainstSuperHit() {
        return ProtectionAgainstSuperHit;
    }

    public void setProtectionAgainstSuperHit(int protectionAgainstSuperHit) {
        ProtectionAgainstSuperHit = protectionAgainstSuperHit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shield)) return false;
        if (!super.equals(o)) return false;

        Shield shield = (Shield) o;

        if (getProtectionAgainstArrows() != shield.getProtectionAgainstArrows()) return false;
        return getProtectionAgainstSuperHit() == shield.getProtectionAgainstSuperHit();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getProtectionAgainstArrows();
        result = 31 * result + getProtectionAgainstSuperHit();
        return result;
    }

    @Override
    public String toString() {
        return "Shield{" +
                "ProtectionAgainstArrows=" + ProtectionAgainstArrows +
                ", ProtectionAgainstSuperHit=" + ProtectionAgainstSuperHit +
                '}';
    }
}
