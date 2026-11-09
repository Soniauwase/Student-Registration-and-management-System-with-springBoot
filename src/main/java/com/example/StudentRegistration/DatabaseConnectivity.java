package com.example.StudentRegistration;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectivity {
    public static Connection getConnection() {
        try {
            String sqlUrl = "jdbc:postgres://localhost:5432/student_management";
            String userName = "postgres";
            String password = "Admin";

            Connection connection = DriverManager.getConnection(sqlUrl, userName, password);
            return connection;

        } catch (SQLException e) {
            e.getMessage();
        }
        return  null;
    }
}
