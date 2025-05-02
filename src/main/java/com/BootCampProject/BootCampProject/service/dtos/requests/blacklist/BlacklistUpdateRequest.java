package com.BootCampProject.BootCampProject.service.dtos.requests.blacklist;

import java.time.LocalDate;

public record BlacklistUpdateRequest(int id, String reason, LocalDate date, int applicantId) {
}
