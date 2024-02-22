package org.example;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SkillManegment {
    List<Skill> skills=new ArrayList<>();
    SkillManegment( List<Skill> skills){
        this.skills=skills;
        Scanner input=new Scanner(System.in);
        char x=' ';

        CellStyle cellStyle=new CellStyle(CellStyle.HorizontalAlign.left);
        CellStyle cellStyle2=new CellStyle(CellStyle.HorizontalAlign.center);
        Table listTable =new Table(2, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.ALL);
        Table listTable2 =new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.ALL);

        listTable2.setColumnWidth(0,37,60);
        listTable.setColumnWidth(0,5,10);
        listTable.setColumnWidth(1,20,40);

        listTable2.addCell("Skill Management",cellStyle2);
        listTable.addCell("1",cellStyle);
        listTable.addCell("Show all skill",cellStyle);
        listTable.addCell("2",cellStyle);
        listTable.addCell("Search and edit skill by id",cellStyle);
        listTable.addCell("3",cellStyle);
        listTable.addCell("Add new skill",cellStyle);
        listTable.addCell("4",cellStyle);
        listTable.addCell("Delete skill ",cellStyle);
        listTable.addCell("5",cellStyle);
        listTable.addCell("Exit",cellStyle);
        while (x!='5') {

            System.out.println(listTable2.render()+"\n"+listTable.render());
            System.out.print("Enter number : ");
            x = input.next().charAt(0);
            switch (x) {
                case '1' -> {
                    showSkill();
                    input.nextLine();
                    input.nextLine();
                }
                case '2' -> searchSkill();
                case '3' -> addNewSkill();
                case '4' -> deleteSkill();
            }
        }
    }
    public  void  showSkill(){
        CellStyle cellStyle=new CellStyle(CellStyle.HorizontalAlign.left);
        Table listTable =new Table(2, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.ALL);
        listTable.setColumnWidth(0,5,10);
        listTable.setColumnWidth(1,20,40);



        listTable.addCell("id",cellStyle);
        listTable.addCell("skill name",cellStyle);

        for (Skill skill:skills) {
            listTable.addCell(String.valueOf(skill.getSkillID()),cellStyle);
            listTable.addCell(skill.getSkillName(),cellStyle);
        }
        System.out.println(listTable.render());

    }
    public   void searchSkill(){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter skill id: ");
        int id=input.nextInt();
        for (Skill skill: skills
             ) {
            if(skill.skillID==id){
                CellStyle cellStyle=new CellStyle(CellStyle.HorizontalAlign.left);
                Table listTable =new Table(2, BorderStyle.UNICODE_BOX_DOUBLE_BORDER_WIDE, ShownBorders.ALL);
                listTable.setColumnWidth(0,5,10);
                listTable.setColumnWidth(1,20,40);
                listTable.addCell("id",cellStyle);
                listTable.addCell("skill name",cellStyle);
                listTable.addCell(String.valueOf(skill.getSkillID()),cellStyle);
                listTable.addCell(skill.getSkillName(),cellStyle);
                System.out.println(listTable.render());
                System.out.print("Do you want to skill? (y/n): ");
                char n=input.next().charAt(0);
                if (n=='y'){
                    System.out.print("Enter new name: ");skill.setSkillName(input.next());
                    UpdateInformation.updateSkillName(skill);
                    skills=GetInformation.getSkillInfo();
                }
                break;
            }
        }
    }
  public  void addNewSkill(){
        Scanner input=new Scanner(System.in);
    Skill skill =new Skill();
    System.out.print("Enter skill name : ");skill.setSkillName(input.next());
    SetInformation.addNewSkillToDB(skill);
    this.skills=GetInformation.getSkillInfo();
  }
public  void  deleteSkill(){
    Scanner input=new Scanner(System.in);
        int id;
        System.out.print("Enter id to delete : ");id=input.nextInt();
        if(id>0){
            DeleteInformation.DeleteSkill(id);
            skills=GetInformation.getSkillInfo();
        }
}
}
