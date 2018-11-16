package com.epam.task5.task5_1.model;

import com.epam.task5.task5_1.model.entity.StudentRecord;
import java.util.LinkedList;
import java.util.List;

public class CuratorJournal {
    private List<StudentRecord> studentRecord = new LinkedList<>();

    public List<StudentRecord> getStudentRecord() {
        return studentRecord;
    }

    public void setStudentRecord(List<StudentRecord> studentRecord) {
        this.studentRecord = studentRecord;
    }
}
