package temp.jdbc;

import java.sql.*;

public class CRUDExample {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try {
            // Connect to database
            String url = "jdbc:mysql://localhost:3306/test";
            String user = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, user, password);

            // Create statement
            statement = connection.createStatement();

            // Create table
            String createTableSQL = "CREATE TABLE users (id INTEGER PRIMARY KEY, name VARCHAR(255), email VARCHAR(255))";
            statement.executeUpdate(createTableSQL);

            // Insert record
            String insertSQL = "INSERT INTO users (id, name, email) VALUES (1, 'John', 'john@example.com')";
            statement.executeUpdate(insertSQL);

            // Update record
            String updateSQL = "UPDATE users SET email='johndoe@example.com' WHERE id=1";
            statement.executeUpdate(updateSQL);

//            // Delete record
//            String deleteSQL = "DELETE FROM users WHERE id=1";
//            statement.executeUpdate(deleteSQL);

            // Select records
            String selectSQL = "SELECT * FROM users";
            resultSet = statement.executeQuery(selectSQL);

            // Print results
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.println(id + "\t" + name + "\t" + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
