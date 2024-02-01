package org.example;

import java.sql.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DeleteInformation {
    public  static  void DeleteProject(Project project){
        String url = "jdbc:mysql://localhost:3306/autotask";
        String username = "root";
        String password = "";
        ZoneId zoneId = ZoneId.of("Asia/Phnom_Penh");  // Adjust for your desired time zone
        ZonedDateTime zonedDateTime = project.getDeadLine().atZone(zoneId);
        Timestamp timestamp = Timestamp.valueOf(zonedDateTime.toLocalDateTime());


        String updateQuery = "DELETE FROM project WHERE projectID = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = conn.prepareStatement(updateQuery)) {

            // Set values for update parameters

            statement.setInt(1, project.getProjectID()); // replace with your ID

            // Execute the update
            int rowsUpdated = statement.executeUpdate();

            System.out.println("Delete " + rowsUpdated + " rows");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public  static  void DeleteSkill(int id){
        String url = "jdbc:mysql://localhost:3306/autotask";
        String username = "root";
        String password = "";
        ZoneId zoneId = ZoneId.of("Asia/Phnom_Penh");  // Adjust for your desired time zone



        String updateQuery = "DELETE FROM skill WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = conn.prepareStatement(updateQuery)) {

            // Set values for update parameters

            statement.setInt(1, id); // replace with your ID

            // Execute the update
            int rowsUpdated = statement.executeUpdate();

            System.out.println("Delete " + rowsUpdated + " rows");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public  static  void DeleteStaff(int id){
        String url = "jdbc:mysql://localhost:3306/autotask";
        String username = "root";
        String password = "";
        ZoneId zoneId = ZoneId.of("Asia/Phnom_Penh");  // Adjust for your desired time zone



        String updateQuery = "DELETE FROM staff WHERE staffID = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = conn.prepareStatement(updateQuery)) {

            // Set values for update parameters

            statement.setInt(1, id); // replace with your ID

            // Execute the update
            int rowsUpdated = statement.executeUpdate();

            System.out.println("Delete " + rowsUpdated + " rows");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
