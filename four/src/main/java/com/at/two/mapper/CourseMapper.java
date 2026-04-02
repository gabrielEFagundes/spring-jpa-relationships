package com.at.two.mapper;

import com.at.two.dto.course.CourseRequest;
import com.at.two.dto.course.CourseResponse;
import com.at.two.model.Course;
import com.at.two.model.Teacher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseMapper {

    public Course toEntity(CourseRequest req, Teacher teacher){
        return new Course(req.courseName(), req.durationHours(), teacher);
    }

    public CourseResponse toResponse(Course c){
        return new CourseResponse(c.getId(), c.getCourseName(), c.getDurationHours(), c.getTeacher());
    }

    public List<CourseResponse> toResponse(List<Course> c){
        List<CourseResponse> courses = new ArrayList<>();

        c.forEach(course -> courses.add(toResponse(course)));

        return courses;
    }

}
