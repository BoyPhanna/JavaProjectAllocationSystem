package org.example;

import java.sql.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
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
    public  static  void updateProjectDateLine(Project project){
        String url = "jdbc:mysql://localhost:3306/autotask";
        String username = "root";
        String password = "";
        ZoneId zoneId = ZoneId.of("Asia/Phnom_Penh");  // Adjust for your desired time zone
        ZonedDateTime zonedDateTime = project.getDeadLine().atZone(zoneId);
        Timestamp timestamp = Timestamp.valueOf(zonedDateTime.toLocalDateTime());


        String updateQuery = "UPDATE project SET deadLine = ? WHERE projectID = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = conn.prepareStatement(updateQuery)) {

            // Set values for update parameters
            statement.setTimestamp(1, timestamp);
            statement.setInt(2, project.getProjectID()); // replace with your ID

            // Execute the update
            int rowsUpdated = statement.executeUpdate();

            System.out.println("Updated " + rowsUpdated + " rows");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public  static  void updateProjectAvailability(Project project){
        String url = "jdbc:mysql://localhost:3306/autotask";
        String username = "root";
        String password = "";
        ZoneId zoneId = ZoneId.of("Asia/Phnom_Penh");  // Adjust for your desired time zone
        ZonedDateTime zonedDateTime = project.getDeadLine().atZone(zoneId);
        Timestamp timestamp = Timestamp.valueOf(zonedDateTime.toLocalDateTime());


        String updateQuery = "UPDATE project SET availability = ? WHERE projectID = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = conn.prepareStatement(updateQuery)) {

            // Set values for update parameters
            statement.setBoolean(1,project.isAvailability());
            statement.setInt(2, project.getProjectID()); // replace with your ID

            // Execute the update
            int rowsUpdated = statement.executeUpdate();

            System.out.println("Updated " + rowsUpdated + " rows");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public  static  void updateProjectStaffID(Project project){
        String url = "jdbc:mysql://localhost:3306/autotask";
        String username = "root";
        String password = "";
        ZoneId zoneId = ZoneId.of("Asia/Phnom_Penh");  // Adjust for your desired time zone
        ZonedDateTime zonedDateTime = project.getDeadLine().atZone(zoneId);
        Timestamp timestamp = Timestamp.valueOf(zonedDateTime.toLocalDateTime());


        String updateQuery = "UPDATE project SET staffID = ? WHERE projectID = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = conn.prepareStatement(updateQuery)) {

            // Set values for update parameters
            statement.setInt(1,project.getStaffID());
            statement.setInt(2, project.getProjectID()); // replace with your ID

            // Execute the update
            int rowsUpdated = statement.executeUpdate();

            System.out.println("Updated " + rowsUpdated + " rows");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
