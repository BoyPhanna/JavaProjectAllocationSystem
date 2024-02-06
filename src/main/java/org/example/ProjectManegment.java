package org.example;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

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
    CellStyle cellStyle=new CellStyle(CellStyle.HorizontalAlign.left);
    CellStyle cellStyle2=new CellStyle(CellStyle.HorizontalAlign.center);
    Table listTable =new Table(2, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.ALL);
    Table listTable2 =new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.ALL);

    listTable2.setColumnWidth(0,37,60);
    listTable.setColumnWidth(0,5,10);
    listTable.setColumnWidth(1,20,40);

    listTable2.addCell("Project Manegment",cellStyle2);
    listTable.addCell("1",cellStyle);
    listTable.addCell("Show all Project",cellStyle);
    listTable.addCell("2",cellStyle);
    listTable.addCell("Search and edit project by id",cellStyle);
    listTable.addCell("3",cellStyle);
    listTable.addCell("task allocation",cellStyle);
    listTable.addCell("4",cellStyle);
    listTable.addCell("Delete project  ",cellStyle);
    listTable.addCell("5",cellStyle);
    listTable.addCell("show workload",cellStyle);
    listTable.addCell("6",cellStyle);
    listTable.addCell("Exit",cellStyle);
    char x=' ';

    while (x!='6') {

        System.out.println(listTable2.render()+"\n"+listTable.render());


        System.out.print("Enter number : ");
        x = input.next().charAt(0);
        switch (x) {
            case '1':
                showProject();
                input.nextLine();
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
               input.nextLine();
               input.nextLine();
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

        CellStyle cellStyle=new CellStyle(CellStyle.HorizontalAlign.left);
        CellStyle cellStyle2=new CellStyle(CellStyle.HorizontalAlign.center);
        Table listTable =new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.ALL);
        listTable.setColumnWidth(0,5,10);
        listTable.setColumnWidth(1,20,40);
        listTable.setColumnWidth(2,20,40);
        listTable.setColumnWidth(3,20,40);
        listTable.setColumnWidth(4,20,40);


        listTable.addCell("id",cellStyle);
        listTable.addCell("Project name",cellStyle);
        listTable.addCell("Dead Line",cellStyle);
        listTable.addCell("availability",cellStyle);
        listTable.addCell("Staff ID",cellStyle);




        for (Project project:projects) {

            listTable.addCell(String.valueOf(project.getProjectID()),cellStyle);
            listTable.addCell(project.getProjectName(),cellStyle);
            listTable.addCell(project.getDeadLine().toString().replace('T',' '),cellStyle);
            listTable.addCell(String.valueOf(project.isAvailability()),cellStyle);
            listTable.addCell(String.valueOf(project.getStaffID()),cellStyle);

        }
        System.out.println(listTable.render());

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
        CellStyle cellStyle=new CellStyle(CellStyle.HorizontalAlign.left);
        CellStyle cellStyle2=new CellStyle(CellStyle.HorizontalAlign.center);
        Table listTable =new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.ALL);
        listTable.setColumnWidth(0,5,10);
        listTable.setColumnWidth(1,20,40);
        listTable.setColumnWidth(2,20,40);
        listTable.setColumnWidth(3,20,40);
        listTable.setColumnWidth(4,20,40);


        listTable.addCell("id",cellStyle);
        listTable.addCell("Project name",cellStyle);
        listTable.addCell("Dead Line",cellStyle);
        listTable.addCell("availability",cellStyle);
        listTable.addCell("Staff ID",cellStyle);

        listTable.addCell(String.valueOf(project.getProjectID()),cellStyle);
        listTable.addCell(project.getProjectName(),cellStyle);
        listTable.addCell(project.getDeadLine().toString().replace('T',' '),cellStyle);
        listTable.addCell(String.valueOf(project.isAvailability()),cellStyle);
        listTable.addCell(String.valueOf(project.getStaffID()),cellStyle);

        System.out.println(listTable.render());

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
    CellStyle cellStyle=new CellStyle(CellStyle.HorizontalAlign.left);
    CellStyle cellStyle2=new CellStyle(CellStyle.HorizontalAlign.center);
    Table listTable =new Table(2, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.ALL);
    Table listTable2 =new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.ALL);
    listTable2.setColumnWidth(0,28,50);
    listTable.setColumnWidth(0,5,10);
    listTable.setColumnWidth(1,20,40);

    listTable2.addCell("Edit Project",cellStyle2);
    listTable.addCell("1",cellStyle);
    listTable.addCell("edit project name",cellStyle);
    listTable.addCell("2",cellStyle);
    listTable.addCell("dead line",cellStyle);
    listTable.addCell("3",cellStyle);
    listTable.addCell("staff id",cellStyle);
    listTable.addCell("4",cellStyle);
    listTable.addCell("availability",cellStyle);
    listTable.addCell("5",cellStyle);
    listTable.addCell("Delete project",cellStyle);
    listTable.addCell("6",cellStyle);
    listTable.addCell("Exit",cellStyle);
    System.out.println(listTable2.render()+"\n"+listTable.render());

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
    CellStyle cellStyle=new CellStyle(CellStyle.HorizontalAlign.left);
    CellStyle cellStyle2=new CellStyle(CellStyle.HorizontalAlign.center);
    Table listTable =new Table(8, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.ALL);
    listTable.setColumnWidth(0,5,10);
    listTable.setColumnWidth(1,20,40);
    listTable.setColumnWidth(2,20,40);
    listTable.setColumnWidth(3,20,40);
    listTable.setColumnWidth(4,20,40);
    listTable.setColumnWidth(5,20,40);
    listTable.setColumnWidth(6,20,40);
    listTable.setColumnWidth(7,20,40);


    listTable.addCell("staff id",cellStyle);
    listTable.addCell("staff name",cellStyle);
    listTable.addCell("skill ID",cellStyle);
    listTable.addCell("Skill Name",cellStyle);
    listTable.addCell("Project ID",cellStyle);
    listTable.addCell("Project name",cellStyle);
    listTable.addCell("Dead Line",cellStyle);
    listTable.addCell("availability",cellStyle);

       for(Workload workload:workloads) {
        listTable.addCell(String.valueOf(workload.getStaffID()),cellStyle);
        listTable.addCell(workload.getStaffName(),cellStyle);
        listTable.addCell(String.valueOf( workload.getSkillID()),cellStyle);
        listTable.addCell(workload.getSkillName(),cellStyle);
        listTable.addCell(String.valueOf( workload.getProjectID()),cellStyle);
        listTable.addCell(workload.getProjectName(),cellStyle);
        listTable.addCell(workload.getDeadLine().toString().replace('T',' '),cellStyle);
        listTable.addCell(String.valueOf( workload.isAvailability()),cellStyle);

    }
       System.out.println(listTable.render());

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
