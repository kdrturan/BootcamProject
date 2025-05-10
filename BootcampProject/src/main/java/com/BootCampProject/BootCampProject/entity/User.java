package com.BootCampProject.BootCampProject.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "Users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    public User() {
    }

    public User(String userName, String firstName, String lastName,
                String dateOfBirth, String nationalIdentity, String email, String password) {

        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.nationalIdentity = nationalIdentity;
        this.email = email;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  int id;

    @Column(name = "nationalIdentity")
    private  String nationalIdentity;

    @Column(name = "email")
    private  String email;


    @Column(name = "password")
    private  String password;

    @Column(name = "userName")
    private  String userName;

    @Column(name = "firstName")
    private  String firstName;

    @Column(name = "lastName")
    private  String lastName;

    @Column(name = "dateOfBirth")
    private  String dateOfBirth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationalIdentity() {
        return nationalIdentity;
    }

    public void setNationalIdentity(String nationalIdentity) {
        this.nationalIdentity = nationalIdentity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
