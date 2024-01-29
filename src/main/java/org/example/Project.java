package org.example;

import java.time.LocalDateTime;

public class Project {
    private int projectID;
    private  String projectName;
   private  LocalDateTime deadLine;
    private  int  staffID;

    boolean availability;
    public  Project(){
        this.projectID=0;
        this.projectName="non";
        this.availability=false;
        this.staffID=0;
        this.deadLine=LocalDateTime.of(2000,12,24,12,20,22);
    }

    public Project(int projectID, String projectName, LocalDateTime deadLine, int staffID, boolean availability) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.deadLine = deadLine;
        this.staffID = staffID;
        this.availability = availability;
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

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
