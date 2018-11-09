package com.epam.task7.task7_2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Runner {
    public void run() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> clazz = UnaryOperation.class;
        Constructor constructor = clazz.getConstructor();
        UnaryOperation unaryOperation = (UnaryOperation) clazz.newInstance();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if(method.getName().startsWith("set")) {
                method.invoke(unaryOperation, 0.0);
                System.out.println(unaryOperation);
            }
            if(method.getName().startsWith("inc")){
                method.invoke(unaryOperation);
                System.out.println(unaryOperation);
            }
        }
    }
}
