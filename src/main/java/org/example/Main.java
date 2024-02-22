package org.example;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char x='8';
        List<Staff> staffs = GetInformation.getStaffInfo();
        List<Skill> skills = GetInformation.getSkillInfo();
        List<Project> projects = GetInformation.getProjectInfo();
        List<Workload> workloads = GetInformation.getWorkloadInfo();
//        openMusic();

        CellStyle cellStyle=new CellStyle(CellStyle.HorizontalAlign.left);
        CellStyle cellStyle2=new CellStyle(CellStyle.HorizontalAlign.center);
        Table listTable =new Table(2, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.ALL);
        Table listTable2 =new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.ALL);
        listTable2.setColumnWidth(0,28,50);
        listTable.setColumnWidth(0,5,10);
        listTable.setColumnWidth(1,20,40);

        listTable2.addCell("Task Allocation",cellStyle2);
        listTable.addCell("1",cellStyle);
        listTable.addCell("Task Management",cellStyle);
        listTable.addCell("2",cellStyle);
        listTable.addCell("Staff Management",cellStyle);
        listTable.addCell("3",cellStyle);
        listTable.addCell("Skill Management",cellStyle);
        listTable.addCell("4",cellStyle);
        listTable.addCell("Exit",cellStyle);


        while (x !='4'){
            System.out.println(listTable2.render()+"\n"+listTable.render());

        System.out.print("Enter number: ");
        x = input.next().charAt(0);
        switch (x) {
            case '1':
                new ProjectManegment(projects, workloads,skills);
                break;
            case '2':
                new StaffManegment(staffs, skills);
                break;
            case '3':
                new  SkillManegment(skills);
            break;

        }
    }

    }

public static void  openMusic(){
    try {
        MusicTest.playMusic();
    } catch (UnsupportedAudioFileException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    } catch (LineUnavailableException e) {
        throw new RuntimeException(e);
    }
}



}