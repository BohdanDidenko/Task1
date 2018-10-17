package com.epam.task3.task3_1.model.entity;

public class ToyWeaponSet extends KidsToy {
    private String themeOfSet;
    private int amountOfElements;

    public ToyWeaponSet() {
    }

    public ToyWeaponSet(String title, String manufacturer, String material, double price, int warrantyDays, int packingWidth,
                        int packingHeight, String ageGroup, String themeOfSet, int amountOfElements) {
        super(title, manufacturer, material, price, warrantyDays, packingWidth, packingHeight, ageGroup);
        this.themeOfSet = themeOfSet;
        this.amountOfElements = amountOfElements;
    }

    public String getThemeOfSet() {
        return themeOfSet;
    }

    public void setThemeOfSet(String themeOfSet) {
        this.themeOfSet = themeOfSet;
    }

    public int getAmountOfElements() {
        return amountOfElements;
    }

    public void setAmountOfElements(int amountOfElements) {
        this.amountOfElements = amountOfElements;
    }

    @Override
    public String toString() {
        return super.toString() +
                "themeOfSet='" + themeOfSet + '\'' +
                ", amountOfElements=" + amountOfElements +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ToyWeaponSet)) return false;
        if (!super.equals(o)) return false;

        ToyWeaponSet that = (ToyWeaponSet) o;

        if (getAmountOfElements() != that.getAmountOfElements()) return false;
        return getThemeOfSet() != null ? getThemeOfSet().equals(that.getThemeOfSet()) : that.getThemeOfSet() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getThemeOfSet() != null ? getThemeOfSet().hashCode() : 0);
        result = 31 * result + getAmountOfElements();
        return result;
    }
}
