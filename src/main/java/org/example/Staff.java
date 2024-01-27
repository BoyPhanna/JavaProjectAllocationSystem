package org.example;

import java.time.LocalDate;

public class Staff extends Person{
    private int skillID;
    private double salary;
    public Staff(){
        this.skillID=0;
        this.salary=0.0;
    }

    public Staff(int skill, double salary) {
        this.skillID = skill;
        this.salary = salary;
    }

    public Staff(int id, String name, char gender, LocalDate dateOfBirth, String phone, String address, String email, int skillID, double salary) {
        super(id, name, gender, dateOfBirth, phone, address, email);
        this.skillID = skillID;
        this.salary = salary;
    }

    public int getSkillID() {
        return skillID;
    }

    public void setSkillID(int skillID) {
        this.skillID = skillID;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
