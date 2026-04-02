package com.at.one.service;

import com.at.one.dto.employee.EmployeeRequest;
import com.at.one.dto.employee.EmployeeResponse;
import com.at.one.mapper.EmployeeMapper;
import com.at.one.model.Department;
import com.at.one.model.Employee;
import com.at.one.repository.DepartmentRepository;
import com.at.one.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeMapper mapper;

    public EmployeeResponse addEmployee(EmployeeRequest req){
        Department department = departmentRepository.findById(req.departmentId()).orElseThrow(() -> new RuntimeException("Nope (department)"));
        Employee employee = mapper.toEntity(req);

        employee.setDepartment(department);

        return mapper.toResponse(employee);
    }

    public List<EmployeeResponse> allEmployees(){
        return mapper.toResponse(repository.findAll());
    }

    public EmployeeResponse employeeById(Long id){
        return mapper.toResponse(repository.findById(id).orElseThrow(() -> new RuntimeException("Nope (employee)")));
    }

    public List<EmployeeResponse> allEmployeesByDepartment(Long departmentId){
        return mapper.toResponse(repository.findByDepartmentId(departmentId));
    }

    public List<EmployeeResponse> allEmployeesByName(String name){
        return mapper.toResponse(repository.findByName(name));
    }
}