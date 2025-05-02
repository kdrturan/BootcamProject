package com.BootCampProject.BootCampProject.service.dtos.responses.instructor;

import com.BootCampProject.BootCampProject.service.dtos.responses.user.UserAddResponse;

public class InstructorAddResponse extends UserAddResponse {

    public InstructorAddResponse() {
    }

    public InstructorAddResponse(int id, String userName, String companyName) {
        super(id, userName);
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
