package com.at.two.dto.teacher;

import com.at.two.model.Course;

import java.util.List;

public record TeacherResponse(Long id, String name, String email, List<Course> courses) {
}
