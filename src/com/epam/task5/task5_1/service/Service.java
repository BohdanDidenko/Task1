package com.epam.task5.task5_1.service;

import com.epam.task5.task5_1.model.CuratorJournal;

import java.io.IOException;
import java.lang.reflect.Method;

public interface Service {
    void addNewRecordIntoCuratorJournal(CuratorJournal curatorJournal, String studentName, String studentSecondName,
                                        String dateOfBirth, String phoneNumber, String homeAddress);
    String createRecordStudentName(String studentName) throws IOException;
    String createRecordStudentSecondName(String studentSecondName) throws IOException;
    String createRecordStudentDateOfBirth(String dateOfBirth) throws IOException;
    String createRecordStudentPhoneNumber(String phoneNumber) throws IOException;
    String createRecordStudentHomeAddress(String homeAddress) throws IOException;

}
