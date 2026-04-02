package com.at.task.service;

import com.at.task.dto.project.ProjectRequest;
import com.at.task.dto.project.ProjectResponse;
import com.at.task.mapper.ProjectMapper;
import com.at.task.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository repository;
    private final ProjectMapper mapper;

    public ProjectResponse add(ProjectRequest req){
        return mapper.toResponse(
                repository.save(
                        mapper.toEntity(req, LocalDate.now())
                )
        );
    }

    public List<ProjectResponse> getAll(){
        return mapper.toResponse(repository.findAll());
    }

    public ProjectResponse getById(Long id){
        return mapper.toResponse(repository.findById(id).orElseThrow(() -> new RuntimeException("Nope (the project of id " + id + " does not exist).")));
    }

    // yeah, I guess tasks can have the same name as well
    public List<ProjectResponse> getByTitle(String title){
        return mapper.toResponse(repository.findAllByProjectTitle(title));
    }

}
