package com.at.two.service;

import com.at.two.dto.category.CategoryRequest;
import com.at.two.dto.category.CategoryResponse;
import com.at.two.mapper.CategoryMapper;
import com.at.two.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    public CategoryResponse add(CategoryRequest req){
        return mapper.toResponse(
                repository.save(
                        mapper.toEntity(req)
                )
        );
    }

    public List<CategoryResponse> getAll(){
        return mapper.toResponse(repository.findAll());
    }

    public CategoryResponse getById(Long id){
        return mapper.toResponse(repository.findById(id).orElseThrow(() -> new RuntimeException("Nope (Category by Id)")));
    }

}
