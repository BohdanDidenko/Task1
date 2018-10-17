package com.epam.task3.task3_1.model.entity;

public class Puzzles extends KidsToy {
    private String theme;
    private int amountOfElements;

    public Puzzles() {
    }

    public Puzzles(String title, String manufacturer, String material, double price, int warrantyDays, int packingWidth,
                   int packingHeight, String ageGroup, String theme, int amountOfElements) {
        super(title, manufacturer, material, price, warrantyDays, packingWidth, packingHeight, ageGroup);
        this.theme = theme;
        this.amountOfElements = amountOfElements;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
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
                "theme='" + theme + '\'' +
                ", amountOfElements=" + amountOfElements +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Puzzles)) return false;
        if (!super.equals(o)) return false;

        Puzzles puzzles = (Puzzles) o;

        if (getAmountOfElements() != puzzles.getAmountOfElements()) return false;
        return getTheme() != null ? getTheme().equals(puzzles.getTheme()) : puzzles.getTheme() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getTheme() != null ? getTheme().hashCode() : 0);
        result = 31 * result + getAmountOfElements();
        return result;
    }
}
