package com.BootCampProject.BootCampProject.service.dtos.responses.bootcamp;

import com.BootCampProject.BootCampProject.entity.enums.BootcampState;

import java.time.LocalDate;

public record BootcampGetListResponse(int id, String name,BootcampState bootcampState) {
}
