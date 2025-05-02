package com.BootCampProject.BootCampProject.controller;

import com.BootCampProject.BootCampProject.service.abstracts.ApplicantService;
import com.BootCampProject.BootCampProject.service.dtos.requests.applicant.ApplicantAddRequest;
import com.BootCampProject.BootCampProject.service.dtos.requests.applicant.ApplicantUpdateRequest;
import com.BootCampProject.BootCampProject.service.dtos.responses.applicant.ApplicantAddResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.applicant.ApplicantGetByIdResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.applicant.ApplicantGetListResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.applicant.ApplicantUpdatedResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicant")
public class ApplicantsController {

    private final ApplicantService applicantService;

    public ApplicantsController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ApplicantGetListResponse> getUsers(){
        return applicantService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApplicantGetByIdResponse getById(@PathVariable int id){
        return applicantService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApplicantAddResponse add(@RequestBody ApplicantAddRequest applicant){
        return applicantService.add(applicant);
    }


    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ApplicantUpdatedResponse update(@RequestBody ApplicantUpdateRequest request){
        return applicantService.update(request);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id){
        applicantService.delete(id);
    }
}
