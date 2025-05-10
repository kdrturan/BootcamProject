package com.BootCampProject.BootCampProject.service.dtos.responses.applicant;

import com.BootCampProject.BootCampProject.service.dtos.responses.user.UserAddResponse;

public class ApplicantAddResponse extends UserAddResponse {

    public ApplicantAddResponse() {
    }

    public ApplicantAddResponse(int id, String userName, String about) {
        super(id, userName);
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
