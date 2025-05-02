package com.BootCampProject.BootCampProject.service.dtos.responses.bootcamp;

import com.BootCampProject.BootCampProject.entity.enums.BootcampState;

import java.time.LocalDate;

public record BootcampGetByIdResponse(int id, String name, int instructorId, LocalDate startDate, LocalDate endDate,
                                      BootcampState bootcampState) {
}
