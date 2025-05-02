package com.BootCampProject.BootCampProject.entity;


import com.BootCampProject.BootCampProject.entity.enums.BootcampState;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Table(name = "bootCamps")
@Entity
public class Bootcamp {

    public Bootcamp(int id, String name, LocalDate startDate, LocalDate endDate, BootcampState bootcampState) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bootcampState = bootcampState;
    }

    public Bootcamp() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int  id;

    @Column(name = "name")
    private String name;

    @Column(name = "startDate")
    private LocalDate startDate;
    @Column(name = "endDate")
    private LocalDate endDate;
    @Column(name = "bootcampState")
    private BootcampState bootcampState;
    @OneToMany(mappedBy = "bootcamp")
    private List<Application> applications;

    @ManyToOne
    @JoinColumn(name = "instructorId")
    private Instructor instructor;

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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BootcampState getBootcampState() {
        return bootcampState;
    }

    public void setBootcampState(BootcampState bootcampState) {
        this.bootcampState = bootcampState;
    }
}
