package com.BootCampProject.BootCampProject.service.mappers;

import com.BootCampProject.BootCampProject.entity.Blacklist;
import com.BootCampProject.BootCampProject.service.dtos.requests.blacklist.BlacklistAddRequest;
import com.BootCampProject.BootCampProject.service.dtos.requests.blacklist.BlacklistUpdateRequest;
import com.BootCampProject.BootCampProject.service.dtos.responses.blacklist.BlacklistAddResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.blacklist.BlacklistGetByIdResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.blacklist.BlacklistGetListResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.blacklist.BlacklistUpdatedResponse;
import java.time.LocalDate;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-02T21:56:29+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
public class BlacklistMapperImpl implements BlacklistMapper {

    @Override
    public Blacklist blacklistFromBlacklistAddRequest(BlacklistAddRequest blacklistAddRequest) {
        if ( blacklistAddRequest == null ) {
            return null;
        }

        Blacklist blacklist = new Blacklist();

        blacklist.setReason( blacklistAddRequest.reason() );
        blacklist.setDate( blacklistAddRequest.date() );

        return blacklist;
    }

    @Override
    public Blacklist blacklistFromBlacklistUpdateRequest(BlacklistUpdateRequest blacklistUpdateRequest) {
        if ( blacklistUpdateRequest == null ) {
            return null;
        }

        Blacklist blacklist = new Blacklist();

        blacklist.setId( blacklistUpdateRequest.id() );
        blacklist.setReason( blacklistUpdateRequest.reason() );
        blacklist.setDate( blacklistUpdateRequest.date() );

        return blacklist;
    }

    @Override
    public BlacklistAddResponse blacklistAddResponseFromBlacklist(Blacklist blacklist) {
        if ( blacklist == null ) {
            return null;
        }

        int id = 0;
        String reason = null;

        id = blacklist.getId();
        reason = blacklist.getReason();

        BlacklistAddResponse blacklistAddResponse = new BlacklistAddResponse( id, reason );

        return blacklistAddResponse;
    }

    @Override
    public BlacklistGetListResponse blacklistGetListResponseFromBlacklist(Blacklist blacklist) {
        if ( blacklist == null ) {
            return null;
        }

        int id = 0;
        String reason = null;
        LocalDate date = null;

        id = blacklist.getId();
        reason = blacklist.getReason();
        date = blacklist.getDate();

        int applicantId = 0;

        BlacklistGetListResponse blacklistGetListResponse = new BlacklistGetListResponse( id, reason, date, applicantId );

        return blacklistGetListResponse;
    }

    @Override
    public BlacklistGetByIdResponse blacklistGetByIdResponseFromBlacklist(Blacklist blacklist) {
        if ( blacklist == null ) {
            return null;
        }

        int id = 0;
        String reason = null;
        LocalDate date = null;

        id = blacklist.getId();
        reason = blacklist.getReason();
        date = blacklist.getDate();

        int applicantId = 0;

        BlacklistGetByIdResponse blacklistGetByIdResponse = new BlacklistGetByIdResponse( id, reason, date, applicantId );

        return blacklistGetByIdResponse;
    }

    @Override
    public BlacklistUpdatedResponse blacklistUpdatedResponseFromBlacklist(Blacklist blacklist) {
        if ( blacklist == null ) {
            return null;
        }

        int id = 0;
        String reason = null;
        LocalDate date = null;

        id = blacklist.getId();
        reason = blacklist.getReason();
        date = blacklist.getDate();

        int applicantId = 0;

        BlacklistUpdatedResponse blacklistUpdatedResponse = new BlacklistUpdatedResponse( id, reason, date, applicantId );

        return blacklistUpdatedResponse;
    }
}
