package com.BootCampProject.BootCampProject.service.concrete;


import com.BootCampProject.BootCampProject.entity.Instructor;
import com.BootCampProject.BootCampProject.repository.InstructorRepository;
import com.BootCampProject.BootCampProject.service.abstracts.InstructorService;
import com.BootCampProject.BootCampProject.service.dtos.requests.instructor.InstructorAddRequest;
import com.BootCampProject.BootCampProject.service.dtos.requests.instructor.InstructorUpdateRequest;
import com.BootCampProject.BootCampProject.service.dtos.responses.instructor.InstructorAddResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.instructor.InstructorGetByIdResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.instructor.InstructorUpdatedResponse;

import com.BootCampProject.BootCampProject.service.dtos.responses.instructor.InstructorGetListResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstructorServiceImpl implements InstructorService {


    private final InstructorRepository instructorRepository;
    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }


    @Override
    public InstructorAddResponse add(InstructorAddRequest instructorAddRequest) {
        Instructor instructor = new Instructor
                (
                        instructorAddRequest.getUserName(),instructorAddRequest.getFirstName(),
                        instructorAddRequest.getLastName(),instructorAddRequest.getDateOfBirth(),
                        instructorAddRequest.getNationalIdentity(),instructorAddRequest.getEmail(),
                        instructorAddRequest.getPassword(),instructorAddRequest.getCompanyName()
                );
        Instructor addedResponse = instructorRepository.save(instructor);
        InstructorAddResponse response = new InstructorAddResponse(addedResponse.getId(),addedResponse.getUserName(),addedResponse.getCompanyName());
        return response;
    }

    @Override
    public List<InstructorGetListResponse> getAll() {
        return instructorRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public InstructorUpdatedResponse update(InstructorUpdateRequest instructorUpdateRequest) {
        Instructor instructor = instructorRepository.findById(instructorUpdateRequest.getId())
                .orElseThrow(() -> new RuntimeException("Applicant not found"));
        InstructorUpdatedResponse response= mapToInstructorUpdatedResponse(instructorUpdateRequest,instructor);
        return response;
    }

    @Override
    public void delete(int id) {
        instructorRepository.deleteById(id);
    }

    @Override
    public InstructorGetByIdResponse getById(int id) {
        Instructor employee = instructorRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        InstructorGetByIdResponse response = new InstructorGetByIdResponse(employee.getId(), employee.getUserName(), employee.getFirstName(),
                employee.getLastName(), employee.getDateOfBirth(), employee.getNationalIdentity(), employee.getEmail(),employee.getCompanyName());
        return response;
    }




    private InstructorUpdatedResponse mapToInstructorUpdatedResponse(InstructorUpdateRequest instructorUpdateRequest,Instructor instructor)
    {
        instructor.setUserName(instructorUpdateRequest.getUserName());
        instructor.setFirstName(instructorUpdateRequest.getFirstName());
        instructor.setLastName(instructorUpdateRequest.getLastName());
        instructor.setEmail(instructorUpdateRequest.getEmail());
        instructor.setPassword(instructorUpdateRequest.getPassword());
        instructor.setDateOfBirth(instructorUpdateRequest.getDateOfBirth());
        instructor.setNationalIdentity(instructorUpdateRequest.getNationalIdentity());
        instructor.setCompanyName(instructorUpdateRequest.getCompanyName());
        Instructor updatedApplicant = instructorRepository.save(instructor);

        InstructorUpdatedResponse response = new InstructorUpdatedResponse();
        response.setId(updatedApplicant.getId());
        response.setUserName(updatedApplicant.getUserName());
        response.setFirstName(updatedApplicant.getFirstName());
        response.setLastName(updatedApplicant.getLastName());
        response.setDateOfBirth(updatedApplicant.getDateOfBirth());
        response.setEmail(updatedApplicant.getEmail());
        response.setCompanyName(updatedApplicant.getCompanyName());
        response.setNationalIdentity(updatedApplicant.getNationalIdentity());
        return response;
    }


    private InstructorGetListResponse mapToResponse(Instructor instructor){
        InstructorGetListResponse response = new InstructorGetListResponse();
        response.setId(instructor.getId());
        response.setUserName(instructor.getUserName());
        response.setFirstName(instructor.getFirstName());
        response.setLastName(instructor.getLastName());
        response.setCompanyName(instructor.getCompanyName());
        return response;
    }

}
