package com.BootCampProject.BootCampProject.service.concrete;


import com.BootCampProject.BootCampProject.entity.Employee;
import com.BootCampProject.BootCampProject.repository.EmployeeRepository;
import com.BootCampProject.BootCampProject.service.abstracts.EmployeeService;

import com.BootCampProject.BootCampProject.service.dtos.requests.employee.EmployeeAddRequest;
import com.BootCampProject.BootCampProject.service.dtos.requests.employee.EmployeeUpdateRequest;
import com.BootCampProject.BootCampProject.service.dtos.responses.employee.EmployeeAddResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.employee.EmployeeGetByIdResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.employee.EmployeeGetListResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.employee.EmployeeUpdatedResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmplooyeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    public EmplooyeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public EmployeeAddResponse add(EmployeeAddRequest employeeAddRequest) {
        Employee employee = new Employee
                (
                        employeeAddRequest.getUserName(),employeeAddRequest.getFirstName(),
                        employeeAddRequest.getLastName(),employeeAddRequest.getDateOfBirth(),
                        employeeAddRequest.getNationalIdentity(),employeeAddRequest.getEmail(),
                        employeeAddRequest.getPassword(),employeeAddRequest.getPosition()
                );
        Employee addedResponse = employeeRepository.save(employee);
        EmployeeAddResponse response = new EmployeeAddResponse(addedResponse.getId(),addedResponse.getUserName(),addedResponse.getPosition());
        return response;
    }

    @Override
    public List<EmployeeGetListResponse> getAll() {
        return employeeRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public EmployeeUpdatedResponse update(EmployeeUpdateRequest employeeUpdateRequest) {
        Employee employee = employeeRepository.findById(employeeUpdateRequest.getId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        EmployeeUpdatedResponse response= mapToEmployeeUpdatedResponse(employeeUpdateRequest,employee);
        return response;
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeGetByIdResponse getById(int id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        EmployeeGetByIdResponse response = new EmployeeGetByIdResponse(employee.getId(), employee.getUserName(), employee.getFirstName(),
                employee.getLastName(), employee.getDateOfBirth(), employee.getNationalIdentity(), employee.getEmail(),employee.getPosition());
        return response;
    }




    private EmployeeUpdatedResponse mapToEmployeeUpdatedResponse(EmployeeUpdateRequest employeeUpdateRequest,Employee employee)
    {
        employee.setUserName(employeeUpdateRequest.getUserName());
        employee.setFirstName(employeeUpdateRequest.getFirstName());
        employee.setLastName(employeeUpdateRequest.getLastName());
        employee.setEmail(employeeUpdateRequest.getEmail());
        employee.setPassword(employeeUpdateRequest.getPassword());
        employee.setDateOfBirth(employeeUpdateRequest.getDateOfBirth());
        employee.setNationalIdentity(employeeUpdateRequest.getNationalIdentity());
        employee.setPosition(employeeUpdateRequest.getPosition());
        Employee updatedApplicant = employeeRepository.save(employee);

        EmployeeUpdatedResponse response = new EmployeeUpdatedResponse();
        response.setId(updatedApplicant.getId());
        response.setUserName(updatedApplicant.getUserName());
        response.setFirstName(updatedApplicant.getFirstName());
        response.setLastName(updatedApplicant.getLastName());
        response.setDateOfBirth(updatedApplicant.getDateOfBirth());
        response.setEmail(updatedApplicant.getEmail());
        response.setPosition(updatedApplicant.getPosition());
        response.setNationalIdentity(updatedApplicant.getNationalIdentity());
        return response;
    }


    private EmployeeGetListResponse mapToResponse(Employee employee){
        EmployeeGetListResponse response = new EmployeeGetListResponse();
        response.setId(employee.getId());
        response.setUserName(employee.getUserName());
        response.setFirstName(employee.getFirstName());
        response.setLastName(employee.getLastName());
        response.setPosition(employee.getPosition());
        return response;
    }

}
