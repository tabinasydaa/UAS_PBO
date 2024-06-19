package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoginDatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3307/glam_haven";
    private static final String USER = "root"; // Replace with your MySQL username
    private static final String PASSWORD = "jQPuQjd!KLii@31q"; // Replace with your MySQL password

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}