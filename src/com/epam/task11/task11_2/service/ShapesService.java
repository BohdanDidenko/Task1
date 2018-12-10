package com.epam.task11.task11_2.service;

import com.epam.task11.task11_2.dao.Dao;
import com.epam.task11.task11_2.dao.ShapesDao;
import com.epam.task11.task11_2.exception.UnExistItemMenu;
import com.epam.task11.task11_2.model.data.DataSource;
import com.epam.task11.task11_2.model.entity.Shape;
import com.epam.task11.task11_2.service.Language;
import com.epam.task11.task11_2.service.Service;
import com.epam.task11.task11_2.util.ResourceManager;
import java.io.IOException;
import java.util.*;

public class ShapesService implements Service {

    private List<Shape> shapes;
    private Dao dao = new ShapesDao();
    private ResourceManager resourceManager = ResourceManager.INSTANCE;
    private Comparator<Shape> shapeColorComparator = (o1, o2) -> o1.getShapeColor().compareTo(o2.getShapeColor());
    private Comparator<Shape> shapeAreaComparator = (o1, o2) -> (int) (o1.calcArea() - o2.calcArea());

    public ShapesService() {
        shapes = dao.loadShapes();
//        shapes = DataSource.getShapes();
    }

    @Override
    public List<Shape> getShapes() { return shapes; }

    @Override
    public void setShapes(List<Shape> shapes) { this.shapes = shapes; }

    @Override
    public String calculateTotalArea(){
        double result = 0;
        for (int i = 0; i < shapes.size(); i++) {
            result += shapes.get(i).calcArea();
        }
        return String.format("%.2f", result);
    }

    @Override
    public <T>String calculateTotalArea(Class<T> type){
        double result = 0;
        for (int i = 0; i < shapes.size(); i++) {
            if(shapes.get(i).getClass() == type)
                result += shapes.get(i).calcArea();
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
    public void changeLanguare(int choise) throws UnExistItemMenu {
        resourceManager.changeLocale(defineLocale(choise));
    }

    private Locale defineLocale(int number) throws UnExistItemMenu {
        Language[] languares = Language.values();
        if (number <= 0 || number > languares.length) {
            throw new UnExistItemMenu(resourceManager.getMessage("WRONG_INPUT"));
        }
        return languares[number - 1].getLocale();
    }

    @Override
    public void saveShapes() throws IOException {
        dao.saveShapes(shapes);
    }

    private void sort(Comparator<Shape> comparator){
        Collections.sort(shapes, comparator);
    }
}
