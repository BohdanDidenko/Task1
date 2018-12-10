package com.epam.task11.task11_2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
public class TestConnection {
    private static String url = "jdbc:mysql://localhost/shapes?serverTimezone=UTC";
    private static String user = "root";
    private static String pass = "root";

    private static Connection conn;

    public static void main(String[] args) throws SQLException {
        Locale.setDefault(Locale.ENGLISH);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Драйвер обнаружен!");
        } catch (ClassNotFoundException e) {
            System.out.println("Драйвер не обнаружен!");
        }

        try {
            conn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println("Соеденение не установлено!");
        } finally {
            if (conn != null) {
                System.out.println("Соеденение установлено!");
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

