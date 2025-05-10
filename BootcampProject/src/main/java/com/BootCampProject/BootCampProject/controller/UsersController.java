package com.BootCampProject.BootCampProject.controller;


import com.BootCampProject.BootCampProject.service.dtos.requests.user.UserAddRequest;
import com.BootCampProject.BootCampProject.service.dtos.requests.user.UserUpdateRequest;
import com.BootCampProject.BootCampProject.service.dtos.responses.user.UserAddResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.user.UserGetByIdResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.user.UserGetListResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.user.UserUpdatedResponse;
import com.BootCampProject.BootCampProject.service.abstracts.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserGetListResponse> getUsers(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserGetByIdResponse getById(@PathVariable int id){
        return userService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserAddResponse add(@RequestBody UserAddRequest user){
        return userService.add(user);
    }


    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UserUpdatedResponse update(@RequestBody UserUpdateRequest request){
        return userService.update(request);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id){
        userService.delete(id);
    }
}