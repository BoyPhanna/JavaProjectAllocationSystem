package org.example;

import java.sql.*;
import java.time.format.DateTimeFormatter;

public class UpdateInformation {
    public  static  void updateProjectName(String name,int id){
        String url = "jdbc:mysql://localhost:3306/autotask";
        String username = "root";
        String password = "";

        String updateQuery = "UPDATE project SET projectName = ? WHERE projectID = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = conn.prepareStatement(updateQuery)) {

            // Set values for update parameters
            statement.setString(1, name);
            statement.setInt(2, id); // replace with your ID

            // Execute the update
            int rowsUpdated = statement.executeUpdate();

            System.out.println("Updated " + rowsUpdated + " rows");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
