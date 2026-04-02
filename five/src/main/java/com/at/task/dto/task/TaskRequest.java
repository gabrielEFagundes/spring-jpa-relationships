package com.at.task.dto.task;

import java.time.LocalDate;

public record TaskRequest(String title, String description, Long projectId) {
}
