package com.epam.task9.util;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;
    private ResourceBundle resourceBundle;
    private final String RESOURCE_NAME = "com.epam.task9.resource.location.text";

    ResourceManager(){
        resourceBundle = ResourceBundle.getBundle(RESOURCE_NAME, Locale.getDefault());
    }

    public void changeResource(Locale locale){
        resourceBundle = ResourceBundle.getBundle(RESOURCE_NAME, locale);
    }

    public String getString(String key){
        return resourceBundle.getString(key);
    }
}
