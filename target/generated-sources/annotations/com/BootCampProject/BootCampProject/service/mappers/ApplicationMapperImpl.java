package com.BootCampProject.BootCampProject.service.mappers;

import com.BootCampProject.BootCampProject.entity.Applicant;
import com.BootCampProject.BootCampProject.entity.Application;
import com.BootCampProject.BootCampProject.entity.Bootcamp;
import com.BootCampProject.BootCampProject.entity.enums.ApplicationState;
import com.BootCampProject.BootCampProject.service.dtos.requests.application.ApplicationAddRequest;
import com.BootCampProject.BootCampProject.service.dtos.requests.application.ApplicationUpdateRequest;
import com.BootCampProject.BootCampProject.service.dtos.responses.application.ApplicationAddResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.application.ApplicationGetByIdResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.application.ApplicationGetListResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.application.ApplicationUpdatedResponse;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-02T22:37:19+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
public class ApplicationMapperImpl implements ApplicationMapper {

    @Override
    public ApplicationUpdatedResponse applicationUpdatedResponseFromApplication(Application application) {
        if ( application == null ) {
            return null;
        }

        int applicantId = 0;
        int bootcampId = 0;
        int id = 0;
        ApplicationState applicationState = null;

        applicantId = applicationApplicantId( application );
        bootcampId = applicationBootcampId( application );
        id = application.getId();
        applicationState = application.getApplicationState();

        ApplicationUpdatedResponse applicationUpdatedResponse = new ApplicationUpdatedResponse( id, applicantId, bootcampId, applicationState );

        return applicationUpdatedResponse;
    }

    @Override
    public ApplicationGetByIdResponse bootcampGetByIdResponseFromApplication(Application application) {
        if ( application == null ) {
            return null;
        }

        int applicantId = 0;
        int bootcampId = 0;
        int id = 0;
        ApplicationState applicationState = null;

        applicantId = applicationApplicantId( application );
        bootcampId = applicationBootcampId( application );
        id = application.getId();
        applicationState = application.getApplicationState();

        ApplicationGetByIdResponse applicationGetByIdResponse = new ApplicationGetByIdResponse( id, applicantId, bootcampId, applicationState );

        return applicationGetByIdResponse;
    }

    @Override
    public Application applicationFromApplicationUpdateRequest(ApplicationUpdateRequest applicationUpdateRequest) {
        if ( applicationUpdateRequest == null ) {
            return null;
        }

        Application application = new Application();

        application.setApplicant( applicationUpdateRequestToApplicant( applicationUpdateRequest ) );
        application.setBootcamp( applicationUpdateRequestToBootcamp( applicationUpdateRequest ) );
        application.setId( applicationUpdateRequest.id() );
        application.setApplicationState( applicationUpdateRequest.applicationState() );

        return application;
    }

    @Override
    public Application applicationFromApplicationAddRequest(ApplicationAddRequest applicationAddRequest) {
        if ( applicationAddRequest == null ) {
            return null;
        }

        Application application = new Application();

        application.setBootcamp( applicationAddRequestToBootcamp( applicationAddRequest ) );
        application.setApplicant( applicationAddRequestToApplicant( applicationAddRequest ) );
        application.setApplicationState( applicationAddRequest.applicationState() );

        return application;
    }

    @Override
    public ApplicationAddResponse applicationAddResponseFromApplication(Application application) {
        if ( application == null ) {
            return null;
        }

        int applicantId = 0;
        int bootcampId = 0;
        int id = 0;

        applicantId = applicationApplicantId( application );
        bootcampId = applicationBootcampId( application );
        id = application.getId();

        ApplicationAddResponse applicationAddResponse = new ApplicationAddResponse( id, applicantId, bootcampId );

        return applicationAddResponse;
    }

    @Override
    public ApplicationGetListResponse applicationGetListResponseFromApplication(Application application) {
        if ( application == null ) {
            return null;
        }

        int applicantId = 0;
        int id = 0;

        applicantId = applicationApplicantId( application );
        id = application.getId();

        ApplicationGetListResponse applicationGetListResponse = new ApplicationGetListResponse( id, applicantId );

        return applicationGetListResponse;
    }

    private int applicationApplicantId(Application application) {
        if ( application == null ) {
            return 0;
        }
        Applicant applicant = application.getApplicant();
        if ( applicant == null ) {
            return 0;
        }
        int id = applicant.getId();
        return id;
    }

    private int applicationBootcampId(Application application) {
        if ( application == null ) {
            return 0;
        }
        Bootcamp bootcamp = application.getBootcamp();
        if ( bootcamp == null ) {
            return 0;
        }
        int id = bootcamp.getId();
        return id;
    }

    protected Applicant applicationUpdateRequestToApplicant(ApplicationUpdateRequest applicationUpdateRequest) {
        if ( applicationUpdateRequest == null ) {
            return null;
        }

        Applicant applicant = new Applicant();

        applicant.setId( applicationUpdateRequest.applicantId() );

        return applicant;
    }

    protected Bootcamp applicationUpdateRequestToBootcamp(ApplicationUpdateRequest applicationUpdateRequest) {
        if ( applicationUpdateRequest == null ) {
            return null;
        }

        Bootcamp bootcamp = new Bootcamp();

        bootcamp.setId( applicationUpdateRequest.bootcampId() );

        return bootcamp;
    }

    protected Bootcamp applicationAddRequestToBootcamp(ApplicationAddRequest applicationAddRequest) {
        if ( applicationAddRequest == null ) {
            return null;
        }

        Bootcamp bootcamp = new Bootcamp();

        bootcamp.setId( applicationAddRequest.bootcampId() );

        return bootcamp;
    }

    protected Applicant applicationAddRequestToApplicant(ApplicationAddRequest applicationAddRequest) {
        if ( applicationAddRequest == null ) {
            return null;
        }

        Applicant applicant = new Applicant();

        applicant.setId( applicationAddRequest.applicantId() );

        return applicant;
    }
}
