package org.example;

import java.time.LocalDateTime;

public class Project {
    private int projectID;
    private  String projectName;
    LocalDateTime deadLine;
    private  int  staffID;
    private int skillID;

    public  Project(){
        this.projectID=0;
        this.projectName="non";
        this.skillID=0;
        this.staffID=0;
        this.deadLine=LocalDateTime.of(2000,12,24,12,20,22);
    }

    public Project(int projectID, String projectName, LocalDateTime deadLine, int staffID, int skillID) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.deadLine = deadLine;
        this.staffID = staffID;
        this.skillID = skillID;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
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

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public int getSkillID() {
        return skillID;
    }

    public void setSkillID(int skillID) {
        this.skillID = skillID;
    }
}
