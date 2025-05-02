package com.BootCampProject.BootCampProject.service.dtos.requests.blacklist;

import java.time.LocalDate;

public record BlacklistAddRequest(String reason, LocalDate date, int applicantId) {
}
