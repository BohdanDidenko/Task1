package com.epam.task5.task5_3.controller;

import com.epam.task5.task5_3.dao.Dao;
import com.epam.task5.task5_3.dao.VocabularyDao;
import com.epam.task5.task5_3.model.Vocabulary;
import com.epam.task5.task5_3.service.Service;
import com.epam.task5.task5_3.service.VocabularyService;
import com.epam.task5.task5_3.veiw.ConsoleView;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

public abstract class Controller {
    protected static ConsoleView view = new ConsoleView();
    protected static Vocabulary model;
    protected static Service<Vocabulary, String> service = new VocabularyService();
    protected static Dao dao = new VocabularyDao();

    protected  <E>E getUserChoice(E[] elements, String message){
        while (true) {
            view.showMessage(message);
            if (view.getRequestFromUser().hasNextInt())
                return elements[view.getRequestFromUser().nextInt()-1];
            else {
                view.showMessage(view.WRONG_INPUT);
                view.getRequestFromUser().next();
            }
        }
    }

    protected void resultHandler(String result) {
        if (result != null && !result.equals(""))
            view.showMessage(result);
        else
            view.showMessage(view.NO_RESULT);
    }

    protected void resultHandler(Map<String, String> result) {
        Iterator<Map.Entry<String, String>> iterator = result.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> pair = iterator.next();
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + " - " + value);
        }
    }
}
