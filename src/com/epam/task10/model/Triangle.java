package com.epam.task10.model;

import com.epam.task10.model.entity.Shape;

public class Triangle extends Shape {

    private int width;
    private int height;

    public Triangle() {
    }

    public Triangle(String shapeColor, int width, int height) {
        super(shapeColor);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public double calcArea() {
        return (width*height)/2;
    }

    @Override
    public String toString() {
//        return super.toString() +
//                "height=" + height + '\'' +
//                "width=" + width + '\'' +
//                '}';
        return super.toString() + String.format("height:%-2s width:%-2s", height, width);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        if (!super.equals(o)) return false;

        Triangle triangle = (Triangle) o;

        if (getWidth() != triangle.getWidth()) return false;
        return getHeight() == triangle.getHeight();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getWidth();
        result = 31 * result + getHeight();
        return result;
    }
}
