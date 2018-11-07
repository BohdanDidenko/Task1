package com.epam.task2.task2_2.model;

import com.epam.task2.task2_2.model.entity.Shape;

/**
 * Класс описывающий строение прямоугольника
 */

public class Rectangle extends Shape {

    /**
     * Поля отвечающие за размер прямоугольника
     */
    private int width ;
    private int height;

    /**
     * Конструктор построения объекта по умолчанию
     */
    public Rectangle() {
    }

    /**
     * Конструктор построения объекта инициализирующий
     * его поля значениями полученными в параметрах.
     *
     * @param shapeColor - параметр для конструктора суперкласса
     * @param width - ширина прямоугольника
     * @param height - высота прямоугольника
     */
    public Rectangle(String shapeColor, int width, int height) {
        super(shapeColor);
        this.width = width;
        this.height = height;
    }

    /**
     * Метод возвращающий значение поля width
     *
     * @return width - ширина прямоугольника
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
     * @return height - высота прямоугольника
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
     * Метод расчета площади прямоугольника
     *
     * @return result - площадь прямоугольника
     */
    @Override
    public double calcArea() {
        return width * height;
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
