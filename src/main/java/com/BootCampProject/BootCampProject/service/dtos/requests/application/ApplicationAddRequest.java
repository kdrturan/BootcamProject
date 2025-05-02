package com.BootCampProject.BootCampProject.service.dtos.requests.application;

import com.BootCampProject.BootCampProject.entity.enums.ApplicationState;

public record ApplicationAddRequest(int applicantId, int bootcampId, ApplicationState applicationState) {
}
