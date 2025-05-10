package com.BootCampProject.BootCampProject.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "instructors")
public class Instructor extends User{

    public Instructor() {
    }

    public Instructor(String userName, String firstName, String lastName,
                      String dateOfBirth, String nationalIdentity, String email, String password, String companyName) {
        super(userName, firstName, lastName, dateOfBirth, nationalIdentity, email, password);
        this.companyName = companyName;
    }

    @Column(name = "companyName")
    private  String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @OneToMany(mappedBy = "instructor")
    private List<Bootcamp> bootcamps;

}
