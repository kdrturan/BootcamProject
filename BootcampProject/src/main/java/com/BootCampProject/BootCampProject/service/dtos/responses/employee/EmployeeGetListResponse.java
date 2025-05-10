package com.BootCampProject.BootCampProject.service.dtos.responses.employee;

import com.BootCampProject.BootCampProject.service.dtos.responses.user.UserGetListResponse;

public class EmployeeGetListResponse extends UserGetListResponse {

    public EmployeeGetListResponse() {
    }

    public EmployeeGetListResponse(int id, String userName, String firstName, String lastName, String position) {
        super(id, userName, firstName, lastName);
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
