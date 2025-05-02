package com.BootCampProject.BootCampProject.service.abstracts;


import com.BootCampProject.BootCampProject.service.dtos.requests.applicant.ApplicantAddRequest;
import com.BootCampProject.BootCampProject.service.dtos.requests.applicant.ApplicantUpdateRequest;
import com.BootCampProject.BootCampProject.service.dtos.responses.applicant.ApplicantAddResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.applicant.ApplicantGetByIdResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.applicant.ApplicantGetListResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.applicant.ApplicantUpdatedResponse;

import java.util.List;

public interface ApplicantService {

    ApplicantAddResponse add(ApplicantAddRequest applicantAddRequest);
    List<ApplicantGetListResponse> getAll();
    ApplicantUpdatedResponse update(ApplicantUpdateRequest applicantUpdateRequest);
    void delete(int id);
    ApplicantGetByIdResponse getById(int id);
}
