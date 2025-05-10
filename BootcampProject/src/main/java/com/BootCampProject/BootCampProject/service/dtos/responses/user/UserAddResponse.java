package com.BootCampProject.BootCampProject.service.dtos.responses.user;

public class UserAddResponse {

    public UserAddResponse() {

    }

    public UserAddResponse(int id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    private int id;
    private String userName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
