package org.example;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
//        Staff[] staff;
//        staff = new Staff[5] ;
//
//        staff[0]=new Staff(1, "Phanna",'M', LocalDate.of(2001,3,24),"01234567", "PP", "Panna@gmail", 0, 200);
//
//        System.out.println("-------------------------------------------------------------");
//        System.out.println("Enter ID: "+staff[0].getId());
//        System.out.println("Enter Gender: "+staff[0].getGender());
//        System.out.println("Enter DOB: "+staff[0].getDateOfBirth());
//        System.out.println("Enter Phone: "+staff[0].getPhone());
//        System.out.println("Enter address: "+staff[0].getAddress());
//        System.out.println("Enter email: "+staff[0].getEmail());
//
//        List<Staff> staffs=getDataFromDatabase();
//        for(Staff staff : staffs){
//            System.out.println("ID : "+staff.getSkillID());
//            System.out.println("Name : "+staff.getName());
//            System.out.println("Date OF Birth : "+staff.getDateOfBirth());
//
//        }

//        setSkill();
        setWorkload();
    }

    public static List<Staff> getDataFromDatabase(){
        List<Staff> staffs=new ArrayList<>();
        Staff staff=new Staff();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/autotask", "root", ""
            );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from staff");
            while (resultSet.next()) {
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
    public  static  void setSkill(){
        Statement stmt;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/autotask", "root", ""
            );
            String sql="INSERT INTO skill (name)" +
                    "VALUES ('Hacker');";
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
}