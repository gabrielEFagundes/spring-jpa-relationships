package com.at.one.dto.department;

import com.at.one.model.Employee;

import java.util.List;

public record DepartmentResponse(
        Long id,
        String name,
        List<Employee> employees
) {
}
