package com.epam.task10.controller.strategy;

import com.epam.task10.exception.UnExistItemMenu;
import com.epam.task10.util.InputUtility;

public class ChangeLanguageStrategy extends Strategy {
    @Override
    public String execute() {
        view.showMessage(resourceManager.getMessage("LANGUAGE_MENU"));
        while (true) {
            try {
                service.changeLanguare(InputUtility.inputInt(view, resourceManager));
                break;
            } catch (UnExistItemMenu exp) {
                view.showErrorMessage(exp.getMessage());
            }
        }
        return null;
    }
}
