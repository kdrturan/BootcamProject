package com.BootCampProject.BootCampProject.service.dtos.responses.blacklist;

import java.time.LocalDate;

public record BlacklistUpdatedResponse(int id, String reason, LocalDate date, int applicantId) {
}
