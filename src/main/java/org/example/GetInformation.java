package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GetInformation {
    public static List<Staff> getStaffInfo(){
        List<Staff> staffs=new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/autotask", "root", ""
            );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from staff");

            while (resultSet.next()) {
                Staff staff=new Staff();
                staff.setId(resultSet.getInt(1) );
                staff.setName(resultSet.getString(2) );
                staff.setGender(resultSet.getString(3).charAt(0) );
                staff.setDateOfBirth(LocalDate.parse(resultSet.getString(4),formatter));
                staff.setAddress(resultSet.getString(5));
                staff.setPhone(resultSet.getString(6) );
                staff.setEmail(resultSet.getString(7) );
                staff.setSkillID(resultSet.getInt(8) );
                staff.setSalary(resultSet.getDouble(9) );
                staffs.add(staff);

            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }



        return staffs;
    }
    public static List<Skill> getSkillInfo(){
        List<Skill> skills=new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/autotask", "root", ""
            );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from skill");

            while (resultSet.next()) {
                Skill skill =new  Skill();
                skill.setSkillID(resultSet.getInt(1) );
                skill.setSkillName(resultSet.getString(2) );

                skills.add(skill);

            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }



        return skills;
    }

}
