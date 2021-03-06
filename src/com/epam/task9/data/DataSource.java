package com.epam.task9.data;

import com.epam.task9.model.Circle;
import com.epam.task9.model.Rectangle;
import com.epam.task9.model.Triangle;
import com.epam.task9.model.entity.Shape;

/**
 * Класс предоставляет массив объектов типа Shape
 */

public class DataSource {

    /**
     * Метод возвращает массив объектов типа Shape инициализированных
     * данными по умолчанию
     *
     * @return Shape[] - массив объектов типа Shape
     */
    public static Shape[] getShapes(){
        return new Shape[]{
                new Circle("Blue", 7),
                new Rectangle("Yellow", 10, 5),
                new Rectangle("Green", 7, 4),
                new Triangle("Brown", 5, 3),
                new Circle("White", 8),
                new Rectangle("Red", 12, 4),
                new Triangle("Orange", 8, 7),
                new Circle("Pink", 5),
                new Triangle("Blue", 7, 7),
                new Circle("Green", 4)
        };
    }
}
