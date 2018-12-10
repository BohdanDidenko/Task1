package com.epam.task11.task11_2.model.entity;

import java.io.Serializable;
import java.text.DecimalFormat;

public abstract class Shape implements Drawable, Serializable{

    private String shapeColor;

    public Shape() {
    }

    public Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public String getShapeColor() {
        return shapeColor;
    }

    public void setShapeColor(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public abstract double calcArea();

    @Override
    public void draw() {
        System.out.println("This is " + this.toString() + "{" +
                "shapeColor='" + shapeColor + '\'' + " " +
                "Area=" + new DecimalFormat("#0.00").format(this.calcArea()) + '\'' +
                '}');
    }

    @Override
    public String toString() {
//        return this.getClass().getSimpleName() + "{" +
//                "shapeColor='" + shapeColor + '\'' +
//                '}';
        return this.getClass().getSimpleName() +
                String.format("shapeColor:%-8s", shapeColor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shape)) return false;

        Shape shape = (Shape) o;

        return getShapeColor() != null ? getShapeColor().equals(shape.getShapeColor()) : shape.getShapeColor() == null;
    }

    @Override
    public int hashCode() {
        return getShapeColor() != null ? getShapeColor().hashCode() : 0;
    }
}