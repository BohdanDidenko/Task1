package com.epam.task11.task11_2.model.data;

import com.epam.task11.task11_2.model.Circle;
import com.epam.task11.task11_2.model.Rectangle;
import com.epam.task11.task11_2.model.entity.Shape;
import com.epam.task11.task11_2.model.Triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataSource {

    public static List<Shape> getShapes(){
        List<Shape> list = new ArrayList<Shape>();
        list.add(new Circle("Blue", 7));
        list.add(new Rectangle("Yellow", 10, 5));
        list.add(new Rectangle("Green", 7, 4));
        list.add(new Triangle("Brown", 5, 3));
        list.add(new Circle("White", 8));
        list.add(new Rectangle("Red", 12, 4));
        list.add(new Triangle("Orange", 8, 7));
        list.add(new Circle("Pink", 5));
        list.add(new Triangle("Blue", 7, 7));
        list.add(new Circle("Green", 4));
        return list;
    }
}
