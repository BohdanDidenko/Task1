package com.epam.project1.model.entity.armor;

import com.epam.project1.model.entity.Rarity;

public class ChestArmor extends Armor {
    private int ProtectionAgainstFire;

    public ChestArmor() {
    }

    public ChestArmor(double weight, double cost, Rarity rarityLevel, int protection, int protectionAgainstFire) {
        super(weight, cost, rarityLevel, protection);
        ProtectionAgainstFire = protectionAgainstFire;
    }

    public int getProtectionAgainstFire() {
        return ProtectionAgainstFire;
    }

    public void setProtectionAgainstFire(int protectionAgainstFire) {
        ProtectionAgainstFire = protectionAgainstFire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChestArmor)) return false;
        if (!super.equals(o)) return false;

        ChestArmor that = (ChestArmor) o;

        return getProtectionAgainstFire() == that.getProtectionAgainstFire();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getProtectionAgainstFire();
        return result;
    }

    @Override
    public String toString() {
        return "ChestArmor{" +
                "ProtectionAgainstFire=" + ProtectionAgainstFire +
                '}';
    }
}
