package com.epam.task4.Task4_2.entity;

import com.epam.task2.task2_2.model.Circle;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class CircleTest {
    @Parameterized.Parameter
    public String color;
    @Parameterized.Parameter(1)
    public int radius;
    @Parameterized.Parameter(2)
    public double area;

    @Parameterized.Parameters
    public static Collection dataSource() {
        return Arrays.asList(new Object[][]{
                {"Red", 5, 78.54},
                {"Green", 7, 153.938},
                {"Blue", 9, 254.469}
        });
    }

    @Test
    public void testCalcArea(){
        Assert.assertEquals(new Circle(color, radius).calcArea(), area, 0.0001);
    }
}
