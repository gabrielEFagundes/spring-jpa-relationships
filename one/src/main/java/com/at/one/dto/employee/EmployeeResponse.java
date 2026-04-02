package com.at.one.dto.employee;

public record EmployeeResponse(
        Long id,
        String name,
        String email,
        Long departmentId
        ) {
}
