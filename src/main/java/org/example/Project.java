package org.example;

import java.time.LocalDateTime;

public class Project {
    private String projectID;
    private  String projectName;
    LocalDateTime deadLine;
    private  String  staffID;
    private String skillID;

    public  Project(){
        this.projectID="00";
        this.projectName="non";
        this.skillID="Non";
        this.staffID="non";
        this.deadLine=LocalDateTime.of(2000,12,24,12,20,22);
    }

    public Project(String projectID, String projectName, LocalDateTime deadLine, String staffID, String skillID) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.deadLine = deadLine;
        this.staffID = staffID;
        this.skillID = skillID;
    }

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
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

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getSkillID() {
        return skillID;
    }

    public void setSkillID(String skillID) {
        this.skillID = skillID;
    }
}
