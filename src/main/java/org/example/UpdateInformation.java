package org.example;

import java.sql.*;
import java.time.LocalDate;
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
        ZoneId zoneId = ZoneId.of("Asia/Phnom_Penh");
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
        ZoneId zoneId = ZoneId.of("Asia/Phnom_Penh");
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
        ZoneId zoneId = ZoneId.of("Asia/Phnom_Penh");


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
    public  static  void updateSkillName(Skill skill){
        String url = "jdbc:mysql://localhost:3306/autotask";
        String username = "root";
        String password = "";
        ZoneId zoneId = ZoneId.of("Asia/Phnom_Penh");  // Adjust for your desired time zone



        String updateQuery = "UPDATE skill SET name = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = conn.prepareStatement(updateQuery)) {

            // Set values for update parameters
            statement.setString(1,skill.getSkillName());
            statement.setInt(2,skill.getSkillID());


            // Execute the update
            int rowsUpdated = statement.executeUpdate();

            System.out.println("Updated " + rowsUpdated + " rows");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public  static  void updateStaffName(Staff staff){
        String url = "jdbc:mysql://localhost:3306/autotask";
        String username = "root";
        String password = "";
        ZoneId zoneId = ZoneId.of("Asia/Phnom_Penh");  // Adjust for your desired time zone

        String updateQuery = "UPDATE staff SET staffName = ? WHERE staffID = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = conn.prepareStatement(updateQuery)) {

            // Set values for update parameters
            statement.setString(1,staff.getName());
            statement.setInt(2,staff.getId());


            // Execute the update
            int rowsUpdated = statement.executeUpdate();

            System.out.println("Updated " + rowsUpdated + " rows");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public  static  void updateStaffGender(Staff staff){
        String url = "jdbc:mysql://localhost:3306/autotask";
        String username = "root";
        String password = "";
        ZoneId zoneId = ZoneId.of("Asia/Phnom_Penh");  // Adjust for your desired time zone

        String updateQuery = "UPDATE staff SET gender = ? WHERE staffID = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = conn.prepareStatement(updateQuery)) {

            // Set values for update parameters
            statement.setString(1,staff.getGender()+"");
            statement.setInt(2,staff.getId());


            // Execute the update
            int rowsUpdated = statement.executeUpdate();

            System.out.println("Updated " + rowsUpdated + " rows");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public  static  void updateStaffDOB(Staff staff){
        String url = "jdbc:mysql://localhost:3306/autotask";
        String username = "root";
        String password = "";


        String updateQuery = "UPDATE staff SET dob = ? WHERE staffID = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = conn.prepareStatement(updateQuery)) {
            java.sql.Date sqlDate = java.sql.Date.valueOf(staff.getDateOfBirth());
            // Set values for update parameters
            statement.setDate(1,sqlDate);
            statement.setInt(2,staff.getId());


            // Execute the update
            int rowsUpdated = statement.executeUpdate();

            System.out.println("Updated " + rowsUpdated + " rows");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  static  void updateStaffAddress(Staff staff){
        String url = "jdbc:mysql://localhost:3306/autotask";
        String username = "root";
        String password = "";


        String updateQuery = "UPDATE staff SET address = ? WHERE staffID = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = conn.prepareStatement(updateQuery)) {
            // Set values for update parameters
            statement.setString(1,staff.getAddress());
            statement.setInt(2,staff.getId());


            // Execute the update
            int rowsUpdated = statement.executeUpdate();

            System.out.println("Updated " + rowsUpdated + " rows");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  static  void updateStaffEmail(Staff staff){
        String url = "jdbc:mysql://localhost:3306/autotask";
        String username = "root";
        String password = "";


        String updateQuery = "UPDATE staff SET email = ? WHERE staffID = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = conn.prepareStatement(updateQuery)) {
            // Set values for update parameters
            statement.setString(1,staff.getEmail());
            statement.setInt(2,staff.getId());


            // Execute the update
            int rowsUpdated = statement.executeUpdate();

            System.out.println("Updated " + rowsUpdated + " rows");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  static  void updateStaffSkillID(Staff staff){
        String url = "jdbc:mysql://localhost:3306/autotask";
        String username = "root";
        String password = "";


        String updateQuery = "UPDATE staff SET skillID = ? WHERE staffID = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = conn.prepareStatement(updateQuery)) {
            // Set values for update parameters
            statement.setInt(1,staff.getSkillID());
            statement.setInt(2,staff.getId());


            // Execute the update
            int rowsUpdated = statement.executeUpdate();

            System.out.println("Updated " + rowsUpdated + " rows");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  static  void updateStaffSalary(Staff staff){
        String url = "jdbc:mysql://localhost:3306/autotask";
        String username = "root";
        String password = "";


        String updateQuery = "UPDATE staff SET salary = ? WHERE staffID = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = conn.prepareStatement(updateQuery)) {
            // Set values for update parameters
            statement.setDouble(1,staff.getSalary());
            statement.setInt(2,staff.getId());


            // Execute the update
            int rowsUpdated = statement.executeUpdate();

            System.out.println("Updated " + rowsUpdated + " rows");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public  static  void updateStaffPhone(Staff staff){
        String url = "jdbc:mysql://localhost:3306/autotask";
        String username = "root";
        String password = "";


        String updateQuery = "UPDATE staff SET phone = ? WHERE staffID = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = conn.prepareStatement(updateQuery)) {
            // Set values for update parameters
            statement.setString(1,staff.getPhone());
            statement.setInt(2,staff.getId());


            // Execute the update
            int rowsUpdated = statement.executeUpdate();

            System.out.println("Updated " + rowsUpdated + " rows");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
