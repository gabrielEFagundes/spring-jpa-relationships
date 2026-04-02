package com.at.task.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "task")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "is_finished")
    private boolean isFinished;

    @ManyToOne
    private Project project;

    public Task(String title, String description, LocalDate createdAt, boolean isFinished, Project project) {
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.isFinished = isFinished;
        this.project = project;
    }
}
