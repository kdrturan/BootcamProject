package com.BootCampProject.BootCampProject.controller;


import com.BootCampProject.BootCampProject.service.abstracts.EmployeeService;
import com.BootCampProject.BootCampProject.service.dtos.requests.employee.EmployeeAddRequest;
import com.BootCampProject.BootCampProject.service.dtos.requests.employee.EmployeeUpdateRequest;
import com.BootCampProject.BootCampProject.service.dtos.responses.employee.EmployeeAddResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.employee.EmployeeGetByIdResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.employee.EmployeeGetListResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.employee.EmployeeUpdatedResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emplooyes")
public class EmployeesController {

    private final EmployeeService employeeService;

    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeGetListResponse> getUsers(){
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeGetByIdResponse getById(@PathVariable int id){
        return employeeService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeAddResponse add(@RequestBody EmployeeAddRequest employee){
        return employeeService.add(employee);
    }


    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public EmployeeUpdatedResponse update(@RequestBody EmployeeUpdateRequest request){
        return employeeService.update(request);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id){
        employeeService.delete(id);
    }
}