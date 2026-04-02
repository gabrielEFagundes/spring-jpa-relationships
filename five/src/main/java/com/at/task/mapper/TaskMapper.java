package com.at.task.mapper;

import com.at.task.dto.task.TaskRequest;
import com.at.task.dto.task.TaskResponse;
import com.at.task.model.Project;
import com.at.task.model.Task;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class TaskMapper {

    public Task toEntity(TaskRequest req, LocalDate createdAt, boolean isFinished, Project project){
        return new Task(req.title(), req.description(), createdAt, isFinished, project);
    }

    public TaskResponse toResponse(Task t){
        return new TaskResponse(t.getId(), t.getTitle(), t.getDescription(), t.getCreatedAt(), t.isFinished(), t.getProject());
    }

    public List<TaskResponse> toResponse(List<Task> t){
        List<TaskResponse> tasks = new ArrayList<>();

        t.forEach(task -> tasks.add(toResponse(task)));

        return tasks;
    }

}
