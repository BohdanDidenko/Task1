package com.epam.project1.model.ammunition.armor;

public class Helmet extends Armor {
    private boolean isHelmetOpen;

    public Helmet() {
    }

    public Helmet(double weight, double cost, Rarity rarityLevel, int protection, boolean isHelmetOpen) {
        super(weight, cost, rarityLevel, protection);
        this.isHelmetOpen = isHelmetOpen;
    }

    public boolean isHelmetOpen() {
        return isHelmetOpen;
    }

    public void setHelmetOpen(boolean helmetOpen) {
        isHelmetOpen = helmetOpen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Helmet)) return false;
        if (!super.equals(o)) return false;

        Helmet helmet = (Helmet) o;

        return isHelmetOpen() == helmet.isHelmetOpen();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (isHelmetOpen() ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Helmet{" +
                "isHelmetOpen=" + isHelmetOpen +
                '}';
    }
}
