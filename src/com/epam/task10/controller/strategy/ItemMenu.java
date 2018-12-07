package com.epam.task10.controller.strategy;

public enum ItemMenu {
    CALCULATE_TOTAL_AREA_OF_ALL_FIGURES(new CalculateTotalAreaAllFiguresStrategy()),
    CALCULATE_TOTAL_AREA_OF_ALL_CIRCLES(new CalculateTotalAreaAllCirclesStrategy()),
    CALCULATE_TOTAL_AREA_OF_ALL_TRIANGLES(new CalculateTotalAreaAllTrianglesStrategy()),
    CALCULATE_THE_TOTAL_AREA_OF_ALL_RECTANGLES(new CalculateTotalAreaAllRectanglesStrategy()),
    SORT_BY_INCREASING_AREA_OF_FIGURES(new SortByIncreasingAreaOfFiguresStrategy()),
    SORT_BY_COLOR_OF_FIGURES(new SortByColorOfFiguresStrategy()),
    CHANGE_LANGUAGE(new ChangeLanguageStrategy()),
    SAVE_AND_EXIT(new SaveAndExitStrategy());

    private Strategy command;
    ItemMenu(Strategy command) { this.command = command; }
    public Strategy getCommand() { return command; }
}
