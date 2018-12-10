package com.epam.task11.task11_2.controller.strategy;

import java.io.IOException;

public class SaveAndExitStrategy extends Strategy {
    @Override
    public String execute() throws IOException {
        service.saveShapes();
        System.exit(0);
        return null;
    }
}
