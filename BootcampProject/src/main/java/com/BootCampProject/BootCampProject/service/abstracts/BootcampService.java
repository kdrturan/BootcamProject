package com.BootCampProject.BootCampProject.service.abstracts;


import com.BootCampProject.BootCampProject.service.dtos.requests.bootcamp.BootcampAddRequest;
import com.BootCampProject.BootCampProject.service.dtos.requests.bootcamp.BootcampUpdateRequest;
import com.BootCampProject.BootCampProject.service.dtos.responses.bootcamp.BootcampAddResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.bootcamp.BootcampGetByIdResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.bootcamp.BootcampGetListResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.bootcamp.BootcampUpdatedResponse;

import java.util.List;

public interface BootcampService {
    BootcampAddResponse add(BootcampAddRequest bootcampAddRequest);
    List<BootcampGetListResponse> getAll();
    BootcampUpdatedResponse update(BootcampUpdateRequest bootcampUpdateRequest);
    void delete(int id);
    BootcampGetByIdResponse getById(int id);
}
