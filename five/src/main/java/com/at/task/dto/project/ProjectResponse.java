package com.at.task.dto.project;

import com.at.task.model.Task;

import java.time.LocalDate;
import java.util.List;

public record ProjectResponse(Long id, String projectTitle, String projectAbout, LocalDate createdAt, List<Task> tasks) {
}
