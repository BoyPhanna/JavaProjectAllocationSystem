package org.example;

import java.time.LocalDate;

public class Person {
    private int id;
    private  String name;
    private char gender;
    private LocalDate dateOfBirth=LocalDate.of(2000,12,22);
    private String phone;
    private String address;
    private String email;

    public  Person(){
        this.id = 0;
        this.name = "Phanna";
        this.gender = 'M';

        this.phone = "01265478";
        this.address = "pp";
        this.email = "dd";
    }
    public Person(int id, String name, char gender, LocalDate dateOfBirth, String phone, String address, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
