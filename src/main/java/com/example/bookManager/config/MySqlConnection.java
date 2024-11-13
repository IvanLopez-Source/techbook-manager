package com.example.bookManager.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    static final String url= "jdbc:mysql://localhost:3306/test";
    static final String user = "root";
    static final String password = "";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, user, password);
    }

}
