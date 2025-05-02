package com.BootCampProject.BootCampProject.service.mappers;

import com.BootCampProject.BootCampProject.entity.Bootcamp;
import com.BootCampProject.BootCampProject.service.dtos.requests.bootcamp.BootcampAddRequest;
import com.BootCampProject.BootCampProject.service.dtos.requests.bootcamp.BootcampUpdateRequest;
import com.BootCampProject.BootCampProject.service.dtos.responses.bootcamp.BootcampAddResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.bootcamp.BootcampGetByIdResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.bootcamp.BootcampGetListResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.bootcamp.BootcampUpdatedResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface BootcampMapper {

    BootcampMapper INSTANCE = Mappers.getMapper(BootcampMapper.class);

    Bootcamp bootcampFromBootcampAddRequest(BootcampAddRequest bootcampAddRequest);

    Bootcamp bootcampFromBootcampUpdateRequest(BootcampUpdateRequest bootcampUpdateRequest);
    BootcampUpdatedResponse bootcampUpdatedResponseFromBootcamp(Bootcamp bootcamp);
    BootcampAddResponse bootcampAddResponseFromBootcamp(Bootcamp bootcamp);

    BootcampGetListResponse bootcampGetListResponseFromBootcamp(Bootcamp bootcamp);
    BootcampGetByIdResponse bootcampGetByIdResponseFromBootcamp(Bootcamp bootcamp);


}
