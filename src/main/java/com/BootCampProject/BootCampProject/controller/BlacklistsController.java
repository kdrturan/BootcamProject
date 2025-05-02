package com.BootCampProject.BootCampProject.controller;

import com.BootCampProject.BootCampProject.service.abstracts.BlacklistService;
import com.BootCampProject.BootCampProject.service.dtos.requests.blacklist.BlacklistAddRequest;
import com.BootCampProject.BootCampProject.service.dtos.requests.blacklist.BlacklistUpdateRequest;
import com.BootCampProject.BootCampProject.service.dtos.responses.blacklist.BlacklistAddResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.blacklist.BlacklistGetListResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.blacklist.BlacklistUpdatedResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blacklists")
public class BlacklistsController {

    private final BlacklistService blacklistService;

    public BlacklistsController(BlacklistService blacklistService) {
        this.blacklistService = blacklistService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlacklistAddResponse add(BlacklistAddRequest blacklistAddRequest)
    {
        return blacklistService.add(blacklistAddRequest);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BlacklistGetListResponse> getList(){
        return blacklistService.getAll();
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id){
        blacklistService.delete(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public BlacklistUpdatedResponse update(@RequestBody BlacklistUpdateRequest request){
        return blacklistService.update(request);
    }

}

