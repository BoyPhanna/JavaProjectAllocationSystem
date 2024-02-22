package org.example;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.sql.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StaffManegment {
    List<Staff> staffs=new ArrayList<>();
    List<Skill> skills=new ArrayList<>();
    StaffManegment(List<Staff> staffs,List<Skill> skills){
        Scanner input=new Scanner(System.in);
        char x=' ';
        this.staffs=staffs;
        this.skills=skills;
        this.skills=GetInformation.getSkillInfo();
        CellStyle cellStyle=new CellStyle(CellStyle.HorizontalAlign.left);
        CellStyle cellStyle2=new CellStyle(CellStyle.HorizontalAlign.center);
        Table listTable =new Table(2, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.ALL);
        Table listTable2 =new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.ALL);

        listTable2.setColumnWidth(0,37,60);
        listTable.setColumnWidth(0,5,10);
        listTable.setColumnWidth(1,20,40);

        listTable2.addCell("Staff Management",cellStyle2);
        listTable.addCell("1",cellStyle);
        listTable.addCell("Show all staff information",cellStyle);
        listTable.addCell("2",cellStyle);
        listTable.addCell("Search and edit staff by id",cellStyle);
        listTable.addCell("3",cellStyle);
        listTable.addCell("Add new staff",cellStyle);
        listTable.addCell("4",cellStyle);
        listTable.addCell("Delete staff ",cellStyle);
        listTable.addCell("5",cellStyle);
        listTable.addCell("Exit",cellStyle);

        while (x!='5') {
            System.out.println(listTable2.render()+"\n"+listTable.render());
            System.out.print("Enter number : ");
            x = input.next().charAt(0);
            switch (x) {
                case '1':
                    showStaff();
                    input.nextLine();
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

    public   void showStaff(){
        CellStyle cellStyle=new CellStyle(CellStyle.HorizontalAlign.left);
        Table listTable =new Table(9, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.ALL);
        listTable.setColumnWidth(0,5,10);
        listTable.setColumnWidth(1,20,40);
        listTable.setColumnWidth(2,5,10);
        listTable.setColumnWidth(3,20,40);
        listTable.setColumnWidth(4,20,40);
        listTable.setColumnWidth(5,20,40);
        listTable.setColumnWidth(6,20,40);
        listTable.setColumnWidth(7,5,10);
        listTable.setColumnWidth(8,20,40);


        listTable.addCell("id",cellStyle);
        listTable.addCell("name",cellStyle);
        listTable.addCell("gender",cellStyle);
        listTable.addCell("DOB",cellStyle);
        listTable.addCell("address",cellStyle);
        listTable.addCell("phone",cellStyle);
        listTable.addCell("email",cellStyle);
        listTable.addCell("skillID",cellStyle);
        listTable.addCell("salary",cellStyle);


        for (Staff staff:staffs) {
            listTable.addCell(String.valueOf(staff.getId()),cellStyle);
            listTable.addCell(staff.getName(),cellStyle);
            listTable.addCell(String.valueOf(staff.getGender()),cellStyle);
            listTable.addCell(staff.getDateOfBirth().toString(),cellStyle);
            listTable.addCell(staff.getAddress(),cellStyle);
            listTable.addCell(staff.getPhone(),cellStyle);
            listTable.addCell(staff.getEmail(),cellStyle);
            listTable.addCell(String.valueOf(staff.getSkillID()),cellStyle);
            listTable.addCell(String.valueOf(staff.getSalary()),cellStyle);


        }
        System.out.println(listTable.render());
    }
    public  void  addNewStaff(List<Skill> skills){
        Scanner input=new Scanner(System.in);
        Staff staff =new Staff();
        staff.setId(staffs.size()+1);
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


        SetInformation.addNewStaffToDB(staff);
        staffs=GetInformation.getStaffInfo();

    }

    public  void  searchStaff(){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter staff id : ");int id=input.nextInt();
        for (Staff staff:staffs
             ) {
            if(staff.getId()==id){
                CellStyle cellStyle=new CellStyle(CellStyle.HorizontalAlign.left);
                Table listTable =new Table(9, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.ALL);
                listTable.setColumnWidth(0,5,10);
                listTable.setColumnWidth(1,20,40);
                listTable.setColumnWidth(2,5,10);
                listTable.setColumnWidth(3,20,40);
                listTable.setColumnWidth(4,20,40);
                listTable.setColumnWidth(5,20,40);
                listTable.setColumnWidth(6,20,40);
                listTable.setColumnWidth(7,5,10);
                listTable.setColumnWidth(8,20,40);


                listTable.addCell("id",cellStyle);
                listTable.addCell("name",cellStyle);
                listTable.addCell("gender",cellStyle);
                listTable.addCell("DOB",cellStyle);
                listTable.addCell("address",cellStyle);
                listTable.addCell("phone",cellStyle);
                listTable.addCell("email",cellStyle);
                listTable.addCell("skillID",cellStyle);
                listTable.addCell("salary",cellStyle);


                listTable.addCell(String.valueOf(staff.getId()),cellStyle);
                listTable.addCell(staff.getName(),cellStyle);
                listTable.addCell(String.valueOf(staff.getGender()),cellStyle);
                listTable.addCell(staff.getDateOfBirth().toString(),cellStyle);
                listTable.addCell(staff.getAddress(),cellStyle);
                listTable.addCell(staff.getPhone(),cellStyle);
                listTable.addCell(staff.getEmail(),cellStyle);
                listTable.addCell(String.valueOf(staff.getSkillID()),cellStyle);
                listTable.addCell(String.valueOf(staff.getSalary()),cellStyle);

                System.out.println(listTable.render());
               System.out.print("Do you want to edit? (y/n) : ");char n=input.next().charAt(0);


                    if(n=='y'){
                        CellStyle cellStyle2=new CellStyle(CellStyle.HorizontalAlign.left);
                        CellStyle cellStyle3=new CellStyle(CellStyle.HorizontalAlign.center);
                        Table listTable4 =new Table(2, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.ALL);
                        Table listTable3 =new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.ALL);

                        listTable3.setColumnWidth(0,28,60);
                        listTable4.setColumnWidth(0,5,10);
                        listTable4.setColumnWidth(1,20,40);

                        listTable3.addCell("Edit staff",cellStyle2);

                        listTable4.addCell("1",cellStyle);
                        listTable4.addCell("Edit name",cellStyle);
                        listTable4.addCell("2",cellStyle);
                        listTable4.addCell("Edit gender",cellStyle);
                        listTable4.addCell("3",cellStyle);
                        listTable4.addCell("AEdit address",cellStyle);
                        listTable4.addCell("4",cellStyle);
                        listTable4.addCell("Edit phone ",cellStyle);
                        listTable4.addCell("5",cellStyle);
                        listTable4.addCell("Edit Email",cellStyle);
                        listTable4.addCell("6",cellStyle);
                        listTable4.addCell("Edit Dead of Birth",cellStyle);
                        listTable4.addCell("7",cellStyle);
                        listTable4.addCell("Edit SkillID",cellStyle);
                        listTable4.addCell("8",cellStyle);
                        listTable4.addCell("Edit salary",cellStyle);
                        listTable4.addCell("9",cellStyle);
                        listTable4.addCell("Exit",cellStyle);
                        System.out.println(listTable3.render()+"\n"+listTable4.render());

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


        CellStyle cellStyle=new CellStyle(CellStyle.HorizontalAlign.left);
        Table listTable =new Table(2, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.ALL);
        listTable.setColumnWidth(0,5,10);
        listTable.setColumnWidth(1,20,40);



        listTable.addCell("id",cellStyle);
        listTable.addCell("skill name",cellStyle);

        for (Skill skill:
                skills) {
            listTable.addCell(String.valueOf(skill.getSkillID()),cellStyle);
            listTable.addCell(skill.getSkillName(),cellStyle);

        }
        System.out.println(listTable.render());

    }


}
