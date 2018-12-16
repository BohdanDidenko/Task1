package com.epam.task11.task11_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionToDB {
    Connection connection;
    private ResourceBundle resourceBundle;
    private String path = "com.epam.task11.task11_1.resource.db";

    public ConnectionToDB() {
        resourceBundle = ResourceBundle.getBundle(path);
        try{
            connection = DriverManager.getConnection(resourceBundle.getString("url"),
                    resourceBundle.getString("user"), resourceBundle.getString("password"));
        }
        catch (SQLException e){
            //todo
        }
    }

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
