package com.epam.task11.task11_2.dao;

import com.epam.task11.task11_2.model.Circle;
import com.epam.task11.task11_2.model.Rectangle;
import com.epam.task11.task11_2.model.Triangle;
import com.epam.task11.task11_2.model.entity.Shape;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ShapesDao implements Dao {
    Connection connection;
    private ResourceBundle resourceBundle;
    private String path = "com.epam.task11.task11_2.resource.db";

    public ShapesDao() {
        resourceBundle = ResourceBundle.getBundle(path);
        try{
            connection = DriverManager.getConnection(resourceBundle.getString("url"),
                    resourceBundle.getString("user"), resourceBundle.getString("password"));
        }
        catch (SQLException e){
            //todo
        }
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public List<Shape> loadShapes() {
        List<Shape> result = new ArrayList<>();
        try(Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM shapes");
            while (resultSet.next()){
                switch (resultSet.getString(1)){
                    case "Circle":{
                        result.add(loadCircle(resultSet));
                        break;
                    }
                    case "Rectangle":{
                        result.add(loadRectangle(resultSet));
                        break;
                    }
                    case "Triangle":{
                        result.add(loadTriangle(resultSet));
                        break;
                    }
                }
            }
            return result;
        }
        catch (SQLException e){
            //todo
        }
        return null;
    }

    private Circle loadCircle(ResultSet resultSet) throws SQLException {
        Circle circle = new Circle();
        circle.setShapeColor(resultSet.getString(2));
        circle.setRadius(Integer.parseInt(resultSet.getString(5)));
        return circle;
    }

    private Rectangle loadRectangle(ResultSet resultSet) throws SQLException {
        Rectangle rectangle = new Rectangle();
        rectangle.setShapeColor(resultSet.getString(2));
        rectangle.setWidth(Integer.parseInt(resultSet.getString(3)));
        rectangle.setHeight(Integer.parseInt(resultSet.getString(4)));
        return rectangle;
    }

    private Triangle loadTriangle(ResultSet resultSet) throws SQLException {
        Triangle triangle = new Triangle();
        triangle.setShapeColor(resultSet.getString(2));
        triangle.setWidth(Integer.parseInt(resultSet.getString(3)));
        triangle.setHeight(Integer.parseInt(resultSet.getString(4)));
        return triangle;
    }

    @Override
    public void saveShapes(List<Shape> shapes) throws IOException {
        try(PreparedStatement statement = connection.prepareStatement("INSERT INTO shapes " +
                "(typeShape, shapeColor, width, height, radius) " + "VALUES (?, ?, ?, ?, ?)")) {
            for (Shape shape : shapes) {
                switch (shape.getClass().getSimpleName()){
                    case "Circle":{
                        saveCircle((Circle)shape, statement);
                        break;
                    }
                    case "Rectangle":{
                        saveRectangle((Rectangle)shape, statement);
                        break;
                    }
                    case "Triangle":{
                        saveTriangle((Triangle)shape, statement);
                        break;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void saveCircle(Circle circle, PreparedStatement statement) throws SQLException {
        statement.setString(1, circle.getClass().getSimpleName());
        statement.setString(2, circle.getShapeColor());
        statement.setString(5, String.valueOf(circle.getRadius()));
        statement.executeUpdate();
    }

    private void saveRectangle(Rectangle rectangle, PreparedStatement statement) throws SQLException {
        statement.setString(1, rectangle.getClass().getSimpleName());
        statement.setString(2, rectangle.getShapeColor());
        statement.setString(3, String.valueOf(rectangle.getWidth()));
        statement.setString(4, String.valueOf(rectangle.getHeight()));
        statement.executeUpdate();
    }

    private void saveTriangle(Triangle triangle, PreparedStatement statement) throws SQLException {
        statement.setString(1, triangle.getClass().getSimpleName());
        statement.setString(2, triangle.getShapeColor());
        statement.setString(3, String.valueOf(triangle.getWidth()));
        statement.setString(4, String.valueOf(triangle.getHeight()));
        statement.executeUpdate();
    }

    @Override
    public void close() {
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                //todo
            }
        }
    }
}
