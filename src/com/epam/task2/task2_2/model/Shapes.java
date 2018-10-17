package com.epam.task2.task2_2.model;

import com.epam.task2.task2_2.model.entity.Shape;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Класс Shapes предоставляет данные и реагирует на команды контроллера,
 * изменяя своё состояние
 */

public class Shapes {

    /**
     * Поле хранящие массив объектов класса Shape
     */
    private Shape[] shapes;

    /**
     * Поле Comparator сортирующий объекты класс Shape по их цвету в алфавитном порядке
     */
    private Comparator<Shape> shapeColorComparator = new Comparator<Shape>() {
        @Override
        public int compare(Shape o1, Shape o2) {
            return o1.getShapeColor().compareTo(o2.getShapeColor());
        }
    };

    /**
     * Поле Comparator сортирующий объекты класс Shape по размеру их площади
     * от меньшего к большему
     */
    private Comparator<Shape> shapeAreaComparator = new Comparator<Shape>() {
        @Override
        public int compare(Shape o1, Shape o2) {
            return (int) (o1.calcArea() - o2.calcArea());
        }
    };

    /**
     * Метод возвращает ссылку на массив shapes
     *
     * @return shapes - массив объектов класса Shape
     */
    public Shape[] getShapes() { return shapes; }

    /**
     * Метод устанавливает значение переменной shapes
     *
     * @param shapes - массив объектов класса Shape
     */
    public void setShapes(Shape[] shapes) { this.shapes = shapes; }

    /**
     * Метод возвращает объект класса Comparator, который сортирующий объекты класс Shape
     * по их цвету в алфавитном порядке
     *
     * @return shapeColorComparator
     */
    public Comparator<Shape> getShapeColorComparator() {
        return shapeColorComparator;
    }

    /**
     * Метод возвращает объект класса Comparator, который сортирующий объекты класс Shape
     * по размеру их площади от меньшего к большему
     *
     * @return shapeAreaComparator
     */
    public Comparator<Shape> getShapeAreaComparator() {
        return shapeAreaComparator;
    }

    /**
     * Метод суммирует и возвращает общую площадь всех фигур
     * полученных в массиве shapes
     *
     * @return result - полученный результат
     */
    public String calculateTotalArea(){
        double result = 0;
        for (int i = 0; i < shapes.length; i++) {
            result += shapes[i].calcArea();
        }
        return String.format("%.2f", result);
    }

    /**
     * Метод суммирует и возвращает общую площадь фигур определенного
     * типа полученного в параметрах метода
     *
     * @param shape - тип конкретной фигуры
     * @return result - полученный результат
     */
    public String calculateTotalArea(Shape shape){
        double result = 0;
        for (int i = 0; i < shapes.length; i++) {
            if(shapes[i].getClass() == shape.getClass())
                result += shapes[i].calcArea();
        }
        return String.format("%.2f", result);
    }

    /**
     * Метод отвечающий за сортировку данных в массиве shapes
     *
     * @param comparator - объект описывающий правила сортировки
     */
    public void sort(Comparator<Shape> comparator){
        Arrays.sort(shapes, comparator);
    }
}
