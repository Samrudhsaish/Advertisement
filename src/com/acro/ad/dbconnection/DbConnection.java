package com.acro.ad.dbconnection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public Connection getConnection() {
        Connection connection = null;
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Create a connection to the MySQL database
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/advertisement",
                    "root",
                    "saibaba");

            // Test the connection
            if (connection != null) {
                System.out.println("Connected to the database");
                return connection;
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Could not find the MySQL JDBC driver: " + e.getMessage());
        }
        return null;
    }

    public void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Disconnected from the database");
            }
        } catch (SQLException e) {
            System.out.println("Error closing the connection: " + e.getMessage());
        }
    }
}
