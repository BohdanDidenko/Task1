package com.epam.task4.Task4_2.entity;

import com.epam.task2.task2_2.model.Rectangle;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

public class RectangleTest {
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
                {"Red", 5, 15, 75},
                {"Green", 7, 10, 70},
                {"Blue", 12, 30, 360}
        });
    }

    @Test
    public void testCalcArea(){
        Assert.assertEquals(new Rectangle(color, width, height).calcArea(), area, 0.0001);
    }
}
