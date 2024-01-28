package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProjectManegment {
    List<Project> prjects=new ArrayList<>();
    List<Workload> workloads=new ArrayList<>();
ProjectManegment(List<Project> prjects,List<Workload> workloads){
    this.prjects=prjects;
    this.workloads=workloads;
    Scanner input=new Scanner(System.in);
    char x=' ';

    while (x!='6') {
        System.out.format("+--------------------------------------+%n");
        System.out.format("|        Project Manegment             |%n");
        System.out.format("+------+-------------------------------+%n");
        System.out.format("| 1    |  Show all Project             |%n");
        System.out.format("+------+-------------------------------+%n");
        System.out.format("| 2    |  Search and edit project by id|%n");
        System.out.format("+------+-------------------------------+%n");
        System.out.format("| 3    |  task allocation              |%n");
        System.out.format("+------+-------------------------------+%n");
        System.out.format("| 4    |  Delete project               |%n");
        System.out.format("+------+-------------------------------+%n");
        System.out.format("| 5    |  show workload                |%n");
        System.out.format("+------+-------------------------------+%n");
        System.out.print("Enter number : ");
        x = input.next().charAt(0);
        switch (x) {
            case '1':
                showProject();
                input.nextLine();
                break;
            case '2':
                searchProject();
                break;
            case '3':
                taskAllocation();
                break;
            case '5':
               showWorkload();
                break;
        }
    }
}
public   void showProject(){
        String leftAlignFormat = "| %-4d  %-15s %-30s %-10d %-10d  |%n";
        System.out.format("+-----------------------------------------------------------------------------+%n");
        System.out.format("| %-4s  %-15s %-30s %-10s %-10s  |%n","id","Project name","Dead Line","Staff ID","Skill ID");
        System.out.format("+-----------------------------------------------------------------------------|%n");

        for (Project project:prjects) {
            System.out.format(leftAlignFormat,project.getProjectID(),project.getProjectName(),
                    project.getDeadLine(),project.getStaffID(),project.getSkillID()
            );
        }
        System.out.format("+-----------------------------------------------------------------------------+%n");
    }
public  void searchProject(){
    Scanner input=new Scanner(System.in);
    Project project=new Project();
    int x;
    int index=0;
    boolean b=false;

    System.out.print("Enter project id: ");x=input.nextInt();
    for(Project project2: prjects ){
        if(project2.getProjectID()==x){
            b=true;
            project=project2;
            break;
        }
        index++;
    }
    if(b){

        String leftAlignFormat = "| %-4d  %-15s %-30s %-10d %-10d  |%n";
        System.out.format("+-----------------------------------------------------------------------------+%n");
        System.out.format("| %-4s  %-15s %-30s %-10s %-10s  |%n","id","Project name","Dead Line","Staff ID","Skill ID");
        System.out.format("+-----------------------------------------------------------------------------|%n");
        System.out.format(leftAlignFormat,project.getProjectID(),project.getProjectName(), project.getDeadLine(),project.getStaffID(),project.getSkillID()
        );
        System.out.format("+-----------------------------------------------------------------------------+%n");
        System.out.print("Do you want to edit? y/n : ");x=input.next().charAt(0);
        if(x=='y'){
            editProject(index,project);
        }

    }
    else {
        System.out.println("Project not fount!");
    }

}

public   void editProject(int index,Project project){
    Scanner input=new Scanner(System.in);
    String name;
    char x;
    System.out.format("+--------------------------------------+%n");
    System.out.format("|       Edit Project                   |%n");
    System.out.format("+------+-------------------------------+%n");
    System.out.format("| 1    |  edit project name            |%n");
    System.out.format("+------+-------------------------------+%n");
    System.out.format("| 2    |  dead line                    |%n");
    System.out.format("+------+-------------------------------+%n");
    System.out.format("| 3    |  staff id                     |%n");
    System.out.format("+------+-------------------------------+%n");
    System.out.format("| 4    |  skill id                     |%n");
    System.out.format("+------+-------------------------------+%n");
    System.out.format("| 5    |  Exit                         |%n");
    System.out.format("+------+-------------------------------+%n");
    System.out.print("Enter number : ");x=input.next().charAt(0);

    switch (x){
        case '1':
            System.out.print("Enter new project name: ");
            input.nextLine();
            name=input.nextLine();
            project.setProjectName(name);
            break;
        case '2':
            break;
        case '3':
            System.out.print("Enter new staff id : ");
            project.setStaffID(input.nextInt());
            break;
        case '4':
            System.out.print("Enter new skill id: ");
            project.setSkillID(input.nextInt());
            break;
    }
    prjects.set(index,project);
}

public  void taskAllocation(){

}

public  void showWorkload(){

    String leftAlignFormat = "| %-4d  %-15d %-10s   |%n";
    System.out.format("+------------------------------------+%n");
    System.out.format("| %-4s  %-15s %-10s |%n","id","project id","availability");
    System.out.format("|------------------------------------|%n");
    for(Workload workload:workloads) {
        System.out.format(leftAlignFormat, workload.getWorkloadID(), workload.getProjectID(), workload.isAvailability()
        );
    }
    System.out.format("+------------------------------------+%n");

}


}
