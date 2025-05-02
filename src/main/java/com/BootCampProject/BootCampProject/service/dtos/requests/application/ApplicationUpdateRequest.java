package com.BootCampProject.BootCampProject.service.dtos.requests.application;

import com.BootCampProject.BootCampProject.entity.enums.ApplicationState;

public record ApplicationUpdateRequest(int id,int applicantId, int bootcampId, ApplicationState applicationState) {
}
