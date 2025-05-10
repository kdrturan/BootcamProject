package com.BootCampProject.BootCampProject.service.dtos.requests.instructor;

import com.BootCampProject.BootCampProject.service.dtos.requests.user.UserAddRequest;

public class InstructorAddRequest extends UserAddRequest {


    public InstructorAddRequest() {
    }

    public InstructorAddRequest(String userName, String firstName, String lastName, String dateOfBirth,
                                String nationalIdentity, String email, String password, String companyName) {
        super(userName, firstName, lastName, dateOfBirth, nationalIdentity, email, password);
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
