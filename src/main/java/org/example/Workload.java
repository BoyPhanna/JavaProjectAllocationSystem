package org.example;

public class Workload {
    private int workloadID;
    private int projectID;

    boolean availability;

    Workload(){
        this.workloadID = 0;
        this.projectID = 0;

        this.availability = false;
    }

    public Workload(int workloadID, int projectID, boolean availability) {
        this.workloadID = workloadID;
        this.projectID = projectID;

        this.availability = availability;
    }

    public int getWorkloadID() {
        return workloadID;
    }

    public void setWorkloadID(int workloadID) {
        this.workloadID = workloadID;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }


    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
