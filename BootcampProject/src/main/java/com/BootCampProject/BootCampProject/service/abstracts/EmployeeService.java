package com.BootCampProject.BootCampProject.service.abstracts;


import com.BootCampProject.BootCampProject.service.dtos.requests.employee.EmployeeAddRequest;
import com.BootCampProject.BootCampProject.service.dtos.requests.employee.EmployeeUpdateRequest;
import com.BootCampProject.BootCampProject.service.dtos.responses.employee.EmployeeAddResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.employee.EmployeeGetByIdResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.employee.EmployeeGetListResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.employee.EmployeeUpdatedResponse;

import java.util.List;

public interface EmployeeService {

    EmployeeAddResponse add(EmployeeAddRequest employeeAddRequest);
    List<EmployeeGetListResponse> getAll();
    EmployeeUpdatedResponse update(EmployeeUpdateRequest employeeUpdateRequest);
    void delete(int id);
    EmployeeGetByIdResponse getById(int id);

}
