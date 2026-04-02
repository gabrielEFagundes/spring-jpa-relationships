package com.at.one.dto.department;

import jakarta.validation.constraints.NotNull;

public record DepartmentRequest(
        @NotNull(message = "The name of the department is required.")
        String name
) {
}
