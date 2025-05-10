package com.BootCampProject.BootCampProject.service.mappers;

import com.BootCampProject.BootCampProject.entity.Bootcamp;
import com.BootCampProject.BootCampProject.entity.enums.BootcampState;
import com.BootCampProject.BootCampProject.service.dtos.requests.bootcamp.BootcampAddRequest;
import com.BootCampProject.BootCampProject.service.dtos.requests.bootcamp.BootcampUpdateRequest;
import com.BootCampProject.BootCampProject.service.dtos.responses.bootcamp.BootcampAddResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.bootcamp.BootcampGetByIdResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.bootcamp.BootcampGetListResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.bootcamp.BootcampUpdatedResponse;
import java.time.LocalDate;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-02T21:56:29+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
public class BootcampMapperImpl implements BootcampMapper {

    @Override
    public Bootcamp bootcampFromBootcampAddRequest(BootcampAddRequest bootcampAddRequest) {
        if ( bootcampAddRequest == null ) {
            return null;
        }

        Bootcamp bootcamp = new Bootcamp();

        bootcamp.setName( bootcampAddRequest.name() );
        bootcamp.setStartDate( bootcampAddRequest.startDate() );
        bootcamp.setEndDate( bootcampAddRequest.endDate() );
        bootcamp.setBootcampState( bootcampAddRequest.bootcampState() );

        return bootcamp;
    }

    @Override
    public Bootcamp bootcampFromBootcampUpdateRequest(BootcampUpdateRequest bootcampUpdateRequest) {
        if ( bootcampUpdateRequest == null ) {
            return null;
        }

        Bootcamp bootcamp = new Bootcamp();

        bootcamp.setId( bootcampUpdateRequest.id() );
        bootcamp.setName( bootcampUpdateRequest.name() );
        bootcamp.setStartDate( bootcampUpdateRequest.startDate() );
        bootcamp.setEndDate( bootcampUpdateRequest.endDate() );
        bootcamp.setBootcampState( bootcampUpdateRequest.bootcampState() );

        return bootcamp;
    }

    @Override
    public BootcampUpdatedResponse bootcampUpdatedResponseFromBootcamp(Bootcamp bootcamp) {
        if ( bootcamp == null ) {
            return null;
        }

        int id = 0;
        String name = null;
        LocalDate startDate = null;
        LocalDate endDate = null;
        BootcampState bootcampState = null;

        id = bootcamp.getId();
        name = bootcamp.getName();
        startDate = bootcamp.getStartDate();
        endDate = bootcamp.getEndDate();
        bootcampState = bootcamp.getBootcampState();

        int instructorId = 0;

        BootcampUpdatedResponse bootcampUpdatedResponse = new BootcampUpdatedResponse( id, name, instructorId, startDate, endDate, bootcampState );

        return bootcampUpdatedResponse;
    }

    @Override
    public BootcampAddResponse bootcampAddResponseFromBootcamp(Bootcamp bootcamp) {
        if ( bootcamp == null ) {
            return null;
        }

        int id = 0;
        String name = null;

        id = bootcamp.getId();
        name = bootcamp.getName();

        BootcampAddResponse bootcampAddResponse = new BootcampAddResponse( id, name );

        return bootcampAddResponse;
    }

    @Override
    public BootcampGetListResponse bootcampGetListResponseFromBootcamp(Bootcamp bootcamp) {
        if ( bootcamp == null ) {
            return null;
        }

        int id = 0;
        String name = null;
        BootcampState bootcampState = null;

        id = bootcamp.getId();
        name = bootcamp.getName();
        bootcampState = bootcamp.getBootcampState();

        BootcampGetListResponse bootcampGetListResponse = new BootcampGetListResponse( id, name, bootcampState );

        return bootcampGetListResponse;
    }

    @Override
    public BootcampGetByIdResponse bootcampGetByIdResponseFromBootcamp(Bootcamp bootcamp) {
        if ( bootcamp == null ) {
            return null;
        }

        int id = 0;
        String name = null;
        LocalDate startDate = null;
        LocalDate endDate = null;
        BootcampState bootcampState = null;

        id = bootcamp.getId();
        name = bootcamp.getName();
        startDate = bootcamp.getStartDate();
        endDate = bootcamp.getEndDate();
        bootcampState = bootcamp.getBootcampState();

        int instructorId = 0;

        BootcampGetByIdResponse bootcampGetByIdResponse = new BootcampGetByIdResponse( id, name, instructorId, startDate, endDate, bootcampState );

        return bootcampGetByIdResponse;
    }
}
