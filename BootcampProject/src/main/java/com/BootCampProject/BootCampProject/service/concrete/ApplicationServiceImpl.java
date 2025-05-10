package com.BootCampProject.BootCampProject.service.concrete;

import com.BootCampProject.BootCampProject.entity.Application;
import com.BootCampProject.BootCampProject.entity.Bootcamp;
import com.BootCampProject.BootCampProject.repository.ApplicationRepository;
import com.BootCampProject.BootCampProject.service.abstracts.ApplicationService;
import com.BootCampProject.BootCampProject.service.dtos.requests.application.ApplicationAddRequest;
import com.BootCampProject.BootCampProject.service.dtos.requests.application.ApplicationUpdateRequest;
import com.BootCampProject.BootCampProject.service.dtos.responses.application.ApplicationAddResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.application.ApplicationGetByIdResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.application.ApplicationGetListResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.application.ApplicationUpdatedResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.bootcamp.BootcampAddResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.bootcamp.BootcampGetByIdResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.bootcamp.BootcampGetListResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.bootcamp.BootcampUpdatedResponse;
import com.BootCampProject.BootCampProject.service.mappers.ApplicationMapper;
import com.BootCampProject.BootCampProject.service.mappers.BootcampMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class ApplicationServiceImpl implements ApplicationService {


        private  final ApplicationRepository applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public ApplicationAddResponse add(ApplicationAddRequest applicationAddRequest) {
        Application application = ApplicationMapper.INSTANCE.applicationFromApplicationAddRequest(applicationAddRequest);
        Application addedApplication = applicationRepository.save(application);
        ApplicationAddResponse response = ApplicationMapper.INSTANCE.applicationAddResponseFromApplication(addedApplication);
        return  response;
    }

    @Override
    public List<ApplicationGetListResponse> getAll() {
        List<Application> applications = applicationRepository.findAll();
        List<ApplicationGetListResponse> response = applications.stream().map(ApplicationMapper.INSTANCE::applicationGetListResponseFromApplication)
                .collect(Collectors.toList());
        return  response;
    }

    @Override
    public ApplicationUpdatedResponse update(ApplicationUpdateRequest applicationUpdateRequest) {
        Application application = applicationRepository.findById(applicationUpdateRequest.id()).orElseThrow(()-> new RuntimeException("Bootcamp not found"));
        Application updateapplication = ApplicationMapper.INSTANCE.applicationFromApplicationUpdateRequest(applicationUpdateRequest);
        updateapplication.setId(application.getId());
        Application updatedApplication = applicationRepository.save(updateapplication);
        ApplicationUpdatedResponse response = ApplicationMapper.INSTANCE.applicationUpdatedResponseFromApplication(updatedApplication);
        return response;
    }

    @Override
    public void delete(int id) {
        applicationRepository.deleteById(id);
    }

    @Override
    public ApplicationGetByIdResponse getById(int id) {
        Application application = applicationRepository.findById(id).orElseThrow(()-> new RuntimeException("Application not found"));
        ApplicationGetByIdResponse response = ApplicationMapper.INSTANCE.bootcampGetByIdResponseFromApplication(application);
        return  response;
    }
}
