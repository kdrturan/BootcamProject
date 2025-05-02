package com.BootCampProject.BootCampProject.service.dtos.responses.instructor;

import com.BootCampProject.BootCampProject.service.dtos.responses.user.UserGetByIdResponse;

public class InstructorGetByIdResponse extends UserGetByIdResponse {

    public InstructorGetByIdResponse() {
    }

    public InstructorGetByIdResponse(int id, String userName, String firstName, String lastName,
                                     String dateOfBirth, String nationalIdentity, String email, String companyName) {
        super(id, userName, firstName, lastName, dateOfBirth, nationalIdentity, email);
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
