package com.epam.task4.Task4_2;

import com.epam.task2.task2_2.model.Circle;
import com.epam.task2.task2_2.model.Rectangle;
import com.epam.task2.task2_2.model.Triangle;
import com.epam.task2.task2_2.model.entity.Shape;

public class DataSourceForShapes {
    public static Shape[] getShapes(){
        return new Shape[]{
                new Circle("Green", 10),
                new Rectangle("Pink", 6, 2),
                new Rectangle("Blue", 14, 9),
                new Circle("Orange", 12),
                new Triangle("Brown", 22, 11),
                new Circle("Green", 6),
                new Triangle("White", 15, 7),
                new Circle("Red", 2)
        };
    }

    public static Shape[] getSortShapesByIncreasingAreaOfFigures(){
        return new Shape[]{
                new Rectangle("Pink", 6, 2),
                new Triangle("White", 15, 7),
                new Rectangle("Blue", 14, 9),
                new Triangle("Brown", 22, 11),
                new Circle("Red", 2),
                new Circle("Green", 6),
                new Circle("Green", 10),
                new Circle("Orange", 12),
        };
    }

    public static Shape[] getSortShapesByColorOfFigures(){
        return new Shape[]{
                new Circle("Blue", 10),
                new Rectangle("Brown", 6, 2),
                new Rectangle("Green", 14, 9),
                new Circle("Green", 12),
                new Triangle("Orange", 22, 11),
                new Circle("Pink", 6),
                new Triangle("Red", 15, 7),
                new Circle("White", 2)
        };
    }
}
