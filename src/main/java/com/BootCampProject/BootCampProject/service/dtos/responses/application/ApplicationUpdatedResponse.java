package com.BootCampProject.BootCampProject.service.dtos.responses.application;

import com.BootCampProject.BootCampProject.entity.enums.ApplicationState;

public record ApplicationUpdatedResponse(int id, int applicantId, int  bootcampId, ApplicationState applicationState) {
}
