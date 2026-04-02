package com.at.task.dto.task;

import com.at.task.model.Project;

import java.time.LocalDate;

public record TaskResponse(Long id, String title, String description, LocalDate createdAt, boolean isFinished, Project project) {
}
