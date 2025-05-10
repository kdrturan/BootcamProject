package com.BootCampProject.BootCampProject.service.concrete;

import com.BootCampProject.BootCampProject.entity.Blacklist;
import com.BootCampProject.BootCampProject.entity.Bootcamp;
import com.BootCampProject.BootCampProject.repository.BlacklistRepository;
import com.BootCampProject.BootCampProject.service.abstracts.BlacklistService;
import com.BootCampProject.BootCampProject.service.dtos.requests.blacklist.BlacklistAddRequest;
import com.BootCampProject.BootCampProject.service.dtos.requests.blacklist.BlacklistUpdateRequest;
import com.BootCampProject.BootCampProject.service.dtos.responses.blacklist.BlacklistAddResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.blacklist.BlacklistGetByIdResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.blacklist.BlacklistGetListResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.blacklist.BlacklistUpdatedResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.bootcamp.BootcampAddResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.bootcamp.BootcampGetByIdResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.bootcamp.BootcampGetListResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.bootcamp.BootcampUpdatedResponse;
import com.BootCampProject.BootCampProject.service.mappers.BlacklistMapper;
import com.BootCampProject.BootCampProject.service.mappers.BootcampMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class BlacklistServiceImpl implements BlacklistService {

    private final BlacklistRepository blacklistRepository;

    public BlacklistServiceImpl(BlacklistRepository blacklistRepository) {
        this.blacklistRepository = blacklistRepository;
    }

    @Override
    public BlacklistAddResponse add(BlacklistAddRequest blacklistAddRequest) {
        Blacklist blacklist = BlacklistMapper.INSTANCE.blacklistFromBlacklistAddRequest(blacklistAddRequest);
        Blacklist addedblacklist = blacklistRepository.save(blacklist);
        BlacklistAddResponse response = BlacklistMapper.INSTANCE.blacklistAddResponseFromBlacklist(addedblacklist);
        return  response;
    }

    @Override
    public List<BlacklistGetListResponse> getAll() {
        List<Blacklist> blacklists = blacklistRepository.findAll();
        List<BlacklistGetListResponse> response = blacklists.stream().map(BlacklistMapper.INSTANCE::blacklistGetListResponseFromBlacklist)
                .collect(Collectors.toList());
        return  response;
    }

    @Override
    public BlacklistUpdatedResponse update(BlacklistUpdateRequest blacklistUpdateRequest) {
        Blacklist blacklist = blacklistRepository.findById(blacklistUpdateRequest.id()).orElseThrow(()-> new RuntimeException("Bootcamp not found"));
        Blacklist updateblacklist = BlacklistMapper.INSTANCE.blacklistFromBlacklistUpdateRequest(blacklistUpdateRequest);
        updateblacklist.setId(blacklist.getId());
        Blacklist updatedBlacklist = blacklistRepository.save(updateblacklist);
        BlacklistUpdatedResponse response = BlacklistMapper.INSTANCE.blacklistUpdatedResponseFromBlacklist(updatedBlacklist);
        return response;
    }

    @Override
    public void delete(int id) {
        blacklistRepository.deleteById(id);
    }

    @Override
    public BlacklistGetByIdResponse getById(int id) {
        Blacklist blacklist = blacklistRepository.findById(id).orElseThrow(()-> new RuntimeException("Blacklist not found"));
        BlacklistGetByIdResponse response = BlacklistMapper.INSTANCE.blacklistGetByIdResponseFromBlacklist(blacklist);
        return  response;
    }
}
