package com.epam.task4.Task4_2;

import com.epam.task2.task2_2.model.Circle;
import com.epam.task2.task2_2.model.Rectangle;
import com.epam.task2.task2_2.model.Triangle;
import com.epam.task2.task2_2.model.entity.Shape;
import com.epam.task2.task2_2.service.ShapesService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

public class ShapeTest {
    private static ShapesService service;
    @Parameterized.Parameter
    public Class<Circle> arrayType;
//    @Parameterized.Parameter(1)
//    public Class<Rectangle> rectangleType = Rectangle.class;
//    @Parameterized.Parameter(2)
//    public Class<Triangle> triangleType = Triangle.class;
    @Parameterized.Parameter(1)
    public String[] shapeArea;
    @Parameterized.Parameter(2)
    public String totalShapesArea = "1203,21";
    public Shape[] sortShapesByIncreasingAreaOfFigures = DataSourceForShapes.getSortShapesByIncreasingAreaOfFigures();
    public Shape[] sortShapesByColorOfFigures = DataSourceForShapes.getSortShapesByColorOfFigures();


//    @Parameterized.Parameter(3)
//    public String totalShapesArea;
//    @Parameterized.Parameter(4)
//    public String totalCirclesArea;
//    @Parameterized.Parameter(5)
//    public String totalRectanglesArea;
//    @Parameterized.Parameter(6)
//    public String totalTrianglesArea;

    @BeforeClass
    public static void init() {
        service = new ShapesService();
        service.setShapes(DataSourceForShapes.getShapes());
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {Circle.class, "892,19"},
                {Rectangle.class, "146,00"},
                {Triangle.class, "173,50"}
        });
    }

    @Test
    public void testCalculateTotalArea(){
        Assert.assertEquals(totalShapesArea, service.calculateTotalArea());
    }

    @Test
    public void testCalculateTotalAreaSelectedFigure(){
        Assert.assertEquals(shapeArea, service.calculateTotalArea(arrayType));
    }

    @Test
    public void testSortByIncreasingAreaOfFigures(){
        service.sortByIncreasingAreaOfFigures();
        Assert.assertEquals(sortShapesByIncreasingAreaOfFigures, service.getShapes());
    }

    @Test
    public void testSortByColorOfFigures(){
        service.sortByColorOfFigures();
        Assert.assertArrayEquals(sortShapesByColorOfFigures, service.getShapes());
    }
}
