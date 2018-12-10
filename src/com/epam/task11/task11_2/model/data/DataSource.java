package com.epam.task11.task11_2.model.data;

import com.epam.task11.task11_2.model.Circle;
import com.epam.task11.task11_2.model.Rectangle;
import com.epam.task11.task11_2.model.entity.Shape;
import com.epam.task11.task11_2.model.Triangle;

public class DataSource {

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
