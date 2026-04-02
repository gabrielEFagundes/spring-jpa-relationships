package com.at.two.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "duration_hours")
    private int durationHours;

    @ManyToOne
    private Teacher teacher;

    public Course(String courseName, int durationHours, Teacher teacher) {
        this.courseName = courseName;
        this.durationHours = durationHours;
        this.teacher = teacher;
    }
}
