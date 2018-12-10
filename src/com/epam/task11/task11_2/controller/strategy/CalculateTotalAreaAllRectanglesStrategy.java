package com.epam.task11.task11_2.controller.strategy;

import com.epam.task11.task11_2.model.Rectangle;

public class CalculateTotalAreaAllRectanglesStrategy extends Strategy {
    @Override
    public String execute() {
        return service.calculateTotalArea(Rectangle.class);
    }
}
