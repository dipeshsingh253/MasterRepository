package temp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcExample {
    public static void main(String[] args) {
        // JDBC driver name and database URL
        final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost:3306/test?";

        // Database credentials
        final String USER = "root";
        final String PASS = "root";

        Connection conn = null;

        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Do something with the connection...
            System.out.println("Connected to database!");

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();

        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();

        } finally {
            // Finally block used to close resources
            try {
                if (conn != null) {
                    conn.close();
                    System.out.println("Connection closed.");
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
