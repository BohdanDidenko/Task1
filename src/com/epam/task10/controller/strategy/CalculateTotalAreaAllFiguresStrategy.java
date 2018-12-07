package com.epam.task10.controller.strategy;

public class CalculateTotalAreaAllFiguresStrategy extends Strategy {
    @Override
    public String execute() {
        return String.valueOf(service.calculateTotalArea());
    }
}
