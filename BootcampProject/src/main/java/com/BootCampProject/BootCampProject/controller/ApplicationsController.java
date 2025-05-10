package com.BootCampProject.BootCampProject.controller;

import com.BootCampProject.BootCampProject.service.abstracts.ApplicationService;
import com.BootCampProject.BootCampProject.service.dtos.requests.application.ApplicationAddRequest;
import com.BootCampProject.BootCampProject.service.dtos.requests.application.ApplicationUpdateRequest;
import com.BootCampProject.BootCampProject.service.dtos.responses.application.ApplicationAddResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.application.ApplicationGetListResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.application.ApplicationUpdatedResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationsController {

    private final ApplicationService applicationService;

    public ApplicationsController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApplicationAddResponse add(ApplicationAddRequest applicationAddRequest)
    {
        return applicationService.add(applicationAddRequest);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ApplicationGetListResponse> getList(){
        return applicationService.getAll();
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id){
        applicationService.delete(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ApplicationUpdatedResponse update(@RequestBody ApplicationUpdateRequest request){
        return applicationService.update(request);
    }

}