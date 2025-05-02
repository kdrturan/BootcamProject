package com.BootCampProject.BootCampProject.service.abstracts;

import com.BootCampProject.BootCampProject.service.dtos.requests.user.UserAddRequest;
import com.BootCampProject.BootCampProject.service.dtos.requests.user.UserUpdateRequest;
import com.BootCampProject.BootCampProject.service.dtos.responses.user.UserAddResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.user.UserGetByIdResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.user.UserGetListResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.user.UserUpdatedResponse;

import java.util.List;


public interface UserService {
    UserAddResponse add(UserAddRequest userAddRequest);
    List<UserGetListResponse> getAll();
    UserUpdatedResponse update(UserUpdateRequest userUpdateRequest);
    void delete(int id);
    UserGetByIdResponse getById(int id);
}
