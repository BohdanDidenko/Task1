package com.epam.task5.task5_1.service;

import com.epam.task5.task5_1.model.CuratorJournal;
import com.epam.task5.task5_1.model.entity.StudentRecord;

import java.io.IOException;

public class JournalService implements Service {
    @Override
    public void addNewRecordIntoCuratorJournal(CuratorJournal curatorJournal, String studentName,
                                               String studentSecondName, String dateOfBirth, String phoneNumber, String homeAddress) {
        curatorJournal.getStudentRecord().add(new StudentRecord(studentName, studentSecondName,
                dateOfBirth, phoneNumber, homeAddress));
    }

    @Override
    public String createRecordStudentName(String studentName) throws IOException {
        if (studentName.matches("^[A-Z][\\p{L} .'-]+$"))
            return studentName;
        else throw new IOException();
    }

    @Override
    public String createRecordStudentSecondName(String studentSecondName) throws IOException {
        if (studentSecondName.matches("^[A-Z][\\p{L} .'-]+$"))
            return studentSecondName;
        else throw new IOException();
    }

    @Override
    public String createRecordStudentDateOfBirth(String dateOfBirth) throws IOException {
        if (dateOfBirth.matches("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$"))
            return dateOfBirth;
        else throw new IOException();
    }

    @Override
    public String createRecordStudentPhoneNumber(String phoneNumber) throws IOException {
        if (phoneNumber.matches("^((8|\\+38)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)[\\d\\- ]{7,10}$"))
            return phoneNumber;
        else throw new IOException();
    }

    @Override
    public String createRecordStudentHomeAddress(String homeAddress) throws IOException {
        return homeAddress;
    }
}