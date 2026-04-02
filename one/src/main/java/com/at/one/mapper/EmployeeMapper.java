package com.at.one.mapper;

import com.at.one.dto.employee.EmployeeRequest;
import com.at.one.dto.employee.EmployeeResponse;
import com.at.one.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeMapper {

    public Employee toEntity(EmployeeRequest req){
        return new Employee(req.name(), req.email());
    }

    public EmployeeResponse toResponse(Employee e){
        return new EmployeeResponse(e.getId(), e.getName(), e.getEmail(), e.getDepartment().getId());
    }

    public List<EmployeeResponse> toResponse(List<Employee> es){
        List<EmployeeResponse> employeeResponses = new ArrayList<>();

        es.forEach(employee -> employeeResponses.add(toResponse(employee)));

        return employeeResponses;
    }

}
