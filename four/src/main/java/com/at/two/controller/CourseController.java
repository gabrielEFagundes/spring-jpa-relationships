package com.at.two.controller;

import com.at.two.dto.course.CourseRequest;
import com.at.two.dto.course.CourseResponse;
import com.at.two.dto.teacher.TeacherRequest;
import com.at.two.dto.teacher.TeacherResponse;
import com.at.two.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService service;

    @PostMapping
    public CourseResponse addCourse(@RequestBody CourseRequest req){
        return service.add(req);
    }

    @GetMapping
    public List<CourseResponse> getAllCourses(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CourseResponse getById(@PathVariable("id") Long id){
        return service.getById(id);
    }

    @GetMapping(params = "name")
    public CourseResponse getByName(@RequestParam("name") String name){
        return service.getByName(name);
    }

    @GetMapping(params = "teacher")
    public List<CourseResponse> getByTeacherName(@RequestParam("category") String category){
        return service.getByTeacherName(category);
    }

    @GetMapping("/teacher/{id}")
    public List<CourseResponse> getAllByTeacherId(@PathVariable("id") Long id){
        return service.getByTeacherId(id);
    }

}
