package com.BootCampProject.BootCampProject.controller;

import com.BootCampProject.BootCampProject.service.abstracts.BootcampService;
import com.BootCampProject.BootCampProject.service.dtos.requests.bootcamp.BootcampAddRequest;
import com.BootCampProject.BootCampProject.service.dtos.requests.bootcamp.BootcampUpdateRequest;
import com.BootCampProject.BootCampProject.service.dtos.responses.bootcamp.BootcampAddResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.bootcamp.BootcampGetListResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.bootcamp.BootcampUpdatedResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bootcamps")
public class BootcampsController {

    private final BootcampService bootcampService;

    public BootcampsController(BootcampService bootcampService) {
        this.bootcampService = bootcampService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BootcampAddResponse add(BootcampAddRequest bootcampAddRequest)
    {
        return bootcampService.add(bootcampAddRequest);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BootcampGetListResponse> getList(){
        return bootcampService.getAll();
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id){
        bootcampService.delete(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public BootcampUpdatedResponse update(@RequestBody BootcampUpdateRequest request){
        return bootcampService.update(request);
    }

}
