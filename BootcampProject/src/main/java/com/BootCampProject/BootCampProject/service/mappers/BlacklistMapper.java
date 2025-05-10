package com.BootCampProject.BootCampProject.service.mappers;

import com.BootCampProject.BootCampProject.entity.Application;
import com.BootCampProject.BootCampProject.entity.Blacklist;
import com.BootCampProject.BootCampProject.entity.Bootcamp;
import com.BootCampProject.BootCampProject.service.dtos.requests.application.ApplicationAddRequest;
import com.BootCampProject.BootCampProject.service.dtos.requests.blacklist.BlacklistAddRequest;
import com.BootCampProject.BootCampProject.service.dtos.requests.blacklist.BlacklistUpdateRequest;
import com.BootCampProject.BootCampProject.service.dtos.requests.bootcamp.BootcampAddRequest;
import com.BootCampProject.BootCampProject.service.dtos.requests.bootcamp.BootcampUpdateRequest;
import com.BootCampProject.BootCampProject.service.dtos.responses.application.ApplicationAddResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.application.ApplicationGetListResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.blacklist.BlacklistAddResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.blacklist.BlacklistGetByIdResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.blacklist.BlacklistGetListResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.blacklist.BlacklistUpdatedResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.bootcamp.BootcampGetByIdResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.bootcamp.BootcampUpdatedResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface BlacklistMapper {

    BlacklistMapper INSTANCE = Mappers.getMapper(BlacklistMapper.class);

    Blacklist blacklistFromBlacklistAddRequest(BlacklistAddRequest blacklistAddRequest);

    Blacklist blacklistFromBlacklistUpdateRequest(BlacklistUpdateRequest blacklistUpdateRequest);

    BlacklistAddResponse blacklistAddResponseFromBlacklist(Blacklist blacklist);

    BlacklistGetListResponse blacklistGetListResponseFromBlacklist(Blacklist blacklist);
    BlacklistGetByIdResponse blacklistGetByIdResponseFromBlacklist(Blacklist blacklist);
    BlacklistUpdatedResponse blacklistUpdatedResponseFromBlacklist(Blacklist blacklist);

}
