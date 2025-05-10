package com.BootCampProject.BootCampProject.service.dtos.responses.employee;

import com.BootCampProject.BootCampProject.service.dtos.responses.user.UserAddResponse;

public class EmployeeAddResponse extends UserAddResponse {

    public EmployeeAddResponse() {
    }

    public EmployeeAddResponse(int id, String userName, String position) {
        super(id, userName);
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
