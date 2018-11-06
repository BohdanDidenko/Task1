package com.epam.project1.model.ammunition.weapon;

public class Spear extends Weapon {
    private String tipMaterial;

    public Spear() {
    }

    public Spear(double weight, double cost, Rarity rarityLevel, int damage, int size, String tipMaterial) {
        super(weight, cost, rarityLevel, damage, size);
        this.tipMaterial = tipMaterial;
    }

    public String getTipMaterial() {
        return tipMaterial;
    }

    public void setTipMaterial(String tipMaterial) {
        this.tipMaterial = tipMaterial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Spear)) return false;
        if (!super.equals(o)) return false;

        Spear spear = (Spear) o;

        return getTipMaterial() != null ? getTipMaterial().equals(spear.getTipMaterial()) : spear.getTipMaterial() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getTipMaterial() != null ? getTipMaterial().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Spear{" +
                "tipMaterial='" + tipMaterial + '\'' +
                '}';
    }
}
