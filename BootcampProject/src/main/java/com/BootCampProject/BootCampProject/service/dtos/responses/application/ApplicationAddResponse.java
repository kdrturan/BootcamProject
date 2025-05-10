package com.BootCampProject.BootCampProject.service.dtos.responses.application;

import com.BootCampProject.BootCampProject.entity.enums.ApplicationState;

public record ApplicationAddResponse(int id, int applicantId, int bootcampId) {
}
