package com.BootCampProject.BootCampProject.service.abstracts;


import com.BootCampProject.BootCampProject.service.dtos.requests.blacklist.BlacklistAddRequest;
import com.BootCampProject.BootCampProject.service.dtos.requests.blacklist.BlacklistUpdateRequest;
import com.BootCampProject.BootCampProject.service.dtos.responses.blacklist.BlacklistAddResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.blacklist.BlacklistGetByIdResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.blacklist.BlacklistGetListResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.blacklist.BlacklistUpdatedResponse;

import java.util.List;

public interface BlacklistService {
    BlacklistAddResponse add(BlacklistAddRequest blacklistAddRequest);
    List<BlacklistGetListResponse> getAll();
    BlacklistUpdatedResponse update(BlacklistUpdateRequest blacklistUpdateRequest);
    void delete(int id);
    BlacklistGetByIdResponse getById(int id);
}
