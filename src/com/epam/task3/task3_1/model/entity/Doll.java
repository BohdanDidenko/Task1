package com.epam.task3.task3_1.model.entity;

public class Doll extends KidsToy {
    private String designerSeries;
    private boolean interactiveDoll;

    public Doll() {
    }

    public Doll(String title, String manufacturer, String material, double price, int warrantyDays, int packingWidth,
                int packingHeight, String ageGroup, String designerSeries, boolean interactiveDoll) {
        super(title, manufacturer, material, price, warrantyDays, packingWidth, packingHeight, ageGroup);
        this.designerSeries = designerSeries;
        this.interactiveDoll = interactiveDoll;
    }

    public String getDesignerSeries() {
        return designerSeries;
    }

    public void setDesignerSeries(String designerSeries) {
        this.designerSeries = designerSeries;
    }

    public boolean isInteractiveDoll() {
        return interactiveDoll;
    }

    public void setInteractiveDoll(boolean interactiveDoll) {
        this.interactiveDoll = interactiveDoll;
    }

    @Override
    public String toString() {
        return super.toString() +
                "designerSeries='" + designerSeries + '\'' +
                ", interactiveDoll=" + interactiveDoll +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doll)) return false;
        if (!super.equals(o)) return false;

        Doll doll = (Doll) o;

        if (isInteractiveDoll() != doll.isInteractiveDoll()) return false;
        return getDesignerSeries() != null ? getDesignerSeries().equals(doll.getDesignerSeries()) : doll.getDesignerSeries() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getDesignerSeries() != null ? getDesignerSeries().hashCode() : 0);
        result = 31 * result + (isInteractiveDoll() ? 1 : 0);
        return result;
    }
}
