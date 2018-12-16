package com.epam.task11.task11_1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoImpl implements Dao<String>{
    ConnectionToDB connectionToDB = new ConnectionToDB();

    @Override
    public List<String> getListAllEmployees() {
        List<String> result = new ArrayList<>();
        try (PreparedStatement statement = connectionToDB.connection.prepareStatement("SELECT * FROM employees")){
            ResultSet resultSet = statement.executeQuery();
            int size = resultSet.getFetchSize();
            while (resultSet.next()) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 1; i <= size; i++) {
                    stringBuilder.append(resultSet.getString(i));
                }
                result.add(stringBuilder.toString());
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<String> getListAllTasks() {
        List<String> result = new ArrayList<>();
        try (PreparedStatement statement = connectionToDB.connection.prepareStatement("SELECT * FROM tasks")){
            ResultSet resultSet = statement.executeQuery();
            int size = resultSet.getFetchSize();
            while (resultSet.next()) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 1; i <= size; i++) {
                    stringBuilder.append(resultSet.getString(i));
                }
                result.add(stringBuilder.toString());
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<String> getListEmployeesByDepartment(String department) {
        List<String> result = new ArrayList<>();
        try (PreparedStatement statement = connectionToDB.connection.prepareStatement("SELECT * FROM tasks WHERE employee = ?")){
            statement.setString(1, department);
            ResultSet resultSet = statement.executeQuery();
            int size = resultSet.getFetchSize();
            while (resultSet.next()) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 1; i <= size; i++) {
                    stringBuilder.append(resultSet.getString(i));
                }
                result.add(stringBuilder.toString());
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<String> getListTaskByEmployees(String employeeName) {
        List<String> result = new ArrayList<>();
        try (PreparedStatement statement = connectionToDB.connection.prepareStatement("SELECT * FROM tasks WHERE employee = ?")){
            statement.setString(1, employeeName);
            ResultSet resultSet = statement.executeQuery();
            int size = resultSet.getFetchSize();
            while (resultSet.next()) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 1; i <= size; i++) {
                    stringBuilder.append(resultSet.getString(i));
                }
                result.add(stringBuilder.toString());
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void addTaskToEmployee(String task_description, String employee) {
        List<String> result = new ArrayList<>();
        try (PreparedStatement statement = connectionToDB.connection.prepareStatement("INSERT INTO tasks (task_description, employee) VALUES(?, ?, ?)")){
            statement.setString(2, task_description);
            statement.setString(3, employee);
            statement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        if(connectionToDB != null) {
            connectionToDB.close();
        }
    }
}
