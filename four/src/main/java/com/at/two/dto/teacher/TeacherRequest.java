package com.at.two.dto.teacher;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TeacherRequest(
        @NotBlank(message = "The name cannot be null!")
        String name,

        @NotBlank(message = "The email cannot be null!")
        String email
) {}
