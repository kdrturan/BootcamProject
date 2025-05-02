package com.BootCampProject.BootCampProject.service.concrete;

import com.BootCampProject.BootCampProject.entity.Bootcamp;
import com.BootCampProject.BootCampProject.repository.BootcampRepository;
import com.BootCampProject.BootCampProject.service.abstracts.BootcampService;
import com.BootCampProject.BootCampProject.service.dtos.requests.bootcamp.BootcampAddRequest;
import com.BootCampProject.BootCampProject.service.dtos.requests.bootcamp.BootcampUpdateRequest;
import com.BootCampProject.BootCampProject.service.dtos.responses.bootcamp.BootcampAddResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.bootcamp.BootcampGetByIdResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.bootcamp.BootcampGetListResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.bootcamp.BootcampUpdatedResponse;
import com.BootCampProject.BootCampProject.service.mappers.BootcampMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BootcampServiceImpl implements BootcampService {

    private  final BootcampRepository bootcampRepository;

    public BootcampServiceImpl(BootcampRepository bootcampRepository) {
        this.bootcampRepository = bootcampRepository;
    }


    @Override
    public BootcampAddResponse add(BootcampAddRequest bootcampAddRequest) {
        Bootcamp bootcamp = BootcampMapper.INSTANCE.bootcampFromBootcampAddRequest(bootcampAddRequest);
        Bootcamp addedBootcamp = bootcampRepository.save(bootcamp);
        BootcampAddResponse response = BootcampMapper.INSTANCE.bootcampAddResponseFromBootcamp(addedBootcamp);
        return  response;
    }

    @Override
    public List<BootcampGetListResponse> getAll() {
        List<Bootcamp> bootcamps = bootcampRepository.findAll();
        List<BootcampGetListResponse> response = bootcamps.stream().map(BootcampMapper.INSTANCE::bootcampGetListResponseFromBootcamp)
                .collect(Collectors.toList());
        return  response;
    }

    @Override
    public BootcampUpdatedResponse update(BootcampUpdateRequest bootcampUpdateRequest) {
        Bootcamp bootcamp = bootcampRepository.findById(bootcampUpdateRequest.id()).orElseThrow(()-> new RuntimeException("Bootcamp not found"));
        Bootcamp updatebootcamp = BootcampMapper.INSTANCE.bootcampFromBootcampUpdateRequest(bootcampUpdateRequest);
        updatebootcamp.setId(bootcamp.getId());
        Bootcamp updatedBootcamp = bootcampRepository.save(updatebootcamp);
        BootcampUpdatedResponse response = BootcampMapper.INSTANCE.bootcampUpdatedResponseFromBootcamp(updatedBootcamp);
        return response;
    }

    @Override
    public void delete(int id) {
        bootcampRepository.deleteById(id);
    }

    @Override
    public BootcampGetByIdResponse getById(int id) {
        Bootcamp bootcamp = bootcampRepository.findById(id).orElseThrow(()-> new RuntimeException("Bootcamp not found"));
        BootcampGetByIdResponse response = BootcampMapper.INSTANCE.bootcampGetByIdResponseFromBootcamp(bootcamp);
        return  response;
    }
}
