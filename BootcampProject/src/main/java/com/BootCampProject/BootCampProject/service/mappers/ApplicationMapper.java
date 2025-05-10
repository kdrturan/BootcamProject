package com.BootCampProject.BootCampProject.service.mappers;

import com.BootCampProject.BootCampProject.entity.Application;
import com.BootCampProject.BootCampProject.entity.Bootcamp;
import com.BootCampProject.BootCampProject.service.dtos.requests.application.ApplicationAddRequest;
import com.BootCampProject.BootCampProject.service.dtos.requests.application.ApplicationUpdateRequest;
import com.BootCampProject.BootCampProject.service.dtos.requests.bootcamp.BootcampUpdateRequest;
import com.BootCampProject.BootCampProject.service.dtos.responses.application.ApplicationAddResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.application.ApplicationGetByIdResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.application.ApplicationGetListResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.application.ApplicationUpdatedResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.bootcamp.BootcampGetByIdResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.bootcamp.BootcampUpdatedResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ApplicationMapper {
    ApplicationMapper INSTANCE = Mappers.getMapper(ApplicationMapper.class);



    @Mapping(target = "applicantId", source = "applicant.id")
    @Mapping(target = "bootcampId", source = "bootcamp.id")
    ApplicationUpdatedResponse applicationUpdatedResponseFromApplication(Application application);
    @Mapping(target = "applicantId", source = "applicant.id")
    @Mapping(target = "bootcampId", source = "bootcamp.id")
    ApplicationGetByIdResponse bootcampGetByIdResponseFromApplication(Application application);
    @Mapping(target = "applicant.id", source = "applicantId")
    @Mapping(target = "bootcamp.id", source = "bootcampId")
    Application applicationFromApplicationUpdateRequest(ApplicationUpdateRequest applicationUpdateRequest);
    @Mapping(target = "bootcamp.id", source = "bootcampId")
    @Mapping(target = "applicant.id", source = "applicantId")
    Application applicationFromApplicationAddRequest(ApplicationAddRequest applicationAddRequest);
    @Mapping(target = "applicantId", source = "applicant.id")
    @Mapping(target = "bootcampId", source = "bootcamp.id")
    ApplicationAddResponse applicationAddResponseFromApplication(Application application);
    @Mapping(target = "applicantId", source = "applicant.id")

    ApplicationGetListResponse applicationGetListResponseFromApplication(Application application);

}
