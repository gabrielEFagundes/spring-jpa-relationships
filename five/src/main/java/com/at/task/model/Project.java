package com.at.task.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "project")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String projectTitle;

    @Column(name = "about")
    private String projectAbout;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @OneToMany(mappedBy = "project")
    private List<Task> tasks;

    public Project(String projectTitle, String projectAbout, LocalDate createdAt) {
        this.projectTitle = projectTitle;
        this.projectAbout = projectAbout;
        this.createdAt = createdAt;
    }
}
