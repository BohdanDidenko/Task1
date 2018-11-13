package com.epam.task6.model;

import com.epam.task6.model.entity.Shape;

/**
 * Класс описывающий строение круга
 */

public class Circle extends Shape {

    /**
     * Поле отвечающие за размер круга
     */
    private int radius;

    /**
     * Конструктор построения объекта по умолчанию
     */
    public Circle() {
    }

    /**
     * Конструктор построения объекта инициализирующий
     * его поля значениями полученными в параметрах.
     *
     * @param shapeColor - параметр для конструктора суперкласса
     * @param radius - радиус круга
     */
    public Circle(String shapeColor, int radius) {
        super(shapeColor);
        this.radius = radius;
    }

    /**
     * Метод возвращающий значение поля radius
     *
     * @return radius - радиус круга
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Метод устанавливающий значение поля radius
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * Метод вычисления площади круга
     *
     * @return result - площадь круга
     */
    @Override
    public double calcArea() {
        return Math.PI * (radius * radius);
    }

    /**
     * Метод отображения объекта в консоли
     *
     * @return result - имя объекта и значение всех его полей
     */
    @Override
    public String toString() {
        return super.toString() +
                "Area=" + radius + '\'' +
                '}';
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
