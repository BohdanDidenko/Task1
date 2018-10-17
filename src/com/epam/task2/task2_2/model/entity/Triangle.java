package com.epam.task2.task2_2.model.entity;

/**
 * Класс описывающий строение треугольника
 */

public class Triangle extends Shape {

    /**
     * Поля отвечающие за размер треугольника
     */
    private int width;
    private int height;

    /**
     * Конструктор построения объекта по умолчанию
     */
    public Triangle() {
    }

    /**
     * Конструктор построения объекта инициализирующий
     * его поля значениями полученными в параметрах.
     *
     * @param shapeColor - параметр для конструктора суперкласса
     * @param width - ширина треугольника
     * @param height - высота треугольника
     */
    public Triangle(String shapeColor, int width, int height) {
        super(shapeColor);
        this.width = width;
        this.height = height;
    }

    /**
     * Метод возвращающий значение поля width
     *
     * @return width - ширина треугольника
     */
    public int getWidth() {
        return width;
    }

    /**
     * Метод устанавливающий значение поля width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Метод возвращающий значение поля height
     *
     * @return height - высота треугольника
     */
    public int getHeight() {
        return height;
    }

    /**
     * Метод устанавливающий значение поля height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Метод расчета площади треугольника
     *
     * @return result - площадь треугольника
     */
    @Override
    public double calcArea() {
        return (width*height)/2;
    }

    /**
     * Метод отображения объекта в консоли
     *
     * @return result - имя объекта и значение всех его полей
     */
    @Override
    public String toString() {
        return super.toString() +
                "height=" + height + '\'' +
                "width=" + width + '\'' +
                '}';
    }
}
