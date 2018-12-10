package com.epam.task11.task11_2.model;

import com.epam.task11.task11_2.model.entity.Shape;

public class Circle extends Shape {

    private int radius;

    public Circle() {
    }

    public Circle(String shapeColor, int radius) {
        super(shapeColor);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public double calcArea() {
        return Math.PI * (radius * radius);
    }

    @Override
    public String toString() {
//        return super.toString() +
//                "Area=" + radius + '\'' +
//                '}';
        return super.toString() + String.format("Area:%-2s", radius);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        if (!super.equals(o)) return false;

        Circle circle = (Circle) o;

        return getRadius() == circle.getRadius();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getRadius();
        return result;
    }
}
