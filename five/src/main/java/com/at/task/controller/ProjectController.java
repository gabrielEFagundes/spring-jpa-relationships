package com.at.task.controller;

import com.at.task.dto.project.ProjectRequest;
import com.at.task.dto.project.ProjectResponse;
import com.at.task.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService service;

    @PostMapping
    public ProjectResponse addProject(@RequestBody ProjectRequest req){
        return service.add(req);
    }

    @GetMapping
    public List<ProjectResponse> getAllProjects(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ProjectResponse getProjectById(@PathVariable("id") Long id){
        return service.getById(id);
    }

    @GetMapping(params = "title")
    public List<ProjectResponse> getProjectByTitle(@RequestParam("title") String title){
        return service.getByTitle(title);
    }

}
