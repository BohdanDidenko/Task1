package com.epam.task4.Task4_2.entity;

import com.epam.task2.task2_2.model.Triangle;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

public class TriangleTest {
    @Parameterized.Parameter
    public String color;
    @Parameterized.Parameter(1)
    public int width ;
    @Parameterized.Parameter(2)
    public int height;
    @Parameterized.Parameter(3)
    public double area;

    @Parameterized.Parameters
    public static Collection dataSource() {
        return Arrays.asList(new Object[][]{
                {"Red", 10, 8, 40},
                {"Green", 15, 20, 150},
                {"Blue", 20, 16, 160}
        });
    }

    @Test
    public void testCalcArea(){
        Assert.assertEquals(new Triangle(color, width, height).calcArea(), area, 0.0001);
    }
}
