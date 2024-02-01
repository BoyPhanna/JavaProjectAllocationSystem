package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProjectManegment {
    List<Project> projects=new ArrayList<>();
    List<Workload> workloads=new ArrayList<>();
    List<Skill> skills=new ArrayList<>();
ProjectManegment(List<Project> projects,List<Workload> workloads,List<Skill> skills){
    this.skills=skills;
    this.projects=projects;
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
        System.out.format("| 6    |  exit                         |%n");
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
            case '4':
                deleteProject();
                break;
            case '5':
               showWorkload();
                break;
        }
    }
}

    private void deleteProject() {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter project id: ");int id=input.nextInt();
        DeleteInformation.DeleteProject(id);
        projects=GetInformation.getProjectInfo();
        workloads=GetInformation.getWorkloadInfo();
    }

    public   void showProject(){
        String leftAlignFormat = "| %-4d  %-15s %-30s %-10s %-10d    |%n";
        System.out.format("+-------------------------------------------------------------------------------+%n");
        System.out.format("| %-4s  %-15s %-30s %-10s %-10s  |%n","id","Project name","Dead Line","availability","Staff ID");
        System.out.format("+-------------------------------------------------------------------------------|%n");

        for (Project project:projects) {
            System.out.format(leftAlignFormat,project.getProjectID(),project.getProjectName(),
                    project.getDeadLine().toString().replace('T',' '),project.isAvailability(),project.getStaffID()
            );
        }
        System.out.format("+-------------------------------------------------------------------------------+%n");
    }
public  void searchProject(){
    Scanner input=new Scanner(System.in);
    Project project=new Project();
    int x;
   int id;
    int index=0;
    boolean b=false;
//System.out.println("size of project : "+projects.size());
    System.out.print("Enter project id: ");id=input.nextInt();
    for(Project project2: projects ){

        if(project2.getProjectID()==id){

            b=true;
            project=project2;
            break;
        }
        index++;
    }
    if(b){

        String leftAlignFormat = "| %-4d  %-15s %-30s %-10s %-10d  |%n";
        System.out.format("+-----------------------------------------------------------------------------+%n");
        System.out.format("| %-4s  %-15s %-30s %-10s %-10s |%n","id","Project name","Dead Line","availability","Staff ID");
        System.out.format("+-----------------------------------------------------------------------------|%n");
        System.out.format(leftAlignFormat,project.getProjectID(),project.getProjectName(), project.getDeadLine().toString().replace('T',' '),project.isAvailability(),project.getStaffID()
        );
        System.out.format("+-----------------------------------------------------------------------------+%n");
        System.out.print("Do you want to edit? y/n : ");x=input.next().charAt(0);
        if(x=='y'){
            editProject(index,project,id);
        }

    }
    else {
        System.out.println("Project not fount!");
    }

}

public   void editProject(int index,Project project,int id){
    System.out.println(index);
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
    System.out.format("| 4    |  availability                 |%n");
    System.out.format("+------+-------------------------------+%n");
    System.out.format("| 5    |  Delete project               |%n");
    System.out.format("+------+-------------------------------+%n");
    System.out.print("Enter number : ");x=input.next().charAt(0);

    switch (x){
        case '1':
            System.out.print("Enter new project name: ");
            input.nextLine();
            name=input.nextLine();
            project.setProjectName(name);
            UpdateInformation.updateProjectName(name,id);
            break;
        case '2':
            System.out.print("Enter new dead Line: ");
            String dateTimeString=input.next();
            LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            project.setDeadLine(dateTime);
            UpdateInformation.updateProjectDateLine(project);
            break;
        case '3':
            System.out.print("Enter new staff id : ");
            project.setStaffID(input.nextInt());
            UpdateInformation.updateProjectStaffID(project);
            break;
        case '4':
            System.out.print("Enter availability: ");
            project.setAvailability(input.nextBoolean());
            UpdateInformation.updateProjectAvailability(project);
            break;
        case '5':
            DeleteInformation.DeleteProject(project);
            break;

    }
    projects.set(index,project);
    workloads=GetInformation.getWorkloadInfo();
}

public  void taskAllocation(){
    Project project =new Project();
    Scanner input=new Scanner(System.in);
    String dateTimeString ;
    int id;
    project.setProjectID(projects.size()+1);
    System.out.print("Enter project name: ");project.setProjectName(input.nextLine());
    showAllSkill();
    System.out.print("Enter skillID: ");id=input.nextInt();
    System.out.print("Enter project Dead Line ( yyyy-mm-ddThh:mm:ss )  :  ");
    input.nextLine();
    dateTimeString=input.nextLine();
    LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    project.setDeadLine(dateTime);
    List<Person> persons=GetInformation.getStaffToDoProject(id,project.getDeadLine());

    if(persons.size()>0){
        project.setStaffID(persons.get(0).getId());
        projects.add(project);
        SetInformation.addNewProjectToDB(project);
        workloads=GetInformation.getWorkloadInfo();
    }
    else {
        System.out.println("Nobody free");
    }



}

public  void showWorkload(){

    String leftAlignFormat = "| %-10d  %-15s %-10d %-15s %-20d %-20s %-30s %-20s  |%n";
    System.out.format("+-------------------------------------------------------------------------------------------------------------------------------------------------------+%n");
    System.out.format("| %-10s  %-15s %-10s  %-15s %-20s %-20s %-30s %-20s |%n","staff id","staff name","skill ID","Skill Name","Project ID","Project Name","Dead Line","availability");
    System.out.format("|-------------------------------------------------------------------------------------------------------------------------------------------------------|%n");
    for(Workload workload:workloads) {
        System.out.format(leftAlignFormat, workload.getStaffID(), workload.getStaffName(),
                workload.getSkillID(),workload.getSkillName(),workload.getProjectID(),workload.getProjectName(),
                workload.getDeadLine().toString().replace('T',' '), workload.isAvailability()
        );
    }
    System.out.format("+-------------------------------------------------------------------------------------------------------------------------------------------------------+%n");
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
