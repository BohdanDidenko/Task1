package com.epam.task3.task3_1.model.entity;

public abstract class KidsToy extends Toy{
    private String ageGroup;

    public KidsToy() {
    }

    public KidsToy(String title, String manufacturer, String material, double price, int warrantyDays,
                   int packingWidth, int packingHeight, String ageGroup) {
        super(title, manufacturer, material, price, warrantyDays, packingWidth, packingHeight);
        this.ageGroup = ageGroup;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    @Override
    public String toString() {
        return super.toString() +
                "ageGroup='" + ageGroup + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KidsToy)) return false;
        if (!super.equals(o)) return false;

        KidsToy kidsToy = (KidsToy) o;

        return getAgeGroup() != null ? getAgeGroup().equals(kidsToy.getAgeGroup()) : kidsToy.getAgeGroup() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getAgeGroup() != null ? getAgeGroup().hashCode() : 0);
        return result;
    }
}
