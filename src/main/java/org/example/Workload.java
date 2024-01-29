package org.example;

import java.time.LocalDateTime;

public class Workload {
   private  int staffID;
   private  String staffName;
   private  int skillID;
   private  String skillName;
   private String projectName;
   private LocalDateTime deadLine;
   private  boolean availability;
   private  int projectID;

    public Workload() {
        this.staffID = 0;
        this.skillID=0;
        this.projectID=0;
        this.staffName =" staffName";
        this.skillName = "skillName";
        this.projectName = "projectName";
        this.deadLine = LocalDateTime.of(2000,2,24,12,25,0);
        this.availability = false;
    }

    public Workload(int staffID,int projectID, String staffName, int skillID, String skillName, String projectName, LocalDateTime deadLine, boolean availability) {
        this.staffID = staffID;
        this.staffName = staffName;
        this.skillID = skillID;
        this.skillName = skillName;
        this.projectName = projectName;
        this.deadLine = deadLine;
        this.availability = availability;
        this.projectID=projectID;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public int getSkillID() {
        return skillID;
    }

    public void setSkillID(int skillID) {
        this.skillID = skillID;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public LocalDateTime getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDateTime deadLine) {
        this.deadLine = deadLine;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
