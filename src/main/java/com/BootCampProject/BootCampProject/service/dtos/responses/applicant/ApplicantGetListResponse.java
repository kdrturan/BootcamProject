package com.BootCampProject.BootCampProject.service.dtos.responses.applicant;

import com.BootCampProject.BootCampProject.service.dtos.responses.user.UserGetListResponse;

public class ApplicantGetListResponse extends UserGetListResponse {


    public ApplicantGetListResponse() {
    }

    public ApplicantGetListResponse(int id, String userName, String firstName, String lastName, String about) {
        super(id, userName, firstName, lastName);
        this.about = about;
    }

    private String about;

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
