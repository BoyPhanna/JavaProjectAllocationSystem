package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SkillManegment {
    List<Skill> skills=new ArrayList<>();
    SkillManegment( List<Skill> skills){
        this.skills=skills;
        Scanner input=new Scanner(System.in);
        char x=' ';
        while (x!='5') {
            System.out.format("+--------------------------------------+%n");
            System.out.format("|        Skill Manegment               |%n");
            System.out.format("+------+-------------------------------+%n");
            System.out.format("| 1    |  Show all skill information   |%n");
            System.out.format("+------+-------------------------------+%n");
            System.out.format("| 2    |  Search and edit staff by id  |%n");
            System.out.format("+------+-------------------------------+%n");
            System.out.format("| 3    |  Add new skill                |%n");
            System.out.format("+------+-------------------------------+%n");
            System.out.format("| 4    |  Delete skill                 |%n");
            System.out.format("+------+-------------------------------+%n");
            System.out.format("| 5    |  Exit                         |%n");
            System.out.format("+------+-------------------------------+%n");
            System.out.print("Enter number : ");
            x = input.next().charAt(0);
            switch (x) {
                case '1':
                    showSkill();
                    input.nextLine();
                    break;
                case '3':

                    break;
            }
        }
    }
    public  void  showSkill(){
        String leftAlignFormat = "| %-4d  %-15s |%n";
        System.out.format("+-----------------------+%n");
        System.out.format("| %-4s  %-15s |%n","id","skill name");
        System.out.format("+-----------------------+%n");
        for (Skill skill:skills) {
            System.out.format(leftAlignFormat,skill.getSkillID(),skill.getSkillName()
            );
        }
        System.out.format("+-----------------------+%n");

    }
}
