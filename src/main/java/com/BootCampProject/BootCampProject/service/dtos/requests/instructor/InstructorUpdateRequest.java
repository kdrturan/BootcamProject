package com.BootCampProject.BootCampProject.service.dtos.requests.instructor;

import com.BootCampProject.BootCampProject.service.dtos.requests.user.UserUpdateRequest;

public class InstructorUpdateRequest extends UserUpdateRequest {


    public InstructorUpdateRequest() {
    }

    public InstructorUpdateRequest(int id, String userName, String firstName, String lastName, String dateOfBirth,
                                   String nationalIdentity, String email, String password, String companyName) {
        super(id, userName, firstName, lastName, dateOfBirth, nationalIdentity, email, password);
        this.companyName = companyName;
    }

    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
