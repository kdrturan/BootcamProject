package com.BootCampProject.BootCampProject.service.abstracts;


import com.BootCampProject.BootCampProject.service.dtos.requests.application.ApplicationAddRequest;
import com.BootCampProject.BootCampProject.service.dtos.requests.application.ApplicationUpdateRequest;
import com.BootCampProject.BootCampProject.service.dtos.responses.application.ApplicationAddResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.application.ApplicationGetByIdResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.application.ApplicationGetListResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.application.ApplicationUpdatedResponse;

import java.util.List;

public interface ApplicationService {
    ApplicationAddResponse add(ApplicationAddRequest applicationAddRequest);
    List<ApplicationGetListResponse> getAll();
    ApplicationUpdatedResponse update(ApplicationUpdateRequest applicationUpdateRequest);
    void delete(int id);
    ApplicationGetByIdResponse getById(int id);
}
