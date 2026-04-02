package com.at.one.controller;

import com.at.one.dto.employee.EmployeeRequest;
import com.at.one.dto.employee.EmployeeResponse;
import com.at.one.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping
    public EmployeeResponse addEmployee(@RequestBody EmployeeRequest req){
        return service.addEmployee(req);
    }

    @GetMapping
    public List<EmployeeResponse> getEmployees(){
        return service.allEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeResponse getEmployeeById(@PathVariable Long id){
        return service.employeeById(id);
    }

    @GetMapping(params = "departmentid")
    public List<EmployeeResponse> getEmployeesByDepartment(@RequestParam("departmentid") Long departmentId){
        return service.allEmployeesByDepartment(departmentId);
    }

    @GetMapping(params = "name")
    public List<EmployeeResponse> getEmployeesByName(@RequestParam("name") String name){
        return service.allEmployeesByName(name);
    }
}
