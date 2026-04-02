package com.at.two.mapper;

import com.at.two.dto.course.CourseRequest;
import com.at.two.dto.teacher.TeacherRequest;
import com.at.two.dto.teacher.TeacherResponse;
import com.at.two.model.Teacher;
import com.at.two.model.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeacherMapper {

    public Teacher toEntity(TeacherRequest req){
        return new Teacher(req.name(), req.email());
    }

    public TeacherResponse toResponse(Teacher p){
        return new TeacherResponse(p.getId(), p.getName(), p.getEmail(), p.getCourses());
    }

    public List<TeacherResponse> toResponse(List<Teacher> t){
        List<TeacherResponse> teachers = new ArrayList<>();

        t.forEach(teacher -> teachers.add(toResponse(teacher)));

        return teachers;
    }

}
