package com.at.task.controller;

import com.at.task.dto.task.TaskRequest;
import com.at.task.dto.task.TaskResponse;
import com.at.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @PostMapping
    public TaskResponse addTask(@RequestBody TaskRequest req){
        return service.add(req);
    }

    // honestly? No reason at all for this endpoint
    @GetMapping
    public List<TaskResponse> getAllTasks(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public TaskResponse getTaskById(@PathVariable("id") Long id){
        return service.getById(id);
    }

    @GetMapping("/project/{projectId}")
    public List<TaskResponse> getTasksByProjectId(@PathVariable("projectId") Long projectId){
        return service.getAllByProjectId(projectId);
    }

    @GetMapping(params = "title")
    public List<TaskResponse> getTasksByTitle(@RequestParam("title") String title){
        return service.getAllByTitle(title);
    }

}
