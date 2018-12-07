package com.epam.task10.service;

import com.epam.task10.dao.Dao;
import com.epam.task10.dao.ShapesDao;
import com.epam.task10.model.data.DataSource;
import com.epam.task10.model.entity.Shape;


import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class ShapesService implements Service {

    private Shape[] shapes;
    private Dao dao = new ShapesDao();
    private Comparator<Shape> shapeColorComparator = (o1, o2) -> o1.getShapeColor().compareTo(o2.getShapeColor());
    private Comparator<Shape> shapeAreaComparator = (o1, o2) -> (int) (o1.calcArea() - o2.calcArea());

    @Override
    public Shape[] getShapes() { return shapes; }

    @Override
    public void setShapes(Shape[] shapes) { this.shapes = shapes; }

    @Override
    public String calculateTotalArea(){
        double result = 0;
        for (int i = 0; i < shapes.length; i++) {
            result += shapes[i].calcArea();
        }
        return String.format("%.2f", result);
    }

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

    @Override
    public void loadShapes() throws IOException, ClassNotFoundException {
        shapes = dao.loadShapes();
    }

    @Override
    public void saveShapes() throws IOException {
        dao.saveShapes(shapes);
    }

    private void sort(Comparator<Shape> comparator){
        Arrays.sort(shapes, comparator);
    }
}
