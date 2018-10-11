package com.epam.task2.task2_2.model.entity;

/**
 * Класс описывающий строение фигуры
 */

public abstract class Shape implements Drawable{

    /**
     * Поле хранящее значение цвета фигуры
     */
    private String shapeColor;

    /**
     * Конструктор построения объекта по умолчанию
     */
    public Shape() {
    }

    /**
     * Конструктор построения объекта инициализирующий
     * поле shapeColor значением полученным в параметрах
     *
     * @param shapeColor - цвет фигуры
     */
    public Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    /**
     * Метод возвращающий значение поля shapeColor
     *
     * @return shapeColor - цвет фигуры
     */
    public String getShapeColor() {
        return shapeColor;
    }

    /**
     * Метод устанавливающий значение поля shapeColor
     *
     * @param shapeColor - цвет фигуры
     */
    public void setShapeColor(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    /**
     * Абстрактный метод расчета площади фигуры
     *
     * @return result - площадь фигуры
     */
    public abstract double calcArea();

    /**
     * Метод отображения фигуры
     */
    @Override
    public void draw() {
        System.out.println("This is " + this.getClass().getSimpleName());
    }

    /**
     * Метод отвечающий за отображение объекта в консоли
     *
     * @return result - имя объекта и значение всех его полей
     */
    @Override
    public String toString() {
        return "Shape{" +
                "shapeColor='" + shapeColor + '\'' +
                '}';
    }
}