package com.epam.task4.Task4_2;

import com.epam.task2.task2_2.model.Circle;
import com.epam.task2.task2_2.model.Rectangle;
import com.epam.task2.task2_2.model.Triangle;
import com.epam.task2.task2_2.model.entity.Shape;
import com.epam.task2.task2_2.service.ShapesService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ShapeTest {
    private static ShapesService service;
    private static String totalShapesArea;
    private static Shape[] sortShapesByIncreasingAreaOfFigures;
    private static Shape[] sortShapesByColorOfFigures;

    @Parameterized.Parameter
    public Class<Circle> arrayType;
    @Parameterized.Parameter(1)
    public String shapeArea;

    @BeforeClass
    public static void init() {
        service = new ShapesService();
        service.setShapes(DataSourceForShapesTest.getShapes());
        totalShapesArea = "1090,11";
        sortShapesByIncreasingAreaOfFigures = DataSourceForShapesTest.getSortShapesByIncreasingAreaOfFigures();
        sortShapesByColorOfFigures = DataSourceForShapesTest.getSortShapesByColorOfFigures();
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {Circle.class, "779,11"},
                {Rectangle.class, "138,00"},
                {Triangle.class, "173,00"}
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
        Assert.assertArrayEquals(sortShapesByIncreasingAreaOfFigures, service.getShapes());
    }

    @Test
    public void testSortByColorOfFigures(){
        service.sortByColorOfFigures();
        Assert.assertArrayEquals(sortShapesByColorOfFigures, service.getShapes());
    }
}
