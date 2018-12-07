package com.epam.task10.controller.strategy;

import java.io.IOException;

public class SaveAndExitStrategy extends Strategy {
    @Override
    public String execute() throws IOException {
        service.saveShapes();
        System.exit(0);
        return null;
    }
}
