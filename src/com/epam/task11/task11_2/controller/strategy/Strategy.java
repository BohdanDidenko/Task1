package com.epam.task11.task11_2.controller.strategy;

import com.epam.task11.task11_2.service.Service;
import com.epam.task11.task11_2.service.ShapesService;
import com.epam.task11.task11_2.util.ResourceManager;
import com.epam.task11.task11_2.view.ConsoleView;
import java.io.IOException;

public abstract class Strategy {
    protected static ConsoleView view = new ConsoleView();
    protected static Service service = new ShapesService();
    protected static ResourceManager resourceManager = ResourceManager.INSTANCE;

    public abstract String execute() throws IOException;
}
