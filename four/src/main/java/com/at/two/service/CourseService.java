package com.at.two.service;

import com.at.two.dto.course.CourseRequest;
import com.at.two.dto.course.CourseResponse;
import com.at.two.dto.teacher.TeacherRequest;
import com.at.two.dto.teacher.TeacherResponse;
import com.at.two.mapper.CourseMapper;
import com.at.two.mapper.TeacherMapper;
import com.at.two.model.Teacher;
import com.at.two.repository.TeacherRepository;
import com.at.two.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository repository;
    private final TeacherRepository teacherRepository;
    private final CourseMapper mapper;

    public CourseResponse add(CourseRequest req){
        if(!teacherRepository.existsById(req.teacherId())){
            throw new RuntimeException("Ops! Teacher does not exists!");
        }

        Teacher teacher = teacherRepository.findById(req.teacherId()).orElseThrow(() -> new RuntimeException("Nope (Course By Id)"));

        return mapper.toResponse(
                repository.save(
                        mapper.toEntity(req, teacher)
                )
        );
    }

    public List<CourseResponse> getAll(){
        return mapper.toResponse(repository.findAll());
    }

    public CourseResponse getByName(String name){
        return mapper.toResponse(repository.findByCourseName(name).orElseThrow(() -> new RuntimeException("Nope (Course by Name)")));
    }

    public CourseResponse getById(Long id){
        return mapper.toResponse(repository.findById(id).orElseThrow(() -> new RuntimeException("Nope (Course by Id)")));
    }

    public List<CourseResponse> getByTeacherName(String name){
        return mapper.toResponse(repository.findAllByTeacherName(name));
    }

    public List<CourseResponse> getByTeacherId(Long id) {
        return mapper.toResponse(repository.findAllByTeacherId(id));
    }
}
