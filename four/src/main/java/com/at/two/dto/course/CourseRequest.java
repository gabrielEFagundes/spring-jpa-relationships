package com.at.two.dto.course;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CourseRequest(
        @NotBlank(message = "fall of a hero")
        String courseName,

        @NotNull(message = "The duration of the course cannot be null!")
        int durationHours,

        @NotNull(message = "The teacher that will ministry the course cannot be null!")
        Long teacherId
) {}
