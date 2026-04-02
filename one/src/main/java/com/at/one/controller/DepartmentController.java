package com.at.one.controller;

import com.at.one.dto.department.DepartmentRequest;
import com.at.one.dto.department.DepartmentResponse;
import com.at.one.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService service;

    @PostMapping
    public DepartmentResponse addDepartment(DepartmentRequest req){
        return service.addDepartment(req);
    }

    @GetMapping
    public List<DepartmentResponse> getDepartments(){
        return service.allDepartments();
    }

    @GetMapping("/{id}")
    public DepartmentResponse getDepartmentById(@PathVariable Long id){
        return service.departmentById(id);
    }

    @GetMapping(params = "eid")
    public DepartmentResponse getDepartmentByEmployeeId(@RequestParam("employeeid") Long employeeId){
        return service.departmentByEmployeeId(employeeId);
    }

    @GetMapping(params = "ename")
    public List<DepartmentResponse> getDepartmentByEmployeeName(@RequestParam("ename") String employeeName){
        return service.departmentByEmployeeName(employeeName);
    }

}
