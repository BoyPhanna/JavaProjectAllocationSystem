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
    List<Skill> skills=new ArrayList<>();
    StaffManegment(List<Staff> staffs,List<Skill> skills){
        Scanner input=new Scanner(System.in);
        char x=' ';
        this.staffs=staffs;
        this.skills=skills;
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
                case '2':
                    searchStaff();
                    break;
                case '3':
                    addNewStaff(skills);
                    break;
                case '4':
                    deleteStaff();
                    break;

            }
        }

    }

    private void deleteStaff() {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter staff id : ");int id=input.nextInt();
        DeleteInformation.DeleteStaff(id);
        staffs=GetInformation.getStaffInfo();

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
        showAllSkill();
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

    public  void  searchStaff(){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter staff id : ");int id=input.nextInt();
        for (Staff staff:staffs
             ) {
            if(staff.getId()==id){
                String leftAlignFormat = "| %-4d  %-15s %-15s %-15s %-15s %-25s %-25s %-8s %-9.2f |%n";
                System.out.format("+----------------------------------------------------------------------------------------------------------------------------------------------+%n");
                System.out.format("| %-4s  %-15s %-15s %-15s %-15s %-25s %-25s %-8s %-9s |%n","id","name","gender","DOB","address","phone","email","skillID","salary");
                System.out.format("+----------------------------------------------------------------------------------------------------------------------------------------------|%n");
                System.out.format(leftAlignFormat,staff.getId(),staff.getName(),
                        staff.getGender(),staff.getDateOfBirth(),staff.getAddress(),
                        staff.getPhone(),staff.getEmail(),staff.getSkillID(),staff.getSalary()
                );
                System.out.format("+----------------------------------------------------------------------------------------------------------------------------------------------|%n");
                System.out.print("Do you want to edit? (y/n) : ");char n=input.next().charAt(0);
                    if(n=='y'){
                        System.out.format("+--------------------------------------+%n");
                        System.out.format("|        Edit staff                    |%n");
                        System.out.format("+------+-------------------------------+%n");
                        System.out.format("| 1    |  Edit name                    |%n");
                        System.out.format("+------+-------------------------------+%n");
                        System.out.format("| 2    |  Edit gender                  |%n");
                        System.out.format("+------+-------------------------------+%n");
                        System.out.format("| 3    |  Edit address                 |%n");
                        System.out.format("+------+-------------------------------+%n");
                        System.out.format("| 4    |  Edit phone                   |%n");
                        System.out.format("+------+-------------------------------+%n");
                        System.out.format("| 5    |  Edit Email                   |%n");
                        System.out.format("+------+-------------------------------+%n");
                        System.out.format("| 6    |  Edit Dead of Birth           |%n");
                        System.out.format("+------+-------------------------------+%n");
                        System.out.format("| 7    |  Edit SkillID                 |%n");
                        System.out.format("+------+-------------------------------+%n");
                        System.out.format("| 8    |  Edit salary                  |%n");
                        System.out.format("+------+-------------------------------+%n");
                        System.out.print("Enter number : ");
                        n=input.next().charAt(0);
                        input.nextLine();
                        switch (n){
                            case '1':
                                System.out.print("Enter new name: ");staff.setName(input.nextLine());
                                UpdateInformation.updateStaffName(staff);
                                staffs=GetInformation.getStaffInfo();
                                break;
                            case '2':
                                System.out.print("Enter new gender: ");staff.setGender(input.nextLine().charAt(0));
                                UpdateInformation.updateStaffGender(staff);
                                staffs=GetInformation.getStaffInfo();
                                break;
                            case '3':
                                System.out.print("Enter new address: ");staff.setAddress(input.nextLine());
                                UpdateInformation.updateStaffAddress(staff);
                                staffs=GetInformation.getStaffInfo();
                                break;
                            case '4':
                                System.out.print("Enter new phone: ");staff.setPhone(input.nextLine());
                                UpdateInformation.updateStaffPhone(staff);
                                staffs=GetInformation.getStaffInfo();
                                break;
                            case '5':
                                System.out.print("Enter new email: ");staff.setEmail(input.nextLine());
                                UpdateInformation.updateStaffEmail(staff);
                                staffs=GetInformation.getStaffInfo();
                                break;
                            case '6':
                                System.out.print("Enter new dead of birth (yyyy-mm-dd): ");staff.setDateOfBirth(LocalDate.parse(input.next()));
                                UpdateInformation.updateStaffDOB(staff);
                                staffs=GetInformation.getStaffInfo();
                                break;
                            case '7':
                                showAllSkill();
                                System.out.print("Enter new skill ID : ");staff.setSkillID(input.nextInt());
                                UpdateInformation.updateStaffSkillID(staff);
                                staffs=GetInformation.getStaffInfo();
                                break;
                            case '8':
                                System.out.print("Enter new salary : ");staff.setSalary(input.nextDouble());
                                UpdateInformation.updateStaffSalary(staff);
                                staffs=GetInformation.getStaffInfo();
                                break;
                        }
                    }
                break;
            }
        }
    }

    public void showAllSkill(){
        String leftAlignFormat = "| %-4d | %-15s |%n";
        System.out.format("+------------------------+%n");
        System.out.format("| %-4s | %-15s |%n","id","skill name");
        System.out.format("+------------------------+%n");

        for (Skill skill:
                skills) {
            System.out.format(leftAlignFormat,skill.getSkillID(),skill.getSkillName());

        }
        System.out.format("+------------------------+%n");

    }


}
