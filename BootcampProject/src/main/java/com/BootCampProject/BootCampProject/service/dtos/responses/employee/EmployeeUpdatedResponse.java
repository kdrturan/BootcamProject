package com.BootCampProject.BootCampProject.service.dtos.responses.employee;

import com.BootCampProject.BootCampProject.service.dtos.responses.user.UserUpdatedResponse;

public class EmployeeUpdatedResponse extends UserUpdatedResponse {


    public EmployeeUpdatedResponse() {
    }

    public EmployeeUpdatedResponse(int id, String userName, String firstName, String lastName,
                                   String dateOfBirth, String nationalIdentity, String email, String position) {
        super(id, userName, firstName, lastName, dateOfBirth, nationalIdentity, email);
        this.position = position;
    }

    private String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
