package com.epam.task10.controller.strategy;

import com.epam.task10.service.Service;
import com.epam.task10.service.ShapesService;
import com.epam.task10.util.ResourceManager;
import com.epam.task10.view.ConsoleView;
import java.io.IOException;

public abstract class Strategy {
    protected static ConsoleView view = new ConsoleView();
    protected static Service service = new ShapesService();
    protected static ResourceManager resourceManager = ResourceManager.INSTANCE;

    public abstract String execute() throws IOException;
}
