package com.BootCampProject.BootCampProject.service.abstracts;

import com.BootCampProject.BootCampProject.service.dtos.requests.instructor.InstructorAddRequest;
import com.BootCampProject.BootCampProject.service.dtos.requests.instructor.InstructorUpdateRequest;
import com.BootCampProject.BootCampProject.service.dtos.responses.instructor.InstructorAddResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.instructor.InstructorGetByIdResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.instructor.InstructorUpdatedResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.instructor.InstructorGetListResponse;

import java.util.List;

public interface InstructorService {
    InstructorAddResponse add(InstructorAddRequest instructorAddRequest);
    List<InstructorGetListResponse> getAll();
    InstructorUpdatedResponse update(InstructorUpdateRequest instructorUpdateRequest);
    void delete(int id);
    InstructorGetByIdResponse getById(int id);

}
