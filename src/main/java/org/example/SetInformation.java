package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SetInformation {
    public    void setSkill(String skillName){
        Statement stmt;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/autotask", "root", ""
            );
            String sql="INSERT INTO skill (name)" +
                    "VALUES ('"+skillName+"');";
            stmt=connection.createStatement();
            stmt.execute(sql);
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public  static  void addNewStaffToDB(Staff staff){
        Statement stmt;
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String text = staff.getDateOfBirth().format(formatters);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/autotask", "root", ""
            );
            String sql="INSERT INTO staff (staffName,gender,dob,address,phone,email,skillID,salary)" +
                    "VALUES ('"+staff.getName()+"','"+staff.getGender()+ "','"+staff.getDateOfBirth()+"','"+staff.getAddress()+
                    "','"+staff.getPhone()+"','"+staff.getEmail()+"',"+staff.getSkillID()+","+staff.getSalary()+");";
            stmt=connection.createStatement();
            stmt.execute(sql);
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public  static  void addNewProjectToDB(Project project){
        Statement stmt;
//        String dateTimeString = "2024-01-29T15:30:00";
//        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
//
//        Project project=new Project();
//        project.setProjectName("workhard");
//        project.setDeadLine(dateTime);
//        project.setStaffID(10);
//        project.setSkillID(5);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/autotask", "root", ""
            );
            String sql="INSERT INTO project (projectName,deadLine,availability,staffID)" +
                    "VALUES ('"+project.getProjectName()+"','"+project.getDeadLine()+ "',"+project.isAvailability()+","+project.getStaffID()+");";
            stmt=connection.createStatement();
            stmt.execute(sql);
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public  static  void addNewSkillToDB(Skill skill){
        Statement stmt;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/autotask", "root", ""
            );
            String sql="INSERT INTO skill (name)" +
                    "VALUES ('"+skill.getSkillName()+ "');";
            stmt=connection.createStatement();
            stmt.execute(sql);
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
