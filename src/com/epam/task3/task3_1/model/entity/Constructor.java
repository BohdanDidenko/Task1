package com.epam.task3.task3_1.model.entity;

public class Constructor extends KidsToy {
    private String designerSeries;
    private int amountOfElements;

    public Constructor() {
    }

    public Constructor(String title, String manufacturer, String material, double price, int warrantyDays,
                       int packingWidth, int packingHeight, String ageGroup, String designerSeries, int amountOfElements) {
        super(title, manufacturer, material, price, warrantyDays, packingWidth, packingHeight, ageGroup);
        this.designerSeries = designerSeries;
        this.amountOfElements = amountOfElements;
    }

    public String getDesignerSeries() {
        return designerSeries;
    }

    public void setDesignerSeries(String designerSeries) {
        this.designerSeries = designerSeries;
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
                "designerSeries='" + designerSeries + '\'' +
                ", amountOfElements=" + amountOfElements +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Constructor)) return false;
        if (!super.equals(o)) return false;

        Constructor that = (Constructor) o;

        if (getAmountOfElements() != that.getAmountOfElements()) return false;
        return getDesignerSeries() != null ? getDesignerSeries().equals(that.getDesignerSeries()) : that.getDesignerSeries() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getDesignerSeries() != null ? getDesignerSeries().hashCode() : 0);
        result = 31 * result + getAmountOfElements();
        return result;
    }
}
