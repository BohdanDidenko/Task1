package com.epam.project1.model.ammunition.weapon;

public class Dagger extends Weapon {
    private Poison poisonDagger;

    public Dagger() {
    }

    public Dagger(double weight, double cost, Rarity rarityLevel, int damage, int size, Poison poisonDagger) {
        super(weight, cost, rarityLevel, damage, size);
        this.poisonDagger = poisonDagger;
    }

    public Poison getPoisonDagger() {
        return poisonDagger;
    }

    public void setPoisonDagger(Poison poisonDagger) {
        this.poisonDagger = poisonDagger;
    }

    public enum Poison {
        SLEEPY_SEA_SPLASHES,
        CANIAN_LEPROSY,
        DWARF_MUTTER,
        LILY_BLOOD,
        DRYAD_POLLEN,
        DRUNK_DORALICE,
        DIVIDED_EMPIRE,
        NONE
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dagger)) return false;
        if (!super.equals(o)) return false;

        Dagger dagger = (Dagger) o;

        return getPoisonDagger() == dagger.getPoisonDagger();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getPoisonDagger() != null ? getPoisonDagger().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Dagger{" +
                "poisonDagger=" + poisonDagger +
                '}';
    }
}
