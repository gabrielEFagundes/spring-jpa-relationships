package com.at.two.service;

import com.at.two.dto.course.CourseRequest;
import com.at.two.dto.course.CourseResponse;
import com.at.two.dto.teacher.TeacherRequest;
import com.at.two.dto.teacher.TeacherResponse;
import com.at.two.mapper.CourseMapper;
import com.at.two.mapper.TeacherMapper;
import com.at.two.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository repository;
    private final TeacherMapper mapper;

    public TeacherResponse add(TeacherRequest req){
        return mapper.toResponse(
                repository.save(
                        mapper.toEntity(req)
                )
        );
    }

    public List<TeacherResponse> getAll(){
        return mapper.toResponse(repository.findAll());
    }

    public TeacherResponse getById(Long id){
        return mapper.toResponse(repository.findById(id).orElseThrow(() -> new RuntimeException("Nope (Teacher by Id)")));
    }

}
