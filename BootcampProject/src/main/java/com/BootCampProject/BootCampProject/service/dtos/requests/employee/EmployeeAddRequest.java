package com.BootCampProject.BootCampProject.service.dtos.requests.employee;

import com.BootCampProject.BootCampProject.service.dtos.requests.user.UserAddRequest;

public class EmployeeAddRequest extends UserAddRequest {

    public EmployeeAddRequest() {
    }

    public EmployeeAddRequest(String userName, String firstName, String lastName, String dateOfBirth,
                              String nationalIdentity, String email, String password, String position) {
        super(userName, firstName, lastName, dateOfBirth, nationalIdentity, email, password);
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
