package com.epam.task5.task5_1.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainMenuController extends Controller {

    public void run(){
        mainMenu();
}

    private enum MainMenu{
        SHOW_CURRENT_JOURNAL,
        ADD_NEW_RECORD_INTO_JOURNAL,
        EXIT
    }

    protected void mainMenu() {
        while (true) {
            try {
                MainMenu choice = getUserChoice(MainMenu.values(), view.MAIN_MENU);
                view.getRequestFromUser().nextLine();
                switch (choice) {
                    case SHOW_CURRENT_JOURNAL: {
                        resultHandler(model.getStudentRecord());
                        break;
                    }
                    case ADD_NEW_RECORD_INTO_JOURNAL: {
                        String studentName = addItemRecord(view.ENTER_STUDENT_NAME,
                                service.getClass().getMethod("createRecordStudentName", String.class));
                        String studentSecondName = addItemRecord(view.ENTER_STUDENT_SECOND_NAME,
                                service.getClass().getMethod("createRecordStudentSecondName", String.class));
                        String dateOfBirth = addItemRecord(view.ENTER_DATE_OF_BIRTH,
                                service.getClass().getMethod("createRecordStudentDateOfBirth", String.class))
                                .replaceAll("[ .-]", "/");
                        String phoneNumber = addItemRecord(view.ENTER_PHONE_NUMBER,
                                service.getClass().getMethod("createRecordStudentPhoneNumber", String.class));
                        String homeAddress = addItemRecord(view.ENTER_HOME_ADDRESS,
                                service.getClass().getMethod("createRecordStudentHomeAddress", String.class));
                        service.addNewRecordIntoCuratorJournal(model, studentName, studentSecondName,
                                dateOfBirth, phoneNumber, homeAddress);
                        break;
                    }
                    case EXIT: { System.exit(0); }
                }
            }
            catch (Exception e){ view.showMessage(view.WRONG_INPUT); }
        }
    }

    private String addItemRecord(String message, Method method){
        String result;
        String stringForCheck;
        while (true){
            view.showMessage(message);
            stringForCheck = view.getRequestFromUser().nextLine();
            try {
                result = (String) method.invoke(service, stringForCheck);
                return result;
            } catch (IllegalAccessException | InvocationTargetException e) {
                view.showMessage(view.WRONG_INPUT);
            }
        }
    }
}