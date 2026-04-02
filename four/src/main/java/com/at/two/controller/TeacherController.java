package com.at.two.controller;

import com.at.two.dto.course.CourseRequest;
import com.at.two.dto.course.CourseResponse;
import com.at.two.dto.teacher.TeacherRequest;
import com.at.two.dto.teacher.TeacherResponse;
import com.at.two.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService service;

    @PostMapping
    public TeacherResponse addTeacher(@RequestBody TeacherRequest req){
        return service.add(req);
    }

    @GetMapping
    public List<TeacherResponse> getAllTeachers(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public TeacherResponse getTeacherById(@PathVariable("id") Long id){
        return service.getById(id);
    }

}
