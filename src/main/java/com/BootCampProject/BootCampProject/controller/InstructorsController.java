package com.BootCampProject.BootCampProject.controller;


import com.BootCampProject.BootCampProject.service.abstracts.InstructorService;
import com.BootCampProject.BootCampProject.service.dtos.requests.instructor.InstructorAddRequest;
import com.BootCampProject.BootCampProject.service.dtos.requests.instructor.InstructorUpdateRequest;
import com.BootCampProject.BootCampProject.service.dtos.responses.instructor.InstructorAddResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.instructor.InstructorGetByIdResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.instructor.InstructorGetListResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.instructor.InstructorUpdatedResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
public class InstructorsController {

    private final InstructorService instructorService;

    public InstructorsController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InstructorGetListResponse> getUsers(){
        return instructorService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InstructorGetByIdResponse getById(@PathVariable int id){
        return instructorService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InstructorAddResponse add(@RequestBody InstructorAddRequest instructor){
        return instructorService.add(instructor);
    }


    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public InstructorUpdatedResponse update(@RequestBody InstructorUpdateRequest request){
        return instructorService.update(request);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id){
        instructorService.delete(id);
    }
}
