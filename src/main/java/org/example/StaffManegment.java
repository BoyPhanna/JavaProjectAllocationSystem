package org.example;

import java.sql.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StaffManegment {
    List<Staff> staffs=new ArrayList<>();

    StaffManegment(List<Staff> staffs,List<Skill> skills){
        Scanner input=new Scanner(System.in);
        char x=' ';
        this.staffs=staffs;
        while (x!='5') {
            System.out.format("+--------------------------------------+%n");
            System.out.format("|        Staff Manegment               |%n");
            System.out.format("+------+-------------------------------+%n");
            System.out.format("| 1    |  Show all staff information   |%n");
            System.out.format("+------+-------------------------------+%n");
            System.out.format("| 2    |  Search and edit staff by id  |%n");
            System.out.format("+------+-------------------------------+%n");
            System.out.format("| 3    |  Add new staff                |%n");
            System.out.format("+------+-------------------------------+%n");
            System.out.format("| 4    |  Delete staff                 |%n");
            System.out.format("+------+-------------------------------+%n");
            System.out.format("| 5    |  Exit                         |%n");
            System.out.format("+------+-------------------------------+%n");
            System.out.print("Enter number : ");
            x = input.next().charAt(0);
            switch (x) {
                case '1':
                    showStaff(staffs);
                    input.nextLine();
                    break;
                case '3':
                    addNewStaff(skills);
                    break;
            }
        }

    }

    public  static void showStaff(List<Staff> staffs){
        String leftAlignFormat = "| %-4d  %-15s %-15s %-15s %-15s %-25s %-25s %-8s %-9.2f |%n";
        System.out.format("+----------------------------------------------------------------------------------------------------------------------------------------------+%n");
        System.out.format("| %-4s  %-15s %-15s %-15s %-15s %-25s %-25s %-8s %-9s |%n","id","name","gender","DOB","address","phone","email","skillID","salary");
        System.out.format("+----------------------------------------------------------------------------------------------------------------------------------------------|%n");

        for (Staff staff:staffs) {
            System.out.format(leftAlignFormat,staff.getId(),staff.getName(),
                    staff.getGender(),staff.getDateOfBirth(),staff.getAddress(),
                    staff.getPhone(),staff.getEmail(),staff.getSkillID(),staff.getSalary()
            );
        }
        System.out.format("+----------------------------------------------------------------------------------------------------------------------------------------------+%n");

    }
    public  void  addNewStaff(List<Skill> skills){
        Scanner input=new Scanner(System.in);
        Staff staff =new Staff();
        staff.setId(staffs.size()+1);
        System.out.println(skills.size());
        System.out.print("Enter name: ");staff.setName(input.nextLine());
        System.out.print("Enter Gender: ");staff.setGender(input.next().charAt(0));
        System.out.print("Enter Date of Birth (yyyy-mm-dd): ");staff.setDateOfBirth(LocalDate.parse(input.next()));
        input.nextLine();
        System.out.print("Enter Address: ");staff.setAddress(input.nextLine());
        System.out.print("Enter Phone: ");staff.setPhone(input.nextLine());
        System.out.print("Enter Email: ");staff.setEmail(input.nextLine());
        String leftAlignFormat = "| %-4d | %-15s |%n";
        System.out.format("+------------------------+%n");
        System.out.format("| %-4s | %-15s |%n","id","skill name");
        System.out.format("+------------------------+%n");

        for (Skill skill:
             skills) {
            System.out.format(leftAlignFormat,skill.getSkillID(),skill.getSkillName());

        }
        System.out.format("+------------------------+%n");
        System.out.print("Enter SkillID: ");staff.setSkillID(input.nextInt());
        System.out.print("Enter Salary: ");staff.setSalary(input.nextDouble());
//        staff.setName("Kako");
//        staff.setGender('M');
//        staff.setDateOfBirth(LocalDate.of(1999,2,25));
//        staff.setAddress("fjfsfj");
//        staff.setPhone("034454655");
//        staff.setEmail("fflsjfls@gmail.com");
//        staff.setSkillID(1);
////        staff.setSalary(500);
staffs.add(staff);
        SetInformation.addNewStaffToDB(staff);

    }


}
