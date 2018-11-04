package com.epam.project1.model.entity;

import java.io.Serializable;

public abstract class Ammunition implements Serializable {
    private double weight;
    private double cost;
    private Rarity rarityLevel;

    public Ammunition() {
    }

    public Ammunition(double weight, double cost, Rarity rarityLevel) {
        this.weight = weight;
        this.cost = cost;
        this.rarityLevel = rarityLevel;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Rarity getRarityLevel() {
        return rarityLevel;
    }

    public void setRarityLevel(Rarity rarityLevel) {
        this.rarityLevel = rarityLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ammunition)) return false;

        Ammunition that = (Ammunition) o;

        if (Double.compare(that.getWeight(), getWeight()) != 0) return false;
        if (Double.compare(that.getCost(), getCost()) != 0) return false;
        return getRarityLevel() == that.getRarityLevel();
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getWeight());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getCost());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getRarityLevel() != null ? getRarityLevel().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ammunition{" +
                "weight=" + weight +
                ", cost=" + cost +
                ", rarityLevel=" + rarityLevel +
                '}';
    }
}
