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
        char x;
        List<Staff> staffs =GetInformation.getStaffInfo();;
        List<Skill> skills = GetInformation.getSkillInfo();


        System.out.format("+--------------------------------------+%n");
        System.out.format("| Group6B Task Automation asigment      |%n");
        System.out.format("+------+-------------------------------+%n");
        System.out.format("| 1    |  Task Management              |%n");
        System.out.format("+------+-------------------------------+%n");
        System.out.format("| 2    |  Staff Management             |%n");
        System.out.format("+------+-------------------------------+%n");
        System.out.format("| 3    |  Skill Management             |%n");
        System.out.format("+------+-------------------------------+%n");
        System.out.format("| 4    |  Exit                         |%n");
        System.out.format("+------+-------------------------------+%n");



        System.out.print("Enter number: ");x=input.next().charAt(0);
       switch (x){
          case '1':
              break;
            case '2':
                    new StaffManegment(staffs,skills);
               break;
           case '3':
              break;
            case '4':

       }

    }




}