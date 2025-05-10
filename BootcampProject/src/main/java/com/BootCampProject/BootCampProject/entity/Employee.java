package com.BootCampProject.BootCampProject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee extends User{

    public Employee() {
    }

    public Employee(String userName, String firstName, String lastName,
                    String dateOfBirth, String nationalIdentity, String email, String password, String position) {
        super(userName, firstName, lastName, dateOfBirth, nationalIdentity, email, password);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Column(name = "position")
    private  String position;
}
