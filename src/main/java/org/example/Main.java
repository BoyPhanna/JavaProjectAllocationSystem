package org.example;

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
        ;
        List<Skill> skills = GetInformation.getSkillInfo();
        List<Project> projects = GetInformation.getProjectInfo();
        List<Workload> workloads = GetInformation.getWorkloadInfo();
        openMusic();

        while (x !='4'){
        System.out.format("+--------------------------------------+%n");
        System.out.format("| Group6B Task Automation asigment     |%n");
        System.out.format("+------+-------------------------------+%n");
        System.out.format("| 1    |  Task Management              |%n");
        System.out.format("+------+-------------------------------+%n");
        System.out.format("| 2    |  Staff Management             |%n");
        System.out.format("+------+-------------------------------+%n");
        System.out.format("| 3    |  Skill Management             |%n");
        System.out.format("+------+-------------------------------+%n");
        System.out.format("| 4    |  Exit                         |%n");
        System.out.format("+------+-------------------------------+%n");


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