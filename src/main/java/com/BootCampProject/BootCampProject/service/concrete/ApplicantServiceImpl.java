package com.BootCampProject.BootCampProject.service.concrete;


import com.BootCampProject.BootCampProject.entity.Applicant;
import com.BootCampProject.BootCampProject.repository.ApplicantRepository;
import com.BootCampProject.BootCampProject.service.abstracts.ApplicantService;
import com.BootCampProject.BootCampProject.service.dtos.requests.applicant.ApplicantAddRequest;
import com.BootCampProject.BootCampProject.service.dtos.requests.applicant.ApplicantUpdateRequest;
import com.BootCampProject.BootCampProject.service.dtos.responses.applicant.ApplicantAddResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.applicant.ApplicantGetByIdResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.applicant.ApplicantGetListResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.applicant.ApplicantUpdatedResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    private final ApplicantRepository applicantRepository;
    public ApplicantServiceImpl(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }


    @Override
    public ApplicantAddResponse add(ApplicantAddRequest applicantAddRequest) {
        Applicant applicant = new Applicant
                (
                        applicantAddRequest.getUserName(),applicantAddRequest.getFirstName(),
                        applicantAddRequest.getLastName(),applicantAddRequest.getDateOfBirth(),
                        applicantAddRequest.getNationalIdentity(),applicantAddRequest.getEmail(),
                        applicantAddRequest.getPassword(),applicantAddRequest.getAbout()
                );
        Applicant addedResponse = applicantRepository.save(applicant);
        ApplicantAddResponse response = new ApplicantAddResponse(addedResponse.getId(),addedResponse.getUserName(),addedResponse.getAbout());
        return response;
    }

    @Override
    public List<ApplicantGetListResponse> getAll() {
        return applicantRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public ApplicantUpdatedResponse update(ApplicantUpdateRequest applicantUpdateRequest) {
        Applicant applicant = applicantRepository.findById(applicantUpdateRequest.getId())
                .orElseThrow(() -> new RuntimeException("Applicant not found"));
        ApplicantUpdatedResponse response= mapToApplicantUpdatedResponse(applicantUpdateRequest,applicant);
        return response;
    }

    @Override
    public void delete(int id) {
        applicantRepository.deleteById(id);
    }

    @Override
    public ApplicantGetByIdResponse getById(int id) {
        Applicant applicant = applicantRepository.findById(id).orElseThrow(() -> new RuntimeException("Applicant not found"));
        ApplicantGetByIdResponse response = new ApplicantGetByIdResponse(applicant.getId(), applicant.getUserName(), applicant.getFirstName(),
                applicant.getLastName(), applicant.getDateOfBirth(), applicant.getNationalIdentity(), applicant.getEmail(),applicant.getAbout());
        return response;
    }




    private ApplicantUpdatedResponse mapToApplicantUpdatedResponse(ApplicantUpdateRequest applicantUpdateRequest,Applicant applicant)
    {
        applicant.setUserName(applicantUpdateRequest.getUserName());
        applicant.setFirstName(applicantUpdateRequest.getFirstName());
        applicant.setLastName(applicantUpdateRequest.getLastName());
        applicant.setEmail(applicantUpdateRequest.getEmail());
        applicant.setPassword(applicantUpdateRequest.getPassword());
        applicant.setDateOfBirth(applicantUpdateRequest.getDateOfBirth());
        applicant.setNationalIdentity(applicantUpdateRequest.getNationalIdentity());
        applicant.setAbout(applicantUpdateRequest.getAbout());
        Applicant updatedApplicant = applicantRepository.save(applicant);

        ApplicantUpdatedResponse response = new ApplicantUpdatedResponse();
        response.setId(updatedApplicant.getId());
        response.setUserName(updatedApplicant.getUserName());
        response.setFirstName(updatedApplicant.getFirstName());
        response.setLastName(updatedApplicant.getLastName());
        response.setDateOfBirth(updatedApplicant.getDateOfBirth());
        response.setEmail(updatedApplicant.getEmail());
        response.setAbout(updatedApplicant.getAbout());
        response.setNationalIdentity(updatedApplicant.getNationalIdentity());
        return response;
    }


    private ApplicantGetListResponse mapToResponse(Applicant applicant){
        ApplicantGetListResponse response = new ApplicantGetListResponse();
        response.setId(applicant.getId());
        response.setUserName(applicant.getUserName());
        response.setFirstName(applicant.getFirstName());
        response.setLastName(applicant.getLastName());
        response.setAbout(applicant.getAbout());
        return response;
    }

}
