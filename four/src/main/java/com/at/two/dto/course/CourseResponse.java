package com.at.two.dto.course;

import com.at.two.model.Teacher;

public record CourseResponse(Long id, String courseName, int durationHours, Teacher teacher) {
}
