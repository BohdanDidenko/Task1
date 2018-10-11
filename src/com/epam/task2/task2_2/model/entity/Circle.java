package com.epam.task2.task2_2.model.entity;

import java.text.DecimalFormat;

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
        return Math.PI * 2 * radius;
    }

    /**
     * Метод отображения объекта в консоли
     *
     * @return result - имя объекта и значение всех его полей
     */
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "Color='" + this.getShapeColor() + '\'' +
                "Area=" + new DecimalFormat("#0.00").format(this.calcArea()) + '\'' +
                '}';
    }
}
