package com.at.task.mapper;

import com.at.task.dto.project.ProjectRequest;
import com.at.task.dto.project.ProjectResponse;
import com.at.task.model.Project;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectMapper {

    public Project toEntity(ProjectRequest req, LocalDate createdAt){
        return new Project(req.projectTitle(), req.projectAbout(), createdAt);
    }

    public ProjectResponse toResponse(Project p){
        return new ProjectResponse(p.getId(), p.getProjectTitle(), p.getProjectAbout(), p.getCreatedAt(), p.getTasks());
    }

    public List<ProjectResponse> toResponse(List<Project> p){
        List<ProjectResponse> projects = new ArrayList<>();

        p.forEach(project -> projects.add(toResponse(project)));

        return projects;
    }

}
