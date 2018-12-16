package com.epam.task11.task11_1;

import java.util.List;

public interface Dao<E> {
    List<E> getListAllEmployees();
    List<E> getListAllTasks();
    List<E> getListEmployeesByDepartment(String department);
    List<E> getListTaskByEmployees(String employeeName);
    void addTaskToEmployee(String employeeName, String task);
    void close();
}
