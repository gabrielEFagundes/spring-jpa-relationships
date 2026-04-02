package com.at.one.service;

import com.at.one.dto.department.DepartmentRequest;
import com.at.one.dto.department.DepartmentResponse;
import com.at.one.mapper.DepartmentMapper;
import com.at.one.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository repository;
    private final DepartmentMapper mapper;

    public DepartmentResponse addDepartment(DepartmentRequest req){
        return mapper.toResponse(repository.save(mapper.toEntity(req)));
    }

    public List<DepartmentResponse> allDepartments(){
        return mapper.toResponse(repository.findAll());
    }

    public DepartmentResponse departmentById(Long id){
        return mapper.toResponse(repository.findById(id).orElseThrow(() -> new RuntimeException("Nope (department)")));
    }

    public DepartmentResponse departmentByEmployeeId(Long employeeId){
        return mapper.toResponse(repository.findByEmployeeId(employeeId).orElseThrow(() -> new RuntimeException("Nope (department)")));
    }

    public List<DepartmentResponse> departmentByEmployeeName(String employeeName) {
        return mapper.toResponse(repository.findByEmployeeName(employeeName));
    }
}