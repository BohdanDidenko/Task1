package com.epam.task3.task3_1.model.entity;

public class Car extends KidsToy {
    private String carType;
    private String carBrand;
    private int maxSpeed;

    public Car() {
    }

    public Car(String title, String manufacturer, String material, double price, int warrantyDays, int packingWidth,
               int packingHeight, String ageGroup, String carType, String carBrand, int maxSpeed) {
        super(title, manufacturer, material, price, warrantyDays, packingWidth, packingHeight, ageGroup);
        this.carType = carType;
        this.carBrand = carBrand;
        this.maxSpeed = maxSpeed;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return super.toString() +
                "carType='" + carType + '\'' +
                ", carBrand='" + carBrand + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        if (!super.equals(o)) return false;

        Car car = (Car) o;

        if (getMaxSpeed() != car.getMaxSpeed()) return false;
        if (getCarType() != null ? !getCarType().equals(car.getCarType()) : car.getCarType() != null) return false;
        return getCarBrand() != null ? getCarBrand().equals(car.getCarBrand()) : car.getCarBrand() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getCarType() != null ? getCarType().hashCode() : 0);
        result = 31 * result + (getCarBrand() != null ? getCarBrand().hashCode() : 0);
        result = 31 * result + getMaxSpeed();
        return result;
    }
}
