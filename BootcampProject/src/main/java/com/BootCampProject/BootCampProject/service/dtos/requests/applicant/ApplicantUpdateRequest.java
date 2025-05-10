package com.BootCampProject.BootCampProject.service.dtos.requests.applicant;

import com.BootCampProject.BootCampProject.service.dtos.requests.user.UserUpdateRequest;

public class ApplicantUpdateRequest extends UserUpdateRequest {

    public ApplicantUpdateRequest() {
    }

    public ApplicantUpdateRequest(int id, String userName, String firstName, String lastName, String dateOfBirth,
                                  String nationalIdentity, String email, String password, String about) {
        super(id, userName, firstName, lastName, dateOfBirth, nationalIdentity, email, password);
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
