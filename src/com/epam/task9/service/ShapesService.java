package com.epam.task9.service;

import com.epam.task9.model.entity.Shape;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Класс ShapesService предоставляет данные и реагирует на команды контроллера,
 * изменяя своё состояние
 */

public class ShapesService implements Service {

    /**
     * Поле хранящие массив объектов класса Shape
     */
    private Shape[] shapes;

    /**
     * Поле Comparator сортирующий объекты класс Shape по их цвету в алфавитном порядке
     */
    private Comparator<Shape> shapeColorComparator = (o1, o2) -> o1.getShapeColor().compareTo(o2.getShapeColor());

    /**
     * Поле Comparator сортирующий объекты класс Shape по размеру их площади
     * от меньшего к большему
     */
    private Comparator<Shape> shapeAreaComparator = (o1, o2) -> (int) (o1.calcArea() - o2.calcArea());

    /**
     * Метод возвращает ссылку на массив shapes
     *
     * @return shapes - массив объектов класса Shape
     */
    @Override
    public Shape[] getShapes() { return shapes; }

    /**
     * Метод устанавливает значение переменной shapes
     *
     * @param shapes - массив объектов класса Shape
     */
    @Override
    public void setShapes(Shape[] shapes) { this.shapes = shapes; }

    /**
     * Метод суммирует и возвращает общую площадь всех фигур
     * полученных в массиве shapes
     *
     * @return result - полученный результат
     */
    @Override
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
     * @param type - тип конкретной фигуры
     * @return result - полученный результат
     */
    @Override
    public <T>String calculateTotalArea(Class<T> type){
        double result = 0;
        for (int i = 0; i < shapes.length; i++) {
            if(shapes[i].getClass() == type)
                result += shapes[i].calcArea();
        }
        return String.format("%.2f", result);
    }

    @Override
    public void sortByIncreasingAreaOfFigures() {
        sort(shapeAreaComparator);
    }

    @Override
    public void sortByColorOfFigures() {
        sort(shapeColorComparator);
    }

    /**
     * Метод отвечающий за сортировку данных в массиве shapes
     *
     * @param comparator - объект описывающий правила сортировки
     */
    private void sort(Comparator<Shape> comparator){
        Arrays.sort(shapes, comparator);
    }
}
