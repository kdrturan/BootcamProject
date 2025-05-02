package com.BootCampProject.BootCampProject.service.dtos.responses.applicant;

import com.BootCampProject.BootCampProject.service.dtos.responses.user.UserUpdatedResponse;

public class ApplicantUpdatedResponse extends UserUpdatedResponse {

    public ApplicantUpdatedResponse() {
    }

    public ApplicantUpdatedResponse(int id, String userName, String firstName, String lastName,
                                    String dateOfBirth, String nationalIdentity, String email, String about) {
        super(id, userName, firstName, lastName, dateOfBirth, nationalIdentity, email);
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
