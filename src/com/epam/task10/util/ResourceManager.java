package com.epam.task10.util;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;
    private ResourceBundle resourceBundle;
    private final String RESOURCE_NAME = "com.epam.task10.resource.location.text";

    ResourceManager(){
        resourceBundle = ResourceBundle.getBundle(RESOURCE_NAME, new Locale("en", "GB"));
    }

    public void changeLocale(Locale locale){
        resourceBundle = ResourceBundle.getBundle(RESOURCE_NAME, locale);
    }

    public String getMessage(String key){
        return resourceBundle.getString(key);
    }
}
