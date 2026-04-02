package com.at.one.mapper;

import com.at.one.dto.department.DepartmentRequest;
import com.at.one.dto.department.DepartmentResponse;
import com.at.one.model.Department;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DepartmentMapper {

    public Department toEntity(DepartmentRequest req){
        return new Department(req.name());
    }

    public DepartmentResponse toResponse(Department d){
        return new DepartmentResponse(d.getId(), d.getName(), d.getEmployees());
    }

    public List<DepartmentResponse> toResponse(List<Department> ds){
        List<DepartmentResponse> departments = new ArrayList<>();

        ds.forEach(department -> departments.add(toResponse(department)));

        return departments;
    }

}
