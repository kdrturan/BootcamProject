package com.BootCampProject.BootCampProject.entity;

import com.BootCampProject.BootCampProject.entity.enums.ApplicationState;
import jakarta.persistence.*;

@Entity
@Table(name = "applications")
public class Application {


    public Bootcamp getBootcamp() {
        return bootcamp;
    }

    public Application(int id, Bootcamp bootcamp, Applicant applicant, ApplicationState applicationState) {
        this.id = id;
        this.bootcamp = bootcamp;
        this.applicant = applicant;
        this.applicationState = applicationState;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "bootcampId")
    private Bootcamp bootcamp;

    @ManyToOne
    @JoinColumn(name = "applicantId")
    private Applicant applicant;
    @Enumerated(EnumType.STRING)
    @Column(name = "applicationState")
    private ApplicationState applicationState;




    public void setBootcamp(Bootcamp bootcamp) {
        this.bootcamp = bootcamp;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Application() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public ApplicationState getApplicationState() {
        return applicationState;
    }

    public void setApplicationState(ApplicationState applicationState) {
        this.applicationState = applicationState;
    }
}


