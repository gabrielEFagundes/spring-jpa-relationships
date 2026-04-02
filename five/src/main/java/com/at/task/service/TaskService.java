package com.at.task.service;

import com.at.task.dto.task.TaskRequest;
import com.at.task.dto.task.TaskResponse;
import com.at.task.mapper.TaskMapper;
import com.at.task.model.Project;
import com.at.task.repository.ProjectRepository;
import com.at.task.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;
    private final ProjectRepository projectRepository;
    private final TaskMapper mapper;

    public TaskResponse add(TaskRequest req){
        Project project = projectRepository.findById(req.projectId()).orElseThrow(() -> new RuntimeException("Nope (the project of id " + req.projectId() + " does not exist)."));

        return mapper.toResponse(
                repository.save(
                        mapper.toEntity(req, LocalDate.now(), false, project)
                )
        );
    }

    public List<TaskResponse> getAll(){
        return mapper.toResponse(repository.findAll());
    }

    public TaskResponse getById(Long id){
        return mapper.toResponse(repository.findById(id).orElseThrow(() -> new RuntimeException("Nope (the task of id " + id + " does not exist).")));
    }

    public List<TaskResponse> getAllByProjectId(Long projectId){
        if(!projectRepository.existsById(projectId))
            throw new RuntimeException("Nope (the project of id " + projectId + " does not exist).");

        return mapper.toResponse(repository.findAllByProjectId(projectId));
    }

    // can be a list since tasks can have repeated names
    public List<TaskResponse> getAllByTitle(String title){
        return mapper.toResponse(repository.findAllByTitle(title));
    }

}
