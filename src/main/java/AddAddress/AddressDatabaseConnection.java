package AddAddress;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AddressDatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3307/glam_haven";
    private static final String USER = "root"; // Update this with your database username
    private static final String PASSWORD = "jQPuQjd!KLii@31q"; // Update this with your database password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            System.out.println("Connection successful: " + (conn != null));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
