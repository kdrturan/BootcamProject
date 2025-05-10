package com.BootCampProject.BootCampProject.service.dtos.requests.bootcamp;

import com.BootCampProject.BootCampProject.entity.enums.BootcampState;

import java.time.LocalDate;

public record BootcampUpdateRequest(int id, String name, int instructorId, LocalDate startDate, LocalDate endDate, BootcampState bootcampState) {
}
