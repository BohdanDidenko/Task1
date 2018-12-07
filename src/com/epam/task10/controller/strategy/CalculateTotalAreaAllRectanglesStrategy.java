package com.epam.task10.controller.strategy;

import com.epam.task10.model.Rectangle;

public class CalculateTotalAreaAllRectanglesStrategy extends Strategy {
    @Override
    public String execute() {
        return service.calculateTotalArea(Rectangle.class);
    }
}
