package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
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
    public  static  void setWorkload(){
        Statement stmt;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/autotask", "root", ""
            );
            String sql="INSERT INTO workload (projectID,staffID,availability)" +
                    "VALUES (2,2,0);";
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
        System.out.println(text);
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
}
