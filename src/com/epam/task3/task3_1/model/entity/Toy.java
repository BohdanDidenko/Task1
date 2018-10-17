package com.epam.task3.task3_1.model.entity;

public abstract class Toy {
    private String title;
    private String manufacturer;
    private String material;
    private double price;
    private int warrantyDays;
    private int packingWidth ;
    private int packingHeight;

    public Toy() {
    }

    public Toy(String title, String manufacturer, String material,
               double price, int warrantyDays, int packingWidth, int packingHeight) {
        this.title = title;
        this.manufacturer = manufacturer;
        this.material = material;
        this.price = price;
        this.warrantyDays = warrantyDays;
        this.packingWidth = packingWidth;
        this.packingHeight = packingHeight;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getWarrantyDays() {
        return warrantyDays;
    }

    public void setWarrantyDays(int warrantyDays) {
        this.warrantyDays = warrantyDays;
    }

    public int getPackingWidth() {
        return packingWidth;
    }

    public void setPackingWidth(int packingWidth) {
        this.packingWidth = packingWidth;
    }

    public int getPackingHeight() {
        return packingHeight;
    }

    public void setPackingHeight(int packingHeight) {
        this.packingHeight = packingHeight;
    }

    public void toPlay(){
        System.out.println("Play with " + this.getClass().getSimpleName());
    }

    @Override
    public String toString() {
        return  this.getClass().getSimpleName() + "{" +
                "title='" + title + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", material='" + material + '\'' +
                ", price=" + price +
                ", warrantyDays=" + warrantyDays +
                ", packingWidth=" + packingWidth +
                ", packingHeight=" + packingHeight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Toy)) return false;

        Toy toy = (Toy) o;

        if (Double.compare(toy.getPrice(), getPrice()) != 0) return false;
        if (getWarrantyDays() != toy.getWarrantyDays()) return false;
        if (getPackingWidth() != toy.getPackingWidth()) return false;
        if (getPackingHeight() != toy.getPackingHeight()) return false;
        if (getTitle() != null ? !getTitle().equals(toy.getTitle()) : toy.getTitle() != null) return false;
        if (getManufacturer() != null ? !getManufacturer().equals(toy.getManufacturer()) : toy.getManufacturer() != null)
            return false;
        return getMaterial() != null ? getMaterial().equals(toy.getMaterial()) : toy.getMaterial() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getTitle() != null ? getTitle().hashCode() : 0;
        result = 31 * result + (getManufacturer() != null ? getManufacturer().hashCode() : 0);
        result = 31 * result + (getMaterial() != null ? getMaterial().hashCode() : 0);
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getWarrantyDays();
        result = 31 * result + getPackingWidth();
        result = 31 * result + getPackingHeight();
        return result;
    }
}
