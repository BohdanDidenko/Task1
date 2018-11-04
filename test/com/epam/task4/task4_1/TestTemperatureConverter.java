package com.epam.task4.task4_1;

import com.epam.task4.task4_1.TemperatureConverter;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestTemperatureConverter {
    private static TemperatureConverter converter;
    @Parameterized.Parameter
    public double temperatureC;
    @Parameterized.Parameter(1)
    public double temperatureK;
    @Parameterized.Parameter(2)
    public double temperatureF;

    //Инициализация переменных осуществляется через конструктор и приват поля, или через  @Parameterized.Parameter и паблик поля
//    public TestTemperatureConverter(double temperatureC, double temperatureK, double temperatureF) {
//        this.temperatureC = temperatureC;
//        this.temperatureK = temperatureK;
//        this.temperatureF = temperatureF;
//    }

    @BeforeClass
    public static void init() {
        converter = new TemperatureConverter();
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList( new Object[][] {
                {0.0, 273.2, 32.0},
                { -100, 173.2, -148.0},
                { -273.2, 0, -459.76},
                { 273.2, 546.4, 523.76}
        });
    }

    @Test
    public void testConvertCtoK() {
        double result = converter.convertCtoK(temperatureC);
        Assert.assertEquals(temperatureK, result, 0.0001);
    }

    @Test
    public void testConvertKtoC(){
        double result = converter.convertKtoC(temperatureK);
        Assert.assertEquals(temperatureC, result, 0.0001);
    }
}
