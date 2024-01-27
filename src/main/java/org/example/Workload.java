package org.example;

public class Workload {
    private String workloadID;
    private String projectID;
    private String staffID;
    boolean availability;

    public Workload(String workloadID, String projectID, String staffID, boolean availability) {
        this.workloadID = workloadID;
        this.projectID = projectID;
        this.staffID = staffID;
        this.availability = availability;
    }

    public String getWorkloadID() {
        return workloadID;
    }

    public void setWorkloadID(String workloadID) {
        this.workloadID = workloadID;
    }

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
