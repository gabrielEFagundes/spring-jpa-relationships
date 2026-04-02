package com.at.one.dto.employee;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record EmployeeRequest(
        @NotNull(message = "Your name is required.")
        String name,

        @Email
        @NotNull(message = "Your email is required.")
        String email,

        @NotNull(message = "Your department is required.")
        Long departmentId
) {
}
