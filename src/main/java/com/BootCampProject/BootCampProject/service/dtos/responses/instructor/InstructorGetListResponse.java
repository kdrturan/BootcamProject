package com.BootCampProject.BootCampProject.service.dtos.responses.instructor;

import com.BootCampProject.BootCampProject.service.dtos.responses.user.UserGetListResponse;

public class InstructorGetListResponse extends UserGetListResponse {


    public InstructorGetListResponse() {

    }

    public InstructorGetListResponse(int id, String userName, String firstName, String lastName, String companyName) {
        super(id, userName, firstName, lastName);
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
